package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_PaySchedule;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Generated Model for C_PaySchedule
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_PaySchedule extends PO implements I_C_PaySchedule {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_C_PaySchedule(Properties ctx, int C_PaySchedule_ID) {
        super(ctx, C_PaySchedule_ID);
        /**
         * if (C_PaySchedule_ID == 0) { setPaymentTermId (0); setC_PaySchedule_ID (0); setDiscount
         * (Env.ZERO); setDiscountDays (0); setGraceDays (0); setIsValid (false); setNetDays (0);
         * setPercentage (Env.ZERO); }
         */
    }

    /**
     * Load Constructor
     */
    public X_C_PaySchedule(Properties ctx, Row row) {
        super(ctx, row);
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
        StringBuffer sb = new StringBuffer("X_C_PaySchedule[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Payment Term.
     *
     * @return The terms of Payment (timing, discount)
     */
    public int getPaymentTermId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_PaymentTerm_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Payment Term.
     *
     * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
     */
    public void setPaymentTermId(int C_PaymentTerm_ID) {
        if (C_PaymentTerm_ID < 1) setValueNoCheck(COLUMNNAME_C_PaymentTerm_ID, null);
        else setValueNoCheck(COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
    }

    /**
     * Get Payment Schedule.
     *
     * @return Payment Schedule Template
     */
    public int getC_PaySchedule_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_PaySchedule_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Discount %.
     *
     * @return Discount in percent
     */
    public BigDecimal getDiscount() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_Discount);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Discount %.
     *
     * @param Discount Discount in percent
     */
    public void setDiscount(BigDecimal Discount) {
        setValue(COLUMNNAME_Discount, Discount);
    }

    /**
     * Get Discount Days.
     *
     * @return Number of days from invoice date to be eligible for discount
     */
    public int getDiscountDays() {
        Integer ii = (Integer) getValue(COLUMNNAME_DiscountDays);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Discount Days.
     *
     * @param DiscountDays Number of days from invoice date to be eligible for discount
     */
    public void setDiscountDays(int DiscountDays) {
        setValue(COLUMNNAME_DiscountDays, Integer.valueOf(DiscountDays));
    }

    /**
     * Set Grace Days.
     *
     * @param GraceDays Days after due date to send first dunning letter
     */
    public void setGraceDays(int GraceDays) {
        setValue(COLUMNNAME_GraceDays, Integer.valueOf(GraceDays));
    }

    /**
     * Set Valid.
     *
     * @param IsValid Element is valid
     */
    public void setIsValid(boolean IsValid) {
        setValue(COLUMNNAME_IsValid, Boolean.valueOf(IsValid));
    }

    /**
     * Get Valid.
     *
     * @return Element is valid
     */
    public boolean isValid() {
        Object oo = getValue(COLUMNNAME_IsValid);
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
        Integer ii = (Integer) getValue(COLUMNNAME_NetDays);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Net Days.
     *
     * @param NetDays Net Days in which payment is due
     */
    public void setNetDays(int NetDays) {
        setValue(COLUMNNAME_NetDays, Integer.valueOf(NetDays));
    }

    /**
     * Get Percentage.
     *
     * @return Percent of the entire amount
     */
    public BigDecimal getPercentage() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_Percentage);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Percentage.
     *
     * @param Percentage Percent of the entire amount
     */
    public void setPercentage(BigDecimal Percentage) {
        setValue(COLUMNNAME_Percentage, Percentage);
    }

    @Override
    public int getTableId() {
        return I_C_PaySchedule.Table_ID;
    }
}
