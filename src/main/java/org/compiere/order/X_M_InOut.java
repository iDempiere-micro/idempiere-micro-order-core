package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import org.compiere.model.IPODoc;
import org.compiere.model.I_M_InOut;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_InOut
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_InOut extends PO implements I_M_InOut, I_Persistent {

    /** Availability = A */
  public static final String DELIVERYRULE_Availability = "A";
    /** Force = F */
  public static final String DELIVERYRULE_Force = "F";
    /** Pickup = P */
  public static final String DELIVERYVIARULE_Pickup = "P";
    /** Complete = CO */
  public static final String DOCACTION_Complete = "CO";
    /** Close = CL */
  public static final String DOCACTION_Close = "CL";
    /** <None> = -- */
  public static final String DOCACTION_None = "--";
  /** Prepare = PR */
  public static final String DOCACTION_Prepare = "PR";
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
    /** In Progress = IP */
  public static final String DOCSTATUS_InProgress = "IP";
    /** Freight included = I */
  public static final String FREIGHTCOSTRULE_FreightIncluded = "I";
    /** Customer Shipment = C- */
  public static final String MOVEMENTTYPE_CustomerShipment = "C-";
  /** Customer Returns = C+ */
  public static final String MOVEMENTTYPE_CustomerReturns = "C+";
  /** Vendor Receipts = V+ */
  public static final String MOVEMENTTYPE_VendorReceipts = "V+";
  /** Vendor Returns = V- */
  public static final String MOVEMENTTYPE_VendorReturns = "V-";
    /** Medium = 5 */
  public static final String PRIORITYRULE_Medium = "5";
    /** */
  private static final long serialVersionUID = 20171031L;
  /* Save array of documents to process AFTER completing this one */
  protected ArrayList<IPODoc> docsPostProcess = new ArrayList<IPODoc>();
  /** Standard Constructor */
  public X_M_InOut(Properties ctx, int M_InOut_ID) {
    super(ctx, M_InOut_ID);
    /**
     * if (M_InOut_ID == 0) { setC_BPartner_ID (0); setC_BPartner_Location_ID (0); setC_DocType_ID
     * (0); setDateAcct (new Timestamp( System.currentTimeMillis() )); // @#Date@ setDeliveryRule
     * (null); // A setDeliveryViaRule (null); // P setDocAction (null); // CO setDocStatus (null);
     * // DR setDocumentNo (null); setFreightCostRule (null); // I setIsAlternateReturnAddress
     * (false); // N setIsApproved (false); setIsInDispute (false); setIsInTransit (false);
     * setIsPrinted (false); setIsSOTrx (false); // @IsSOTrx@ setM_InOut_ID (0); setMovementDate
     * (new Timestamp( System.currentTimeMillis() )); // @#Date@ setMovementType (null);
     * setM_Warehouse_ID (0); setPosted (false); setPriorityRule (null); // 5 setProcessed (false);
     * setSendEMail (false); }
     */
  }
  /** Load Constructor */
  public X_M_InOut(Properties ctx, ResultSet rs) {
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
    StringBuffer sb = new StringBuffer("X_M_InOut[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Trx Organization.
   *
   * @return Performing or initiating organization
   */
  public int getAD_OrgTrx_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_AD_OrgTrx_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Trx Organization.
   *
   * @param AD_OrgTrx_ID Performing or initiating organization
   */
  public void setAD_OrgTrx_ID(int AD_OrgTrx_ID) {
    if (AD_OrgTrx_ID < 1) set_Value(COLUMNNAME_AD_OrgTrx_ID, null);
    else set_Value(COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
  }

    /**
   * Get User/Contact.
   *
   * @return User within the system - Internal or Business Partner Contact
   */
  public int getAD_User_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_AD_User_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set User/Contact.
   *
   * @param AD_User_ID User within the system - Internal or Business Partner Contact
   */
  public void setAD_User_ID(int AD_User_ID) {
    if (AD_User_ID < 1) set_Value(COLUMNNAME_AD_User_ID, null);
    else set_Value(COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
  }

    /**
   * Get Activity.
   *
   * @return Business Activity
   */
  public int getC_Activity_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Activity_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Activity.
   *
   * @param C_Activity_ID Business Activity
   */
  public void setC_Activity_ID(int C_Activity_ID) {
    if (C_Activity_ID < 1) set_Value(COLUMNNAME_C_Activity_ID, null);
    else set_Value(COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
  }

    /**
   * Get Business Partner .
   *
   * @return Identifies a Business Partner
   */
  public int getC_BPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Business Partner .
   *
   * @param C_BPartner_ID Identifies a Business Partner
   */
  public void setC_BPartner_ID(int C_BPartner_ID) {
    if (C_BPartner_ID < 1) set_Value(COLUMNNAME_C_BPartner_ID, null);
    else set_Value(COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
  }

    /**
   * Get Partner Location.
   *
   * @return Identifies the (ship to) address for this Business Partner
   */
  public int getC_BPartner_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Partner Location.
   *
   * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
   */
  public void setC_BPartner_Location_ID(int C_BPartner_Location_ID) {
    if (C_BPartner_Location_ID < 1) set_Value(COLUMNNAME_C_BPartner_Location_ID, null);
    else set_Value(COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
  }

    /**
   * Get Campaign.
   *
   * @return Marketing Campaign
   */
  public int getC_Campaign_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Campaign_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Campaign.
   *
   * @param C_Campaign_ID Marketing Campaign
   */
  public void setC_Campaign_ID(int C_Campaign_ID) {
    if (C_Campaign_ID < 1) set_Value(COLUMNNAME_C_Campaign_ID, null);
    else set_Value(COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
  }

    /**
   * Get Charge.
   *
   * @return Additional document charges
   */
  public int getC_Charge_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Charge_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Charge.
   *
   * @param C_Charge_ID Additional document charges
   */
  public void setC_Charge_ID(int C_Charge_ID) {
    if (C_Charge_ID < 1) set_Value(COLUMNNAME_C_Charge_ID, null);
    else set_Value(COLUMNNAME_C_Charge_ID, C_Charge_ID);
  }

  public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException {
    return (org.compiere.model.I_C_DocType)
        MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
            .getPO(getC_DocType_ID());
  }

  /**
   * Get Document Type.
   *
   * @return Document type or rules
   */
  public int getC_DocType_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_DocType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Document Type.
   *
   * @param C_DocType_ID Document type or rules
   */
  public void setC_DocType_ID(int C_DocType_ID) {
    if (C_DocType_ID < 0) set_ValueNoCheck(COLUMNNAME_C_DocType_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_DocType_ID, C_DocType_ID);
  }

  /**
   * Get Charge amount.
   *
   * @return Charge Amount
   */
  public BigDecimal getChargeAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ChargeAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Charge amount.
   *
   * @param ChargeAmt Charge Amount
   */
  public void setChargeAmt(BigDecimal ChargeAmt) {
    set_Value(COLUMNNAME_ChargeAmt, ChargeAmt);
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
    if (C_Invoice_ID < 1) set_ValueNoCheck(COLUMNNAME_C_Invoice_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_Invoice_ID, C_Invoice_ID);
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
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Order_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Order.
   *
   * @param C_Order_ID Order
   */
  public void setC_Order_ID(int C_Order_ID) {
    if (C_Order_ID < 1) set_ValueNoCheck(COLUMNNAME_C_Order_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_Order_ID, C_Order_ID);
  }

    /**
   * Get Project.
   *
   * @return Financial Project
   */
  public int getC_Project_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Project_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Project.
   *
   * @param C_Project_ID Financial Project
   */
  public void setC_Project_ID(int C_Project_ID) {
    if (C_Project_ID < 1) set_Value(COLUMNNAME_C_Project_ID, null);
    else set_Value(COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
  }

    /**
   * Get Account Date.
   *
   * @return Accounting Date
   */
  public Timestamp getDateAcct() {
    return (Timestamp) get_Value(COLUMNNAME_DateAcct);
  }

  /**
   * Set Account Date.
   *
   * @param DateAcct Accounting Date
   */
  public void setDateAcct(Timestamp DateAcct) {
    set_Value(COLUMNNAME_DateAcct, DateAcct);
  }

  /**
   * Get Date Ordered.
   *
   * @return Date of Order
   */
  public Timestamp getDateOrdered() {
    return (Timestamp) get_Value(COLUMNNAME_DateOrdered);
  }

  /**
   * Set Date Ordered.
   *
   * @param DateOrdered Date of Order
   */
  public void setDateOrdered(Timestamp DateOrdered) {
    set_ValueNoCheck(COLUMNNAME_DateOrdered, DateOrdered);
  }

    /**
   * Set Date printed.
   *
   * @param DatePrinted Date the document was printed.
   */
  public void setDatePrinted(Timestamp DatePrinted) {
    set_Value(COLUMNNAME_DatePrinted, DatePrinted);
  }

    /**
   * Set Date received.
   *
   * @param DateReceived Date a product was received
   */
  public void setDateReceived(Timestamp DateReceived) {
    set_Value(COLUMNNAME_DateReceived, DateReceived);
  }

  /**
   * Get Delivery Rule.
   *
   * @return Defines the timing of Delivery
   */
  public String getDeliveryRule() {
    return (String) get_Value(COLUMNNAME_DeliveryRule);
  }

  /**
   * Set Delivery Rule.
   *
   * @param DeliveryRule Defines the timing of Delivery
   */
  public void setDeliveryRule(String DeliveryRule) {

    set_Value(COLUMNNAME_DeliveryRule, DeliveryRule);
  }

  /**
   * Get Delivery Via.
   *
   * @return How the order will be delivered
   */
  public String getDeliveryViaRule() {
    return (String) get_Value(COLUMNNAME_DeliveryViaRule);
  }

  /**
   * Set Delivery Via.
   *
   * @param DeliveryViaRule How the order will be delivered
   */
  public void setDeliveryViaRule(String DeliveryViaRule) {

    set_Value(COLUMNNAME_DeliveryViaRule, DeliveryViaRule);
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
    set_ValueNoCheck(COLUMNNAME_DocumentNo, DocumentNo);
  }

    /**
   * Get Drop Ship Business Partner.
   *
   * @return Business Partner to ship to
   */
  public int getDropShip_BPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_DropShip_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Drop Ship Business Partner.
   *
   * @param DropShip_BPartner_ID Business Partner to ship to
   */
  public void setDropShip_BPartner_ID(int DropShip_BPartner_ID) {
    if (DropShip_BPartner_ID < 1) set_Value(COLUMNNAME_DropShip_BPartner_ID, null);
    else set_Value(COLUMNNAME_DropShip_BPartner_ID, Integer.valueOf(DropShip_BPartner_ID));
  }

    /**
   * Get Drop Shipment Location.
   *
   * @return Business Partner Location for shipping to
   */
  public int getDropShip_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_DropShip_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Drop Shipment Location.
   *
   * @param DropShip_Location_ID Business Partner Location for shipping to
   */
  public void setDropShip_Location_ID(int DropShip_Location_ID) {
    if (DropShip_Location_ID < 1) set_Value(COLUMNNAME_DropShip_Location_ID, null);
    else set_Value(COLUMNNAME_DropShip_Location_ID, Integer.valueOf(DropShip_Location_ID));
  }

    /**
   * Get Drop Shipment Contact.
   *
   * @return Business Partner Contact for drop shipment
   */
  public int getDropShip_User_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_DropShip_User_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Drop Shipment Contact.
   *
   * @param DropShip_User_ID Business Partner Contact for drop shipment
   */
  public void setDropShip_User_ID(int DropShip_User_ID) {
    if (DropShip_User_ID < 1) set_Value(COLUMNNAME_DropShip_User_ID, null);
    else set_Value(COLUMNNAME_DropShip_User_ID, Integer.valueOf(DropShip_User_ID));
  }

    /**
   * Get Freight Amount.
   *
   * @return Freight Amount
   */
  public BigDecimal getFreightAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_FreightAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Freight Amount.
   *
   * @param FreightAmt Freight Amount
   */
  public void setFreightAmt(BigDecimal FreightAmt) {
    set_Value(COLUMNNAME_FreightAmt, FreightAmt);
  }

    /**
   * Get Freight Cost Rule.
   *
   * @return Method for charging Freight
   */
  public String getFreightCostRule() {
    return (String) get_Value(COLUMNNAME_FreightCostRule);
  }

  /**
   * Set Freight Cost Rule.
   *
   * @param FreightCostRule Method for charging Freight
   */
  public void setFreightCostRule(String FreightCostRule) {

    set_Value(COLUMNNAME_FreightCostRule, FreightCostRule);
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
   * Set Drop Shipment.
   *
   * @param IsDropShip Drop Shipments are sent from the Vendor directly to the Customer
   */
  public void setIsDropShip(boolean IsDropShip) {
    set_Value(COLUMNNAME_IsDropShip, Boolean.valueOf(IsDropShip));
  }

  /**
   * Get Drop Shipment.
   *
   * @return Drop Shipments are sent from the Vendor directly to the Customer
   */
  public boolean isDropShip() {
    Object oo = get_Value(COLUMNNAME_IsDropShip);
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
   * Set In Transit.
   *
   * @param IsInTransit Movement is in transit
   */
  public void setIsInTransit(boolean IsInTransit) {
    set_Value(COLUMNNAME_IsInTransit, Boolean.valueOf(IsInTransit));
  }

    /**
   * Set Printed.
   *
   * @param IsPrinted Indicates if this document / line is printed
   */
  public void setIsPrinted(boolean IsPrinted) {
    set_Value(COLUMNNAME_IsPrinted, Boolean.valueOf(IsPrinted));
  }

    /**
   * Set Sales Transaction.
   *
   * @param IsSOTrx This is a Sales Transaction
   */
  public void setIsSOTrx(boolean IsSOTrx) {
    set_Value(COLUMNNAME_IsSOTrx, Boolean.valueOf(IsSOTrx));
  }

  /**
   * Get Sales Transaction.
   *
   * @return This is a Sales Transaction
   */
  public boolean isSOTrx() {
    Object oo = get_Value(COLUMNNAME_IsSOTrx);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
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
   * Get Movement Date.
   *
   * @return Date a product was moved in or out of inventory
   */
  public Timestamp getMovementDate() {
    return (Timestamp) get_Value(COLUMNNAME_MovementDate);
  }

  /**
   * Set Movement Date.
   *
   * @param MovementDate Date a product was moved in or out of inventory
   */
  public void setMovementDate(Timestamp MovementDate) {
    set_Value(COLUMNNAME_MovementDate, MovementDate);
  }

  /**
   * Get Movement Type.
   *
   * @return Method of moving the inventory
   */
  public String getMovementType() {
    return (String) get_Value(COLUMNNAME_MovementType);
  }

  /**
   * Set Movement Type.
   *
   * @param MovementType Method of moving the inventory
   */
  public void setMovementType(String MovementType) {

    set_ValueNoCheck(COLUMNNAME_MovementType, MovementType);
  }

    /**
   * Get RMA.
   *
   * @return Return Material Authorization
   */
  public int getM_RMA_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_RMA_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set RMA.
   *
   * @param M_RMA_ID Return Material Authorization
   */
  public void setM_RMA_ID(int M_RMA_ID) {
    if (M_RMA_ID < 1) set_Value(COLUMNNAME_M_RMA_ID, null);
    else set_Value(COLUMNNAME_M_RMA_ID, Integer.valueOf(M_RMA_ID));
  }

    /**
   * Get Shipper.
   *
   * @return Method or manner of product delivery
   */
  public int getM_Shipper_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Shipper_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipper.
   *
   * @param M_Shipper_ID Method or manner of product delivery
   */
  public void setM_Shipper_ID(int M_Shipper_ID) {
    if (M_Shipper_ID < 1) set_Value(COLUMNNAME_M_Shipper_ID, null);
    else set_Value(COLUMNNAME_M_Shipper_ID, Integer.valueOf(M_Shipper_ID));
  }

    /**
   * Get Warehouse.
   *
   * @return Storage Warehouse and Service Point
   */
  public int getM_Warehouse_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Warehouse_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Warehouse.
   *
   * @param M_Warehouse_ID Storage Warehouse and Service Point
   */
  public void setM_Warehouse_ID(int M_Warehouse_ID) {
    if (M_Warehouse_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Warehouse_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
  }

  /**
   * Get No Packages.
   *
   * @return Number of packages shipped
   */
  public int getNoPackages() {
    Integer ii = (Integer) get_Value(COLUMNNAME_NoPackages);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set No Packages.
   *
   * @param NoPackages Number of packages shipped
   */
  public void setNoPackages(int NoPackages) {
    set_Value(COLUMNNAME_NoPackages, Integer.valueOf(NoPackages));
  }

    /**
   * Set Pick Date.
   *
   * @param PickDate Date/Time when picked for Shipment
   */
  public void setPickDate(Timestamp PickDate) {
    set_Value(COLUMNNAME_PickDate, PickDate);
  }

  /**
   * Get Order Reference.
   *
   * @return Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
   */
  public String getPOReference() {
    return (String) get_Value(COLUMNNAME_POReference);
  }

  /**
   * Set Order Reference.
   *
   * @param POReference Transaction Reference Number (Sales Order, Purchase Order) of your Business
   *     Partner
   */
  public void setPOReference(String POReference) {
    set_Value(COLUMNNAME_POReference, POReference);
  }

  /**
   * Get Posted.
   *
   * @return Posting status
   */
  public boolean isPosted() {
    Object oo = get_Value(COLUMNNAME_Posted);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Posted.
   *
   * @param Posted Posting status
   */
  public void setPosted(boolean Posted) {
    set_Value(COLUMNNAME_Posted, Boolean.valueOf(Posted));
  }

    /**
   * Set Priority.
   *
   * @param PriorityRule Priority of a document
   */
  public void setPriorityRule(String PriorityRule) {

    set_Value(COLUMNNAME_PriorityRule, PriorityRule);
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
   * Set Process Now.
   *
   * @param Processing Process Now
   */
  public void setProcessing(boolean Processing) {
    set_Value(COLUMNNAME_Processing, Boolean.valueOf(Processing));
  }

  /**
   * Get Referenced Shipment.
   *
   * @return Referenced Shipment
   */
  public int getRef_InOut_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Ref_InOut_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Referenced Shipment.
   *
   * @param Ref_InOut_ID Referenced Shipment
   */
  public void setRef_InOut_ID(int Ref_InOut_ID) {
    if (Ref_InOut_ID < 1) set_Value(COLUMNNAME_Ref_InOut_ID, null);
    else set_Value(COLUMNNAME_Ref_InOut_ID, Integer.valueOf(Ref_InOut_ID));
  }

    /**
   * Get Return Partner.
   *
   * @return Return Partner
   */
  public int getReturnBPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ReturnBPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Return Location.
   *
   * @return Return Location
   */
  public int getReturnLocation_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ReturnLocation_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Return User/Contact.
   *
   * @return Return User/Contact
   */
  public int getReturnUser_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ReturnUser_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Reversal ID.
   *
   * @return ID of document reversal
   */
  public int getReversal_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Reversal_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Reversal ID.
   *
   * @param Reversal_ID ID of document reversal
   */
  public void setReversal_ID(int Reversal_ID) {
    if (Reversal_ID < 1) set_Value(COLUMNNAME_Reversal_ID, null);
    else set_Value(COLUMNNAME_Reversal_ID, Integer.valueOf(Reversal_ID));
  }

    /**
   * Get Sales Representative.
   *
   * @return Sales Representative or Company Agent
   */
  public int getSalesRep_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_SalesRep_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Sales Representative.
   *
   * @param SalesRep_ID Sales Representative or Company Agent
   */
  public void setSalesRep_ID(int SalesRep_ID) {
    if (SalesRep_ID < 1) set_Value(COLUMNNAME_SalesRep_ID, null);
    else set_Value(COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
  }

  /**
   * Get Send EMail.
   *
   * @return Enable sending Document EMail
   */
  public boolean isSendEMail() {
    Object oo = get_Value(COLUMNNAME_SendEMail);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Send EMail.
   *
   * @param SendEMail Enable sending Document EMail
   */
  public void setSendEMail(boolean SendEMail) {
    set_Value(COLUMNNAME_SendEMail, Boolean.valueOf(SendEMail));
  }

    /**
   * Set Ship Date.
   *
   * @param ShipDate Shipment Date/Time
   */
  public void setShipDate(Timestamp ShipDate) {
    set_Value(COLUMNNAME_ShipDate, ShipDate);
  }

    /**
   * Set Tracking No.
   *
   * @param TrackingNo Number to track the shipment
   */
  public void setTrackingNo(String TrackingNo) {
    set_Value(COLUMNNAME_TrackingNo, TrackingNo);
  }

    /**
   * Get User Element List 1.
   *
   * @return User defined list element #1
   */
  public int getUser1_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_User1_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set User Element List 1.
   *
   * @param User1_ID User defined list element #1
   */
  public void setUser1_ID(int User1_ID) {
    if (User1_ID < 1) set_Value(COLUMNNAME_User1_ID, null);
    else set_Value(COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
  }

    /**
   * Get User Element List 2.
   *
   * @return User defined list element #2
   */
  public int getUser2_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_User2_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set User Element List 2.
   *
   * @param User2_ID User defined list element #2
   */
  public void setUser2_ID(int User2_ID) {
    if (User2_ID < 1) set_Value(COLUMNNAME_User2_ID, null);
    else set_Value(COLUMNNAME_User2_ID, Integer.valueOf(User2_ID));
  }

    /**
   * Set Volume.
   *
   * @param Volume Volume of a product
   */
  public void setVolume(BigDecimal Volume) {
    set_Value(COLUMNNAME_Volume, Volume);
  }

    /**
   * Set Weight.
   *
   * @param Weight Weight of a product
   */
  public void setWeight(BigDecimal Weight) {
    set_Value(COLUMNNAME_Weight, Weight);
  }

  protected void addDocsPostProcess(IPODoc doc) {
    docsPostProcess.add(doc);
  }

  public ArrayList<IPODoc> getDocsPostProcess() {
    return docsPostProcess;
  }

  @Override
  public int getTableId() {
    return I_M_InOut.Table_ID;
  }
}
