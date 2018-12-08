package org.compiere.order;

import static software.hsharp.core.util.DBKt.close;
import static software.hsharp.core.util.DBKt.prepareStatement;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_C_OrderTax;
import org.compiere.model.I_C_Tax;
import org.compiere.tax.MTax;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;
import org.idempiere.icommon.model.IPO;

/**
 * Order Tax Model
 *
 * @author Jorg Janke
 * @version $Id: MOrderTax.java,v 1.4 2006/07/30 00:51:04 jjanke Exp $
 */
public class MOrderTax extends X_C_OrderTax implements I_C_OrderTax {
  /** */
  private static final long serialVersionUID = -6776007249310373908L;
  /** Static Logger */
  private static CLogger s_log = CLogger.getCLogger(MOrderTax.class);
  /** Tax */
  private MTax m_tax = null;
  /** Cached Precision */
  private Integer m_precision = null;

  /**
   * ************************************************************************ Persistence
   * Constructor
   *
   * @param ctx context
   * @param ignored ignored
   * @param trxName transaction
   */
  public MOrderTax(Properties ctx, int ignored, String trxName) {
    super(ctx, 0, trxName);
    if (ignored != 0) throw new IllegalArgumentException("Multi-Key");
    setTaxAmt(Env.ZERO);
    setTaxBaseAmt(Env.ZERO);
    setIsTaxIncluded(false);
  } //	MOrderTax

  /**
   * Load Constructor. Set Precision and TaxIncluded for tax calculations!
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MOrderTax(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MOrderTax

  /**
   * Get Tax Line for Order Line
   *
   * @param line Order line
   * @param precision currency precision
   * @param oldTax get old tax
   * @param trxName transaction
   * @return existing or new tax
   */
  public static MOrderTax get(I_C_OrderLine line, int precision, boolean oldTax, String trxName) {
    MOrderTax retValue = null;
    if (line == null || line.getC_Order_ID() == 0) {
      s_log.fine("No Order");
      return null;
    }
    int C_Tax_ID = line.getC_Tax_ID();
    boolean isOldTax = oldTax && line.is_ValueChanged(MOrderTax.COLUMNNAME_C_Tax_ID);
    if (isOldTax) {
      Object old = line.get_ValueOld(MOrderTax.COLUMNNAME_C_Tax_ID);
      if (old == null) {
        s_log.fine("No Old Tax");
        return null;
      }
      C_Tax_ID = ((Integer) old).intValue();
    }
    if (C_Tax_ID == 0) {
      if (!line.isDescription()) s_log.fine("No Tax");
      return null;
    }

    String sql = "SELECT * FROM C_OrderTax WHERE C_Order_ID=? AND C_Tax_ID=?";
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      pstmt = prepareStatement(sql, trxName);
      pstmt.setInt(1, line.getC_Order_ID());
      pstmt.setInt(2, C_Tax_ID);
      rs = pstmt.executeQuery();
      if (rs.next()) retValue = new MOrderTax(line.getCtx(), rs, trxName);
    } catch (Exception e) {
      s_log.log(Level.SEVERE, sql, e);
    } finally {
      close(rs, pstmt);
      rs = null;
      pstmt = null;
    }
    if (retValue != null) {
      retValue.setPrecision(precision);
      retValue.set_TrxName(trxName);
      if (s_log.isLoggable(Level.FINE)) s_log.fine("(old=" + oldTax + ") " + retValue);
      return retValue;
    }
    // If the old tax was required and there is no MOrderTax for that
    // return null, and not create another MOrderTax - teo_sarca [ 1583825 ]
    else {
      if (isOldTax) return null;
    }

    //	Create New
    retValue = new MOrderTax(line.getCtx(), 0, trxName);
    retValue.set_TrxName(trxName);
    retValue.setClientOrg(line);
    retValue.setC_Order_ID(line.getC_Order_ID());
    retValue.setC_Tax_ID(line.getC_Tax_ID());
    retValue.setPrecision(precision);
    retValue.setIsTaxIncluded(line.isTaxIncluded());
    if (s_log.isLoggable(Level.FINE)) s_log.fine("(new) " + retValue);
    return retValue;
  } //	get

  /**
   * Get Precision
   *
   * @return Returns the precision or 2
   */
  private int getPrecision() {
    if (m_precision == null) return 2;
    return m_precision.intValue();
  } //	getPrecision

  /**
   * Set Precision
   *
   * @param precision The precision to set.
   */
  protected void setPrecision(int precision) {
    m_precision = new Integer(precision);
  } //	setPrecision

  /**
   * Get Tax
   *
   * @return tax
   */
  public I_C_Tax getTax() {
    if (m_tax == null) m_tax = MTax.get(getCtx(), getC_Tax_ID());
    return m_tax;
  } //	getTax

  /**
   * ************************************************************************ Calculate/Set Tax Amt
   * from Order Lines
   *
   * @return true if calculated
   */
  public boolean calculateTaxFromLines() {
    BigDecimal taxBaseAmt = Env.ZERO;
    BigDecimal taxAmt = Env.ZERO;
    //
    boolean documentLevel = getTax().isDocumentLevel();
    I_C_Tax tax = getTax();
    //
    String sql = "SELECT LineNetAmt FROM C_OrderLine WHERE C_Order_ID=? AND C_Tax_ID=?";
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      pstmt = prepareStatement(sql, get_TrxName());
      pstmt.setInt(1, getC_Order_ID());
      pstmt.setInt(2, getC_Tax_ID());
      rs = pstmt.executeQuery();
      while (rs.next()) {
        BigDecimal baseAmt = rs.getBigDecimal(1);
        taxBaseAmt = taxBaseAmt.add(baseAmt);
        //
        if (!documentLevel) // calculate line tax
        taxAmt = taxAmt.add(tax.calculateTax(baseAmt, isTaxIncluded(), getPrecision()));
      }
    } catch (Exception e) {
      log.log(Level.SEVERE, get_TrxName(), e);
      taxBaseAmt = null;
    } finally {
      close(rs, pstmt);
      rs = null;
      pstmt = null;
    }
    //
    if (taxBaseAmt == null) return false;

    //	Calculate Tax
    if (documentLevel) //	document level
    taxAmt = tax.calculateTax(taxBaseAmt, isTaxIncluded(), getPrecision());
    setTaxAmt(taxAmt);

    //	Set Base
    if (isTaxIncluded()) setTaxBaseAmt(taxBaseAmt.subtract(taxAmt));
    else setTaxBaseAmt(taxBaseAmt);
    if (log.isLoggable(Level.FINE)) log.fine(toString());
    return true;
  } //	calculateTaxFromLines

  /**
   * String Representation
   *
   * @return info
   */
  public String toString() {
    StringBuffer sb =
        new StringBuffer("MOrderTax[")
            .append("C_Order_ID=")
            .append(getC_Order_ID())
            .append(", C_Tax_ID=")
            .append(getC_Tax_ID())
            .append(", Base=")
            .append(getTaxBaseAmt())
            .append(", Tax=")
            .append(getTaxAmt())
            .append("]");
    return sb.toString();
  } //	toString

  protected void setClientOrg(IPO po) {
    super.setClientOrg(po);
  }

  @Override
  public int getTableId() {
    return I_C_OrderTax.Table_ID;
  }
} //	MOrderTax
