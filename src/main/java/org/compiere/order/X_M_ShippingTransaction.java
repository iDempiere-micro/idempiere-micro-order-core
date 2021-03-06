package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_ShippingTransaction;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Generated Model for M_ShippingTransaction
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShippingTransaction extends PO implements I_M_ShippingTransaction {

    /**
     * Rate Inquiry = RI
     */
    public static final String ACTION_RateInquiry = "RI";
    /**
     * Void Shipment = VS
     */
    public static final String ACTION_VoidShipment = "VS";
    /**
     * Process Shipment = PS
     */
    public static final String ACTION_ProcessShipment = "PS";
    /**
     * Collect = A_Col
     */
    public static final String FREIGHTCHARGES_Collect = "A_Col";
    /**
     * 3rd Party = B_3P
     */
    public static final String FREIGHTCHARGES_3rdParty = "B_3P";
    /**
     * Prepaid = D_PP
     */
    public static final String FREIGHTCHARGES_Prepaid = "D_PP";
    /**
     * Prepaid and Bill = E_PPB
     */
    public static final String FREIGHTCHARGES_PrepaidAndBill = "E_PPB";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ShippingTransaction(int M_ShippingTransaction_ID) {
        super(M_ShippingTransaction_ID);
        /**
         * if (M_ShippingTransaction_ID == 0) { setAction (null); setCashOnDelivery (false); // N
         * setDeliveryConfirmation (false); // N setIsAccessible (false); // N setIsAddedHandling
         * (false); // N setIsAlternateReturnAddress (false); // N setIsCargoAircraftOnly (false); // N
         * setIsDryIce (false); // N setIsDutiable (false); // N setIsFutureDayShipment (false); // N
         * setIsHazMat (false); // N setIsHoldAtLocation (false); // N setIsIgnoreZipNotFound (false);
         * // N setIsIgnoreZipStateNotMatch (false); // N setIsPriviledgedRate (false); // N
         * setIsResidential (true); // Y setIsSaturdayDelivery (false); // N setIsSaturdayPickup
         * (false); // N setIsVerbalConfirmation (false); // N setShipperId (0);
         * setShippingTransactionId (0); setProcessed (false); // N }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_ShippingTransaction(Row row) {
        super(row);
    }

    /**
     * AccessLevel
     *
     * @return 3 - Client - Org
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("X_M_ShippingTransaction[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Action.
     *
     * @return Indicates the Action to be performed
     */
    public String getAction() {
        return getValue(COLUMNNAME_Action);
    }

    /**
     * Set Action.
     *
     * @param Action Indicates the Action to be performed
     */
    public void setAction(String Action) {

        setValue(COLUMNNAME_Action, Action);
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
     * Set Invoice Location.
     *
     * @param Bill_Location_ID Business Partner Location for invoicing
     */
    public void setBusinessPartnerInvoicingLocationId(int Bill_Location_ID) {
        if (Bill_Location_ID < 1) setValue(COLUMNNAME_Bill_Location_ID, null);
        else setValue(COLUMNNAME_Bill_Location_ID, Integer.valueOf(Bill_Location_ID));
    }

    /**
     * Set Box Count.
     *
     * @param BoxCount Box Count
     */
    public void setBoxCount(int BoxCount) {
        setValue(COLUMNNAME_BoxCount, Integer.valueOf(BoxCount));
    }

    /**
     * Get COD.
     *
     * @return COD
     */
    public boolean isCashOnDelivery() {
        Object oo = getValue(COLUMNNAME_CashOnDelivery);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
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
     * Set Partner Location.
     *
     * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
     */
    public void setBusinessPartnerLocationId(int C_BPartner_Location_ID) {
        if (C_BPartner_Location_ID < 1) setValue(COLUMNNAME_C_BPartner_Location_ID, null);
        else setValue(COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
    }

    /**
     * Set Currency.
     *
     * @param C_Currency_ID The Currency for this record
     */
    public void setCurrencyId(int C_Currency_ID) {
        if (C_Currency_ID < 1) setValue(COLUMNNAME_C_Currency_ID, null);
        else setValue(COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
    }

    /**
     * Set COD Amount.
     *
     * @param CODAmount COD Amount
     */
    public void setCODAmount(BigDecimal CODAmount) {
        setValue(COLUMNNAME_CODAmount, CODAmount);
    }

    /**
     * Set Order.
     *
     * @param C_Order_ID Order
     */
    public void setOrderId(int C_Order_ID) {
        if (C_Order_ID < 1) setValue(COLUMNNAME_C_Order_ID, null);
        else setValue(COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
    }

    /**
     * Set UOM for Length.
     *
     * @param C_UOM_Length_ID Standard Unit of Measure for Length
     */
    public void setUOMLengthId(int C_UOM_Length_ID) {
        if (C_UOM_Length_ID < 1) setValue(COLUMNNAME_C_UOM_Length_ID, null);
        else setValue(COLUMNNAME_C_UOM_Length_ID, Integer.valueOf(C_UOM_Length_ID));
    }

    /**
     * Set UOM for Weight.
     *
     * @param C_UOM_Weight_ID Standard Unit of Measure for Weight
     */
    public void setUOMWeightId(int C_UOM_Weight_ID) {
        if (C_UOM_Weight_ID < 1) setValue(COLUMNNAME_C_UOM_Weight_ID, null);
        else setValue(COLUMNNAME_C_UOM_Weight_ID, Integer.valueOf(C_UOM_Weight_ID));
    }

    /**
     * Set Customs Value.
     *
     * @param CustomsValue Customs Value
     */
    public void setCustomsValue(BigDecimal CustomsValue) {
        setValue(COLUMNNAME_CustomsValue, CustomsValue);
    }

    /**
     * Set Duties Shipper Account.
     *
     * @param DutiesShipperAccount Duties Shipper Account
     */
    public void setDutiesShipperAccount(String DutiesShipperAccount) {
        setValue(COLUMNNAME_DutiesShipperAccount, DutiesShipperAccount);
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
     * Get Freight Charges.
     *
     * @return Freight Charges
     */
    public String getFreightCharges() {
        return getValue(COLUMNNAME_FreightCharges);
    }

    /**
     * Set Freight Charges.
     *
     * @param FreightCharges Freight Charges
     */
    public void setFreightCharges(String FreightCharges) {

        setValueNoCheck(COLUMNNAME_FreightCharges, FreightCharges);
    }

    /**
     * Set Priviledged Rate.
     *
     * @param IsPriviledgedRate Priviledged Rate
     */
    public void setIsPriviledgedRate(boolean IsPriviledgedRate) {
        setValue(COLUMNNAME_IsPriviledgedRate, Boolean.valueOf(IsPriviledgedRate));
    }

    /**
     * Get Priviledged Rate.
     *
     * @return Priviledged Rate
     */
    public boolean isPriviledgedRate() {
        Object oo = getValue(COLUMNNAME_IsPriviledgedRate);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Residential.
     *
     * @param IsResidential Residential
     */
    public void setIsResidential(boolean IsResidential) {
        setValue(COLUMNNAME_IsResidential, Boolean.valueOf(IsResidential));
    }

    /**
     * Set Saturday Delivery.
     *
     * @param IsSaturdayDelivery Saturday Delivery
     */
    public void setIsSaturdayDelivery(boolean IsSaturdayDelivery) {
        setValue(COLUMNNAME_IsSaturdayDelivery, Boolean.valueOf(IsSaturdayDelivery));
    }

    /**
     * Get Shipper.
     *
     * @return Method or manner of product delivery
     */
    public int getShipperId() {
        Integer ii = getValue(COLUMNNAME_M_Shipper_ID);
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
        else setValue(COLUMNNAME_M_Shipper_ID, Integer.valueOf(M_Shipper_ID));
    }

    /**
     * Set Shipper Labels.
     *
     * @param M_ShipperLabels_ID Shipper Labels
     */
    public void setShipperLabelsId(int M_ShipperLabels_ID) {
        if (M_ShipperLabels_ID < 1) setValue(COLUMNNAME_M_ShipperLabels_ID, null);
        else setValue(COLUMNNAME_M_ShipperLabels_ID, Integer.valueOf(M_ShipperLabels_ID));
    }

    /**
     * Set Shipper Packaging.
     *
     * @param M_ShipperPackaging_ID Shipper Packaging
     */
    public void setShipperPackagingId(int M_ShipperPackaging_ID) {
        if (M_ShipperPackaging_ID < 1) setValue(COLUMNNAME_M_ShipperPackaging_ID, null);
        else setValue(COLUMNNAME_M_ShipperPackaging_ID, Integer.valueOf(M_ShipperPackaging_ID));
    }

    /**
     * Set Shipper Pickup Types.
     *
     * @param M_ShipperPickupTypes_ID Shipper Pickup Types
     */
    public void setShipperPickupTypesId(int M_ShipperPickupTypes_ID) {
        if (M_ShipperPickupTypes_ID < 1) setValue(COLUMNNAME_M_ShipperPickupTypes_ID, null);
        else setValue(COLUMNNAME_M_ShipperPickupTypes_ID, Integer.valueOf(M_ShipperPickupTypes_ID));
    }

    /**
     * Set Shipping Processor.
     *
     * @param M_ShippingProcessor_ID Shipping Processor
     */
    public void setShippingProcessorId(int M_ShippingProcessor_ID) {
        if (M_ShippingProcessor_ID < 1) setValueNoCheck(COLUMNNAME_M_ShippingProcessor_ID, null);
        else
            setValueNoCheck(COLUMNNAME_M_ShippingProcessor_ID, Integer.valueOf(M_ShippingProcessor_ID));
    }

    /**
     * Get Shipping Transaction.
     *
     * @return Shipping Transaction
     */
    public int getShippingTransactionId() {
        Integer ii = getValue(COLUMNNAME_M_ShippingTransaction_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Warehouse.
     *
     * @param M_Warehouse_ID Storage Warehouse and Service Point
     */
    public void setWarehouseId(int M_Warehouse_ID) {
        if (M_Warehouse_ID < 1) setValue(COLUMNNAME_M_Warehouse_ID, null);
        else setValue(COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
    }

    /**
     * Set Payment Rule.
     *
     * @param PaymentRule How you pay the invoice
     */
    public void setPaymentRule(String PaymentRule) {

        setValue(COLUMNNAME_PaymentRule, PaymentRule);
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
     * Get Price.
     *
     * @return Price
     */
    public BigDecimal getPrice() {
        BigDecimal bd = getValue(COLUMNNAME_Price);
        if (bd == null) return Env.ZERO;
        return bd;
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
     * Set Sales Representative.
     *
     * @param SalesRep_ID Sales Representative or Company Agent
     */
    public void setSalesRepresentativeId(int SalesRep_ID) {
        if (SalesRep_ID < 1) setValue(COLUMNNAME_SalesRep_ID, null);
        else setValue(COLUMNNAME_SalesRep_ID, SalesRep_ID);
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
     * Set Shipper Account Number.
     *
     * @param ShipperAccount Shipper Account Number
     */
    public void setShipperAccount(String ShipperAccount) {
        setValue(COLUMNNAME_ShipperAccount, ShipperAccount);
    }

    /**
     * Get Response Message.
     *
     * @return Response Message
     */
    public String getShippingRespMessage() {
        return getValue(COLUMNNAME_ShippingRespMessage);
    }

    /**
     * Set Tracking Info.
     *
     * @param TrackingInfo Tracking Info
     */
    public void setTrackingInfo(String TrackingInfo) {
        setValue(COLUMNNAME_TrackingInfo, TrackingInfo);
    }

    /**
     * Set Weight.
     *
     * @param Weight Weight of a product
     */
    public void setWeight(BigDecimal Weight) {
        setValue(COLUMNNAME_Weight, Weight);
    }

    @Override
    public int getTableId() {
        return I_M_ShippingTransaction.Table_ID;
    }
}
