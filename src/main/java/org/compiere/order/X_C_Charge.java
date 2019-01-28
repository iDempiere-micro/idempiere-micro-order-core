package org.compiere.order;

import kotliquery.Row;
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
  public X_C_Charge(Properties ctx, Row row) {
    super(ctx, row);
  } //	MCharge

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
   * Get Charge amount.
   *
   * @return Charge Amount
   */
  public BigDecimal getChargeAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ChargeAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Charge amount.
   *
   * @param ChargeAmt Charge Amount
   */
  public void setChargeAmt(BigDecimal ChargeAmt) {
    set_Value(COLUMNNAME_ChargeAmt, ChargeAmt);
  }

  public org.compiere.model.I_C_TaxCategory getC_TaxCategory() throws RuntimeException {
    return (org.compiere.model.I_C_TaxCategory)
        MTable.get(getCtx(), org.compiere.model.I_C_TaxCategory.Table_Name)
            .getPO(getC_TaxCategory_ID(), null);
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
   * Set Same Currency.
   *
   * @param IsSameCurrency Same Currency
   */
  public void setIsSameCurrency(boolean IsSameCurrency) {
    set_Value(COLUMNNAME_IsSameCurrency, Boolean.valueOf(IsSameCurrency));
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
   * Set Price includes Tax.
   *
   * @param IsTaxIncluded Tax is included in the price
   */
  public void setIsTaxIncluded(boolean IsTaxIncluded) {
    set_Value(COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
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
   * Set Name.
   *
   * @param Name Alphanumeric identifier of the entity
   */
  public void setName(String Name) {
    set_Value(HasName.Companion.getCOLUMNNAME_Name(), Name);
  }

    @Override
  public int getTableId() {
    return I_C_Charge.Table_ID;
  }
}
