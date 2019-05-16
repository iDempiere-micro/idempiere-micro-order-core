package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_RMATax;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;

/**
 * Generated Model for M_RMATax
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_RMATax extends PO {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_RMATax(int M_RMATax_ID) {
        super(M_RMATax_ID);
        /**
         * if (M_RMATax_ID == 0) { setTaxId (0); setIsTaxIncluded (false); setRMAId (0);
         * setProcessed (false); setTaxAmt (Env.ZERO); setTaxBaseAmt (Env.ZERO); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_RMATax(Row row) {
        super(row);
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

    /**
     * Get Tax.
     *
     * @return Tax identifier
     */
    public int getTaxId() {
        Integer ii = getValue(I_M_RMATax.COLUMNNAME_C_Tax_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Tax.
     *
     * @param C_Tax_ID Tax identifier
     */
    public void setTaxId(int C_Tax_ID) {
        if (C_Tax_ID < 1) setValueNoCheck(I_M_RMATax.COLUMNNAME_C_Tax_ID, null);
        else setValueNoCheck(I_M_RMATax.COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
    }

    /**
     * Get Tax Provider.
     *
     * @return Tax Provider
     */
    public int getTaxProviderId() {
        Integer ii = getValue(I_M_RMATax.COLUMNNAME_C_TaxProvider_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Price includes Tax.
     *
     * @param IsTaxIncluded Tax is included in the price
     */
    public void setIsTaxIncluded(boolean IsTaxIncluded) {
        setValue(I_M_RMATax.COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
    }

    /**
     * Get Price includes Tax.
     *
     * @return Tax is included in the price
     */
    public boolean isTaxIncluded() {
        Object oo = getValue(I_M_RMATax.COLUMNNAME_IsTaxIncluded);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get RMA.
     *
     * @return Return Material Authorization
     */
    public int getRMAId() {
        Integer ii = getValue(I_M_RMATax.COLUMNNAME_M_RMA_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set RMA.
     *
     * @param M_RMA_ID Return Material Authorization
     */
    public void setRMAId(int M_RMA_ID) {
        if (M_RMA_ID < 1) setValueNoCheck(I_M_RMATax.COLUMNNAME_M_RMA_ID, null);
        else setValueNoCheck(I_M_RMATax.COLUMNNAME_M_RMA_ID, Integer.valueOf(M_RMA_ID));
    }

    /**
     * Get Tax Amount.
     *
     * @return Tax Amount for a document
     */
    public BigDecimal getTaxAmt() {
        BigDecimal bd = getValue(I_M_RMATax.COLUMNNAME_TaxAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Tax Amount.
     *
     * @param TaxAmt Tax Amount for a document
     */
    public void setTaxAmt(BigDecimal TaxAmt) {
        setValueNoCheck(I_M_RMATax.COLUMNNAME_TaxAmt, TaxAmt);
    }

    /**
     * Get Tax base Amount.
     *
     * @return Base for calculating the tax amount
     */
    public BigDecimal getTaxBaseAmt() {
        BigDecimal bd = getValue(I_M_RMATax.COLUMNNAME_TaxBaseAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Tax base Amount.
     *
     * @param TaxBaseAmt Base for calculating the tax amount
     */
    public void setTaxBaseAmt(BigDecimal TaxBaseAmt) {
        setValueNoCheck(I_M_RMATax.COLUMNNAME_TaxBaseAmt, TaxBaseAmt);
    }

    @Override
    public int getTableId() {
        return I_M_RMATax.Table_ID;
    }
}
