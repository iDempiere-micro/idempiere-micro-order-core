package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_RMATax;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_RMATax
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_RMATax extends PO implements I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_RMATax(Properties ctx, int M_RMATax_ID, String trxName) {
    super(ctx, M_RMATax_ID, trxName);
    /**
     * if (M_RMATax_ID == 0) { setC_Tax_ID (0); setIsTaxIncluded (false); setM_RMA_ID (0);
     * setProcessed (false); setTaxAmt (Env.ZERO); setTaxBaseAmt (Env.ZERO); }
     */
  }

  /** Load Constructor */
  public X_M_RMATax(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 1 - Org
   */
  protected int getAccessLevel() {
    return I_M_RMATax.accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_M_RMATax[").append(getId()).append("]");
    return sb.toString();
  }

  public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException {
    return (org.compiere.model.I_C_Tax)
        MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
            .getPO(getC_Tax_ID(), get_TrxName());
  }

  /**
   * Get Tax.
   *
   * @return Tax identifier
   */
  public int getC_Tax_ID() {
    Integer ii = (Integer) get_Value(I_M_RMATax.COLUMNNAME_C_Tax_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Tax.
   *
   * @param C_Tax_ID Tax identifier
   */
  public void setC_Tax_ID(int C_Tax_ID) {
    if (C_Tax_ID < 1) set_ValueNoCheck(I_M_RMATax.COLUMNNAME_C_Tax_ID, null);
    else set_ValueNoCheck(I_M_RMATax.COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
  }

  public org.compiere.model.I_C_TaxProvider getC_TaxProvider() throws RuntimeException {
    return (org.compiere.model.I_C_TaxProvider)
        MTable.get(getCtx(), org.compiere.model.I_C_TaxProvider.Table_Name)
            .getPO(getC_TaxProvider_ID(), get_TrxName());
  }

  /**
   * Get Tax Provider.
   *
   * @return Tax Provider
   */
  public int getC_TaxProvider_ID() {
    Integer ii = (Integer) get_Value(I_M_RMATax.COLUMNNAME_C_TaxProvider_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Tax Provider.
   *
   * @param C_TaxProvider_ID Tax Provider
   */
  public void setC_TaxProvider_ID(int C_TaxProvider_ID) {
    if (C_TaxProvider_ID < 1) set_ValueNoCheck(I_M_RMATax.COLUMNNAME_C_TaxProvider_ID, null);
    else
      set_ValueNoCheck(I_M_RMATax.COLUMNNAME_C_TaxProvider_ID, Integer.valueOf(C_TaxProvider_ID));
  }

  /**
   * Set Price includes Tax.
   *
   * @param IsTaxIncluded Tax is included in the price
   */
  public void setIsTaxIncluded(boolean IsTaxIncluded) {
    set_Value(I_M_RMATax.COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
  }

  /**
   * Get Price includes Tax.
   *
   * @return Tax is included in the price
   */
  public boolean isTaxIncluded() {
    Object oo = get_Value(I_M_RMATax.COLUMNNAME_IsTaxIncluded);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  public org.compiere.model.I_M_RMA getM_RMA() throws RuntimeException {
    return (org.compiere.model.I_M_RMA)
        MTable.get(getCtx(), org.compiere.model.I_M_RMA.Table_Name)
            .getPO(getM_RMA_ID(), get_TrxName());
  }

  /**
   * Get RMA.
   *
   * @return Return Material Authorization
   */
  public int getM_RMA_ID() {
    Integer ii = (Integer) get_Value(I_M_RMATax.COLUMNNAME_M_RMA_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set RMA.
   *
   * @param M_RMA_ID Return Material Authorization
   */
  public void setM_RMA_ID(int M_RMA_ID) {
    if (M_RMA_ID < 1) set_ValueNoCheck(I_M_RMATax.COLUMNNAME_M_RMA_ID, null);
    else set_ValueNoCheck(I_M_RMATax.COLUMNNAME_M_RMA_ID, Integer.valueOf(M_RMA_ID));
  }

  /**
   * Get M_RMATax_UU.
   *
   * @return M_RMATax_UU
   */
  public String getM_RMATax_UU() {
    return (String) get_Value(I_M_RMATax.COLUMNNAME_M_RMATax_UU);
  }

  /**
   * Set M_RMATax_UU.
   *
   * @param M_RMATax_UU M_RMATax_UU
   */
  public void setM_RMATax_UU(String M_RMATax_UU) {
    set_Value(I_M_RMATax.COLUMNNAME_M_RMATax_UU, M_RMATax_UU);
  }

  /**
   * Get Processed.
   *
   * @return The document has been processed
   */
  public boolean isProcessed() {
    Object oo = get_Value(I_M_RMATax.COLUMNNAME_Processed);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Processed.
   *
   * @param Processed The document has been processed
   */
  public void setProcessed(boolean Processed) {
    set_Value(I_M_RMATax.COLUMNNAME_Processed, Boolean.valueOf(Processed));
  }

  /**
   * Get Tax Amount.
   *
   * @return Tax Amount for a document
   */
  public BigDecimal getTaxAmt() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_RMATax.COLUMNNAME_TaxAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Tax Amount.
   *
   * @param TaxAmt Tax Amount for a document
   */
  public void setTaxAmt(BigDecimal TaxAmt) {
    set_ValueNoCheck(I_M_RMATax.COLUMNNAME_TaxAmt, TaxAmt);
  }

  /**
   * Get Tax base Amount.
   *
   * @return Base for calculating the tax amount
   */
  public BigDecimal getTaxBaseAmt() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_RMATax.COLUMNNAME_TaxBaseAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Tax base Amount.
   *
   * @param TaxBaseAmt Base for calculating the tax amount
   */
  public void setTaxBaseAmt(BigDecimal TaxBaseAmt) {
    set_ValueNoCheck(I_M_RMATax.COLUMNNAME_TaxBaseAmt, TaxBaseAmt);
  }

  @Override
  public int getTableId() {
    return I_M_RMATax.Table_ID;
  }
}
