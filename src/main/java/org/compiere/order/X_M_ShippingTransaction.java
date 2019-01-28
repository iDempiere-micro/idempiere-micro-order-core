package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_M_ShippingTransaction;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_ShippingTransaction
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShippingTransaction extends PO implements I_M_ShippingTransaction, I_Persistent {

    /** Rate Inquiry = RI */
  public static final String ACTION_RateInquiry = "RI";
  /** Void Shipment = VS */
  public static final String ACTION_VoidShipment = "VS";
  /** Process Shipment = PS */
  public static final String ACTION_ProcessShipment = "PS";
    /** Collect = A_Col */
  public static final String FREIGHTCHARGES_Collect = "A_Col";
  /** 3rd Party = B_3P */
  public static final String FREIGHTCHARGES_3rdParty = "B_3P";
    /** Prepaid = D_PP */
  public static final String FREIGHTCHARGES_Prepaid = "D_PP";
  /** Prepaid and Bill = E_PPB */
  public static final String FREIGHTCHARGES_PrepaidAndBill = "E_PPB";
    /** */
  private static final long serialVersionUID = 20171031L;
  /** Standard Constructor */
  public X_M_ShippingTransaction(Properties ctx, int M_ShippingTransaction_ID, String trxName) {
    super(ctx, M_ShippingTransaction_ID, trxName);
    /**
     * if (M_ShippingTransaction_ID == 0) { setAction (null); setCashOnDelivery (false); // N
     * setDeliveryConfirmation (false); // N setIsAccessible (false); // N setIsAddedHandling
     * (false); // N setIsAlternateReturnAddress (false); // N setIsCargoAircraftOnly (false); // N
     * setIsDryIce (false); // N setIsDutiable (false); // N setIsFutureDayShipment (false); // N
     * setIsHazMat (false); // N setIsHoldAtLocation (false); // N setIsIgnoreZipNotFound (false);
     * // N setIsIgnoreZipStateNotMatch (false); // N setIsPriviledgedRate (false); // N
     * setIsResidential (true); // Y setIsSaturdayDelivery (false); // N setIsSaturdayPickup
     * (false); // N setIsVerbalConfirmation (false); // N setM_Shipper_ID (0);
     * setM_ShippingTransaction_ID (0); setProcessed (false); // N }
     */
  }
  /** Load Constructor */
  public X_M_ShippingTransaction(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
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
    return (String) get_Value(COLUMNNAME_Action);
  }

  /**
   * Set Action.
   *
   * @param Action Indicates the Action to be performed
   */
  public void setAction(String Action) {

    set_Value(COLUMNNAME_Action, Action);
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
   * Get Invoice Location.
   *
   * @return Business Partner Location for invoicing
   */
  public int getBill_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Bill_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Invoice Location.
   *
   * @param Bill_Location_ID Business Partner Location for invoicing
   */
  public void setBill_Location_ID(int Bill_Location_ID) {
    if (Bill_Location_ID < 1) set_Value(COLUMNNAME_Bill_Location_ID, null);
    else set_Value(COLUMNNAME_Bill_Location_ID, Integer.valueOf(Bill_Location_ID));
  }

    /**
   * Set Box Count.
   *
   * @param BoxCount Box Count
   */
  public void setBoxCount(int BoxCount) {
    set_Value(COLUMNNAME_BoxCount, Integer.valueOf(BoxCount));
  }

  /**
   * Get COD.
   *
   * @return COD
   */
  public boolean isCashOnDelivery() {
    Object oo = get_Value(COLUMNNAME_CashOnDelivery);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
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
   * Get Business Partner Shipping Account.
   *
   * @return Business Partner Shipping Account
   */
  public int getC_BP_ShippingAcct_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BP_ShippingAcct_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Currency.
   *
   * @return The Currency for this record
   */
  public int getC_Currency_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Currency_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Currency.
   *
   * @param C_Currency_ID The Currency for this record
   */
  public void setC_Currency_ID(int C_Currency_ID) {
    if (C_Currency_ID < 1) set_Value(COLUMNNAME_C_Currency_ID, null);
    else set_Value(COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
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
   * Set COD Amount.
   *
   * @param CODAmount COD Amount
   */
  public void setCODAmount(BigDecimal CODAmount) {
    set_Value(COLUMNNAME_CODAmount, CODAmount);
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
    if (C_Order_ID < 1) set_Value(COLUMNNAME_C_Order_ID, null);
    else set_Value(COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
  }

    /**
   * Get UOM for Length.
   *
   * @return Standard Unit of Measure for Length
   */
  public int getC_UOM_Length_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_UOM_Length_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set UOM for Length.
   *
   * @param C_UOM_Length_ID Standard Unit of Measure for Length
   */
  public void setC_UOM_Length_ID(int C_UOM_Length_ID) {
    if (C_UOM_Length_ID < 1) set_Value(COLUMNNAME_C_UOM_Length_ID, null);
    else set_Value(COLUMNNAME_C_UOM_Length_ID, Integer.valueOf(C_UOM_Length_ID));
  }

    /**
   * Get UOM for Weight.
   *
   * @return Standard Unit of Measure for Weight
   */
  public int getC_UOM_Weight_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_UOM_Weight_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set UOM for Weight.
   *
   * @param C_UOM_Weight_ID Standard Unit of Measure for Weight
   */
  public void setC_UOM_Weight_ID(int C_UOM_Weight_ID) {
    if (C_UOM_Weight_ID < 1) set_Value(COLUMNNAME_C_UOM_Weight_ID, null);
    else set_Value(COLUMNNAME_C_UOM_Weight_ID, Integer.valueOf(C_UOM_Weight_ID));
  }

    /**
   * Set Customs Value.
   *
   * @param CustomsValue Customs Value
   */
  public void setCustomsValue(BigDecimal CustomsValue) {
    set_Value(COLUMNNAME_CustomsValue, CustomsValue);
  }

    /**
   * Get Duties Shipper Account.
   *
   * @return Duties Shipper Account
   */
  public String getDutiesShipperAccount() {
    return (String) get_Value(COLUMNNAME_DutiesShipperAccount);
  }

  /**
   * Set Duties Shipper Account.
   *
   * @param DutiesShipperAccount Duties Shipper Account
   */
  public void setDutiesShipperAccount(String DutiesShipperAccount) {
    set_Value(COLUMNNAME_DutiesShipperAccount, DutiesShipperAccount);
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
   * Get Freight Charges.
   *
   * @return Freight Charges
   */
  public String getFreightCharges() {
    return (String) get_Value(COLUMNNAME_FreightCharges);
  }

  /**
   * Set Freight Charges.
   *
   * @param FreightCharges Freight Charges
   */
  public void setFreightCharges(String FreightCharges) {

    set_ValueNoCheck(COLUMNNAME_FreightCharges, FreightCharges);
  }

    /**
   * Get Hold Address.
   *
   * @return Hold Address
   */
  public int getHoldAddress_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_HoldAddress_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Set Priviledged Rate.
   *
   * @param IsPriviledgedRate Priviledged Rate
   */
  public void setIsPriviledgedRate(boolean IsPriviledgedRate) {
    set_Value(COLUMNNAME_IsPriviledgedRate, Boolean.valueOf(IsPriviledgedRate));
  }

  /**
   * Get Priviledged Rate.
   *
   * @return Priviledged Rate
   */
  public boolean isPriviledgedRate() {
    Object oo = get_Value(COLUMNNAME_IsPriviledgedRate);
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
    set_Value(COLUMNNAME_IsResidential, Boolean.valueOf(IsResidential));
  }

    /**
   * Set Saturday Delivery.
   *
   * @param IsSaturdayDelivery Saturday Delivery
   */
  public void setIsSaturdayDelivery(boolean IsSaturdayDelivery) {
    set_Value(COLUMNNAME_IsSaturdayDelivery, Boolean.valueOf(IsSaturdayDelivery));
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
   * Get Package.
   *
   * @return Shipment Package
   */
  public int getM_Package_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Package_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Shipper Labels.
   *
   * @return Shipper Labels
   */
  public int getM_ShipperLabels_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperLabels_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipper Labels.
   *
   * @param M_ShipperLabels_ID Shipper Labels
   */
  public void setM_ShipperLabels_ID(int M_ShipperLabels_ID) {
    if (M_ShipperLabels_ID < 1) set_Value(COLUMNNAME_M_ShipperLabels_ID, null);
    else set_Value(COLUMNNAME_M_ShipperLabels_ID, Integer.valueOf(M_ShipperLabels_ID));
  }

    /**
   * Get Shipper Packaging.
   *
   * @return Shipper Packaging
   */
  public int getM_ShipperPackaging_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperPackaging_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipper Packaging.
   *
   * @param M_ShipperPackaging_ID Shipper Packaging
   */
  public void setM_ShipperPackaging_ID(int M_ShipperPackaging_ID) {
    if (M_ShipperPackaging_ID < 1) set_Value(COLUMNNAME_M_ShipperPackaging_ID, null);
    else set_Value(COLUMNNAME_M_ShipperPackaging_ID, Integer.valueOf(M_ShipperPackaging_ID));
  }

    /**
   * Get Shipper Pickup Types.
   *
   * @return Shipper Pickup Types
   */
  public int getM_ShipperPickupTypes_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperPickupTypes_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipper Pickup Types.
   *
   * @param M_ShipperPickupTypes_ID Shipper Pickup Types
   */
  public void setM_ShipperPickupTypes_ID(int M_ShipperPickupTypes_ID) {
    if (M_ShipperPickupTypes_ID < 1) set_Value(COLUMNNAME_M_ShipperPickupTypes_ID, null);
    else set_Value(COLUMNNAME_M_ShipperPickupTypes_ID, Integer.valueOf(M_ShipperPickupTypes_ID));
  }

    /**
   * Get Shipping Processor.
   *
   * @return Shipping Processor
   */
  public int getM_ShippingProcessor_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShippingProcessor_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipping Processor.
   *
   * @param M_ShippingProcessor_ID Shipping Processor
   */
  public void setM_ShippingProcessor_ID(int M_ShippingProcessor_ID) {
    if (M_ShippingProcessor_ID < 1) set_ValueNoCheck(COLUMNNAME_M_ShippingProcessor_ID, null);
    else
      set_ValueNoCheck(COLUMNNAME_M_ShippingProcessor_ID, Integer.valueOf(M_ShippingProcessor_ID));
  }

  /**
   * Get Shipping Transaction.
   *
   * @return Shipping Transaction
   */
  public int getM_ShippingTransaction_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShippingTransaction_ID);
    if (ii == null) return 0;
    return ii;
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
    if (M_Warehouse_ID < 1) set_Value(COLUMNNAME_M_Warehouse_ID, null);
    else set_Value(COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
  }

    /**
   * Set Payment Rule.
   *
   * @param PaymentRule How you pay the invoice
   */
  public void setPaymentRule(String PaymentRule) {

    set_Value(COLUMNNAME_PaymentRule, PaymentRule);
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
   * Get Price.
   *
   * @return Price
   */
  public BigDecimal getPrice() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_Price);
    if (bd == null) return Env.ZERO;
    return bd;
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
   * Set Ship Date.
   *
   * @param ShipDate Shipment Date/Time
   */
  public void setShipDate(Timestamp ShipDate) {
    set_Value(COLUMNNAME_ShipDate, ShipDate);
  }

  /**
   * Get Shipper Account Number.
   *
   * @return Shipper Account Number
   */
  public String getShipperAccount() {
    return (String) get_Value(COLUMNNAME_ShipperAccount);
  }

  /**
   * Set Shipper Account Number.
   *
   * @param ShipperAccount Shipper Account Number
   */
  public void setShipperAccount(String ShipperAccount) {
    set_Value(COLUMNNAME_ShipperAccount, ShipperAccount);
  }

  /**
   * Get Response Message.
   *
   * @return Response Message
   */
  public String getShippingRespMessage() {
    return (String) get_Value(COLUMNNAME_ShippingRespMessage);
  }

    /**
   * Set Tracking Info.
   *
   * @param TrackingInfo Tracking Info
   */
  public void setTrackingInfo(String TrackingInfo) {
    set_Value(COLUMNNAME_TrackingInfo, TrackingInfo);
  }

    /**
   * Set Weight.
   *
   * @param Weight Weight of a product
   */
  public void setWeight(BigDecimal Weight) {
    set_Value(COLUMNNAME_Weight, Weight);
  }

    @Override
  public int getTableId() {
    return I_M_ShippingTransaction.Table_ID;
  }
}
