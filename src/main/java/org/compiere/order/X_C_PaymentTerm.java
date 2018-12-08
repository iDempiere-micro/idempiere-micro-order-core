package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_C_PaymentTerm;
import org.compiere.orm.BasePONameValue;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for C_PaymentTerm
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_PaymentTerm extends BasePONameValue implements I_Persistent {

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
  /** PaymentTermUsage AD_Reference_ID=53382 */
  public static final int PAYMENTTERMUSAGE_AD_Reference_ID = 53382;
  /** Both = B */
  public static final String PAYMENTTERMUSAGE_Both = "B";
  /** Sales = S */
  public static final String PAYMENTTERMUSAGE_Sales = "S";
  /** Purchases = P */
  public static final String PAYMENTTERMUSAGE_Purchases = "P";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_C_PaymentTerm(Properties ctx, int C_PaymentTerm_ID, String trxName) {
    super(ctx, C_PaymentTerm_ID, trxName);
  }

  /** Load Constructor */
  public X_C_PaymentTerm(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 3 - Client - Org
   */
  protected int getAccessLevel() {
    return I_C_PaymentTerm.accessLevel.intValue();
  }

  public String toString() {
    return "X_C_PaymentTerm[" + getId() + "]";
  }

  /**
   * Get After Delivery.
   *
   * @return Due after delivery rather than after invoicing
   */
  public boolean isAfterDelivery() {
    Object oo = get_Value(I_C_PaymentTerm.COLUMNNAME_AfterDelivery);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set After Delivery.
   *
   * @param AfterDelivery Due after delivery rather than after invoicing
   */
  public void setAfterDelivery(boolean AfterDelivery) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_AfterDelivery, Boolean.valueOf(AfterDelivery));
  }

  /**
   * Get Payment Term.
   *
   * @return The terms of Payment (timing, discount)
   */
  public int getC_PaymentTerm_ID() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_C_PaymentTerm_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Payment Term.
   *
   * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
   */
  public void setC_PaymentTerm_ID(int C_PaymentTerm_ID) {
    if (C_PaymentTerm_ID < 1) set_ValueNoCheck(I_C_PaymentTerm.COLUMNNAME_C_PaymentTerm_ID, null);
    else
      set_ValueNoCheck(
          I_C_PaymentTerm.COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
  }

  /**
   * Get C_PaymentTerm_UU.
   *
   * @return C_PaymentTerm_UU
   */
  public String getC_PaymentTerm_UU() {
    return (String) get_Value(I_C_PaymentTerm.COLUMNNAME_C_PaymentTerm_UU);
  }

  /**
   * Set C_PaymentTerm_UU.
   *
   * @param C_PaymentTerm_UU C_PaymentTerm_UU
   */
  public void setC_PaymentTerm_UU(String C_PaymentTerm_UU) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_C_PaymentTerm_UU, C_PaymentTerm_UU);
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(I_C_PaymentTerm.COLUMNNAME_Description);
  }

  /**
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_Description, Description);
  }

  /**
   * Get Discount %.
   *
   * @return Discount in percent
   */
  public BigDecimal getDiscount() {
    BigDecimal bd = (BigDecimal) get_Value(I_C_PaymentTerm.COLUMNNAME_Discount);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Discount %.
   *
   * @param Discount Discount in percent
   */
  public void setDiscount(BigDecimal Discount) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_Discount, Discount);
  }

  /**
   * Get Discount 2 %.
   *
   * @return Discount in percent
   */
  public BigDecimal getDiscount2() {
    BigDecimal bd = (BigDecimal) get_Value(I_C_PaymentTerm.COLUMNNAME_Discount2);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Discount 2 %.
   *
   * @param Discount2 Discount in percent
   */
  public void setDiscount2(BigDecimal Discount2) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_Discount2, Discount2);
  }

  /**
   * Get Discount Days.
   *
   * @return Number of days from invoice date to be eligible for discount
   */
  public int getDiscountDays() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_DiscountDays);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Discount Days.
   *
   * @param DiscountDays Number of days from invoice date to be eligible for discount
   */
  public void setDiscountDays(int DiscountDays) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_DiscountDays, Integer.valueOf(DiscountDays));
  }

  /**
   * Get Discount Days 2.
   *
   * @return Number of days from invoice date to be eligible for discount
   */
  public int getDiscountDays2() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_DiscountDays2);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Discount Days 2.
   *
   * @param DiscountDays2 Number of days from invoice date to be eligible for discount
   */
  public void setDiscountDays2(int DiscountDays2) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_DiscountDays2, Integer.valueOf(DiscountDays2));
  }

  /**
   * Get Document Note.
   *
   * @return Additional information for a Document
   */
  public String getDocumentNote() {
    return (String) get_Value(I_C_PaymentTerm.COLUMNNAME_DocumentNote);
  }

  /**
   * Set Document Note.
   *
   * @param DocumentNote Additional information for a Document
   */
  public void setDocumentNote(String DocumentNote) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_DocumentNote, DocumentNote);
  }

  /**
   * Get Fix month cutoff.
   *
   * @return Last day to include for next due date
   */
  public int getFixMonthCutoff() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_FixMonthCutoff);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Fix month cutoff.
   *
   * @param FixMonthCutoff Last day to include for next due date
   */
  public void setFixMonthCutoff(int FixMonthCutoff) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_FixMonthCutoff, Integer.valueOf(FixMonthCutoff));
  }

  /**
   * Get Fix month day.
   *
   * @return Day of the month of the due date
   */
  public int getFixMonthDay() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_FixMonthDay);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Fix month day.
   *
   * @param FixMonthDay Day of the month of the due date
   */
  public void setFixMonthDay(int FixMonthDay) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_FixMonthDay, Integer.valueOf(FixMonthDay));
  }

  /**
   * Get Fix month offset.
   *
   * @return Number of months (0=same, 1=following)
   */
  public int getFixMonthOffset() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_FixMonthOffset);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Fix month offset.
   *
   * @param FixMonthOffset Number of months (0=same, 1=following)
   */
  public void setFixMonthOffset(int FixMonthOffset) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_FixMonthOffset, Integer.valueOf(FixMonthOffset));
  }

  /**
   * Get Grace Days.
   *
   * @return Days after due date to send first dunning letter
   */
  public int getGraceDays() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_GraceDays);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Grace Days.
   *
   * @param GraceDays Days after due date to send first dunning letter
   */
  public void setGraceDays(int GraceDays) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_GraceDays, Integer.valueOf(GraceDays));
  }

  /**
   * Set Default.
   *
   * @param IsDefault Default value
   */
  public void setIsDefault(boolean IsDefault) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
  }

  /**
   * Get Default.
   *
   * @return Default value
   */
  public boolean isDefault() {
    Object oo = get_Value(I_C_PaymentTerm.COLUMNNAME_IsDefault);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Fixed due date.
   *
   * @param IsDueFixed Payment is due on a fixed date
   */
  public void setIsDueFixed(boolean IsDueFixed) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_IsDueFixed, Boolean.valueOf(IsDueFixed));
  }

  /**
   * Get Fixed due date.
   *
   * @return Payment is due on a fixed date
   */
  public boolean isDueFixed() {
    Object oo = get_Value(I_C_PaymentTerm.COLUMNNAME_IsDueFixed);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Next Business Day.
   *
   * @param IsNextBusinessDay Payment due on the next business day
   */
  public void setIsNextBusinessDay(boolean IsNextBusinessDay) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_IsNextBusinessDay, Boolean.valueOf(IsNextBusinessDay));
  }

  /**
   * Get Next Business Day.
   *
   * @return Payment due on the next business day
   */
  public boolean isNextBusinessDay() {
    Object oo = get_Value(I_C_PaymentTerm.COLUMNNAME_IsNextBusinessDay);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Valid.
   *
   * @param IsValid Element is valid
   */
  public void setIsValid(boolean IsValid) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_IsValid, Boolean.valueOf(IsValid));
  }

  /**
   * Get Valid.
   *
   * @return Element is valid
   */
  public boolean isValid() {
    Object oo = get_Value(I_C_PaymentTerm.COLUMNNAME_IsValid);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Net Day.
   *
   * @return Day when payment is due net
   */
  public String getNetDay() {
    return (String) get_Value(I_C_PaymentTerm.COLUMNNAME_NetDay);
  }

  /**
   * Set Net Day.
   *
   * @param NetDay Day when payment is due net
   */
  public void setNetDay(String NetDay) {

    set_Value(I_C_PaymentTerm.COLUMNNAME_NetDay, NetDay);
  }

  /**
   * Get Net Days.
   *
   * @return Net Days in which payment is due
   */
  public int getNetDays() {
    Integer ii = (Integer) get_Value(I_C_PaymentTerm.COLUMNNAME_NetDays);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Net Days.
   *
   * @param NetDays Net Days in which payment is due
   */
  public void setNetDays(int NetDays) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_NetDays, Integer.valueOf(NetDays));
  }

  /**
   * Get Payment Term Usage.
   *
   * @return Payment term usage indicates if this payment term is used for sales, purchases or both.
   */
  public String getPaymentTermUsage() {
    return (String) get_Value(I_C_PaymentTerm.COLUMNNAME_PaymentTermUsage);
  }

  /**
   * Set Payment Term Usage.
   *
   * @param PaymentTermUsage Payment term usage indicates if this payment term is used for sales,
   *     purchases or both.
   */
  public void setPaymentTermUsage(String PaymentTermUsage) {

    set_Value(I_C_PaymentTerm.COLUMNNAME_PaymentTermUsage, PaymentTermUsage);
  }

  /**
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(I_C_PaymentTerm.COLUMNNAME_Processing);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Process Now.
   *
   * @param Processing Process Now
   */
  public void setProcessing(boolean Processing) {
    set_Value(I_C_PaymentTerm.COLUMNNAME_Processing, Boolean.valueOf(Processing));
  }

  @Override
  public int getTableId() {
    return I_C_PaymentTerm.Table_ID;
  }
}
