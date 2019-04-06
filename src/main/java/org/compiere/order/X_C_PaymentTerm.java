package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_PaymentTerm;
import org.compiere.orm.BasePONameValue;

import java.math.BigDecimal;

/**
 * Generated Model for C_PaymentTerm
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_PaymentTerm extends BasePONameValue {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_C_PaymentTerm(int C_PaymentTerm_ID) {
        super(C_PaymentTerm_ID);
    }

    /**
     * Load Constructor
     */
    public X_C_PaymentTerm(Row row) {
        super(row);
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
     * Set After Delivery.
     *
     * @param AfterDelivery Due after delivery rather than after invoicing
     */
    public void setAfterDelivery(boolean AfterDelivery) {
        setValue(I_C_PaymentTerm.COLUMNNAME_AfterDelivery, AfterDelivery);
    }

    /**
     * Get Payment Term.
     *
     * @return The terms of Payment (timing, discount)
     */
    public int getPaymentTermId() {
        Integer ii = (Integer) getValue(I_C_PaymentTerm.COLUMNNAME_C_PaymentTerm_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Discount %.
     *
     * @param Discount Discount in percent
     */
    public void setDiscount(BigDecimal Discount) {
        setValue(I_C_PaymentTerm.COLUMNNAME_Discount, Discount);
    }

    /**
     * Set Discount 2 %.
     *
     * @param Discount2 Discount in percent
     */
    public void setDiscount2(BigDecimal Discount2) {
        setValue(I_C_PaymentTerm.COLUMNNAME_Discount2, Discount2);
    }

    /**
     * Set Discount Days.
     *
     * @param DiscountDays Number of days from invoice date to be eligible for discount
     */
    public void setDiscountDays(int DiscountDays) {
        setValue(I_C_PaymentTerm.COLUMNNAME_DiscountDays, Integer.valueOf(DiscountDays));
    }

    /**
     * Set Discount Days 2.
     *
     * @param DiscountDays2 Number of days from invoice date to be eligible for discount
     */
    public void setDiscountDays2(int DiscountDays2) {
        setValue(I_C_PaymentTerm.COLUMNNAME_DiscountDays2, Integer.valueOf(DiscountDays2));
    }

    /**
     * Get Fix month cutoff.
     *
     * @return Last day to include for next due date
     */
    public int getFixMonthCutoff() {
        Integer ii = (Integer) getValue(I_C_PaymentTerm.COLUMNNAME_FixMonthCutoff);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Fix month day.
     *
     * @return Day of the month of the due date
     */
    public int getFixMonthDay() {
        Integer ii = (Integer) getValue(I_C_PaymentTerm.COLUMNNAME_FixMonthDay);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Grace Days.
     *
     * @param GraceDays Days after due date to send first dunning letter
     */
    public void setGraceDays(int GraceDays) {
        setValue(I_C_PaymentTerm.COLUMNNAME_GraceDays, Integer.valueOf(GraceDays));
    }

    /**
     * Set Fixed due date.
     *
     * @param IsDueFixed Payment is due on a fixed date
     */
    public void setIsDueFixed(boolean IsDueFixed) {
        setValue(I_C_PaymentTerm.COLUMNNAME_IsDueFixed, Boolean.valueOf(IsDueFixed));
    }

    /**
     * Get Fixed due date.
     *
     * @return Payment is due on a fixed date
     */
    public boolean isDueFixed() {
        Object oo = getValue(I_C_PaymentTerm.COLUMNNAME_IsDueFixed);
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
        setValue(I_C_PaymentTerm.COLUMNNAME_IsValid, Boolean.valueOf(IsValid));
    }

    /**
     * Get Valid.
     *
     * @return Element is valid
     */
    public boolean isValid() {
        Object oo = getValue(I_C_PaymentTerm.COLUMNNAME_IsValid);
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
        Integer ii = (Integer) getValue(I_C_PaymentTerm.COLUMNNAME_NetDays);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Net Days.
     *
     * @param NetDays Net Days in which payment is due
     */
    public void setNetDays(int NetDays) {
        setValue(I_C_PaymentTerm.COLUMNNAME_NetDays, Integer.valueOf(NetDays));
    }

    @Override
    public int getTableId() {
        return I_C_PaymentTerm.Table_ID;
    }
}
