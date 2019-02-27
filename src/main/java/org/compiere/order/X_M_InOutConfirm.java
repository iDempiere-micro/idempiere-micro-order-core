package org.compiere.order;

import org.compiere.model.I_M_InOutConfirm;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_InOutConfirm
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_InOutConfirm extends PO implements I_M_InOutConfirm {

    /**
     * ConfirmType AD_Reference_ID=320
     */
    public static final int CONFIRMTYPE_AD_Reference_ID = 320;
    /**
     * Vendor Confirmation = XV
     */
    public static final String CONFIRMTYPE_VendorConfirmation = "XV";
    /**
     * Customer Confirmation = XC
     */
    public static final String CONFIRMTYPE_CustomerConfirmation = "XC";
    /**
     * Drop Ship Confirm = DS
     */
    public static final String CONFIRMTYPE_DropShipConfirm = "DS";
    /**
     * Ship/Receipt Confirm = SC
     */
    public static final String CONFIRMTYPE_ShipReceiptConfirm = "SC";
    /**
     * Pick/QA Confirm = PC
     */
    public static final String CONFIRMTYPE_PickQAConfirm = "PC";
    /**
     * Complete = CO
     */
    public static final String DOCACTION_Complete = "CO";
    /**
     * Void = VO
     */
    public static final String DOCACTION_Void = "VO";
    /**
     * Close = CL
     */
    public static final String DOCACTION_Close = "CL";
    /**
     * <None> = --
     */
    public static final String DOCACTION_None = "--";
    /**
     * Prepare = PR
     */
    public static final String DOCACTION_Prepare = "PR";
    /**
     * Drafted = DR
     */
    public static final String DOCSTATUS_Drafted = "DR";
    /**
     * Approved = AP
     */
    public static final String DOCSTATUS_Approved = "AP";
    /**
     * Not Approved = NA
     */
    public static final String DOCSTATUS_NotApproved = "NA";
    /**
     * Voided = VO
     */
    public static final String DOCSTATUS_Voided = "VO";
    /**
     * Invalid = IN
     */
    public static final String DOCSTATUS_Invalid = "IN";
    /**
     * Reversed = RE
     */
    public static final String DOCSTATUS_Reversed = "RE";
    /**
     * Closed = CL
     */
    public static final String DOCSTATUS_Closed = "CL";
    /**
     * In Progress = IP
     */
    public static final String DOCSTATUS_InProgress = "IP";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_InOutConfirm(Properties ctx, int M_InOutConfirm_ID) {
        super(ctx, M_InOutConfirm_ID);
        /**
         * if (M_InOutConfirm_ID == 0) { setConfirmType (null); setDocAction (null); // CO setDocStatus
         * (null); // DR setDocumentNo (null); setIsApproved (false); setIsCancelled (false);
         * setIsInDispute (false); // N setM_InOutConfirm_ID (0); setM_InOut_ID (0); setProcessed
         * (false); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_InOutConfirm(Properties ctx, ResultSet rs) {
        super(ctx, rs);
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
        StringBuffer sb = new StringBuffer("X_M_InOutConfirm[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Approval Amount.
     *
     * @return Document Approval Amount
     */
    public BigDecimal getApprovalAmt() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_ApprovalAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Invoice.
     *
     * @param C_Invoice_ID Invoice Identifier
     */
    public void setInvoiceId(int C_Invoice_ID) {
        if (C_Invoice_ID < 1) setValue(COLUMNNAME_C_Invoice_ID, null);
        else setValue(COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
    }

    /**
     * Get Confirmation Type.
     *
     * @return Type of confirmation
     */
    public String getConfirmType() {
        return (String) getValue(COLUMNNAME_ConfirmType);
    }

    /**
     * Set Confirmation Type.
     *
     * @param ConfirmType Type of confirmation
     */
    public void setConfirmType(String ConfirmType) {

        setValue(COLUMNNAME_ConfirmType, ConfirmType);
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) getValue(COLUMNNAME_Description);
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
     * Get Document Action.
     *
     * @return The targeted status of the document
     */
    public String getDocAction() {
        return (String) getValue(COLUMNNAME_DocAction);
    }

    /**
     * Set Document Action.
     *
     * @param DocAction The targeted status of the document
     */
    public void setDocAction(String DocAction) {

        setValue(COLUMNNAME_DocAction, DocAction);
    }

    /**
     * Get Document Status.
     *
     * @return The current status of the document
     */
    public String getDocStatus() {
        return (String) getValue(COLUMNNAME_DocStatus);
    }

    /**
     * Set Document Status.
     *
     * @param DocStatus The current status of the document
     */
    public void setDocStatus(String DocStatus) {

        setValue(COLUMNNAME_DocStatus, DocStatus);
    }

    /**
     * Get Document No.
     *
     * @return Document sequence number of the document
     */
    public String getDocumentNo() {
        return (String) getValue(COLUMNNAME_DocumentNo);
    }

    /**
     * Set Approved.
     *
     * @param IsApproved Indicates if this document requires approval
     */
    public void setIsApproved(boolean IsApproved) {
        setValue(COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
    }

    /**
     * Get Approved.
     *
     * @return Indicates if this document requires approval
     */
    public boolean isApproved() {
        Object oo = getValue(COLUMNNAME_IsApproved);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Cancelled.
     *
     * @param IsCancelled The transaction was cancelled
     */
    public void setIsCancelled(boolean IsCancelled) {
        setValue(COLUMNNAME_IsCancelled, Boolean.valueOf(IsCancelled));
    }

    /**
     * Set In Dispute.
     *
     * @param IsInDispute Document is in dispute
     */
    public void setIsInDispute(boolean IsInDispute) {
        setValue(COLUMNNAME_IsInDispute, Boolean.valueOf(IsInDispute));
    }

    /**
     * Get In Dispute.
     *
     * @return Document is in dispute
     */
    public boolean isInDispute() {
        Object oo = getValue(COLUMNNAME_IsInDispute);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Ship/Receipt Confirmation.
     *
     * @return Material Shipment or Receipt Confirmation
     */
    public int getM_InOutConfirm_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_InOutConfirm_ID);
        if (ii == null) return 0;
        return ii;
    }

    public org.compiere.model.I_M_InOut getM_InOut() throws RuntimeException {
        return (org.compiere.model.I_M_InOut)
                MTable.get(getCtx(), org.compiere.model.I_M_InOut.Table_Name)
                        .getPO(getM_InOut_ID());
    }

    /**
     * Get Shipment/Receipt.
     *
     * @return Material Shipment Document
     */
    public int getM_InOut_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_InOut_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Shipment/Receipt.
     *
     * @param M_InOut_ID Material Shipment Document
     */
    public void setM_InOut_ID(int M_InOut_ID) {
        if (M_InOut_ID < 1) setValueNoCheck(COLUMNNAME_M_InOut_ID, null);
        else setValueNoCheck(COLUMNNAME_M_InOut_ID, M_InOut_ID);
    }

    /**
     * Set Phys.Inventory.
     *
     * @param M_Inventory_ID Parameters for a Physical Inventory
     */
    public void setM_Inventory_ID(int M_Inventory_ID) {
        if (M_Inventory_ID < 1) setValue(COLUMNNAME_M_Inventory_ID, null);
        else setValue(COLUMNNAME_M_Inventory_ID, M_Inventory_ID);
    }

    /**
     * Get Processed.
     *
     * @return The document has been processed
     */
    public boolean isProcessed() {
        Object oo = getValue(COLUMNNAME_Processed);
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
        setValue(COLUMNNAME_Processed, Boolean.valueOf(Processed));
    }

    /**
     * Set Process Now.
     *
     * @param Processing Process Now
     */
    public void setProcessing(boolean Processing) {
        setValue(COLUMNNAME_Processing, Boolean.valueOf(Processing));
    }

    @Override
    public int getTableId() {
        return I_M_InOutConfirm.Table_ID;
    }
}
