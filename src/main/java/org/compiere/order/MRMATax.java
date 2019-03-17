package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_Tax;
import org.compiere.model.I_M_RMALine;
import org.compiere.model.I_M_RMATax;
import org.compiere.tax.MTax;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;
import org.idempiere.icommon.model.IPO;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.prepareStatement;

/**
 * @author Elaine
 */
public class MRMATax extends X_M_RMATax implements I_M_RMATax {
    /**
     *
     */
    private static final long serialVersionUID = -8702466449639865049L;
    /**
     * Static Logger
     */
    private static CLogger s_log = CLogger.getCLogger(MRMATax.class);
    /**
     * Tax
     */
    private MTax m_tax = null;
    /**
     * Cached Precision
     */
    private Integer m_precision = null;

    /**
     * ************************************************************************ Persistence
     * Constructor
     *
     * @param ctx     context
     * @param ignored ignored
     * @param trxName transaction
     */
    public MRMATax(Properties ctx, int ignored) {
        super(ctx, 0);
        if (ignored != 0) throw new IllegalArgumentException("Multi-Key");
        setTaxAmt(Env.ZERO);
        setTaxBaseAmt(Env.ZERO);
        setIsTaxIncluded(false);
    }

    /**
     * Load Constructor. Set Precision and TaxIncluded for tax calculations!
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MRMATax(Properties ctx, Row row) {
        super(ctx, row);
    }

    /**
     * Get Tax Line for RMA Line
     *
     * @param line      RMA line
     * @param precision currency precision
     * @param oldTax    get old tax
     * @param trxName   transaction
     * @return existing or new tax
     */
    public static MRMATax get(I_M_RMALine line, int precision, boolean oldTax) {
        MRMATax retValue = null;
        if (line == null || line.getRMAId() == 0) {
            s_log.fine("No RMA");
            return null;
        }
        int C_Tax_ID = line.getTaxId();
        boolean isOldTax = oldTax && line.isValueChanged(MRMATax.COLUMNNAME_C_Tax_ID);
        if (isOldTax) {
            Object old = line.getValueOld(MRMATax.COLUMNNAME_C_Tax_ID);
            if (old == null) {
                s_log.fine("No Old Tax");
                return null;
            }
            C_Tax_ID = (Integer) old;
        }
        if (C_Tax_ID == 0) {
            s_log.fine("No Tax");
            return null;
        }

        retValue = MBaseRMATaxKt.getRMATax(line.getCtx(), line.getRMAId(), C_Tax_ID);
        if (retValue != null) {
            retValue.setPrecision(precision);
            if (s_log.isLoggable(Level.FINE)) s_log.fine("(old=" + oldTax + ") " + retValue);
            return retValue;
        }
        // If the old tax was required and there is no MOrderTax for that
        // return null, and not create another MOrderTax - teo_sarca [ 1583825 ]
        else {
            if (isOldTax) return null;
        }

        //	Create New
        retValue = new MRMATax(line.getCtx(), 0);
        retValue.setClientOrg(line);
        retValue.setRMAId(line.getRMAId());
        retValue.setTaxId(line.getTaxId());
        retValue.setPrecision(precision);
        retValue.setIsTaxIncluded(line.getParent().isTaxIncluded());
        if (s_log.isLoggable(Level.FINE)) s_log.fine("(new) " + retValue);
        return retValue;
    }

    /**
     * Get Precision
     *
     * @return Returns the precision or 2
     */
    private int getPrecision() {
        if (m_precision == null) return 2;
        return m_precision;
    } //	getPrecision

    /**
     * Set Precision
     *
     * @param precision The precision to set.
     */
    protected void setPrecision(int precision) {
        m_precision = precision;
    } //	setPrecision

    /**
     * Get Tax
     *
     * @return tax
     */
    public I_C_Tax getTax() {
        if (m_tax == null) m_tax = MTax.get(getCtx(), getTaxId());
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
        String sql = "SELECT LineNetAmt FROM M_RMALine WHERE M_RMA_ID=? AND C_Tax_ID=?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = prepareStatement(sql);
            pstmt.setInt(1, getRMAId());
            pstmt.setInt(2, getTaxId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BigDecimal baseAmt = rs.getBigDecimal(1);
                taxBaseAmt = taxBaseAmt.add(baseAmt);
                //
                if (!documentLevel) // calculate line tax
                    taxAmt = taxAmt.add(tax.calculateTax(baseAmt, isTaxIncluded(), getPrecision()));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            taxBaseAmt = null;
        } finally {
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
                new StringBuffer("MRMATax[")
                        .append("M_RMA_ID=")
                        .append(getRMAId())
                        .append(", C_Tax_ID=")
                        .append(getTaxId())
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
        return I_M_RMATax.Table_ID;
    }
}
