package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_M_InOut;
import org.compiere.model.I_M_InOutLine;
import org.compiere.model.I_M_Product;
import org.compiere.model.I_M_RMALine;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import software.hsharp.core.orm.MBaseTableKt;

import java.math.BigDecimal;

/**
 * Generated Model for M_InOutLine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public abstract class X_M_InOutLine extends PO implements I_M_InOutLine {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_InOutLine(int M_InOutLine_ID) {
        super(M_InOutLine_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_InOutLine(Row row) {
        super(row);
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
        return "X_M_InOutLine[" + getId() + "]";
    }

    /**
     * Get Trx Organization.
     *
     * @return Performing or initiating organization
     */
    public int getTransactionOrganizationId() {
        Integer ii = getValue(COLUMNNAME_AD_OrgTrx_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Trx Organization.
     *
     * @param AD_OrgTrx_ID Performing or initiating organization
     */
    public void setTransactionOrganizationId(int AD_OrgTrx_ID) {
        if (AD_OrgTrx_ID < 1) setValue(COLUMNNAME_AD_OrgTrx_ID, null);
        else setValue(COLUMNNAME_AD_OrgTrx_ID, AD_OrgTrx_ID);
    }

    /**
     * Get Activity.
     *
     * @return Business Activity
     */
    public int getBusinessActivityId() {
        Integer ii = getValue(COLUMNNAME_C_Activity_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Activity.
     *
     * @param C_Activity_ID Business Activity
     */
    public void setBusinessActivityId(int C_Activity_ID) {
        if (C_Activity_ID < 1) setValue(COLUMNNAME_C_Activity_ID, null);
        else setValue(COLUMNNAME_C_Activity_ID, C_Activity_ID);
    }

    /**
     * Get Campaign.
     *
     * @return Marketing Campaign
     */
    public int getCampaignId() {
        Integer ii = getValue(COLUMNNAME_C_Campaign_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Campaign.
     *
     * @param C_Campaign_ID Marketing Campaign
     */
    public void setCampaignId(int C_Campaign_ID) {
        if (C_Campaign_ID < 1) setValue(COLUMNNAME_C_Campaign_ID, null);
        else setValue(COLUMNNAME_C_Campaign_ID, C_Campaign_ID);
    }

    /**
     * Get Charge.
     *
     * @return Additional document charges
     */
    public int getChargeId() {
        Integer ii = getValue(COLUMNNAME_C_Charge_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Charge.
     *
     * @param C_Charge_ID Additional document charges
     */
    public void setChargeId(int C_Charge_ID) {
        if (C_Charge_ID < 1) setValue(COLUMNNAME_C_Charge_ID, null);
        else setValue(COLUMNNAME_C_Charge_ID, C_Charge_ID);
    }

    /**
     * Set Confirmed Quantity.
     *
     * @param ConfirmedQty Confirmation of a received quantity
     */
    public void setConfirmedQty(BigDecimal ConfirmedQty) {
        setValue(COLUMNNAME_ConfirmedQty, ConfirmedQty);
    }

    public I_C_OrderLine getOrderLine() throws RuntimeException {
        return (I_C_OrderLine)
                MBaseTableKt.getTable(I_C_OrderLine.Table_Name)
                        .getPO(getOrderLineId());
    }

    /**
     * Get Sales Order Line.
     *
     * @return Sales Order Line
     */
    public int getOrderLineId() {
        Integer ii = getValue(COLUMNNAME_C_OrderLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Sales Order Line.
     *
     * @param C_OrderLine_ID Sales Order Line
     */
    public void setOrderLineId(int C_OrderLine_ID) {
        if (C_OrderLine_ID < 1) setValueNoCheck(COLUMNNAME_C_OrderLine_ID, null);
        else setValueNoCheck(COLUMNNAME_C_OrderLine_ID, C_OrderLine_ID);
    }

    /**
     * Get Project.
     *
     * @return Financial Project
     */
    public int getProjectId() {
        Integer ii = getValue(COLUMNNAME_C_Project_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Project.
     *
     * @param C_Project_ID Financial Project
     */
    public void setProjectId(int C_Project_ID) {
        if (C_Project_ID < 1) setValue(COLUMNNAME_C_Project_ID, null);
        else setValue(COLUMNNAME_C_Project_ID, C_Project_ID);
    }

    /**
     * Get Project Phase.
     *
     * @return Phase of a Project
     */
    public int getProjectPhaseId() {
        Integer ii = getValue(COLUMNNAME_C_ProjectPhase_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Project Phase.
     *
     * @param C_ProjectPhase_ID Phase of a Project
     */
    public void setProjectPhaseId(int C_ProjectPhase_ID) {
        if (C_ProjectPhase_ID < 1) setValue(COLUMNNAME_C_ProjectPhase_ID, null);
        else setValue(COLUMNNAME_C_ProjectPhase_ID, C_ProjectPhase_ID);
    }

    /**
     * Get Project Task.
     *
     * @return Actual Project Task in a Phase
     */
    public int getProjectTaskId() {
        Integer ii = getValue(COLUMNNAME_C_ProjectTask_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Project Task.
     *
     * @param C_ProjectTask_ID Actual Project Task in a Phase
     */
    public void setProjectTaskId(int C_ProjectTask_ID) {
        if (C_ProjectTask_ID < 1) setValue(COLUMNNAME_C_ProjectTask_ID, null);
        else setValue(COLUMNNAME_C_ProjectTask_ID, C_ProjectTask_ID);
    }

    /**
     * Get UOM.
     *
     * @return Unit of Measure
     */
    public int getUOMId() {
        Integer ii = getValue(COLUMNNAME_C_UOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set UOM.
     *
     * @param C_UOM_ID Unit of Measure
     */
    public void setUOMId(int C_UOM_ID) {
        if (C_UOM_ID < 1) setValueNoCheck(COLUMNNAME_C_UOM_ID, null);
        else setValueNoCheck(COLUMNNAME_C_UOM_ID, C_UOM_ID);
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return getValue(COLUMNNAME_Description);
    }

    /**
     * Set Description Only.
     *
     * @param IsDescription if true, the line is just description and no transaction
     */
    public void setIsDescription(boolean IsDescription) {
        setValue(COLUMNNAME_IsDescription, IsDescription);
    }

    /**
     * Get Description Only.
     *
     * @return if true, the line is just description and no transaction
     */
    public boolean isDescription() {
        Object oo = getValue(COLUMNNAME_IsDescription);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(COLUMNNAME_Description, Description);
    }

    /**
     * Set Invoiced.
     *
     * @param IsInvoiced Is this invoiced?
     */
    public void setIsInvoiced(boolean IsInvoiced) {
        setValue(COLUMNNAME_IsInvoiced, IsInvoiced);
    }

    /**
     * Get Invoiced.
     *
     * @return Is this invoiced?
     */
    public boolean isInvoiced() {
        Object oo = getValue(COLUMNNAME_IsInvoiced);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Line No.
     *
     * @return Unique line for this document
     */
    public int getLine() {
        Integer ii = getValue(COLUMNNAME_Line);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Line No.
     *
     * @param Line Unique line for this document
     */
    public void setLine(int Line) {
        setValue(COLUMNNAME_Line, Line);
    }

    /**
     * Get Attribute Set Instance.
     *
     * @return Product Attribute Set Instance
     */
    public int getAttributeSetInstanceId() {
        Integer ii = getValue(COLUMNNAME_M_AttributeSetInstance_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Attribute Set Instance.
     *
     * @param M_AttributeSetInstance_ID Product Attribute Set Instance
     */
    public void setAttributeSetInstanceId(int M_AttributeSetInstance_ID) {
        if (M_AttributeSetInstance_ID < 0) setValue(COLUMNNAME_M_AttributeSetInstance_ID, null);
        else
            setValue(COLUMNNAME_M_AttributeSetInstance_ID, M_AttributeSetInstance_ID);
    }

    public I_M_InOut getInOut() throws RuntimeException {
        return (I_M_InOut)
                MBaseTableKt.getTable(I_M_InOut.Table_Name)
                        .getPO(getInOutId());
    }

    /**
     * Get Shipment/Receipt.
     *
     * @return Material Shipment Document
     */
    public int getInOutId() {
        Integer ii = getValue(COLUMNNAME_M_InOut_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Shipment/Receipt.
     *
     * @param M_InOut_ID Material Shipment Document
     */
    public void setInOutId(int M_InOut_ID) {
        if (M_InOut_ID < 1) setValueNoCheck(COLUMNNAME_M_InOut_ID, null);
        else setValueNoCheck(COLUMNNAME_M_InOut_ID, M_InOut_ID);
    }

    /**
     * Get Shipment/Receipt Line.
     *
     * @return Line on Shipment or Receipt document
     */
    public int getInOutLineId() {
        Integer ii = getValue(COLUMNNAME_M_InOutLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Locator.
     *
     * @return Warehouse Locator
     */
    public int getLocatorId() {
        Integer ii = getValue(COLUMNNAME_M_Locator_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Locator.
     *
     * @param M_Locator_ID Warehouse Locator
     */
    public void setLocatorId(int M_Locator_ID) {
        if (M_Locator_ID < 1) setValue(COLUMNNAME_M_Locator_ID, null);
        else setValue(COLUMNNAME_M_Locator_ID, M_Locator_ID);
    }

    /**
     * Get Movement Quantity.
     *
     * @return Quantity of a product moved.
     */
    public BigDecimal getMovementQty() {
        BigDecimal bd = getValue(COLUMNNAME_MovementQty);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Movement Quantity.
     *
     * @param MovementQty Quantity of a product moved.
     */
    public void setMovementQty(BigDecimal MovementQty) {
        setValue(COLUMNNAME_MovementQty, MovementQty);
    }

    public I_M_Product getProduct() throws RuntimeException {
        return (I_M_Product)
                MBaseTableKt.getTable(I_M_Product.Table_Name)
                        .getPO(getProductId());
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getProductId() {
        Integer ii = getValue(COLUMNNAME_M_Product_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Product.
     *
     * @param M_Product_ID Product, Service, Item
     */
    public void setProductId(int M_Product_ID) {
        if (M_Product_ID < 1) setValue(COLUMNNAME_M_Product_ID, null);
        else setValue(COLUMNNAME_M_Product_ID, M_Product_ID);
    }

    public I_M_RMALine getRMALine() throws RuntimeException {
        return (I_M_RMALine)
                MBaseTableKt.getTable(I_M_RMALine.Table_Name)
                        .getPO(getRMALineId());
    }

    /**
     * Get RMA Line.
     *
     * @return Return Material Authorization Line
     */
    public int getRMALineId() {
        Integer ii = getValue(COLUMNNAME_M_RMALine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set RMA Line.
     *
     * @param M_RMALine_ID Return Material Authorization Line
     */
    public void setRMALineId(int M_RMALine_ID) {
        if (M_RMALine_ID < 1) setValue(COLUMNNAME_M_RMALine_ID, null);
        else setValue(COLUMNNAME_M_RMALine_ID, M_RMALine_ID);
    }

    /**
     * Set Picked Quantity.
     *
     * @param PickedQty Picked Quantity
     */
    public void setPickedQty(BigDecimal PickedQty) {
        setValue(COLUMNNAME_PickedQty, PickedQty);
    }

    /**
     * Set Processed.
     *
     * @param Processed The document has been processed
     */
    public void setProcessed(boolean Processed) {
        setValue(COLUMNNAME_Processed, Processed);
    }

    /**
     * Get Quantity.
     *
     * @return The Quantity Entered is based on the selected UoM
     */
    public BigDecimal getQtyEntered() {
        BigDecimal bd = getValue(COLUMNNAME_QtyEntered);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Quantity.
     *
     * @param QtyEntered The Quantity Entered is based on the selected UoM
     */
    public void setQtyEntered(BigDecimal QtyEntered) {
        setValue(COLUMNNAME_QtyEntered, QtyEntered);
    }

    /**
     * Get Over Receipt.
     *
     * @return Over Receipt Quantity
     */
    public BigDecimal getQtyOverReceipt() {
        BigDecimal bd = getValue(COLUMNNAME_QtyOverReceipt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Over Receipt.
     *
     * @param QtyOverReceipt Over Receipt Quantity
     */
    public void setQtyOverReceipt(BigDecimal QtyOverReceipt) {
        setValue(COLUMNNAME_QtyOverReceipt, QtyOverReceipt);
    }

    /**
     * Get Referenced Shipment Line.
     *
     * @return Referenced Shipment Line
     */
    public int getReferencedInOutLineId() {
        Integer ii = getValue(COLUMNNAME_Ref_InOutLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Referenced Shipment Line.
     *
     * @param Ref_InOutLine_ID Referenced Shipment Line
     */
    public void setReferencedInOutLineId(int Ref_InOutLine_ID) {
        if (Ref_InOutLine_ID < 1) setValue(COLUMNNAME_Ref_InOutLine_ID, null);
        else setValue(COLUMNNAME_Ref_InOutLine_ID, Ref_InOutLine_ID);
    }

    /**
     * Get Reversal Line.
     *
     * @return Use to keep the reversal line ID for reversing costing purpose
     */
    public int getReversalLineId() {
        Integer ii = getValue(COLUMNNAME_ReversalLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Reversal Line.
     *
     * @param ReversalLine_ID Use to keep the reversal line ID for reversing costing purpose
     */
    public void setReversalLineId(int ReversalLine_ID) {
        if (ReversalLine_ID < 1) setValue(COLUMNNAME_ReversalLine_ID, null);
        else setValue(COLUMNNAME_ReversalLine_ID, ReversalLine_ID);
    }

    /**
     * Set Scrapped Quantity.
     *
     * @param ScrappedQty The Quantity scrapped due to QA issues
     */
    public void setScrappedQty(BigDecimal ScrappedQty) {
        setValue(COLUMNNAME_ScrappedQty, ScrappedQty);
    }

    /**
     * Set Target Quantity.
     *
     * @param TargetQty Target Movement Quantity
     */
    public void setTargetQty(BigDecimal TargetQty) {
        setValue(COLUMNNAME_TargetQty, TargetQty);
    }

    /**
     * Get User Element List 1.
     *
     * @return User defined list element #1
     */
    public int getUser1Id() {
        Integer ii = getValue(COLUMNNAME_User1_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set User Element List 1.
     *
     * @param User1_ID User defined list element #1
     */
    public void setUser1Id(int User1_ID) {
        if (User1_ID < 1) setValue(COLUMNNAME_User1_ID, null);
        else setValue(COLUMNNAME_User1_ID, User1_ID);
    }

    /**
     * Get User Element List 2.
     *
     * @return User defined list element #2
     */
    public int getUser2Id() {
        Integer ii = getValue(COLUMNNAME_User2_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set User Element List 2.
     *
     * @param User2_ID User defined list element #2
     */
    public void setUser2Id(int User2_ID) {
        if (User2_ID < 1) setValue(COLUMNNAME_User2_ID, null);
        else setValue(COLUMNNAME_User2_ID, User2_ID);
    }

    @Override
    public int getTableId() {
        return I_M_InOutLine.Table_ID;
    }
}
