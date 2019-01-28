package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_PaySchedule;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for C_PaySchedule
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_PaySchedule extends PO implements I_C_PaySchedule, I_Persistent {

  /** NetDay AD_Reference_ID=167 */
  public static final int NETDAY_AD_Reference_ID = 167;
  /** Sunday = 7 */
  public static final String NETDAY_Sunday = "7";
  /** Monday = 1 */
  public static final String NETDAY_Monday = "1";
  /** Tuesday = 2 */
  public static final String NETDAY_Tuesday = "2";
  /** Wednesday = 3 */
  public static final String NETDAY_Wednesday = "3";
  /** Thursday = 4 */
  public static final String NETDAY_Thursday = "4";
  /** Friday = 5 */
  public static final String NETDAY_Friday = "5";
  /** Saturday = 6 */
  public static final String NETDAY_Saturday = "6";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_C_PaySchedule(Properties ctx, int C_PaySchedule_ID, String trxName) {
    super(ctx, C_PaySchedule_ID, trxName);
    /**
     * if (C_PaySchedule_ID == 0) { setC_PaymentTerm_ID (0); setC_PaySchedule_ID (0); setDiscount
     * (Env.ZERO); setDiscountDays (0); setGraceDays (0); setIsValid (false); setNetDays (0);
     * setPercentage (Env.ZERO); }
     */
  }

  /** Load Constructor */
  public X_C_PaySchedule(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }
  public X_C_PaySchedule(Properties ctx, Row row) {
    super(ctx, row);
  } //	MPaySchedule

  /**
   * AccessLevel
   *
   * @return 3 - Client - Org
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_C_PaySchedule[").append(getId()).append("]");
    return sb.toString();
  }

    /**
   * Get Payment Term.
   *
   * @return The terms of Payment (timing, discount)
   */
  public int getC_PaymentTerm_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_PaymentTerm_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Payment Term.
   *
   * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
   */
  public void setC_PaymentTerm_ID(int C_PaymentTerm_ID) {
    if (C_PaymentTerm_ID < 1) set_ValueNoCheck(COLUMNNAME_C_PaymentTerm_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), String.valueOf(getC_PaymentTerm_ID()));
  }

  /**
   * Get Payment Schedule.
   *
   * @return Payment Schedule Template
   */
  public int getC_PaySchedule_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_PaySchedule_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Discount %.
   *
   * @return Discount in percent
   */
  public BigDecimal getDiscount() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_Discount);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Discount %.
   *
   * @param Discount Discount in percent
   */
  public void setDiscount(BigDecimal Discount) {
    set_Value(COLUMNNAME_Discount, Discount);
  }

  /**
   * Get Discount Days.
   *
   * @return Number of days from invoice date to be eligible for discount
   */
  public int getDiscountDays() {
    Integer ii = (Integer) get_Value(COLUMNNAME_DiscountDays);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Discount Days.
   *
   * @param DiscountDays Number of days from invoice date to be eligible for discount
   */
  public void setDiscountDays(int DiscountDays) {
    set_Value(COLUMNNAME_DiscountDays, Integer.valueOf(DiscountDays));
  }

    /**
   * Set Grace Days.
   *
   * @param GraceDays Days after due date to send first dunning letter
   */
  public void setGraceDays(int GraceDays) {
    set_Value(COLUMNNAME_GraceDays, Integer.valueOf(GraceDays));
  }

  /**
   * Set Valid.
   *
   * @param IsValid Element is valid
   */
  public void setIsValid(boolean IsValid) {
    set_Value(COLUMNNAME_IsValid, Boolean.valueOf(IsValid));
  }

  /**
   * Get Valid.
   *
   * @return Element is valid
   */
  public boolean isValid() {
    Object oo = get_Value(COLUMNNAME_IsValid);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

    /**
   * Get Net Days.
   *
   * @return Net Days in which payment is due
   */
  public int getNetDays() {
    Integer ii = (Integer) get_Value(COLUMNNAME_NetDays);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Net Days.
   *
   * @param NetDays Net Days in which payment is due
   */
  public void setNetDays(int NetDays) {
    set_Value(COLUMNNAME_NetDays, Integer.valueOf(NetDays));
  }

  /**
   * Get Percentage.
   *
   * @return Percent of the entire amount
   */
  public BigDecimal getPercentage() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_Percentage);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Percentage.
   *
   * @param Percentage Percent of the entire amount
   */
  public void setPercentage(BigDecimal Percentage) {
    set_Value(COLUMNNAME_Percentage, Percentage);
  }

  @Override
  public int getTableId() {
    return I_C_PaySchedule.Table_ID;
  }
}
