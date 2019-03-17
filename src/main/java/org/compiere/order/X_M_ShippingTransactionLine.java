package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_ShippingTransactionLine;
import org.compiere.orm.PO;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Generated Model for M_ShippingTransactionLine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShippingTransactionLine extends PO
        implements I_M_ShippingTransactionLine {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ShippingTransactionLine(
            Properties ctx, int M_ShippingTransactionLine_ID) {
        super(ctx, M_ShippingTransactionLine_ID);
        /**
         * if (M_ShippingTransactionLine_ID == 0) { setShippingTransactionId (0);
         * setShippingTransactionLine_ID (0); setProcessed (false); // N }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_ShippingTransactionLine(Properties ctx, Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_ShippingTransactionLine[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Set UOM for Length.
     *
     * @param C_UOM_Length_ID Standard Unit of Measure for Length
     */
    public void setUOMLengthId(int C_UOM_Length_ID) {
        if (C_UOM_Length_ID < 1) setValue(COLUMNNAME_C_UOM_Length_ID, null);
        else setValue(COLUMNNAME_C_UOM_Length_ID, Integer.valueOf(C_UOM_Length_ID));
    }

    /**
     * Set UOM for Weight.
     *
     * @param C_UOM_Weight_ID Standard Unit of Measure for Weight
     */
    public void setUOMWeightId(int C_UOM_Weight_ID) {
        if (C_UOM_Weight_ID < 1) setValue(COLUMNNAME_C_UOM_Weight_ID, null);
        else setValue(COLUMNNAME_C_UOM_Weight_ID, Integer.valueOf(C_UOM_Weight_ID));
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        setValue(COLUMNNAME_Description, Description);
    }

    /**
     * Set Height.
     *
     * @param Height Height
     */
    public void setHeight(BigDecimal Height) {
        setValue(COLUMNNAME_Height, Height);
    }

    /**
     * Set Length.
     *
     * @param Length Length
     */
    public void setLength(BigDecimal Length) {
        setValue(COLUMNNAME_Length, Length);
    }

    /**
     * Set Shipping Transaction.
     *
     * @param M_ShippingTransaction_ID Shipping Transaction
     */
    public void setShippingTransactionId(int M_ShippingTransaction_ID) {
        if (M_ShippingTransaction_ID < 1) setValueNoCheck(COLUMNNAME_M_ShippingTransaction_ID, null);
        else
            setValueNoCheck(
                    COLUMNNAME_M_ShippingTransaction_ID, Integer.valueOf(M_ShippingTransaction_ID));
    }

    /**
     * Set Sequence.
     *
     * @param SeqNo Method of ordering records; lowest number comes first
     */
    public void setSeqNo(int SeqNo) {
        setValue(COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
    }

    /**
     * Set Weight.
     *
     * @param Weight Weight of a product
     */
    public void setWeight(BigDecimal Weight) {
        setValue(COLUMNNAME_Weight, Weight);
    }

    /**
     * Set Width.
     *
     * @param Width Width
     */
    public void setWidth(BigDecimal Width) {
        setValue(COLUMNNAME_Width, Width);
    }

    @Override
    public int getTableId() {
        return I_M_ShippingTransactionLine.Table_ID;
    }
}
