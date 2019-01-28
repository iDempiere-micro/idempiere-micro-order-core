package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_C_OrderPaySchedule;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for C_OrderPaySchedule
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_OrderPaySchedule extends PO implements I_C_OrderPaySchedule, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_C_OrderPaySchedule(Properties ctx, int C_OrderPaySchedule_ID, String trxName) {
    super(ctx, C_OrderPaySchedule_ID, trxName);
    /**
     * if (C_OrderPaySchedule_ID == 0) { setC_Order_ID (0); setC_OrderPaySchedule_ID (0);
     * setDiscountAmt (Env.ZERO); setDiscountDate (new Timestamp( System.currentTimeMillis() ));
     * setDueAmt (Env.ZERO); setDueDate (new Timestamp( System.currentTimeMillis() )); setIsValid
     * (false); setProcessed (false); }
     */
  }

  /** Load Constructor */
  public X_C_OrderPaySchedule(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 1 - Org
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_C_OrderPaySchedule[").append(getId()).append("]");
    return sb.toString();
  }

    /**
   * Get Order.
   *
   * @return Order
   */
  public int getC_Order_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Order_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Order.
   *
   * @param C_Order_ID Order
   */
  public void setC_Order_ID(int C_Order_ID) {
    if (C_Order_ID < 1) set_ValueNoCheck(COLUMNNAME_C_Order_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
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
   * Set Payment Schedule.
   *
   * @param C_PaySchedule_ID Payment Schedule Template
   */
  public void setC_PaySchedule_ID(int C_PaySchedule_ID) {
    if (C_PaySchedule_ID < 1) set_ValueNoCheck(COLUMNNAME_C_PaySchedule_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_PaySchedule_ID, Integer.valueOf(C_PaySchedule_ID));
  }

  /**
   * Get Discount Amount.
   *
   * @return Calculated amount of discount
   */
  public BigDecimal getDiscountAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_DiscountAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Discount Amount.
   *
   * @param DiscountAmt Calculated amount of discount
   */
  public void setDiscountAmt(BigDecimal DiscountAmt) {
    set_Value(COLUMNNAME_DiscountAmt, DiscountAmt);
  }

  /**
   * Get Discount Date.
   *
   * @return Last Date for payments with discount
   */
  public Timestamp getDiscountDate() {
    return (Timestamp) get_Value(COLUMNNAME_DiscountDate);
  }

  /**
   * Set Discount Date.
   *
   * @param DiscountDate Last Date for payments with discount
   */
  public void setDiscountDate(Timestamp DiscountDate) {
    set_Value(COLUMNNAME_DiscountDate, DiscountDate);
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), String.valueOf(getDiscountDate()));
  }

  /**
   * Get Amount due.
   *
   * @return Amount of the payment due
   */
  public BigDecimal getDueAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_DueAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Amount due.
   *
   * @param DueAmt Amount of the payment due
   */
  public void setDueAmt(BigDecimal DueAmt) {
    set_Value(COLUMNNAME_DueAmt, DueAmt);
  }

  /**
   * Get Due Date.
   *
   * @return Date when the payment is due
   */
  public Timestamp getDueDate() {
    return (Timestamp) get_Value(COLUMNNAME_DueDate);
  }

  /**
   * Set Due Date.
   *
   * @param DueDate Date when the payment is due
   */
  public void setDueDate(Timestamp DueDate) {
    set_Value(COLUMNNAME_DueDate, DueDate);
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
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(COLUMNNAME_Processing);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

    @Override
  public int getTableId() {
    return I_C_OrderPaySchedule.Table_ID;
  }
}
