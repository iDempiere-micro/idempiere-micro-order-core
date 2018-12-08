package org.compiere.order;

import org.compiere.model.HasName;
import org.compiere.model.I_C_Charge;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for C_Charge
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_Charge extends PO implements I_C_Charge, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_C_Charge(Properties ctx, int C_Charge_ID, String trxName) {
    super(ctx, C_Charge_ID, trxName);
    /**
     * if (C_Charge_ID == 0) { setC_Charge_ID (0); setChargeAmt (Env.ZERO); setC_TaxCategory_ID (0);
     * setIsSameCurrency (false); setIsSameTax (false); setIsTaxIncluded (false); // N setName
     * (null); }
     */
  }

  /** Load Constructor */
  public X_C_Charge(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 3 - Client - Org
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_C_Charge[").append(getId()).append("]");
    return sb.toString();
  }

  public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getC_BPartner_ID(), get_TrxName());
  }

  /**
   * Set Business Partner .
   *
   * @param C_BPartner_ID Identifies a Business Partner
   */
  public void setC_BPartner_ID(int C_BPartner_ID) {
    if (C_BPartner_ID < 1) set_Value(COLUMNNAME_C_BPartner_ID, null);
    else set_Value(COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
  }

  /**
   * Get Business Partner .
   *
   * @return Identifies a Business Partner
   */
  public int getC_BPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Charge.
   *
   * @param C_Charge_ID Additional document charges
   */
  public void setC_Charge_ID(int C_Charge_ID) {
    if (C_Charge_ID < 1) set_ValueNoCheck(COLUMNNAME_C_Charge_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
  }

  /**
   * Get Charge.
   *
   * @return Additional document charges
   */
  public int getC_Charge_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Charge_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_C_ChargeType getC_ChargeType() throws RuntimeException {
    return (org.compiere.model.I_C_ChargeType)
        MTable.get(getCtx(), org.compiere.model.I_C_ChargeType.Table_Name)
            .getPO(getC_ChargeType_ID(), get_TrxName());
  }

  /**
   * Set Charge Type.
   *
   * @param C_ChargeType_ID Charge Type
   */
  public void setC_ChargeType_ID(int C_ChargeType_ID) {
    if (C_ChargeType_ID < 1) set_Value(COLUMNNAME_C_ChargeType_ID, null);
    else set_Value(COLUMNNAME_C_ChargeType_ID, Integer.valueOf(C_ChargeType_ID));
  }

  /**
   * Get Charge Type.
   *
   * @return Charge Type
   */
  public int getC_ChargeType_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_ChargeType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set C_Charge_UU.
   *
   * @param C_Charge_UU C_Charge_UU
   */
  public void setC_Charge_UU(String C_Charge_UU) {
    set_Value(COLUMNNAME_C_Charge_UU, C_Charge_UU);
  }

  /**
   * Get C_Charge_UU.
   *
   * @return C_Charge_UU
   */
  public String getC_Charge_UU() {
    return (String) get_Value(COLUMNNAME_C_Charge_UU);
  }

  /**
   * Set Charge amount.
   *
   * @param ChargeAmt Charge Amount
   */
  public void setChargeAmt(BigDecimal ChargeAmt) {
    set_Value(COLUMNNAME_ChargeAmt, ChargeAmt);
  }

  /**
   * Get Charge amount.
   *
   * @return Charge Amount
   */
  public BigDecimal getChargeAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ChargeAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  public org.compiere.model.I_C_TaxCategory getC_TaxCategory() throws RuntimeException {
    return (org.compiere.model.I_C_TaxCategory)
        MTable.get(getCtx(), org.compiere.model.I_C_TaxCategory.Table_Name)
            .getPO(getC_TaxCategory_ID(), get_TrxName());
  }

  /**
   * Set Tax Category.
   *
   * @param C_TaxCategory_ID Tax Category
   */
  public void setC_TaxCategory_ID(int C_TaxCategory_ID) {
    if (C_TaxCategory_ID < 1) set_Value(COLUMNNAME_C_TaxCategory_ID, null);
    else set_Value(COLUMNNAME_C_TaxCategory_ID, Integer.valueOf(C_TaxCategory_ID));
  }

  /**
   * Get Tax Category.
   *
   * @return Tax Category
   */
  public int getC_TaxCategory_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_TaxCategory_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(COLUMNNAME_Description, Description);
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
  }

  /**
   * Set Same Currency.
   *
   * @param IsSameCurrency Same Currency
   */
  public void setIsSameCurrency(boolean IsSameCurrency) {
    set_Value(COLUMNNAME_IsSameCurrency, Boolean.valueOf(IsSameCurrency));
  }

  /**
   * Get Same Currency.
   *
   * @return Same Currency
   */
  public boolean isSameCurrency() {
    Object oo = get_Value(COLUMNNAME_IsSameCurrency);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Same Tax.
   *
   * @param IsSameTax Use the same tax as the main transaction
   */
  public void setIsSameTax(boolean IsSameTax) {
    set_Value(COLUMNNAME_IsSameTax, Boolean.valueOf(IsSameTax));
  }

  /**
   * Get Same Tax.
   *
   * @return Use the same tax as the main transaction
   */
  public boolean isSameTax() {
    Object oo = get_Value(COLUMNNAME_IsSameTax);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Price includes Tax.
   *
   * @param IsTaxIncluded Tax is included in the price
   */
  public void setIsTaxIncluded(boolean IsTaxIncluded) {
    set_Value(COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
  }

  /**
   * Get Price includes Tax.
   *
   * @return Tax is included in the price
   */
  public boolean isTaxIncluded() {
    Object oo = get_Value(COLUMNNAME_IsTaxIncluded);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Name.
   *
   * @param Name Alphanumeric identifier of the entity
   */
  public void setName(String Name) {
    set_Value(HasName.Companion.getCOLUMNNAME_Name(), Name);
  }

  /**
   * Get Name.
   *
   * @return Alphanumeric identifier of the entity
   */
  public String getName() {
    return (String) get_Value(HasName.Companion.getCOLUMNNAME_Name());
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), getName());
  }

  @Override
  public int getTableId() {
    return I_C_Charge.Table_ID;
  }
}
