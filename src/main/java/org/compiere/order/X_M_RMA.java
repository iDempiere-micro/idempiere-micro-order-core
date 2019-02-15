package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_RMA;
import org.compiere.orm.BasePOName;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_RMA
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_RMA extends BasePOName implements I_Persistent {

    /** Complete = CO */
  public static final String DOCACTION_Complete = "CO";
    /** Void = VO */
  public static final String DOCACTION_Void = "VO";
  /** Close = CL */
  public static final String DOCACTION_Close = "CL";
    /** <None> = -- */
  public static final String DOCACTION_None = "--";
    /** Drafted = DR */
  public static final String DOCSTATUS_Drafted = "DR";
  /** Completed = CO */
  public static final String DOCSTATUS_Completed = "CO";
    /** Reversed = RE */
  public static final String DOCSTATUS_Reversed = "RE";
  /** Closed = CL */
  public static final String DOCSTATUS_Closed = "CL";
    /** */
  private static final long serialVersionUID = 20171031L;
  /** Standard Constructor */
  public X_M_RMA(Properties ctx, int M_RMA_ID) {
    super(ctx, M_RMA_ID);
  }
  /** Load Constructor */
  public X_M_RMA(Properties ctx, ResultSet rs) {
    super(ctx, rs);
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
   * Get Amount.
   *
   * @return Amount
   */
  public BigDecimal getAmt() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_RMA.COLUMNNAME_Amt);
    if (bd == null) return Env.ZERO;
    return bd;
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
   * Get Business Partner .
   *
   * @return Identifies a Business Partner
   */
  public int getC_BPartner_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_C_BPartner_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Currency.
   *
   * @return The Currency for this record
   */
  public int getC_Currency_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_C_Currency_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Document Type.
   *
   * @return Document type or rules
   */
  public int getC_DocType_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_C_DocType_ID);
    if (ii == null) return 0;
    return ii;
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
   * Set Order.
   *
   * @param C_Order_ID Order
   */
  public void setC_Order_ID(int C_Order_ID) {
    if (C_Order_ID < 1) set_ValueNoCheck(I_M_RMA.COLUMNNAME_C_Order_ID, null);
    else set_ValueNoCheck(I_M_RMA.COLUMNNAME_C_Order_ID, C_Order_ID);
  }

    /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_Description);
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
   * Get Document Action.
   *
   * @return The targeted status of the document
   */
  public String getDocAction() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_DocAction);
  }

  /**
   * Set Document Action.
   *
   * @param DocAction The targeted status of the document
   */
  public void setDocAction(String DocAction) {

    set_Value(I_M_RMA.COLUMNNAME_DocAction, DocAction);
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
   * Set Document Status.
   *
   * @param DocStatus The current status of the document
   */
  public void setDocStatus(String DocStatus) {

    set_Value(I_M_RMA.COLUMNNAME_DocStatus, DocStatus);
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
   * Set Document No.
   *
   * @param DocumentNo Document sequence number of the document
   */
  public void setDocumentNo(String DocumentNo) {
    set_Value(I_M_RMA.COLUMNNAME_DocumentNo, DocumentNo);
  }

    /**
   * Get Comment/Help.
   *
   * @return Comment or Hint
   */
  public String getHelp() {
    return (String) get_Value(I_M_RMA.COLUMNNAME_Help);
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
   * Set Shipment/Receipt.
   *
   * @param InOut_ID MaterialShipment Document
   */
  public void setInOut_ID(int InOut_ID) {
    if (InOut_ID < 1) set_ValueNoCheck(I_M_RMA.COLUMNNAME_InOut_ID, null);
    else set_ValueNoCheck(I_M_RMA.COLUMNNAME_InOut_ID, InOut_ID);
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
   * Get RMA.
   *
   * @return Return Material Authorization
   */
  public int getM_RMA_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_M_RMA_ID);
    if (ii == null) return 0;
    return ii;
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
   * Set RMA Type.
   *
   * @param M_RMAType_ID Return Material Authorization Type
   */
  public void setM_RMAType_ID(int M_RMAType_ID) {
    if (M_RMAType_ID < 1) set_Value(I_M_RMA.COLUMNNAME_M_RMAType_ID, null);
    else set_Value(I_M_RMA.COLUMNNAME_M_RMAType_ID, M_RMAType_ID);
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
   * Set Processed.
   *
   * @param Processed The document has been processed
   */
  public void setProcessed(boolean Processed) {
    set_Value(I_M_RMA.COLUMNNAME_Processed, Processed);
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
   * Get Referenced RMA.
   *
   * @return Referenced RMA
   */
  public int getRef_RMA_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_Ref_RMA_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Sales Representative.
   *
   * @return Sales Representative or Company Agent
   */
  public int getSalesRep_ID() {
    Integer ii = (Integer) get_Value(I_M_RMA.COLUMNNAME_SalesRep_ID);
    if (ii == null) return 0;
    return ii;
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

  @Override
  public int getTableId() {
    return I_M_RMA.Table_ID;
  }
}
