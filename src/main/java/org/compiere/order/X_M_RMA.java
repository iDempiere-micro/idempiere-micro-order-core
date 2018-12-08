package org.compiere.order;

import org.compiere.model.I_M_RMA;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_RMA
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_RMA extends BasePOName implements I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_RMA(Properties ctx, int M_RMA_ID, String trxName) {
    super(ctx, M_RMA_ID, trxName);
  }

  /** Load Constructor */
  public X_M_RMA(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 1 - Org
   */
  protected int getAccessLevel() {
    return I_M_RMA.accessLevel.intValue();
  }

  public String toString() {
    return "X_M_RMA[" + getId() + "]";
  }

  /**
   * Set Amount.
   *
   * @param Amt Amount
   */
  public void setAmt(BigDecimal Amt) {
    set_Value(I_M_RMA.COLUMNNAME_Amt, Amt);
  }

  /**
   * Get Amount.
   *
   * @return Amount
   */
  public BigDecimal getAmt() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_RMA.COLUMNNAME_Amt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getC_BPartner_ID(), get_TrxName());
  }

  /**
   * Set Business Partner .
   *
   * @param C_BPartner_ID Identifies a Business Partner
   */
  public void setC_BPartner_ID(int C_BPartner_ID) {
    if (C_BPartner_ID < 1) set_Value(I_M_RMA.COLUMNNAME_C_BPartner_ID, null);
    else set_Value(I_M_RMA.COLUMNNAME_C_BPartner_ID, C_BPartner_ID);
  }

  /**
   * Get Business Partner .
   *
   * @return Identifies a Business Partner
   */
  public int getC_BPartner_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_C_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException {
    return (org.compiere.model.I_C_Currency)
        MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
            .getPO(getC_Currency_ID(), get_TrxName());
  }

  /**
   * Set Currency.
   *
   * @param C_Currency_ID The Currency for this record
   */
  public void setC_Currency_ID(int C_Currency_ID) {
    if (C_Currency_ID < 1) set_Value(I_M_RMA.COLUMNNAME_C_Currency_ID, null);
    else set_Value(I_M_RMA.COLUMNNAME_C_Currency_ID, C_Currency_ID);
  }

  /**
   * Get Currency.
   *
   * @return The Currency for this record
   */
  public int getC_Currency_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_C_Currency_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException {
    return (org.compiere.model.I_C_DocType)
        MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
            .getPO(getC_DocType_ID(), get_TrxName());
  }

  /**
   * Set Document Type.
   *
   * @param C_DocType_ID Document type or rules
   */
  public void setC_DocType_ID(int C_DocType_ID) {
    if (C_DocType_ID < 0) set_Value(I_M_RMA.COLUMNNAME_C_DocType_ID, null);
    else set_Value(I_M_RMA.COLUMNNAME_C_DocType_ID, C_DocType_ID);
  }

  /**
   * Get Document Type.
   *
   * @return Document type or rules
   */
  public int getC_DocType_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_C_DocType_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_C_Order getC_Order() throws RuntimeException {
    return (org.compiere.model.I_C_Order)
        MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
            .getPO(getC_Order_ID(), get_TrxName());
  }

  /**
   * Set Order.
   *
   * @param C_Order_ID Order
   */
  public void setC_Order_ID(int C_Order_ID) {
    if (C_Order_ID < 1) set_ValueNoCheck(I_M_RMA.COLUMNNAME_C_Order_ID, null);
    else set_ValueNoCheck(I_M_RMA.COLUMNNAME_C_Order_ID, C_Order_ID);
  }

  /**
   * Get Order.
   *
   * @return Order
   */
  public int getC_Order_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_C_Order_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Create lines from.
   *
   * @param CreateFrom Process which will generate a new document lines based on an existing
   *     document
   */
  public void setCreateFrom(String CreateFrom) {
    set_Value(I_M_RMA.COLUMNNAME_CreateFrom, CreateFrom);
  }

  /**
   * Get Create lines from.
   *
   * @return Process which will generate a new document lines based on an existing document
   */
  public String getCreateFrom() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_CreateFrom);
  }

  /**
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(I_M_RMA.COLUMNNAME_Description, Description);
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_Description);
  }

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
  /**
   * Set Document Action.
   *
   * @param DocAction The targeted status of the document
   */
  public void setDocAction(String DocAction) {

    set_Value(I_M_RMA.COLUMNNAME_DocAction, DocAction);
  }

  /**
   * Get Document Action.
   *
   * @return The targeted status of the document
   */
  public String getDocAction() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_DocAction);
  }

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
  /**
   * Set Document Status.
   *
   * @param DocStatus The current status of the document
   */
  public void setDocStatus(String DocStatus) {

    set_Value(I_M_RMA.COLUMNNAME_DocStatus, DocStatus);
  }

  /**
   * Get Document Status.
   *
   * @return The current status of the document
   */
  public String getDocStatus() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_DocStatus);
  }

  /**
   * Set Document No.
   *
   * @param DocumentNo Document sequence number of the document
   */
  public void setDocumentNo(String DocumentNo) {
    set_Value(I_M_RMA.COLUMNNAME_DocumentNo, DocumentNo);
  }

  /**
   * Get Document No.
   *
   * @return Document sequence number of the document
   */
  public String getDocumentNo() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_DocumentNo);
  }

  /**
   * Set Generate To.
   *
   * @param GenerateTo Generate To
   */
  public void setGenerateTo(String GenerateTo) {
    set_Value(I_M_RMA.COLUMNNAME_GenerateTo, GenerateTo);
  }

  /**
   * Get Generate To.
   *
   * @return Generate To
   */
  public String getGenerateTo() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_GenerateTo);
  }

  /**
   * Set Comment/Help.
   *
   * @param Help Comment or Hint
   */
  public void setHelp(String Help) {
    set_Value(I_M_RMA.COLUMNNAME_Help, Help);
  }

  /**
   * Get Comment/Help.
   *
   * @return Comment or Hint
   */
  public String getHelp() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_Help);
  }

  public org.compiere.model.I_M_InOut getInOut() throws RuntimeException {
    return (org.compiere.model.I_M_InOut)
        MTable.get(getCtx(), org.compiere.model.I_M_InOut.Table_Name)
            .getPO(getInOut_ID(), get_TrxName());
  }

  /**
   * Set Shipment/Receipt.
   *
   * @param InOut_ID MaterialShipment Document
   */
  public void setInOut_ID(int InOut_ID) {
    if (InOut_ID < 1) set_ValueNoCheck(I_M_RMA.COLUMNNAME_InOut_ID, null);
    else set_ValueNoCheck(I_M_RMA.COLUMNNAME_InOut_ID, InOut_ID);
  }

  /**
   * Get Shipment/Receipt.
   *
   * @return MaterialShipment Document
   */
  public int getInOut_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_InOut_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Approved.
   *
   * @param IsApproved Indicates if this document requires approval
   */
  public void setIsApproved(boolean IsApproved) {
    set_Value(I_M_RMA.COLUMNNAME_IsApproved, IsApproved);
  }

  /**
   * Get Approved.
   *
   * @return Indicates if this document requires approval
   */
  public boolean isApproved() {
    Object oo = get_Value(I_M_RMA.COLUMNNAME_IsApproved);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Sales Transaction.
   *
   * @param IsSOTrx This is a Sales Transaction
   */
  public void setIsSOTrx(boolean IsSOTrx) {
    set_Value(I_M_RMA.COLUMNNAME_IsSOTrx, IsSOTrx);
  }

  /**
   * Get Sales Transaction.
   *
   * @return This is a Sales Transaction
   */
  public boolean isSOTrx() {
    Object oo = get_Value(I_M_RMA.COLUMNNAME_IsSOTrx);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set RMA.
   *
   * @param M_RMA_ID Return Material Authorization
   */
  public void setM_RMA_ID(int M_RMA_ID) {
    if (M_RMA_ID < 1) set_ValueNoCheck(I_M_RMA.COLUMNNAME_M_RMA_ID, null);
    else set_ValueNoCheck(I_M_RMA.COLUMNNAME_M_RMA_ID, M_RMA_ID);
  }

  /**
   * Get RMA.
   *
   * @return Return Material Authorization
   */
  public int getM_RMA_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_M_RMA_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_M_RMAType getM_RMAType() throws RuntimeException {
    return (org.compiere.model.I_M_RMAType)
        MTable.get(getCtx(), org.compiere.model.I_M_RMAType.Table_Name)
            .getPO(getM_RMAType_ID(), get_TrxName());
  }

  /**
   * Set RMA Type.
   *
   * @param M_RMAType_ID Return Material Authorization Type
   */
  public void setM_RMAType_ID(int M_RMAType_ID) {
    if (M_RMAType_ID < 1) set_Value(I_M_RMA.COLUMNNAME_M_RMAType_ID, null);
    else set_Value(I_M_RMA.COLUMNNAME_M_RMAType_ID, M_RMAType_ID);
  }

  /**
   * Get RMA Type.
   *
   * @return Return Material Authorization Type
   */
  public int getM_RMAType_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_M_RMAType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set M_RMA_UU.
   *
   * @param M_RMA_UU M_RMA_UU
   */
  public void setM_RMA_UU(String M_RMA_UU) {
    set_Value(I_M_RMA.COLUMNNAME_M_RMA_UU, M_RMA_UU);
  }

  /**
   * Get M_RMA_UU.
   *
   * @return M_RMA_UU
   */
  public String getM_RMA_UU() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_M_RMA_UU);
  }

  /**
   * Set Processed.
   *
   * @param Processed The document has been processed
   */
  public void setProcessed(boolean Processed) {
    set_Value(I_M_RMA.COLUMNNAME_Processed, Processed);
  }

  /**
   * Get Processed.
   *
   * @return The document has been processed
   */
  public boolean isProcessed() {
    Object oo = get_Value(I_M_RMA.COLUMNNAME_Processed);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
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
    set_Value(I_M_RMA.COLUMNNAME_Processing, Processing);
  }

  /**
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(I_M_RMA.COLUMNNAME_Processing);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
      return "Y".equals(oo);
    }
    return false;
  }

  public org.compiere.model.I_M_RMA getRef_RMA() throws RuntimeException {
    return (org.compiere.model.I_M_RMA)
        MTable.get(getCtx(), org.compiere.model.I_M_RMA.Table_Name)
            .getPO(getRef_RMA_ID(), get_TrxName());
  }

  /**
   * Set Referenced RMA.
   *
   * @param Ref_RMA_ID Referenced RMA
   */
  public void setRef_RMA_ID(int Ref_RMA_ID) {
    if (Ref_RMA_ID < 1) set_Value(I_M_RMA.COLUMNNAME_Ref_RMA_ID, null);
    else set_Value(I_M_RMA.COLUMNNAME_Ref_RMA_ID, Ref_RMA_ID);
  }

  /**
   * Get Referenced RMA.
   *
   * @return Referenced RMA
   */
  public int getRef_RMA_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_Ref_RMA_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_AD_User getSalesRep() throws RuntimeException {
    return (org.compiere.model.I_AD_User)
        MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
            .getPO(getSalesRep_ID(), get_TrxName());
  }

  /**
   * Set Sales Representative.
   *
   * @param SalesRep_ID Sales Representative or Company Agent
   */
  public void setSalesRep_ID(int SalesRep_ID) {
    if (SalesRep_ID < 1) set_Value(I_M_RMA.COLUMNNAME_SalesRep_ID, null);
    else set_Value(I_M_RMA.COLUMNNAME_SalesRep_ID, SalesRep_ID);
  }

  /**
   * Get Sales Representative.
   *
   * @return Sales Representative or Company Agent
   */
  public int getSalesRep_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_SalesRep_ID);
    if (ii == null) return 0;
    return ii;
  }

  @Override
  public int getTableId() {
    return I_M_RMA.Table_ID;
  }
}
