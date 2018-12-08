package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_InOutConfirm;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_InOutConfirm
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_InOutConfirm extends PO implements I_M_InOutConfirm, I_Persistent {

  /** ConfirmType AD_Reference_ID=320 */
  public static final int CONFIRMTYPE_AD_Reference_ID = 320;
  /** Vendor Confirmation = XV */
  public static final String CONFIRMTYPE_VendorConfirmation = "XV";
  /** Customer Confirmation = XC */
  public static final String CONFIRMTYPE_CustomerConfirmation = "XC";
  /** Drop Ship Confirm = DS */
  public static final String CONFIRMTYPE_DropShipConfirm = "DS";
  /** Ship/Receipt Confirm = SC */
  public static final String CONFIRMTYPE_ShipReceiptConfirm = "SC";
  /** Pick/QA Confirm = PC */
  public static final String CONFIRMTYPE_PickQAConfirm = "PC";
  /** DocAction AD_Reference_ID=135 */
  public static final int DOCACTION_AD_Reference_ID = 135;
  /** Complete = CO */
  public static final String DOCACTION_Complete = "CO";
  /** Approve = AP */
  public static final String DOCACTION_Approve = "AP";
  /** Reject = RJ */
  public static final String DOCACTION_Reject = "RJ";
  /** Post = PO */
  public static final String DOCACTION_Post = "PO";
  /** Void = VO */
  public static final String DOCACTION_Void = "VO";
  /** Close = CL */
  public static final String DOCACTION_Close = "CL";
  /** Reverse - Correct = RC */
  public static final String DOCACTION_Reverse_Correct = "RC";
  /** Reverse - Accrual = RA */
  public static final String DOCACTION_Reverse_Accrual = "RA";
  /** Invalidate = IN */
  public static final String DOCACTION_Invalidate = "IN";
  /** Re-activate = RE */
  public static final String DOCACTION_Re_Activate = "RE";
  /** <None> = -- */
  public static final String DOCACTION_None = "--";
  /** Prepare = PR */
  public static final String DOCACTION_Prepare = "PR";
  /** Unlock = XL */
  public static final String DOCACTION_Unlock = "XL";
  /** Wait Complete = WC */
  public static final String DOCACTION_WaitComplete = "WC";
  /** DocStatus AD_Reference_ID=131 */
  public static final int DOCSTATUS_AD_Reference_ID = 131;
  /** Drafted = DR */
  public static final String DOCSTATUS_Drafted = "DR";
  /** Completed = CO */
  public static final String DOCSTATUS_Completed = "CO";
  /** Approved = AP */
  public static final String DOCSTATUS_Approved = "AP";
  /** Not Approved = NA */
  public static final String DOCSTATUS_NotApproved = "NA";
  /** Voided = VO */
  public static final String DOCSTATUS_Voided = "VO";
  /** Invalid = IN */
  public static final String DOCSTATUS_Invalid = "IN";
  /** Reversed = RE */
  public static final String DOCSTATUS_Reversed = "RE";
  /** Closed = CL */
  public static final String DOCSTATUS_Closed = "CL";
  /** Unknown = ?? */
  public static final String DOCSTATUS_Unknown = "??";
  /** In Progress = IP */
  public static final String DOCSTATUS_InProgress = "IP";
  /** Waiting Payment = WP */
  public static final String DOCSTATUS_WaitingPayment = "WP";
  /** Waiting Confirmation = WC */
  public static final String DOCSTATUS_WaitingConfirmation = "WC";
  /** */
  private static final long serialVersionUID = 20171031L;
  /** Standard Constructor */
  public X_M_InOutConfirm(Properties ctx, int M_InOutConfirm_ID, String trxName) {
    super(ctx, M_InOutConfirm_ID, trxName);
    /**
     * if (M_InOutConfirm_ID == 0) { setConfirmType (null); setDocAction (null); // CO setDocStatus
     * (null); // DR setDocumentNo (null); setIsApproved (false); setIsCancelled (false);
     * setIsInDispute (false); // N setM_InOutConfirm_ID (0); setM_InOut_ID (0); setProcessed
     * (false); }
     */
  }
  /** Load Constructor */
  public X_M_InOutConfirm(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
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
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ApprovalAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Approval Amount.
   *
   * @param ApprovalAmt Document Approval Amount
   */
  public void setApprovalAmt(BigDecimal ApprovalAmt) {
    set_Value(COLUMNNAME_ApprovalAmt, ApprovalAmt);
  }

  public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException {
    return (org.compiere.model.I_C_Invoice)
        MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
            .getPO(getC_Invoice_ID(), get_TrxName());
  }

  /**
   * Get Invoice.
   *
   * @return Invoice Identifier
   */
  public int getC_Invoice_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Invoice_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Invoice.
   *
   * @param C_Invoice_ID Invoice Identifier
   */
  public void setC_Invoice_ID(int C_Invoice_ID) {
    if (C_Invoice_ID < 1) set_Value(COLUMNNAME_C_Invoice_ID, null);
    else set_Value(COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
  }

  /**
   * Get Confirmation No.
   *
   * @return Confirmation Number
   */
  public String getConfirmationNo() {
    return (String) get_Value(COLUMNNAME_ConfirmationNo);
  }

  /**
   * Set Confirmation No.
   *
   * @param ConfirmationNo Confirmation Number
   */
  public void setConfirmationNo(String ConfirmationNo) {
    set_Value(COLUMNNAME_ConfirmationNo, ConfirmationNo);
  }

  /**
   * Get Confirmation Type.
   *
   * @return Type of confirmation
   */
  public String getConfirmType() {
    return (String) get_Value(COLUMNNAME_ConfirmType);
  }

  /**
   * Set Confirmation Type.
   *
   * @param ConfirmType Type of confirmation
   */
  public void setConfirmType(String ConfirmType) {

    set_Value(COLUMNNAME_ConfirmType, ConfirmType);
  }

  /**
   * Get Create Package.
   *
   * @return Create Package
   */
  public String getCreatePackage() {
    return (String) get_Value(COLUMNNAME_CreatePackage);
  }

  /**
   * Set Create Package.
   *
   * @param CreatePackage Create Package
   */
  public void setCreatePackage(String CreatePackage) {
    set_Value(COLUMNNAME_CreatePackage, CreatePackage);
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
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
   * Get Document Action.
   *
   * @return The targeted status of the document
   */
  public String getDocAction() {
    return (String) get_Value(COLUMNNAME_DocAction);
  }

  /**
   * Set Document Action.
   *
   * @param DocAction The targeted status of the document
   */
  public void setDocAction(String DocAction) {

    set_Value(COLUMNNAME_DocAction, DocAction);
  }

  /**
   * Get Document Status.
   *
   * @return The current status of the document
   */
  public String getDocStatus() {
    return (String) get_Value(COLUMNNAME_DocStatus);
  }

  /**
   * Set Document Status.
   *
   * @param DocStatus The current status of the document
   */
  public void setDocStatus(String DocStatus) {

    set_Value(COLUMNNAME_DocStatus, DocStatus);
  }

  /**
   * Get Document No.
   *
   * @return Document sequence number of the document
   */
  public String getDocumentNo() {
    return (String) get_Value(COLUMNNAME_DocumentNo);
  }

  /**
   * Set Document No.
   *
   * @param DocumentNo Document sequence number of the document
   */
  public void setDocumentNo(String DocumentNo) {
    set_Value(COLUMNNAME_DocumentNo, DocumentNo);
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), getDocumentNo());
  }

  /**
   * Set Approved.
   *
   * @param IsApproved Indicates if this document requires approval
   */
  public void setIsApproved(boolean IsApproved) {
    set_Value(COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
  }

  /**
   * Get Approved.
   *
   * @return Indicates if this document requires approval
   */
  public boolean isApproved() {
    Object oo = get_Value(COLUMNNAME_IsApproved);
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
    set_Value(COLUMNNAME_IsCancelled, Boolean.valueOf(IsCancelled));
  }

  /**
   * Get Cancelled.
   *
   * @return The transaction was cancelled
   */
  public boolean isCancelled() {
    Object oo = get_Value(COLUMNNAME_IsCancelled);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set In Dispute.
   *
   * @param IsInDispute Document is in dispute
   */
  public void setIsInDispute(boolean IsInDispute) {
    set_Value(COLUMNNAME_IsInDispute, Boolean.valueOf(IsInDispute));
  }

  /**
   * Get In Dispute.
   *
   * @return Document is in dispute
   */
  public boolean isInDispute() {
    Object oo = get_Value(COLUMNNAME_IsInDispute);
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
    Integer ii = (Integer) get_Value(COLUMNNAME_M_InOutConfirm_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Ship/Receipt Confirmation.
   *
   * @param M_InOutConfirm_ID Material Shipment or Receipt Confirmation
   */
  public void setM_InOutConfirm_ID(int M_InOutConfirm_ID) {
    if (M_InOutConfirm_ID < 1) set_ValueNoCheck(COLUMNNAME_M_InOutConfirm_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_InOutConfirm_ID, Integer.valueOf(M_InOutConfirm_ID));
  }

  /**
   * Get M_InOutConfirm_UU.
   *
   * @return M_InOutConfirm_UU
   */
  public String getM_InOutConfirm_UU() {
    return (String) get_Value(COLUMNNAME_M_InOutConfirm_UU);
  }

  /**
   * Set M_InOutConfirm_UU.
   *
   * @param M_InOutConfirm_UU M_InOutConfirm_UU
   */
  public void setM_InOutConfirm_UU(String M_InOutConfirm_UU) {
    set_Value(COLUMNNAME_M_InOutConfirm_UU, M_InOutConfirm_UU);
  }

  public org.compiere.model.I_M_InOut getM_InOut() throws RuntimeException {
    return (org.compiere.model.I_M_InOut)
        MTable.get(getCtx(), org.compiere.model.I_M_InOut.Table_Name)
            .getPO(getM_InOut_ID(), get_TrxName());
  }

  /**
   * Get Shipment/Receipt.
   *
   * @return Material Shipment Document
   */
  public int getM_InOut_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_InOut_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipment/Receipt.
   *
   * @param M_InOut_ID Material Shipment Document
   */
  public void setM_InOut_ID(int M_InOut_ID) {
    if (M_InOut_ID < 1) set_ValueNoCheck(COLUMNNAME_M_InOut_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_InOut_ID, Integer.valueOf(M_InOut_ID));
  }

  public org.compiere.model.I_M_Inventory getM_Inventory() throws RuntimeException {
    return (org.compiere.model.I_M_Inventory)
        MTable.get(getCtx(), org.compiere.model.I_M_Inventory.Table_Name)
            .getPO(getM_Inventory_ID(), get_TrxName());
  }

  /**
   * Get Phys.Inventory.
   *
   * @return Parameters for a Physical Inventory
   */
  public int getM_Inventory_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Inventory_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Phys.Inventory.
   *
   * @param M_Inventory_ID Parameters for a Physical Inventory
   */
  public void setM_Inventory_ID(int M_Inventory_ID) {
    if (M_Inventory_ID < 1) set_Value(COLUMNNAME_M_Inventory_ID, null);
    else set_Value(COLUMNNAME_M_Inventory_ID, Integer.valueOf(M_Inventory_ID));
  }

  /**
   * Get Processed.
   *
   * @return The document has been processed
   */
  public boolean isProcessed() {
    Object oo = get_Value(COLUMNNAME_Processed);
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
    set_Value(COLUMNNAME_Processed, Boolean.valueOf(Processed));
  }

  /**
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(COLUMNNAME_Processing);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Process Now.
   *
   * @param Processing Process Now
   */
  public void setProcessing(boolean Processing) {
    set_Value(COLUMNNAME_Processing, Boolean.valueOf(Processing));
  }

  @Override
  public int getTableId() {
    return I_M_InOutConfirm.Table_ID;
  }
}