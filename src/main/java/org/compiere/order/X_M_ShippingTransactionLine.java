package org.compiere.order;

import org.compiere.model.I_M_ShippingTransactionLine;
import org.compiere.orm.PO;

import java.math.BigDecimal;
import java.sql.ResultSet;
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
         * if (M_ShippingTransactionLine_ID == 0) { setM_ShippingTransaction_ID (0);
         * setM_ShippingTransactionLine_ID (0); setProcessed (false); // N }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_ShippingTransactionLine(Properties ctx, ResultSet rs) {
        super(ctx, rs);
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
    public void setC_UOM_Length_ID(int C_UOM_Length_ID) {
        if (C_UOM_Length_ID < 1) set_Value(COLUMNNAME_C_UOM_Length_ID, null);
        else set_Value(COLUMNNAME_C_UOM_Length_ID, Integer.valueOf(C_UOM_Length_ID));
    }

    /**
     * Set UOM for Weight.
     *
     * @param C_UOM_Weight_ID Standard Unit of Measure for Weight
     */
    public void setC_UOM_Weight_ID(int C_UOM_Weight_ID) {
        if (C_UOM_Weight_ID < 1) set_Value(COLUMNNAME_C_UOM_Weight_ID, null);
        else set_Value(COLUMNNAME_C_UOM_Weight_ID, Integer.valueOf(C_UOM_Weight_ID));
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
     * Set Height.
     *
     * @param Height Height
     */
    public void setHeight(BigDecimal Height) {
        set_Value(COLUMNNAME_Height, Height);
    }

    /**
     * Set Length.
     *
     * @param Length Length
     */
    public void setLength(BigDecimal Length) {
        set_Value(COLUMNNAME_Length, Length);
    }

    /**
     * Set Shipping Transaction.
     *
     * @param M_ShippingTransaction_ID Shipping Transaction
     */
    public void setM_ShippingTransaction_ID(int M_ShippingTransaction_ID) {
        if (M_ShippingTransaction_ID < 1) set_ValueNoCheck(COLUMNNAME_M_ShippingTransaction_ID, null);
        else
            set_ValueNoCheck(
                    COLUMNNAME_M_ShippingTransaction_ID, Integer.valueOf(M_ShippingTransaction_ID));
    }

    /**
     * Set Sequence.
     *
     * @param SeqNo Method of ordering records; lowest number comes first
     */
    public void setSeqNo(int SeqNo) {
        set_Value(COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
    }

    /**
     * Set Weight.
     *
     * @param Weight Weight of a product
     */
    public void setWeight(BigDecimal Weight) {
        set_Value(COLUMNNAME_Weight, Weight);
    }

    /**
     * Set Width.
     *
     * @param Width Width
     */
    public void setWidth(BigDecimal Width) {
        set_Value(COLUMNNAME_Width, Width);
    }

    @Override
    public int getTableId() {
        return I_M_ShippingTransactionLine.Table_ID;
    }
}
