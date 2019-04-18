package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.I_C_Charge;
import org.compiere.model.I_C_TaxCategory;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import software.hsharp.core.orm.MBaseTableKt;

import java.math.BigDecimal;

/**
 * Generated Model for C_Charge
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_Charge extends PO implements I_C_Charge {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_C_Charge(int C_Charge_ID) {
        super(C_Charge_ID);
    }

    /**
     * Load Constructor
     */
    public X_C_Charge(Row row) {
        super(row);
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
        return "X_C_Charge[" + getId() + "]";
    }

    /**
     * Get Business Partner .
     *
     * @return Identifies a Business Partner
     */
    public int getBusinessPartnerId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Charge amount.
     *
     * @return Charge Amount
     */
    public BigDecimal getChargeAmt() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_ChargeAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Charge amount.
     *
     * @param ChargeAmt Charge Amount
     */
    public void setChargeAmt(BigDecimal ChargeAmt) {
        setValue(COLUMNNAME_ChargeAmt, ChargeAmt);
    }

    public I_C_TaxCategory getTaxCategory() throws RuntimeException {
        return (I_C_TaxCategory)
                MBaseTableKt.getTable(I_C_TaxCategory.Table_Name)
                        .getPO(getTaxCategoryId());
    }

    /**
     * Get Tax Category.
     *
     * @return Tax Category
     */
    public int getTaxCategoryId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_TaxCategory_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Same Currency.
     *
     * @param IsSameCurrency Same Currency
     */
    public void setIsSameCurrency(boolean IsSameCurrency) {
        setValue(COLUMNNAME_IsSameCurrency, IsSameCurrency);
    }

    /**
     * Set Same Tax.
     *
     * @param IsSameTax Use the same tax as the main transaction
     */
    public void setIsSameTax(boolean IsSameTax) {
        setValue(COLUMNNAME_IsSameTax, IsSameTax);
    }

    /**
     * Set Price includes Tax.
     *
     * @param IsTaxIncluded Tax is included in the price
     */
    public void setIsTaxIncluded(boolean IsTaxIncluded) {
        setValue(COLUMNNAME_IsTaxIncluded, IsTaxIncluded);
    }

    /**
     * Get Name.
     *
     * @return Alphanumeric identifier of the entity
     */
    public String getName() {
        return (String) getValue(HasName.COLUMNNAME_Name);
    }

    /**
     * Set Name.
     *
     * @param Name Alphanumeric identifier of the entity
     */
    public void setName(String Name) {
        setValue(HasName.COLUMNNAME_Name, Name);
    }

    @Override
    public int getTableId() {
        return I_C_Charge.Table_ID;
    }
}
