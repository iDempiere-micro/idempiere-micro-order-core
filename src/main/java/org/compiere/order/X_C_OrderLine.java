package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_OrderLine;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Generated Model for C_OrderLine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_OrderLine extends PO {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_C_OrderLine(Properties ctx, int C_OrderLine_ID) {
        super(ctx, C_OrderLine_ID);
        /**
         * if (C_OrderLine_ID == 0) { setC_BPartner_Location_ID (0); // @C_BPartner_Location_ID@
         * setCurrencyId (0); // @C_Currency_ID@ setC_Order_ID (0); setC_OrderLine_ID (0);
         * setC_Tax_ID (0); setC_UOM_ID (0); // @#C_UOM_ID@ setDateOrdered (new Timestamp(
         * System.currentTimeMillis() )); // @DateOrdered@ setFreightAmt (Env.ZERO); setIsDescription
         * (false); // N setLine (0); // @SQL=SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM
         * C_OrderLine WHERE C_Order_ID=@C_Order_ID@ setLineNetAmt (Env.ZERO);
         * setM_AttributeSetInstance_ID (0); setWarehouseId (0); // @M_Warehouse_ID@ setPriceActual
         * (Env.ZERO); setPriceEntered (Env.ZERO); setPriceLimit (Env.ZERO); setPriceList (Env.ZERO);
         * setProcessed (false); setQtyDelivered (Env.ZERO); setQtyEntered (Env.ZERO); // 1
         * setQtyInvoiced (Env.ZERO); setQtyLostSales (Env.ZERO); setQtyOrdered (Env.ZERO); // 1
         * setQtyReserved (Env.ZERO); }
         */
    }

    /**
     * Load Constructor
     */
    public X_C_OrderLine(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    }

    public X_C_OrderLine(Properties ctx, Row row) {
        super(ctx, row);
    }

    /**
     * AccessLevel
     *
     * @return 1 - Org
     */
    protected int getAccessLevel() {
        return I_C_OrderLine.accessLevel.intValue();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("X_C_OrderLine[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Trx Organization.
     *
     * @return Performing or initiating organization
     */
    public int getAD_OrgTrx_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_AD_OrgTrx_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Activity.
     *
     * @return Business Activity
     */
    public int getC_Activity_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_Activity_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Activity.
     *
     * @param C_Activity_ID Business Activity
     */
    public void setC_Activity_ID(int C_Activity_ID) {
        if (C_Activity_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_C_Activity_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
    }

    /**
     * Get Business Partner .
     *
     * @return Identifies a Business Partner
     */
    public int getC_BPartner_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Business Partner .
     *
     * @param C_BPartner_ID Identifies a Business Partner
     */
    public void setC_BPartner_ID(int C_BPartner_ID) {
        if (C_BPartner_ID < 1) set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_BPartner_ID, null);
        else set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
    }

    /**
     * Get Partner Location.
     *
     * @return Identifies the (ship to) address for this Business Partner
     */
    public int getC_BPartner_Location_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_BPartner_Location_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Partner Location.
     *
     * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
     */
    public void setC_BPartner_Location_ID(int C_BPartner_Location_ID) {
        if (C_BPartner_Location_ID < 1)
            set_Value(I_C_OrderLine.COLUMNNAME_C_BPartner_Location_ID, null);
        else
            set_Value(
                    I_C_OrderLine.COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
    }

    /**
     * Get Campaign.
     *
     * @return Marketing Campaign
     */
    public int getC_Campaign_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_Campaign_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Campaign.
     *
     * @param C_Campaign_ID Marketing Campaign
     */
    public void setC_Campaign_ID(int C_Campaign_ID) {
        if (C_Campaign_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_C_Campaign_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
    }

    /**
     * Get Charge.
     *
     * @return Additional document charges
     */
    public int getC_Charge_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_Charge_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Charge.
     *
     * @param C_Charge_ID Additional document charges
     */
    public void setC_Charge_ID(int C_Charge_ID) {
        if (C_Charge_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_C_Charge_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
    }

    /**
     * Get Currency.
     *
     * @return The Currency for this record
     */
    public int getC_Currency_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_Currency_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Currency.
     *
     * @param C_Currency_ID The Currency for this record
     */
    public void setC_Currency_ID(int C_Currency_ID) {
        if (C_Currency_ID < 1) set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_Currency_ID, null);
        else set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_Currency_ID, C_Currency_ID);
    }


    public org.compiere.model.I_C_Order getC_Order() throws RuntimeException {
        return (org.compiere.model.I_C_Order)
                MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
                        .getPO(getC_Order_ID());
    }

    /**
     * Get Order.
     *
     * @return Order
     */
    public int getC_Order_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_Order_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Order.
     *
     * @param C_Order_ID Order
     */
    public void setC_Order_ID(int C_Order_ID) {
        if (C_Order_ID < 1) set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_Order_ID, null);
        else set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_Order_ID, C_Order_ID);
    }

    /**
     * Get Sales Order Line.
     *
     * @return Sales Order Line
     */
    public int getC_OrderLine_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_OrderLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Project.
     *
     * @return Financial Project
     */
    public int getC_Project_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_Project_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Project.
     *
     * @param C_Project_ID Financial Project
     */
    public void setC_Project_ID(int C_Project_ID) {
        if (C_Project_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_C_Project_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
    }

    /**
     * Get Project Phase.
     *
     * @return Phase of a Project
     */
    public int getC_ProjectPhase_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_ProjectPhase_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Project Phase.
     *
     * @param C_ProjectPhase_ID Phase of a Project
     */
    public void setC_ProjectPhase_ID(int C_ProjectPhase_ID) {
        if (C_ProjectPhase_ID < 1) set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_ProjectPhase_ID, null);
        else
            set_ValueNoCheck(
                    I_C_OrderLine.COLUMNNAME_C_ProjectPhase_ID, Integer.valueOf(C_ProjectPhase_ID));
    }

    /**
     * Get Project Task.
     *
     * @return Actual Project Task in a Phase
     */
    public int getC_ProjectTask_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_ProjectTask_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Project Task.
     *
     * @param C_ProjectTask_ID Actual Project Task in a Phase
     */
    public void setC_ProjectTask_ID(int C_ProjectTask_ID) {
        if (C_ProjectTask_ID < 1) set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_ProjectTask_ID, null);
        else
            set_ValueNoCheck(
                    I_C_OrderLine.COLUMNNAME_C_ProjectTask_ID, Integer.valueOf(C_ProjectTask_ID));
    }

    /**
     * Get Tax.
     *
     * @return Tax identifier
     */
    public int getC_Tax_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_Tax_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Tax.
     *
     * @param C_Tax_ID Tax identifier
     */
    public void setC_Tax_ID(int C_Tax_ID) {
        if (C_Tax_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_C_Tax_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
    }

    /**
     * Get UOM.
     *
     * @return Unit of Measure
     */
    public int getC_UOM_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_C_UOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set UOM.
     *
     * @param C_UOM_ID Unit of Measure
     */
    public void setC_UOM_ID(int C_UOM_ID) {
        if (C_UOM_ID < 1) set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_UOM_ID, null);
        else set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
    }

    /**
     * Set Date Delivered.
     *
     * @param DateDelivered Date when the product was delivered
     */
    public void setDateDelivered(Timestamp DateDelivered) {
        set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_DateDelivered, DateDelivered);
    }

    /**
     * Set Date Invoiced.
     *
     * @param DateInvoiced Date printed on Invoice
     */
    public void setDateInvoiced(Timestamp DateInvoiced) {
        set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_DateInvoiced, DateInvoiced);
    }

    /**
     * Get Date Ordered.
     *
     * @return Date of Order
     */
    public Timestamp getDateOrdered() {
        return (Timestamp) getValue(I_C_OrderLine.COLUMNNAME_DateOrdered);
    }

    /**
     * Set Date Ordered.
     *
     * @param DateOrdered Date of Order
     */
    public void setDateOrdered(Timestamp DateOrdered) {
        set_Value(I_C_OrderLine.COLUMNNAME_DateOrdered, DateOrdered);
    }

    /**
     * Get Date Promised.
     *
     * @return Date Order was promised
     */
    public Timestamp getDatePromised() {
        return (Timestamp) getValue(I_C_OrderLine.COLUMNNAME_DatePromised);
    }

    /**
     * Set Date Promised.
     *
     * @param DatePromised Date Order was promised
     */
    public void setDatePromised(Timestamp DatePromised) {
        set_Value(I_C_OrderLine.COLUMNNAME_DatePromised, DatePromised);
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) getValue(I_C_OrderLine.COLUMNNAME_Description);
    }

    /**
     * Set Discount %.
     *
     * @param Discount Discount in percent
     */
    public void setDiscount(BigDecimal Discount) {
        set_Value(I_C_OrderLine.COLUMNNAME_Discount, Discount);
    }

    /**
     * Get Freight Amount.
     *
     * @return Freight Amount
     */
    public BigDecimal getFreightAmt() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_FreightAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Freight Amount.
     *
     * @param FreightAmt Freight Amount
     */
    public void setFreightAmt(BigDecimal FreightAmt) {
        set_Value(I_C_OrderLine.COLUMNNAME_FreightAmt, FreightAmt);
    }

    /**
     * Set Description Only.
     *
     * @param IsDescription if true, the line is just description and no transaction
     */
    public void setIsDescription(boolean IsDescription) {
        set_Value(I_C_OrderLine.COLUMNNAME_IsDescription, Boolean.valueOf(IsDescription));
    }

    /**
     * Get Description Only.
     *
     * @return if true, the line is just description and no transaction
     */
    public boolean isDescription() {
        Object oo = getValue(I_C_OrderLine.COLUMNNAME_IsDescription);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        set_Value(I_C_OrderLine.COLUMNNAME_Description, Description);
    }

    /**
     * Get Line No.
     *
     * @return Unique line for this document
     */
    public int getLine() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_Line);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Line No.
     *
     * @param Line Unique line for this document
     */
    public void setLine(int Line) {
        set_Value(I_C_OrderLine.COLUMNNAME_Line, Integer.valueOf(Line));
    }

    /**
     * Get Line Amount.
     *
     * @return Line Extended Amount (Quantity * Actual Price) without Freight and Charges
     */
    public BigDecimal getLineNetAmt() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_LineNetAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Line Amount.
     *
     * @param LineNetAmt Line Extended Amount (Quantity * Actual Price) without Freight and Charges
     */
    public void setLineNetAmt(BigDecimal LineNetAmt) {
        set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_LineNetAmt, LineNetAmt);
    }

    /**
     * Get Linked Order Line.
     *
     * @return This field links a sales order line to the purchase order line that is generated from
     * it.
     */
    public int getLink_OrderLine_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_Link_OrderLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Linked Order Line.
     *
     * @param Link_OrderLine_ID This field links a sales order line to the purchase order line that is
     *                          generated from it.
     */
    public void setLink_OrderLine_ID(int Link_OrderLine_ID) {
        if (Link_OrderLine_ID < 1) set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_Link_OrderLine_ID, null);
        else
            set_ValueNoCheck(
                    I_C_OrderLine.COLUMNNAME_Link_OrderLine_ID, Integer.valueOf(Link_OrderLine_ID));
    }

    /**
     * Set Attribute Set Instance.
     *
     * @param M_AttributeSetInstance_ID Product Attribute Set Instance
     */
    public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
        if (M_AttributeSetInstance_ID < 0)
            set_Value(I_C_OrderLine.COLUMNNAME_M_AttributeSetInstance_ID, null);
        else
            set_Value(
                    I_C_OrderLine.COLUMNNAME_M_AttributeSetInstance_ID,
                    Integer.valueOf(M_AttributeSetInstance_ID));
    }

    /**
     * Get Attribute Set Instance.
     *
     * @return Product Attribute Set Instance
     */
    public int getMAttributeSetInstance_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_M_AttributeSetInstance_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getM_Product_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_M_Product_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Product.
     *
     * @param M_Product_ID Product, Service, Item
     */
    public void setM_Product_ID(int M_Product_ID) {
        if (M_Product_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_M_Product_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
    }

    /**
     * Set Shipper.
     *
     * @param M_Shipper_ID Method or manner of product delivery
     */
    public void setM_Shipper_ID(int M_Shipper_ID) {
        if (M_Shipper_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_M_Shipper_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_M_Shipper_ID, Integer.valueOf(M_Shipper_ID));
    }

    /**
     * Get Warehouse.
     *
     * @return Storage Warehouse and Service Point
     */
    public int getM_Warehouse_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_M_Warehouse_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Warehouse.
     *
     * @param M_Warehouse_ID Storage Warehouse and Service Point
     */
    public void setM_Warehouse_ID(int M_Warehouse_ID) {
        if (M_Warehouse_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_M_Warehouse_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
    }

    /**
     * Get Unit Price.
     *
     * @return Actual Price
     */
    public BigDecimal getPriceActual() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_PriceActual);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Unit Price.
     *
     * @param PriceActual Actual Price
     */
    public void setPriceActual(BigDecimal PriceActual) {
        set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_PriceActual, PriceActual);
    }

    /**
     * Get Cost Price.
     *
     * @return Price per Unit of Measure including all indirect costs (Freight, etc.)
     */
    public BigDecimal getPriceCost() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_PriceCost);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Get Price.
     *
     * @return Price Entered - the price based on the selected/base UoM
     */
    public BigDecimal getPriceEntered() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_PriceEntered);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Price.
     *
     * @param PriceEntered Price Entered - the price based on the selected/base UoM
     */
    public void setPriceEntered(BigDecimal PriceEntered) {
        set_Value(I_C_OrderLine.COLUMNNAME_PriceEntered, PriceEntered);
    }

    /**
     * Get Limit Price.
     *
     * @return Lowest price for a product
     */
    public BigDecimal getPriceLimit() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_PriceLimit);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Limit Price.
     *
     * @param PriceLimit Lowest price for a product
     */
    public void setPriceLimit(BigDecimal PriceLimit) {
        set_Value(I_C_OrderLine.COLUMNNAME_PriceLimit, PriceLimit);
    }

    /**
     * Get List Price.
     *
     * @return List Price
     */
    public BigDecimal getPriceList() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_PriceList);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set List Price.
     *
     * @param PriceList List Price
     */
    public void setPriceList(BigDecimal PriceList) {
        set_Value(I_C_OrderLine.COLUMNNAME_PriceList, PriceList);
    }

    /**
     * Get Processed.
     *
     * @return The document has been processed
     */
    public boolean isProcessed() {
        Object oo = getValue(I_C_OrderLine.COLUMNNAME_Processed);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
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
        set_Value(I_C_OrderLine.COLUMNNAME_Processed, Boolean.valueOf(Processed));
    }

    /**
     * Get Delivered Quantity.
     *
     * @return Delivered Quantity
     */
    public BigDecimal getQtyDelivered() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_QtyDelivered);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Delivered Quantity.
     *
     * @param QtyDelivered Delivered Quantity
     */
    public void setQtyDelivered(BigDecimal QtyDelivered) {
        set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_QtyDelivered, QtyDelivered);
    }

    /**
     * Get Quantity.
     *
     * @return The Quantity Entered is based on the selected UoM
     */
    public BigDecimal getQtyEntered() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_QtyEntered);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Quantity.
     *
     * @param QtyEntered The Quantity Entered is based on the selected UoM
     */
    public void setQtyEntered(BigDecimal QtyEntered) {
        set_Value(I_C_OrderLine.COLUMNNAME_QtyEntered, QtyEntered);
    }

    /**
     * Get Quantity Invoiced.
     *
     * @return Invoiced Quantity
     */
    public BigDecimal getQtyInvoiced() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_QtyInvoiced);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Quantity Invoiced.
     *
     * @param QtyInvoiced Invoiced Quantity
     */
    public void setQtyInvoiced(BigDecimal QtyInvoiced) {
        set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_QtyInvoiced, QtyInvoiced);
    }

    /**
     * Get Lost Sales Qty.
     *
     * @return Quantity of potential sales
     */
    public BigDecimal getQtyLostSales() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_QtyLostSales);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Lost Sales Qty.
     *
     * @param QtyLostSales Quantity of potential sales
     */
    public void setQtyLostSales(BigDecimal QtyLostSales) {
        set_Value(I_C_OrderLine.COLUMNNAME_QtyLostSales, QtyLostSales);
    }

    /**
     * Get Ordered Quantity.
     *
     * @return Ordered Quantity
     */
    public BigDecimal getQtyOrdered() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_QtyOrdered);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Ordered Quantity.
     *
     * @param QtyOrdered Ordered Quantity
     */
    public void setQtyOrdered(BigDecimal QtyOrdered) {
        set_Value(I_C_OrderLine.COLUMNNAME_QtyOrdered, QtyOrdered);
    }

    /**
     * Get Reserved Quantity.
     *
     * @return Reserved Quantity
     */
    public BigDecimal getQtyReserved() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_QtyReserved);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Reserved Quantity.
     *
     * @param QtyReserved Reserved Quantity
     */
    public void setQtyReserved(BigDecimal QtyReserved) {
        set_ValueNoCheck(I_C_OrderLine.COLUMNNAME_QtyReserved, QtyReserved);
    }

    /**
     * Get Referenced Order Line.
     *
     * @return Reference to corresponding Sales/Purchase Order
     */
    public int getRef_OrderLine_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_Ref_OrderLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Referenced Order Line.
     *
     * @param Ref_OrderLine_ID Reference to corresponding Sales/Purchase Order
     */
    public void setRef_OrderLine_ID(int Ref_OrderLine_ID) {
        if (Ref_OrderLine_ID < 1) set_Value(I_C_OrderLine.COLUMNNAME_Ref_OrderLine_ID, null);
        else set_Value(I_C_OrderLine.COLUMNNAME_Ref_OrderLine_ID, Integer.valueOf(Ref_OrderLine_ID));
    }

    /**
     * Get Revenue Recognition Amt.
     *
     * @return Revenue Recognition Amount
     */
    public BigDecimal getRRAmt() {
        BigDecimal bd = (BigDecimal) getValue(I_C_OrderLine.COLUMNNAME_RRAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Get Revenue Recognition Start.
     *
     * @return Revenue Recognition Start Date
     */
    public Timestamp getRRStartDate() {
        return (Timestamp) getValue(I_C_OrderLine.COLUMNNAME_RRStartDate);
    }

    /**
     * Get Resource Assignment.
     *
     * @return Resource Assignment
     */
    public int getS_ResourceAssignment_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_S_ResourceAssignment_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Resource Assignment.
     *
     * @param S_ResourceAssignment_ID Resource Assignment
     */
    public void setS_ResourceAssignment_ID(int S_ResourceAssignment_ID) {
        if (S_ResourceAssignment_ID < 1)
            set_Value(I_C_OrderLine.COLUMNNAME_S_ResourceAssignment_ID, null);
        else
            set_Value(
                    I_C_OrderLine.COLUMNNAME_S_ResourceAssignment_ID,
                    Integer.valueOf(S_ResourceAssignment_ID));
    }

    /**
     * Get User Element List 1.
     *
     * @return User defined list element #1
     */
    public int getUser1_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_User1_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get User Element List 2.
     *
     * @return User defined list element #2
     */
    public int getUser2_ID() {
        Integer ii = (Integer) getValue(I_C_OrderLine.COLUMNNAME_User2_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_C_OrderLine.Table_ID;
    }
}
