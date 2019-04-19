package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.IPODoc;
import org.compiere.model.DocumentType;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_M_InOut;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import software.hsharp.core.orm.MBaseTableKt;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Generated Model for M_InOut
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public abstract class X_M_InOut extends PO implements I_M_InOut {

    /**
     * Availability = A
     */
    public static final String DELIVERYRULE_Availability = "A";
    /**
     * Force = F
     */
    public static final String DELIVERYRULE_Force = "F";
    /**
     * Pickup = P
     */
    public static final String DELIVERYVIARULE_Pickup = "P";
    /**
     * Complete = CO
     */
    public static final String DOCACTION_Complete = "CO";
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
     * Completed = CO
     */
    public static final String DOCSTATUS_Completed = "CO";
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
     * Freight included = I
     */
    public static final String FREIGHTCOSTRULE_FreightIncluded = "I";
    /**
     * Customer Shipment = C-
     */
    public static final String MOVEMENTTYPE_CustomerShipment = "C-";
    /**
     * Customer Returns = C+
     */
    public static final String MOVEMENTTYPE_CustomerReturns = "C+";
    /**
     * Vendor Receipts = V+
     */
    public static final String MOVEMENTTYPE_VendorReceipts = "V+";
    /**
     * Vendor Returns = V-
     */
    public static final String MOVEMENTTYPE_VendorReturns = "V-";
    /**
     * Medium = 5
     */
    public static final String PRIORITYRULE_Medium = "5";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;
    /* Save array of documents to process AFTER completing this one */
    protected ArrayList<IPODoc> docsPostProcess = new ArrayList<IPODoc>();

    /**
     * Standard Constructor
     */
    public X_M_InOut(int M_InOut_ID) {
        super(M_InOut_ID);
        /**
         * if (M_InOut_ID == 0) { setBusinessPartnerId (0); setBusinessPartnerLocationId (0); setDocumentTypeId
         * (0); setDateAcct (new Timestamp( System.currentTimeMillis() )); // @#Date@ setDeliveryRule
         * (null); // A setDeliveryViaRule (null); // P setDocAction (null); // CO setDocStatus (null);
         * // DR setDocumentNo (null); setFreightCostRule (null); // I setIsAlternateReturnAddress
         * (false); // N setIsApproved (false); setIsInDispute (false); setIsInTransit (false);
         * setIsPrinted (false); setIsSOTrx (false); // @IsSOTrx@ setInOutId (0); setMovementDate
         * (new Timestamp( System.currentTimeMillis() )); // @#Date@ setMovementType (null);
         * setWarehouseId (0); setPosted (false); setPriorityRule (null); // 5 setProcessed (false);
         * setSendEMail (false); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_InOut(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_InOut[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Trx Organization.
     *
     * @return Performing or initiating organization
     */
    public int getTransactionOrganizationId() {
        Integer ii = (Integer) getValue(COLUMNNAME_AD_OrgTrx_ID);
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
        else setValue(COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
    }

    /**
     * Get User/Contact.
     *
     * @return User within the system - Internal or Business Partner Contact
     */
    public int getUserId() {
        Integer ii = (Integer) getValue(COLUMNNAME_AD_User_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set User/Contact.
     *
     * @param AD_User_ID User within the system - Internal or Business Partner Contact
     */
    public void setUserId(int AD_User_ID) {
        if (AD_User_ID < 1) setValue(COLUMNNAME_AD_User_ID, null);
        else setValue(COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
    }

    /**
     * Get Activity.
     *
     * @return Business Activity
     */
    public int getBusinessActivityId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_Activity_ID);
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
        else setValue(COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
    }

    /**
     * Get Business Partner .
     *
     * @return Identifies a Business Partner
     */
    public int getBusinessPartnerId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Business Partner .
     *
     * @param C_BPartner_ID Identifies a Business Partner
     */
    public void setBusinessPartnerId(int C_BPartner_ID) {
        if (C_BPartner_ID < 1) setValue(COLUMNNAME_C_BPartner_ID, null);
        else setValue(COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
    }

    /**
     * Get Partner Location.
     *
     * @return Identifies the (ship to) address for this Business Partner
     */
    public int getBusinessPartnerLocationId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_BPartner_Location_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Partner Location.
     *
     * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
     */
    public void setBusinessPartnerLocationId(int C_BPartner_Location_ID) {
        if (C_BPartner_Location_ID < 1) setValue(COLUMNNAME_C_BPartner_Location_ID, null);
        else setValue(COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
    }

    /**
     * Get Campaign.
     *
     * @return Marketing Campaign
     */
    public int getCampaignId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_Campaign_ID);
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
        else setValue(COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
    }

    /**
     * Get Charge.
     *
     * @return Additional document charges
     */
    public int getChargeId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_Charge_ID);
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

    public DocumentType getDocumentType() throws RuntimeException {
        return (DocumentType)
                MBaseTableKt.getTable(DocumentType.Table_Name)
                        .getPO(getDocumentTypeId());
    }

    /**
     * Get Document Type.
     *
     * @return Document type or rules
     */
    public int getDocumentTypeId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_DocType_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Document Type.
     *
     * @param C_DocType_ID Document type or rules
     */
    public void setDocumentTypeId(int C_DocType_ID) {
        if (C_DocType_ID < 0) setValueNoCheck(COLUMNNAME_C_DocType_ID, null);
        else setValueNoCheck(COLUMNNAME_C_DocType_ID, C_DocType_ID);
    }

    /**
     * Get Charge amount.
     *
     * @return Charge Amount
     */
    public BigDecimal getChargeAmt() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_ChargeAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Charge amount.
     *
     * @param ChargeAmt Charge Amount
     */
    public void setChargeAmt(BigDecimal ChargeAmt) {
        setValue(COLUMNNAME_ChargeAmt, ChargeAmt);
    }

    /**
     * Get Invoice.
     *
     * @return Invoice Identifier
     */
    public int getInvoiceId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_Invoice_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Invoice.
     *
     * @param C_Invoice_ID Invoice Identifier
     */
    public void setInvoiceId(int C_Invoice_ID) {
        if (C_Invoice_ID < 1) setValueNoCheck(COLUMNNAME_C_Invoice_ID, null);
        else setValueNoCheck(COLUMNNAME_C_Invoice_ID, C_Invoice_ID);
    }

    public I_C_Order getOrder() throws RuntimeException {
        return (I_C_Order)
                MBaseTableKt.getTable(I_C_Order.Table_Name)
                        .getPO(getOrderId());
    }

    /**
     * Get Order.
     *
     * @return Order
     */
    public int getOrderId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_Order_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Order.
     *
     * @param C_Order_ID Order
     */
    public void setOrderId(int C_Order_ID) {
        if (C_Order_ID < 1) setValueNoCheck(COLUMNNAME_C_Order_ID, null);
        else setValueNoCheck(COLUMNNAME_C_Order_ID, C_Order_ID);
    }

    /**
     * Get Project.
     *
     * @return Financial Project
     */
    public int getProjectId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_Project_ID);
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
     * Get Account Date.
     *
     * @return Accounting Date
     */
    public Timestamp getDateAcct() {
        return (Timestamp) getValue(COLUMNNAME_DateAcct);
    }

    /**
     * Set Account Date.
     *
     * @param DateAcct Accounting Date
     */
    public void setDateAcct(Timestamp DateAcct) {
        setValue(COLUMNNAME_DateAcct, DateAcct);
    }

    /**
     * Get Date Ordered.
     *
     * @return Date of Order
     */
    public Timestamp getDateOrdered() {
        return (Timestamp) getValue(COLUMNNAME_DateOrdered);
    }

    /**
     * Set Date Ordered.
     *
     * @param DateOrdered Date of Order
     */
    public void setDateOrdered(Timestamp DateOrdered) {
        setValueNoCheck(COLUMNNAME_DateOrdered, DateOrdered);
    }

    /**
     * Set Date printed.
     *
     * @param DatePrinted Date the document was printed.
     */
    public void setDatePrinted(Timestamp DatePrinted) {
        setValue(COLUMNNAME_DatePrinted, DatePrinted);
    }

    /**
     * Set Date received.
     *
     * @param DateReceived Date a product was received
     */
    public void setDateReceived(Timestamp DateReceived) {
        setValue(COLUMNNAME_DateReceived, DateReceived);
    }

    /**
     * Get Delivery Rule.
     *
     * @return Defines the timing of Delivery
     */
    public String getDeliveryRule() {
        return (String) getValue(COLUMNNAME_DeliveryRule);
    }

    /**
     * Set Delivery Rule.
     *
     * @param DeliveryRule Defines the timing of Delivery
     */
    public void setDeliveryRule(String DeliveryRule) {

        setValue(COLUMNNAME_DeliveryRule, DeliveryRule);
    }

    /**
     * Get Delivery Via.
     *
     * @return How the order will be delivered
     */
    public String getDeliveryViaRule() {
        return (String) getValue(COLUMNNAME_DeliveryViaRule);
    }

    /**
     * Set Delivery Via.
     *
     * @param DeliveryViaRule How the order will be delivered
     */
    public void setDeliveryViaRule(String DeliveryViaRule) {

        setValue(COLUMNNAME_DeliveryViaRule, DeliveryViaRule);
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
     * Set Document No.
     *
     * @param DocumentNo Document sequence number of the document
     */
    public void setDocumentNo(String DocumentNo) {
        setValueNoCheck(COLUMNNAME_DocumentNo, DocumentNo);
    }

    /**
     * Get Drop Ship Business Partner.
     *
     * @return Business Partner to ship to
     */
    public int getDropShipBPartnerId() {
        Integer ii = (Integer) getValue(COLUMNNAME_DropShip_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Drop Ship Business Partner.
     *
     * @param DropShip_BPartner_ID Business Partner to ship to
     */
    public void setDropShipBPartnerId(int DropShip_BPartner_ID) {
        if (DropShip_BPartner_ID < 1) setValue(COLUMNNAME_DropShip_BPartner_ID, null);
        else setValue(COLUMNNAME_DropShip_BPartner_ID, DropShip_BPartner_ID);
    }

    /**
     * Get Drop Shipment Location.
     *
     * @return Business Partner Location for shipping to
     */
    public int getDropShipLocationId() {
        Integer ii = (Integer) getValue(COLUMNNAME_DropShip_Location_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Drop Shipment Location.
     *
     * @param DropShip_Location_ID Business Partner Location for shipping to
     */
    public void setDropShipLocationId(int DropShip_Location_ID) {
        if (DropShip_Location_ID < 1) setValue(COLUMNNAME_DropShip_Location_ID, null);
        else setValue(COLUMNNAME_DropShip_Location_ID, DropShip_Location_ID);
    }

    /**
     * Get Drop Shipment Contact.
     *
     * @return Business Partner Contact for drop shipment
     */
    public int getDropShipUserId() {
        Integer ii = (Integer) getValue(COLUMNNAME_DropShip_User_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Drop Shipment Contact.
     *
     * @param DropShip_User_ID Business Partner Contact for drop shipment
     */
    public void setDropShipUserId(int DropShip_User_ID) {
        if (DropShip_User_ID < 1) setValue(COLUMNNAME_DropShip_User_ID, null);
        else setValue(COLUMNNAME_DropShip_User_ID, DropShip_User_ID);
    }

    /**
     * Get Freight Amount.
     *
     * @return Freight Amount
     */
    public BigDecimal getFreightAmt() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_FreightAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Freight Amount.
     *
     * @param FreightAmt Freight Amount
     */
    public void setFreightAmt(BigDecimal FreightAmt) {
        setValue(COLUMNNAME_FreightAmt, FreightAmt);
    }

    /**
     * Get Freight Cost Rule.
     *
     * @return Method for charging Freight
     */
    public String getFreightCostRule() {
        return (String) getValue(COLUMNNAME_FreightCostRule);
    }

    /**
     * Set Freight Cost Rule.
     *
     * @param FreightCostRule Method for charging Freight
     */
    public void setFreightCostRule(String FreightCostRule) {

        setValue(COLUMNNAME_FreightCostRule, FreightCostRule);
    }

    /**
     * Set Approved.
     *
     * @param IsApproved Indicates if this document requires approval
     */
    public void setIsApproved(boolean IsApproved) {
        setValue(COLUMNNAME_IsApproved, IsApproved);
    }

    /**
     * Get Approved.
     *
     * @return Indicates if this document requires approval
     */
    public boolean isApproved() {
        Object oo = getValue(COLUMNNAME_IsApproved);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(COLUMNNAME_IsDropShip, IsDropShip);
    }

    /**
     * Get Drop Shipment.
     *
     * @return Drop Shipments are sent from the Vendor directly to the Customer
     */
    public boolean isDropShip() {
        Object oo = getValue(COLUMNNAME_IsDropShip);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(COLUMNNAME_IsInDispute, IsInDispute);
    }

    /**
     * Set In Transit.
     *
     * @param IsInTransit Movement is in transit
     */
    public void setIsInTransit(boolean IsInTransit) {
        setValue(COLUMNNAME_IsInTransit, IsInTransit);
    }

    /**
     * Set Printed.
     *
     * @param IsPrinted Indicates if this document / line is printed
     */
    public void setIsPrinted(boolean IsPrinted) {
        setValue(COLUMNNAME_IsPrinted, IsPrinted);
    }

    /**
     * Set Sales Transaction.
     *
     * @param IsSOTrx This is a Sales Transaction
     */
    public void setIsSOTrx(boolean IsSOTrx) {
        setValue(COLUMNNAME_IsSOTrx, IsSOTrx);
    }

    /**
     * Get Sales Transaction.
     *
     * @return This is a Sales Transaction
     */
    public boolean isSOTrx() {
        Object oo = getValue(COLUMNNAME_IsSOTrx);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Shipment/Receipt.
     *
     * @return Material Shipment Document
     */
    public int getInOutId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_InOut_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Movement Date.
     *
     * @return Date a product was moved in or out of inventory
     */
    public Timestamp getMovementDate() {
        return (Timestamp) getValue(COLUMNNAME_MovementDate);
    }

    /**
     * Set Movement Date.
     *
     * @param MovementDate Date a product was moved in or out of inventory
     */
    public void setMovementDate(Timestamp MovementDate) {
        setValue(COLUMNNAME_MovementDate, MovementDate);
    }

    /**
     * Get Movement Type.
     *
     * @return Method of moving the inventory
     */
    public String getMovementType() {
        return (String) getValue(COLUMNNAME_MovementType);
    }

    /**
     * Set Movement Type.
     *
     * @param MovementType Method of moving the inventory
     */
    public void setMovementType(String MovementType) {

        setValueNoCheck(COLUMNNAME_MovementType, MovementType);
    }

    /**
     * Get RMA.
     *
     * @return Return Material Authorization
     */
    public int getRMAId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_RMA_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set RMA.
     *
     * @param M_RMA_ID Return Material Authorization
     */
    public void setRMAId(int M_RMA_ID) {
        if (M_RMA_ID < 1) setValue(COLUMNNAME_M_RMA_ID, null);
        else setValue(COLUMNNAME_M_RMA_ID, M_RMA_ID);
    }

    /**
     * Get Shipper.
     *
     * @return Method or manner of product delivery
     */
    public int getShipperId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Shipper_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Shipper.
     *
     * @param M_Shipper_ID Method or manner of product delivery
     */
    public void setShipperId(int M_Shipper_ID) {
        if (M_Shipper_ID < 1) setValue(COLUMNNAME_M_Shipper_ID, null);
        else setValue(COLUMNNAME_M_Shipper_ID, M_Shipper_ID);
    }

    /**
     * Get Warehouse.
     *
     * @return Storage Warehouse and Service Point
     */
    public int getWarehouseId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Warehouse_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Warehouse.
     *
     * @param M_Warehouse_ID Storage Warehouse and Service Point
     */
    public void setWarehouseId(int M_Warehouse_ID) {
        if (M_Warehouse_ID < 1) setValueNoCheck(COLUMNNAME_M_Warehouse_ID, null);
        else setValueNoCheck(COLUMNNAME_M_Warehouse_ID, M_Warehouse_ID);
    }

    /**
     * Get No Packages.
     *
     * @return Number of packages shipped
     */
    public int getNoPackages() {
        Integer ii = (Integer) getValue(COLUMNNAME_NoPackages);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set No Packages.
     *
     * @param NoPackages Number of packages shipped
     */
    public void setNoPackages(int NoPackages) {
        setValue(COLUMNNAME_NoPackages, NoPackages);
    }

    /**
     * Set Pick Date.
     *
     * @param PickDate Date/Time when picked for Shipment
     */
    public void setPickDate(Timestamp PickDate) {
        setValue(COLUMNNAME_PickDate, PickDate);
    }

    /**
     * Get Order Reference.
     *
     * @return Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
     */
    public String getPOReference() {
        return (String) getValue(COLUMNNAME_POReference);
    }

    /**
     * Set Order Reference.
     *
     * @param POReference Transaction Reference Number (Sales Order, Purchase Order) of your Business
     *                    Partner
     */
    public void setPOReference(String POReference) {
        setValue(COLUMNNAME_POReference, POReference);
    }

    /**
     * Get Posted.
     *
     * @return Posting status
     */
    public boolean isPosted() {
        Object oo = getValue(COLUMNNAME_Posted);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(COLUMNNAME_Posted, Posted);
    }

    /**
     * Set Priority.
     *
     * @param PriorityRule Priority of a document
     */
    public void setPriorityRule(String PriorityRule) {

        setValue(COLUMNNAME_PriorityRule, PriorityRule);
    }

    /**
     * Get Processed.
     *
     * @return The document has been processed
     */
    public boolean isProcessed() {
        Object oo = getValue(COLUMNNAME_Processed);
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
        setValue(COLUMNNAME_Processed, Processed);
    }

    /**
     * Set Process Now.
     *
     * @param Processing Process Now
     */
    public void setProcessing(boolean Processing) {
        setValue(COLUMNNAME_Processing, Processing);
    }

    /**
     * Get Referenced Shipment.
     *
     * @return Referenced Shipment
     */
    public int getReferencedInOutId() {
        Integer ii = (Integer) getValue(COLUMNNAME_Ref_InOut_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Referenced Shipment.
     *
     * @param Ref_InOut_ID Referenced Shipment
     */
    public void setReferencedInOutId(int Ref_InOut_ID) {
        if (Ref_InOut_ID < 1) setValue(COLUMNNAME_Ref_InOut_ID, null);
        else setValue(COLUMNNAME_Ref_InOut_ID, Ref_InOut_ID);
    }

    /**
     * Get Reversal ID.
     *
     * @return ID of document reversal
     */
    public int getReversalId() {
        Integer ii = (Integer) getValue(COLUMNNAME_Reversal_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Reversal ID.
     *
     * @param Reversal_ID ID of document reversal
     */
    public void setReversalId(int Reversal_ID) {
        if (Reversal_ID < 1) setValue(COLUMNNAME_Reversal_ID, null);
        else setValue(COLUMNNAME_Reversal_ID, Reversal_ID);
    }

    /**
     * Get Sales Representative.
     *
     * @return Sales Representative or Company Agent
     */
    public int getSalesRepresentativeId() {
        Integer ii = (Integer) getValue(COLUMNNAME_SalesRep_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Sales Representative.
     *
     * @param SalesRep_ID Sales Representative or Company Agent
     */
    public void setSalesRepresentativeId(int SalesRep_ID) {
        if (SalesRep_ID < 1) setValue(COLUMNNAME_SalesRep_ID, null);
        else setValue(COLUMNNAME_SalesRep_ID, SalesRep_ID);
    }

    /**
     * Get Send EMail.
     *
     * @return Enable sending Document EMail
     */
    public boolean isSendEMail() {
        Object oo = getValue(COLUMNNAME_SendEMail);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(COLUMNNAME_SendEMail, SendEMail);
    }

    /**
     * Set Ship Date.
     *
     * @param ShipDate Shipment Date/Time
     */
    public void setShipDate(Timestamp ShipDate) {
        setValue(COLUMNNAME_ShipDate, ShipDate);
    }

    /**
     * Set Tracking No.
     *
     * @param TrackingNo Number to track the shipment
     */
    public void setTrackingNo(String TrackingNo) {
        setValue(COLUMNNAME_TrackingNo, TrackingNo);
    }

    /**
     * Get User Element List 1.
     *
     * @return User defined list element #1
     */
    public int getUser1Id() {
        Integer ii = (Integer) getValue(COLUMNNAME_User1_ID);
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
        Integer ii = (Integer) getValue(COLUMNNAME_User2_ID);
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

    /**
     * Set Volume.
     *
     * @param Volume Volume of a product
     */
    public void setVolume(BigDecimal Volume) {
        setValue(COLUMNNAME_Volume, Volume);
    }

    /**
     * Set Weight.
     *
     * @param Weight Weight of a product
     */
    public void setWeight(BigDecimal Weight) {
        setValue(COLUMNNAME_Weight, Weight);
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
