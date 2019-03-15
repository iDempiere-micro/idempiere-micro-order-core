package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_Order;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Generated Model for C_Order
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_Order extends PO {

    /**
     * Availability = A
     */
    public static final String DELIVERYRULE_Availability = "A";
    /**
     * Complete Line = L
     */
    public static final String DELIVERYRULE_CompleteLine = "L";
    /**
     * Complete Order = O
     */
    public static final String DELIVERYRULE_CompleteOrder = "O";
    /**
     * Force = F
     */
    public static final String DELIVERYRULE_Force = "F";
    /**
     * Manual = M
     */
    public static final String DELIVERYRULE_Manual = "M";
    /**
     * Pickup = P
     */
    public static final String DELIVERYVIARULE_Pickup = "P";
    /**
     * Shipper = S
     */
    public static final String DELIVERYVIARULE_Shipper = "S";
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
     * Wait Complete = WC
     */
    public static final String DOCACTION_WaitComplete = "WC";
    /**
     * Drafted = DR
     */
    public static final String DOCSTATUS_Drafted = "DR";
    /**
     * Completed = CO
     */
    public static final String DOCSTATUS_Completed = "CO";
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
     * Waiting Payment = WP
     */
    public static final String DOCSTATUS_WaitingPayment = "WP";
    /**
     * Freight included = I
     */
    public static final String FREIGHTCOSTRULE_FreightIncluded = "I";
    /**
     * Fix price = F
     */
    public static final String FREIGHTCOSTRULE_FixPrice = "F";
    /**
     * Calculated = C
     */
    public static final String FREIGHTCOSTRULE_Calculated = "C";
    /**
     * After Order delivered = O
     */
    public static final String INVOICERULE_AfterOrderDelivered = "O";
    /**
     * After Delivery = D
     */
    public static final String INVOICERULE_AfterDelivery = "D";
    /**
     * Customer Schedule after Delivery = S
     */
    public static final String INVOICERULE_CustomerScheduleAfterDelivery = "S";
    /**
     * Immediate = I
     */
    public static final String INVOICERULE_Immediate = "I";
    /**
     * Cash = B
     */
    public static final String PAYMENTRULE_Cash = "B";
    /**
     * Direct Deposit = T
     */
    public static final String PAYMENTRULE_DirectDeposit = "T";
    /**
     * On Credit = P
     */
    public static final String PAYMENTRULE_OnCredit = "P";
    /**
     * Direct Debit = D
     */
    public static final String PAYMENTRULE_DirectDebit = "D";
    /**
     * Mixed POS Payment = M
     */
    public static final String PAYMENTRULE_MixedPOSPayment = "M";
    /**
     * Medium = 5
     */
    public static final String PRIORITYRULE_Medium = "5";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_C_Order(Properties ctx, int C_Order_ID) {
        super(ctx, C_Order_ID);
        /**
         * if (C_Order_ID == 0) { setBusinessPartnerId (0); setBusinessPartnerLocationId (0); setCurrencyId
         * (0); // @C_Currency_ID@ setDocumentTypeId (0); // 0 setTargetDocumentTypeId (0); setOrderId
         * (0); setPaymentTermId (0); setDateAcct (new Timestamp( System.currentTimeMillis() ));
         * // @#Date@ setDateOrdered (new Timestamp( System.currentTimeMillis() )); // @#Date@
         * setDatePromised (new Timestamp( System.currentTimeMillis() )); // @#Date@ setDeliveryRule
         * (null); // F setDeliveryViaRule (null); // P setDocAction (null); // CO setDocStatus (null);
         * // DR setDocumentNo (null); setFreightAmt (Env.ZERO); setFreightCostRule (null); // I
         * setGrandTotal (Env.ZERO); setInvoiceRule (null); // I setIsApproved (false); // @IsApproved@
         * setIsCreditApproved (false); setIsDelivered (false); setIsDiscountPrinted (false);
         * setIsDropShip (false); // N setIsInvoiced (false); setIsPayScheduleValid (false); // N
         * setIsPrinted (false); setIsPriviledgedRate (false); // N setIsSelected (false);
         * setIsSelfService (false); setIsSOTrx (false); // @IsSOTrx@ setIsTaxIncluded (false);
         * setIsTransferred (false); setPriceListId (0); setWarehouseId (0); setPaymentRule
         * (null); // B setPosted (false); // N setPriorityRule (null); // 5 setProcessed (false);
         * setSalesRepresentativeId (0); setSendEMail (false); setTotalLines (Env.ZERO); }
         */
    }

    /**
     * Load Constructor
     */
    public X_C_Order(Properties ctx, Row row) {
        super(ctx, row);
    }

    /**
     * AccessLevel
     *
     * @return 1 - Org
     */
    protected int getAccessLevel() {
        return I_C_Order.accessLevel.intValue();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("X_C_Order[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Trx Organization.
     *
     * @return Performing or initiating organization
     */
    public int getTransactionOrganizationId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_AD_OrgTrx_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Trx Organization.
     *
     * @param AD_OrgTrx_ID Performing or initiating organization
     */
    public void setTransactionOrganizationId(int AD_OrgTrx_ID) {
        if (AD_OrgTrx_ID < 1) setValue(I_C_Order.COLUMNNAME_AD_OrgTrx_ID, null);
        else setValue(I_C_Order.COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
    }

    /**
     * Get User/Contact.
     *
     * @return User within the system - Internal or Business Partner Contact
     */
    public int getUserId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_AD_User_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set User/Contact.
     *
     * @param AD_User_ID User within the system - Internal or Business Partner Contact
     */
    public void setUserId(int AD_User_ID) {
        if (AD_User_ID < 1) setValue(I_C_Order.COLUMNNAME_AD_User_ID, null);
        else setValue(I_C_Order.COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
    }

    /**
     * Get Invoice Partner.
     *
     * @return Business Partner to be invoiced
     */
    public int getBill_BPartner_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_Bill_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Invoice Partner.
     *
     * @param Bill_BPartner_ID Business Partner to be invoiced
     */
    public void setBill_BPartner_ID(int Bill_BPartner_ID) {
        if (Bill_BPartner_ID < 1) setValue(I_C_Order.COLUMNNAME_Bill_BPartner_ID, null);
        else setValue(I_C_Order.COLUMNNAME_Bill_BPartner_ID, Integer.valueOf(Bill_BPartner_ID));
    }

    /**
     * Get Invoice Location.
     *
     * @return Business Partner Location for invoicing
     */
    public int getBusinessPartnerInvoicingLocationId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_Bill_Location_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Invoice Location.
     *
     * @param Bill_Location_ID Business Partner Location for invoicing
     */
    public void setBusinessPartnerInvoicingLocationId(int Bill_Location_ID) {
        if (Bill_Location_ID < 1) setValue(I_C_Order.COLUMNNAME_Bill_Location_ID, null);
        else setValue(I_C_Order.COLUMNNAME_Bill_Location_ID, Integer.valueOf(Bill_Location_ID));
    }

    /**
     * Get Invoice Contact.
     *
     * @return Business Partner Contact for invoicing
     */
    public int getBill_User_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_Bill_User_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Invoice Contact.
     *
     * @param Bill_User_ID Business Partner Contact for invoicing
     */
    public void setBill_User_ID(int Bill_User_ID) {
        if (Bill_User_ID < 1) setValue(I_C_Order.COLUMNNAME_Bill_User_ID, null);
        else setValue(I_C_Order.COLUMNNAME_Bill_User_ID, Integer.valueOf(Bill_User_ID));
    }

    /**
     * Get Activity.
     *
     * @return Business Activity
     */
    public int getBusinessActivityId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_Activity_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Activity.
     *
     * @param C_Activity_ID Business Activity
     */
    public void setBusinessActivityId(int C_Activity_ID) {
        if (C_Activity_ID < 1) setValue(I_C_Order.COLUMNNAME_C_Activity_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
    }

    /**
     * Get Business Partner .
     *
     * @return Identifies a Business Partner
     */
    public int getBusinessPartnerId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Business Partner .
     *
     * @param C_BPartner_ID Identifies a Business Partner
     */
    public void setBusinessPartnerId(int C_BPartner_ID) {
        if (C_BPartner_ID < 1) setValue(I_C_Order.COLUMNNAME_C_BPartner_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
    }

    /**
     * Get Partner Location.
     *
     * @return Identifies the (ship to) address for this Business Partner
     */
    public int getBusinessPartnerLocationId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_BPartner_Location_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Partner Location.
     *
     * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
     */
    public void setBusinessPartnerLocationId(int C_BPartner_Location_ID) {
        if (C_BPartner_Location_ID < 1) setValue(I_C_Order.COLUMNNAME_C_BPartner_Location_ID, null);
        else
            setValue(
                    I_C_Order.COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
    }

    /**
     * Get Campaign.
     *
     * @return Marketing Campaign
     */
    public int getCampaignId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_Campaign_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Campaign.
     *
     * @param C_Campaign_ID Marketing Campaign
     */
    public void setCampaignId(int C_Campaign_ID) {
        if (C_Campaign_ID < 1) setValue(I_C_Order.COLUMNNAME_C_Campaign_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
    }

    /**
     * Get Cash Journal Line.
     *
     * @return Cash Journal Line
     */
    public int getC_CashLine_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_CashLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Cash Journal Line.
     *
     * @param C_CashLine_ID Cash Journal Line
     */
    public void setC_CashLine_ID(int C_CashLine_ID) {
        if (C_CashLine_ID < 1) setValue(I_C_Order.COLUMNNAME_C_CashLine_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_CashLine_ID, Integer.valueOf(C_CashLine_ID));
    }

    /**
     * Get Cash Plan Line.
     *
     * @return Cash Plan Line
     */
    public int getC_CashPlanLine_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_CashPlanLine_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Charge.
     *
     * @return Additional document charges
     */
    public int getChargeId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_Charge_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Currency Type.
     *
     * @return Currency Conversion Rate Type
     */
    public int getConversionTypeId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_ConversionType_ID);
        if (ii == null) return 0;
        return ii;
    }

    public org.compiere.model.I_C_Currency getCurrency() throws RuntimeException {
        return (org.compiere.model.I_C_Currency)
                MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
                        .getPO(getCurrencyId());
    }


    /**
     * Get Currency.
     *
     * @return The Currency for this record
     */
    public int getCurrencyId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_Currency_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Currency.
     *
     * @param C_Currency_ID The Currency for this record
     */
    public void setCurrencyId(int C_Currency_ID) {
        if (C_Currency_ID < 1) setValueNoCheck(I_C_Order.COLUMNNAME_C_Currency_ID, null);
        else setValueNoCheck(I_C_Order.COLUMNNAME_C_Currency_ID, C_Currency_ID);
    }

    public org.compiere.model.I_C_DocType getDocumentType() throws RuntimeException {
        return (org.compiere.model.I_C_DocType)
                MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
                        .getPO(getDocumentTypeId());
    }

    /**
     * Get Document Type.
     *
     * @return Document type or rules
     */
    public int getDocumentTypeId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_DocType_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Document Type.
     *
     * @param C_DocType_ID Document type or rules
     */
    public void setDocumentTypeId(int C_DocType_ID) {
        if (C_DocType_ID < 0) setValueNoCheck(I_C_Order.COLUMNNAME_C_DocType_ID, null);
        else setValueNoCheck(I_C_Order.COLUMNNAME_C_DocType_ID, C_DocType_ID);
    }


    public org.compiere.model.I_C_DocType getTargetDocumentType() throws RuntimeException {
        return (org.compiere.model.I_C_DocType)
                MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
                        .getPO(getTargetDocumentTypeId());
    }

    /**
     * Get Target Document Type.
     *
     * @return Target document type for conversing documents
     */
    public int getTargetDocumentTypeId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_DocTypeTarget_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Target Document Type.
     *
     * @param C_DocTypeTarget_ID Target document type for conversing documents
     */
    public void setTargetDocumentTypeId(int C_DocTypeTarget_ID) {
        if (C_DocTypeTarget_ID < 1) setValue(I_C_Order.COLUMNNAME_C_DocTypeTarget_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_DocTypeTarget_ID, C_DocTypeTarget_ID);
    }

    /**
     * Get Charge amount.
     *
     * @return Charge Amount
     */
    public BigDecimal getChargeAmt() {
        BigDecimal bd = (BigDecimal) getValue(I_C_Order.COLUMNNAME_ChargeAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Charge amount.
     *
     * @param ChargeAmt Charge Amount
     */
    public void setChargeAmt(BigDecimal ChargeAmt) {
        setValue(I_C_Order.COLUMNNAME_ChargeAmt, ChargeAmt);
    }

    /**
     * Get Order.
     *
     * @return Order
     */
    public int getOrderId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_Order_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Order Source.
     *
     * @param C_OrderSource_ID Order Source
     */
    public void setC_OrderSource_ID(int C_OrderSource_ID) {
        if (C_OrderSource_ID < 1) setValue(I_C_Order.COLUMNNAME_C_OrderSource_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_OrderSource_ID, Integer.valueOf(C_OrderSource_ID));
    }

    /**
     * Get Payment.
     *
     * @return Payment identifier
     */
    public int getPaymentId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_Payment_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Payment.
     *
     * @param C_Payment_ID Payment identifier
     */
    public void setPaymentId(int C_Payment_ID) {
        if (C_Payment_ID < 1) setValue(I_C_Order.COLUMNNAME_C_Payment_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_Payment_ID, Integer.valueOf(C_Payment_ID));
    }

    /**
     * Get Payment Term.
     *
     * @return The terms of Payment (timing, discount)
     */
    public int getPaymentTermId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_PaymentTerm_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Payment Term.
     *
     * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
     */
    public void setPaymentTermId(int C_PaymentTerm_ID) {
        if (C_PaymentTerm_ID < 1) setValue(I_C_Order.COLUMNNAME_C_PaymentTerm_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
    }

    /**
     * Get POS Terminal.
     *
     * @return Point of Sales Terminal
     */
    public int getPOSId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_POS_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Project.
     *
     * @return Financial Project
     */
    public int getProjectId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_C_Project_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Project.
     *
     * @param C_Project_ID Financial Project
     */
    public void setProjectId(int C_Project_ID) {
        if (C_Project_ID < 1) setValue(I_C_Order.COLUMNNAME_C_Project_ID, null);
        else setValue(I_C_Order.COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
    }

    /**
     * Get Account Date.
     *
     * @return Accounting Date
     */
    public Timestamp getDateAcct() {
        return (Timestamp) getValue(I_C_Order.COLUMNNAME_DateAcct);
    }

    /**
     * Set Account Date.
     *
     * @param DateAcct Accounting Date
     */
    public void setDateAcct(Timestamp DateAcct) {
        setValue(I_C_Order.COLUMNNAME_DateAcct, DateAcct);
    }

    /**
     * Get Date Ordered.
     *
     * @return Date of Order
     */
    public Timestamp getDateOrdered() {
        return (Timestamp) getValue(I_C_Order.COLUMNNAME_DateOrdered);
    }

    /**
     * Set Date Ordered.
     *
     * @param DateOrdered Date of Order
     */
    public void setDateOrdered(Timestamp DateOrdered) {
        setValue(I_C_Order.COLUMNNAME_DateOrdered, DateOrdered);
    }

    /**
     * Set Date printed.
     *
     * @param DatePrinted Date the document was printed.
     */
    public void setDatePrinted(Timestamp DatePrinted) {
        setValue(I_C_Order.COLUMNNAME_DatePrinted, DatePrinted);
    }

    /**
     * Get Date Promised.
     *
     * @return Date Order was promised
     */
    public Timestamp getDatePromised() {
        return (Timestamp) getValue(I_C_Order.COLUMNNAME_DatePromised);
    }

    /**
     * Set Date Promised.
     *
     * @param DatePromised Date Order was promised
     */
    public void setDatePromised(Timestamp DatePromised) {
        setValue(I_C_Order.COLUMNNAME_DatePromised, DatePromised);
    }

    /**
     * Get Delivery Rule.
     *
     * @return Defines the timing of Delivery
     */
    public String getDeliveryRule() {
        return (String) getValue(I_C_Order.COLUMNNAME_DeliveryRule);
    }

    /**
     * Set Delivery Rule.
     *
     * @param DeliveryRule Defines the timing of Delivery
     */
    public void setDeliveryRule(String DeliveryRule) {

        setValue(I_C_Order.COLUMNNAME_DeliveryRule, DeliveryRule);
    }

    /**
     * Get Delivery Via.
     *
     * @return How the order will be delivered
     */
    public String getDeliveryViaRule() {
        return (String) getValue(I_C_Order.COLUMNNAME_DeliveryViaRule);
    }

    /**
     * Set Delivery Via.
     *
     * @param DeliveryViaRule How the order will be delivered
     */
    public void setDeliveryViaRule(String DeliveryViaRule) {

        setValue(I_C_Order.COLUMNNAME_DeliveryViaRule, DeliveryViaRule);
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) getValue(I_C_Order.COLUMNNAME_Description);
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        setValue(I_C_Order.COLUMNNAME_Description, Description);
    }

    /**
     * Get Document Action.
     *
     * @return The targeted status of the document
     */
    public String getDocAction() {
        return (String) getValue(I_C_Order.COLUMNNAME_DocAction);
    }

    /**
     * Set Document Action.
     *
     * @param DocAction The targeted status of the document
     */
    public void setDocAction(String DocAction) {

        setValue(I_C_Order.COLUMNNAME_DocAction, DocAction);
    }

    /**
     * Get Document Status.
     *
     * @return The current status of the document
     */
    public String getDocStatus() {
        return (String) getValue(I_C_Order.COLUMNNAME_DocStatus);
    }

    /**
     * Set Document Status.
     *
     * @param DocStatus The current status of the document
     */
    public void setDocStatus(String DocStatus) {

        setValue(I_C_Order.COLUMNNAME_DocStatus, DocStatus);
    }

    /**
     * Get Document No.
     *
     * @return Document sequence number of the document
     */
    public String getDocumentNo() {
        return (String) getValue(I_C_Order.COLUMNNAME_DocumentNo);
    }

    /**
     * Set Document No.
     *
     * @param DocumentNo Document sequence number of the document
     */
    public void setDocumentNo(String DocumentNo) {
        setValueNoCheck(I_C_Order.COLUMNNAME_DocumentNo, DocumentNo);
    }

    /**
     * Get Drop Ship Business Partner.
     *
     * @return Business Partner to ship to
     */
    public int getDropShip_BPartner_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_DropShip_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Drop Ship Business Partner.
     *
     * @param DropShip_BPartner_ID Business Partner to ship to
     */
    public void setDropShip_BPartner_ID(int DropShip_BPartner_ID) {
        if (DropShip_BPartner_ID < 1) setValue(I_C_Order.COLUMNNAME_DropShip_BPartner_ID, null);
        else
            setValue(I_C_Order.COLUMNNAME_DropShip_BPartner_ID, Integer.valueOf(DropShip_BPartner_ID));
    }

    /**
     * Get Drop Shipment Location.
     *
     * @return Business Partner Location for shipping to
     */
    public int getDropShip_Location_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_DropShip_Location_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Drop Shipment Location.
     *
     * @param DropShip_Location_ID Business Partner Location for shipping to
     */
    public void setDropShip_Location_ID(int DropShip_Location_ID) {
        if (DropShip_Location_ID < 1) setValue(I_C_Order.COLUMNNAME_DropShip_Location_ID, null);
        else
            setValue(I_C_Order.COLUMNNAME_DropShip_Location_ID, Integer.valueOf(DropShip_Location_ID));
    }

    /**
     * Get Drop Shipment Contact.
     *
     * @return Business Partner Contact for drop shipment
     */
    public int getDropShip_User_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_DropShip_User_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Drop Shipment Contact.
     *
     * @param DropShip_User_ID Business Partner Contact for drop shipment
     */
    public void setDropShip_User_ID(int DropShip_User_ID) {
        if (DropShip_User_ID < 1) setValue(I_C_Order.COLUMNNAME_DropShip_User_ID, null);
        else setValue(I_C_Order.COLUMNNAME_DropShip_User_ID, Integer.valueOf(DropShip_User_ID));
    }

    /**
     * Get Freight Amount.
     *
     * @return Freight Amount
     */
    public BigDecimal getFreightAmt() {
        BigDecimal bd = (BigDecimal) getValue(I_C_Order.COLUMNNAME_FreightAmt);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Freight Amount.
     *
     * @param FreightAmt Freight Amount
     */
    public void setFreightAmt(BigDecimal FreightAmt) {
        setValue(I_C_Order.COLUMNNAME_FreightAmt, FreightAmt);
    }

    /**
     * Get Freight Cost Rule.
     *
     * @return Method for charging Freight
     */
    public String getFreightCostRule() {
        return (String) getValue(I_C_Order.COLUMNNAME_FreightCostRule);
    }

    /**
     * Set Freight Cost Rule.
     *
     * @param FreightCostRule Method for charging Freight
     */
    public void setFreightCostRule(String FreightCostRule) {

        setValue(I_C_Order.COLUMNNAME_FreightCostRule, FreightCostRule);
    }

    /**
     * Get Grand Total.
     *
     * @return Total amount of document
     */
    public BigDecimal getGrandTotal() {
        BigDecimal bd = (BigDecimal) getValue(I_C_Order.COLUMNNAME_GrandTotal);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Grand Total.
     *
     * @param GrandTotal Total amount of document
     */
    public void setGrandTotal(BigDecimal GrandTotal) {
        setValueNoCheck(I_C_Order.COLUMNNAME_GrandTotal, GrandTotal);
    }

    /**
     * Get Invoice Rule.
     *
     * @return Frequency and method of invoicing
     */
    public String getInvoiceRule() {
        return (String) getValue(I_C_Order.COLUMNNAME_InvoiceRule);
    }

    /**
     * Set Invoice Rule.
     *
     * @param InvoiceRule Frequency and method of invoicing
     */
    public void setInvoiceRule(String InvoiceRule) {

        setValue(I_C_Order.COLUMNNAME_InvoiceRule, InvoiceRule);
    }

    /**
     * Set Approved.
     *
     * @param IsApproved Indicates if this document requires approval
     */
    public void setIsApproved(boolean IsApproved) {
        setValueNoCheck(I_C_Order.COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
    }

    /**
     * Get Approved.
     *
     * @return Indicates if this document requires approval
     */
    public boolean isApproved() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsApproved);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Credit Approved.
     *
     * @param IsCreditApproved Credit has been approved
     */
    public void setIsCreditApproved(boolean IsCreditApproved) {
        setValueNoCheck(I_C_Order.COLUMNNAME_IsCreditApproved, Boolean.valueOf(IsCreditApproved));
    }

    /**
     * Set Delivered.
     *
     * @param IsDelivered Delivered
     */
    public void setIsDelivered(boolean IsDelivered) {
        setValueNoCheck(I_C_Order.COLUMNNAME_IsDelivered, Boolean.valueOf(IsDelivered));
    }

    /**
     * Set Discount Printed.
     *
     * @param IsDiscountPrinted Print Discount on Invoice and Order
     */
    public void setIsDiscountPrinted(boolean IsDiscountPrinted) {
        setValue(I_C_Order.COLUMNNAME_IsDiscountPrinted, Boolean.valueOf(IsDiscountPrinted));
    }

    /**
     * Get Discount Printed.
     *
     * @return Print Discount on Invoice and Order
     */
    public boolean isDiscountPrinted() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsDiscountPrinted);
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
        setValue(I_C_Order.COLUMNNAME_IsDropShip, Boolean.valueOf(IsDropShip));
    }

    /**
     * Get Drop Shipment.
     *
     * @return Drop Shipments are sent from the Vendor directly to the Customer
     */
    public boolean isDropShip() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsDropShip);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Invoiced.
     *
     * @param IsInvoiced Is this invoiced?
     */
    public void setIsInvoiced(boolean IsInvoiced) {
        setValueNoCheck(I_C_Order.COLUMNNAME_IsInvoiced, Boolean.valueOf(IsInvoiced));
    }

    /**
     * Set Pay Schedule valid.
     *
     * @param IsPayScheduleValid Is the Payment Schedule is valid
     */
    public void setIsPayScheduleValid(boolean IsPayScheduleValid) {
        setValue(I_C_Order.COLUMNNAME_IsPayScheduleValid, Boolean.valueOf(IsPayScheduleValid));
    }

    /**
     * Get Pay Schedule valid.
     *
     * @return Is the Payment Schedule is valid
     */
    public boolean isPayScheduleValid() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsPayScheduleValid);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Printed.
     *
     * @param IsPrinted Indicates if this document / line is printed
     */
    public void setIsPrinted(boolean IsPrinted) {
        setValueNoCheck(I_C_Order.COLUMNNAME_IsPrinted, Boolean.valueOf(IsPrinted));
    }

    /**
     * Get Priviledged Rate.
     *
     * @return Priviledged Rate
     */
    public boolean isPriviledgedRate() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsPriviledgedRate);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Selected.
     *
     * @param IsSelected Selected
     */
    public void setIsSelected(boolean IsSelected) {
        setValue(I_C_Order.COLUMNNAME_IsSelected, Boolean.valueOf(IsSelected));
    }

    /**
     * Set Self-Service.
     *
     * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
     */
    public void setIsSelfService(boolean IsSelfService) {
        setValue(I_C_Order.COLUMNNAME_IsSelfService, Boolean.valueOf(IsSelfService));
    }

    /**
     * Get Self-Service.
     *
     * @return This is a Self-Service entry or this entry can be changed via Self-Service
     */
    public boolean isSelfService() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsSelfService);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
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
        setValue(I_C_Order.COLUMNNAME_IsSOTrx, Boolean.valueOf(IsSOTrx));
    }

    /**
     * Get Sales Transaction.
     *
     * @return This is a Sales Transaction
     */
    public boolean isSOTrx() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsSOTrx);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Price includes Tax.
     *
     * @param IsTaxIncluded Tax is included in the price
     */
    public void setIsTaxIncluded(boolean IsTaxIncluded) {
        setValue(I_C_Order.COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
    }

    /**
     * Get Price includes Tax.
     *
     * @return Tax is included in the price
     */
    public boolean isTaxIncluded() {
        Object oo = getValue(I_C_Order.COLUMNNAME_IsTaxIncluded);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Transferred.
     *
     * @param IsTransferred Transferred to General Ledger (i.e. accounted)
     */
    public void setIsTransferred(boolean IsTransferred) {
        setValueNoCheck(I_C_Order.COLUMNNAME_IsTransferred, Boolean.valueOf(IsTransferred));
    }

    /**
     * Get Linked Order.
     *
     * @return This field links a sales order to the purchase order that is generated from it.
     */
    public int getLink_Order_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_Link_Order_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Linked Order.
     *
     * @param Link_Order_ID This field links a sales order to the purchase order that is generated
     *                      from it.
     */
    public void setLink_Order_ID(int Link_Order_ID) {
        if (Link_Order_ID < 1) setValueNoCheck(I_C_Order.COLUMNNAME_Link_Order_ID, null);
        else setValueNoCheck(I_C_Order.COLUMNNAME_Link_Order_ID, Link_Order_ID);
    }

    public org.compiere.model.I_M_PriceList getPriceList() throws RuntimeException {
        return (org.compiere.model.I_M_PriceList)
                MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
                        .getPO(getPriceListId());
    }

    /**
     * Get Price List.
     *
     * @return Unique identifier of a Price List
     */
    public int getPriceListId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_M_PriceList_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Price List.
     *
     * @param M_PriceList_ID Unique identifier of a Price List
     */
    public void setPriceListId(int M_PriceList_ID) {
        if (M_PriceList_ID < 1) setValue(I_C_Order.COLUMNNAME_M_PriceList_ID, null);
        else setValue(I_C_Order.COLUMNNAME_M_PriceList_ID, M_PriceList_ID);
    }

    /**
     * Get Shipper.
     *
     * @return Method or manner of product delivery
     */
    public int getShipperId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_M_Shipper_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Shipper.
     *
     * @param M_Shipper_ID Method or manner of product delivery
     */
    public void setShipperId(int M_Shipper_ID) {
        if (M_Shipper_ID < 1) setValue(I_C_Order.COLUMNNAME_M_Shipper_ID, null);
        else setValue(I_C_Order.COLUMNNAME_M_Shipper_ID, M_Shipper_ID);
    }

    /**
     * Get Warehouse.
     *
     * @return Storage Warehouse and Service Point
     */
    public int getWarehouseId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_M_Warehouse_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Warehouse.
     *
     * @param M_Warehouse_ID Storage Warehouse and Service Point
     */
    public void setWarehouseId(int M_Warehouse_ID) {
        if (M_Warehouse_ID < 1) setValue(I_C_Order.COLUMNNAME_M_Warehouse_ID, null);
        else setValue(I_C_Order.COLUMNNAME_M_Warehouse_ID, M_Warehouse_ID);
    }

    /**
     * Get Payment Rule.
     *
     * @return How you pay the invoice
     */
    public String getPaymentRule() {
        return (String) getValue(I_C_Order.COLUMNNAME_PaymentRule);
    }

    /**
     * Set Payment Rule.
     *
     * @param PaymentRule How you pay the invoice
     */
    public void setPaymentRule(String PaymentRule) {

        setValue(I_C_Order.COLUMNNAME_PaymentRule, PaymentRule);
    }

    /**
     * Get Order Reference.
     *
     * @return Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
     */
    public String getPOReference() {
        return (String) getValue(I_C_Order.COLUMNNAME_POReference);
    }

    /**
     * Set Order Reference.
     *
     * @param POReference Transaction Reference Number (Sales Order, Purchase Order) of your Business
     *                    Partner
     */
    public void setPOReference(String POReference) {
        setValue(I_C_Order.COLUMNNAME_POReference, POReference);
    }

    /**
     * Get Posted.
     *
     * @return Posting status
     */
    public boolean isPosted() {
        Object oo = getValue(I_C_Order.COLUMNNAME_Posted);
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
        setValue(I_C_Order.COLUMNNAME_Posted, Boolean.valueOf(Posted));
    }

    /**
     * Get Priority.
     *
     * @return Priority of a document
     */
    public String getPriorityRule() {
        return (String) getValue(I_C_Order.COLUMNNAME_PriorityRule);
    }

    /**
     * Set Priority.
     *
     * @param PriorityRule Priority of a document
     */
    public void setPriorityRule(String PriorityRule) {

        setValue(I_C_Order.COLUMNNAME_PriorityRule, PriorityRule);
    }

    /**
     * Get Processed.
     *
     * @return The document has been processed
     */
    public boolean isProcessed() {
        Object oo = getValue(I_C_Order.COLUMNNAME_Processed);
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
        setValueNoCheck(I_C_Order.COLUMNNAME_Processed, Boolean.valueOf(Processed));
    }

    /**
     * Get Processed On.
     *
     * @return The date+time (expressed in decimal format) when the document has been processed
     */
    public BigDecimal getProcessedOn() {
        BigDecimal bd = (BigDecimal) getValue(I_C_Order.COLUMNNAME_ProcessedOn);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Process Now.
     *
     * @param Processing Process Now
     */
    public void setProcessing(boolean Processing) {
        setValue(I_C_Order.COLUMNNAME_Processing, Boolean.valueOf(Processing));
    }

    /**
     * Set Quotation.
     *
     * @param QuotationOrder_ID Quotation used for generating this order
     */
    public void setQuotationOrder_ID(int QuotationOrder_ID) {
        if (QuotationOrder_ID < 1) setValue(I_C_Order.COLUMNNAME_QuotationOrder_ID, null);
        else setValue(I_C_Order.COLUMNNAME_QuotationOrder_ID, Integer.valueOf(QuotationOrder_ID));
    }

    /**
     * Get Referenced Order.
     *
     * @return Reference to corresponding Sales/Purchase Order
     */
    public int getRef_Order_ID() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_Ref_Order_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Referenced Order.
     *
     * @param Ref_Order_ID Reference to corresponding Sales/Purchase Order
     */
    public void setRef_Order_ID(int Ref_Order_ID) {
        if (Ref_Order_ID < 1) setValue(I_C_Order.COLUMNNAME_Ref_Order_ID, null);
        else setValue(I_C_Order.COLUMNNAME_Ref_Order_ID, Integer.valueOf(Ref_Order_ID));
    }

    /**
     * Get Sales Representative.
     *
     * @return Sales Representative or Company Agent
     */
    public int getSalesRepresentativeId() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_SalesRep_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Sales Representative.
     *
     * @param SalesRep_ID Sales Representative or Company Agent
     */
    public void setSalesRepresentativeId(int SalesRep_ID) {
        if (SalesRep_ID < 1) setValue(I_C_Order.COLUMNNAME_SalesRep_ID, null);
        else setValue(I_C_Order.COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
    }

    /**
     * Get Send EMail.
     *
     * @return Enable sending Document EMail
     */
    public boolean isSendEMail() {
        Object oo = getValue(I_C_Order.COLUMNNAME_SendEMail);
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
        setValue(I_C_Order.COLUMNNAME_SendEMail, Boolean.valueOf(SendEMail));
    }

    /**
     * Get Total Lines.
     *
     * @return Total of all document lines
     */
    public BigDecimal getTotalLines() {
        BigDecimal bd = (BigDecimal) getValue(I_C_Order.COLUMNNAME_TotalLines);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Total Lines.
     *
     * @param TotalLines Total of all document lines
     */
    public void setTotalLines(BigDecimal TotalLines) {
        setValueNoCheck(I_C_Order.COLUMNNAME_TotalLines, TotalLines);
    }

    /**
     * Get User Element List 1.
     *
     * @return User defined list element #1
     */
    public int getUser1Id() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_User1_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set User Element List 1.
     *
     * @param User1_ID User defined list element #1
     */
    public void setUser1Id(int User1_ID) {
        if (User1_ID < 1) setValue(I_C_Order.COLUMNNAME_User1_ID, null);
        else setValue(I_C_Order.COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
    }

    /**
     * Get User Element List 2.
     *
     * @return User defined list element #2
     */
    public int getUser2Id() {
        Integer ii = (Integer) getValue(I_C_Order.COLUMNNAME_User2_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set User Element List 2.
     *
     * @param User2_ID User defined list element #2
     */
    public void setUser2Id(int User2_ID) {
        if (User2_ID < 1) setValue(I_C_Order.COLUMNNAME_User2_ID, null);
        else setValue(I_C_Order.COLUMNNAME_User2_ID, Integer.valueOf(User2_ID));
    }

    /**
     * Set Volume.
     *
     * @param Volume Volume of a product
     */
    public void setVolume(BigDecimal Volume) {
        setValue(I_C_Order.COLUMNNAME_Volume, Volume);
    }

    /**
     * Set Weight.
     *
     * @param Weight Weight of a product
     */
    public void setWeight(BigDecimal Weight) {
        setValue(I_C_Order.COLUMNNAME_Weight, Weight);
    }

    @Override
    public int getTableId() {
        return I_C_Order.Table_ID;
    }
}
