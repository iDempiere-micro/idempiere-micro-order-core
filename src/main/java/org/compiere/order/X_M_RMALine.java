package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_InOutLine;
import org.compiere.model.I_M_RMALine;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import software.hsharp.core.orm.MBaseTableKt;

import java.math.BigDecimal;

/**
 * Generated Model for M_RMALine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_RMALine extends PO {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_RMALine(int M_RMALine_ID) {
        super(M_RMALine_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_RMALine(Row row) {
        super(row);
    }

    /**
     * AccessLevel
     *
     * @return 1 - Org
     */
    protected int getAccessLevel() {
        return I_M_RMALine.accessLevel.intValue();
    }

    public String toString() {
        return "X_M_RMALine[" + getId() + "]";
    }

    /**
     * Get Amount.
     *
     * @return Amount
     */
    public BigDecimal getAmt() {
        BigDecimal bd = getValue(I_M_RMALine.COLUMNNAME_Amt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Amount.
     *
     * @param Amt Amount
     */
    public void setAmt(BigDecimal Amt) {
        setValue(I_M_RMALine.COLUMNNAME_Amt, Amt);
    }

    /**
     * Get Charge.
     *
     * @return Additional document charges
     */
    public int getChargeId() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_C_Charge_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Charge.
     *
     * @param C_Charge_ID Additional document charges
     */
    public void setChargeId(int C_Charge_ID) {
        if (C_Charge_ID < 1) setValue(I_M_RMALine.COLUMNNAME_C_Charge_ID, null);
        else setValue(I_M_RMALine.COLUMNNAME_C_Charge_ID, C_Charge_ID);
    }

    /**
     * Get Tax.
     *
     * @return Tax identifier
     */
    public int getTaxId() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_C_Tax_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Tax.
     *
     * @param C_Tax_ID Tax identifier
     */
    public void setTaxId(int C_Tax_ID) {
        if (C_Tax_ID < 1) setValue(I_M_RMALine.COLUMNNAME_C_Tax_ID, null);
        else setValue(I_M_RMALine.COLUMNNAME_C_Tax_ID, C_Tax_ID);
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return getValue(I_M_RMALine.COLUMNNAME_Description);
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        setValue(I_M_RMALine.COLUMNNAME_Description, Description);
    }

    /**
     * Get Line No.
     *
     * @return Unique line for this document
     */
    public int getLine() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_Line);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Line No.
     *
     * @param Line Unique line for this document
     */
    public void setLine(int Line) {
        setValue(I_M_RMALine.COLUMNNAME_Line, Line);
    }

    /**
     * Get Line Amount.
     *
     * @return Line Extended Amount (Quantity * Actual Price) without Freight and Charges
     */
    public BigDecimal getLineNetAmt() {
        BigDecimal bd = getValue(I_M_RMALine.COLUMNNAME_LineNetAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Line Amount.
     *
     * @param LineNetAmt Line Extended Amount (Quantity * Actual Price) without Freight and Charges
     */
    public void setLineNetAmt(BigDecimal LineNetAmt) {
        setValue(I_M_RMALine.COLUMNNAME_LineNetAmt, LineNetAmt);
    }

    public I_M_InOutLine getInOutLine() throws RuntimeException {
        return (I_M_InOutLine)
                MBaseTableKt.getTable(I_M_InOutLine.Table_Name)
                        .getPO(getInOutLineId());
    }


    /**
     * Get Shipment/Receipt Line.
     *
     * @return Line on Shipment or Receipt document
     */
    public int getInOutLineId() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_M_InOutLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Shipment/Receipt Line.
     *
     * @param M_InOutLine_ID Line on Shipment or Receipt document
     */
    public void setInOutLineId(int M_InOutLine_ID) {
        if (M_InOutLine_ID < 1) setValue(I_M_RMALine.COLUMNNAME_M_InOutLine_ID, null);
        else setValue(I_M_RMALine.COLUMNNAME_M_InOutLine_ID, M_InOutLine_ID);
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getProductId() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_M_Product_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Product.
     *
     * @param M_Product_ID Product, Service, Item
     */
    public void setProductId(int M_Product_ID) {
        if (M_Product_ID < 1) setValue(I_M_RMALine.COLUMNNAME_M_Product_ID, null);
        else setValue(I_M_RMALine.COLUMNNAME_M_Product_ID, M_Product_ID);
    }

    /**
     * Get RMA.
     *
     * @return Return Material Authorization
     */
    public int getRMAId() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_M_RMA_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set RMA.
     *
     * @param M_RMA_ID Return Material Authorization
     */
    public void setRMAId(int M_RMA_ID) {
        if (M_RMA_ID < 1) setValueNoCheck(I_M_RMALine.COLUMNNAME_M_RMA_ID, null);
        else setValueNoCheck(I_M_RMALine.COLUMNNAME_M_RMA_ID, M_RMA_ID);
    }

    /**
     * Get RMA Line.
     *
     * @return Return Material Authorization Line
     */
    public int getRMALineId() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_M_RMALine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Processed.
     *
     * @return The document has been processed
     */
    public boolean isProcessed() {
        Object oo = getValue(I_M_RMALine.COLUMNNAME_Processed);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Processed.
     *
     * @param Processed The document has been processed
     */
    public void setProcessed(boolean Processed) {
        setValue(I_M_RMALine.COLUMNNAME_Processed, Processed);
    }

    /**
     * Get Quantity.
     *
     * @return Quantity
     */
    public BigDecimal getQty() {
        BigDecimal bd = getValue(I_M_RMALine.COLUMNNAME_Qty);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Quantity.
     *
     * @param Qty Quantity
     */
    public void setQty(BigDecimal Qty) {
        setValue(I_M_RMALine.COLUMNNAME_Qty, Qty);
    }

    /**
     * Get Delivered Quantity.
     *
     * @return Delivered Quantity
     */
    public BigDecimal getQtyDelivered() {
        BigDecimal bd = getValue(I_M_RMALine.COLUMNNAME_QtyDelivered);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Delivered Quantity.
     *
     * @param QtyDelivered Delivered Quantity
     */
    public void setQtyDelivered(BigDecimal QtyDelivered) {
        setValue(I_M_RMALine.COLUMNNAME_QtyDelivered, QtyDelivered);
    }

    /**
     * Get Quantity Invoiced.
     *
     * @return Invoiced Quantity
     */
    public BigDecimal getQtyInvoiced() {
        BigDecimal bd = getValue(I_M_RMALine.COLUMNNAME_QtyInvoiced);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Quantity Invoiced.
     *
     * @param QtyInvoiced Invoiced Quantity
     */
    public void setQtyInvoiced(BigDecimal QtyInvoiced) {
        setValue(I_M_RMALine.COLUMNNAME_QtyInvoiced, QtyInvoiced);
    }

    /**
     * Get Referenced RMA Line.
     *
     * @return Referenced RMA Line
     */
    public int getRef_RMALineId() {
        Integer ii = getValue(I_M_RMALine.COLUMNNAME_Ref_RMALine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Referenced RMA Line.
     *
     * @param Ref_RMALine_ID Referenced RMA Line
     */
    public void setRefRMALineId(int Ref_RMALine_ID) {
        if (Ref_RMALine_ID < 1) setValue(I_M_RMALine.COLUMNNAME_Ref_RMALine_ID, null);
        else setValue(I_M_RMALine.COLUMNNAME_Ref_RMALine_ID, Ref_RMALine_ID);
    }

    @Override
    public int getTableId() {
        return I_M_RMALine.Table_ID;
    }
}
