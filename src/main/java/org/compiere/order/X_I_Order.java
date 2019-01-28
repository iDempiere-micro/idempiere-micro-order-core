package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_I_Order;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for I_Order
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_I_Order extends BasePOName implements I_I_Order, I_Persistent {

    /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_I_Order(Properties ctx, int I_Order_ID, String trxName) {
    super(ctx, I_Order_ID, trxName);
  }

  /** Load Constructor */
  public X_I_Order(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 2 - Client
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_I_Order[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Address 1.
   *
   * @return Address line 1 for this location
   */
  public String getAddress1() {
    return (String) get_Value(COLUMNNAME_Address1);
  }

    /**
   * Get Address 2.
   *
   * @return Address line 2 for this location
   */
  public String getAddress2() {
    return (String) get_Value(COLUMNNAME_Address2);
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
   * Get Invoice To.
   *
   * @return Bill to Address
   */
  public int getBillTo_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_BillTo_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Invoice To.
   *
   * @param BillTo_ID Bill to Address
   */
  public void setBillTo_ID(int BillTo_ID) {
    if (BillTo_ID < 1) set_Value(COLUMNNAME_BillTo_ID, null);
    else set_Value(COLUMNNAME_BillTo_ID, Integer.valueOf(BillTo_ID));
  }

  /**
   * Get Business Partner Key.
   *
   * @return Key of the Business Partner
   */
  public String getBPartnerValue() {
    return (String) get_Value(COLUMNNAME_BPartnerValue);
  }

  /**
   * Set Business Partner Key.
   *
   * @param BPartnerValue Key of the Business Partner
   */
  public void setBPartnerValue(String BPartnerValue) {
    set_Value(COLUMNNAME_BPartnerValue, BPartnerValue);
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
   * Get Country.
   *
   * @return Country
   */
  public int getC_Country_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Country_ID);
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
   * Get City.
   *
   * @return Identifies a City
   */
  public String getCity() {
    return (String) get_Value(COLUMNNAME_City);
  }

    /**
   * Get Address.
   *
   * @return Location or Address
   */
  public int getC_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Address.
   *
   * @param C_Location_ID Location or Address
   */
  public void setC_Location_ID(int C_Location_ID) {
    if (C_Location_ID < 1) set_Value(COLUMNNAME_C_Location_ID, null);
    else set_Value(COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
  }

  /**
   * Get Contact Name.
   *
   * @return Business Partner Contact Name
   */
  public String getContactName() {
    return (String) get_Value(COLUMNNAME_ContactName);
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
   * Get Sales Order Line.
   *
   * @return Sales Order Line
   */
  public int getC_OrderLine_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_OrderLine_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Sales Order Line.
   *
   * @param C_OrderLine_ID Sales Order Line
   */
  public void setC_OrderLine_ID(int C_OrderLine_ID) {
    if (C_OrderLine_ID < 1) set_Value(COLUMNNAME_C_OrderLine_ID, null);
    else set_Value(COLUMNNAME_C_OrderLine_ID, Integer.valueOf(C_OrderLine_ID));
  }

  public org.compiere.model.I_C_OrderSource getC_OrderSource() throws RuntimeException {
    return (org.compiere.model.I_C_OrderSource)
        MTable.get(getCtx(), org.compiere.model.I_C_OrderSource.Table_Name)
            .getPO(getC_OrderSource_ID(), null);
  }

  /**
   * Get Order Source.
   *
   * @return Order Source
   */
  public int getC_OrderSource_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_OrderSource_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Payment Term.
   *
   * @return The terms of Payment (timing, discount)
   */
  public int getC_PaymentTerm_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_PaymentTerm_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Region.
   *
   * @return Identifies a geographical Region
   */
  public int getC_Region_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Region_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Tax.
   *
   * @return Tax identifier
   */
  public int getC_Tax_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Tax_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Tax.
   *
   * @param C_Tax_ID Tax identifier
   */
  public void setC_Tax_ID(int C_Tax_ID) {
    if (C_Tax_ID < 1) set_Value(COLUMNNAME_C_Tax_ID, null);
    else set_Value(COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
  }

    /**
   * Get UOM.
   *
   * @return Unit of Measure
   */
  public int getC_UOM_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_UOM_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Date Ordered.
   *
   * @return Date of Order
   */
  public Timestamp getDateOrdered() {
    return (Timestamp) get_Value(COLUMNNAME_DateOrdered);
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
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
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
   * Get EMail Address.
   *
   * @return Electronic Mail Address
   */
  public String getEMail() {
    return (String) get_Value(COLUMNNAME_EMail);
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
   * Set Imported.
   *
   * @param I_IsImported Has this import been processed
   */
  public void setI_IsImported(boolean I_IsImported) {
    set_Value(COLUMNNAME_I_IsImported, Boolean.valueOf(I_IsImported));
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
   * Get Line Description.
   *
   * @return Description of the Line
   */
  public String getLineDescription() {
    return (String) get_Value(COLUMNNAME_LineDescription);
  }

    /**
   * Get Price List.
   *
   * @return Unique identifier of a Price List
   */
  public int getM_PriceList_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_PriceList_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Product.
   *
   * @return Product, Service, Item
   */
  public int getM_Product_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_ID);
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
   * Get Phone.
   *
   * @return Identifies a telephone number
   */
  public String getPhone() {
    return (String) get_Value(COLUMNNAME_Phone);
  }

    /**
   * Get ZIP.
   *
   * @return Postal code
   */
  public String getPostal() {
    return (String) get_Value(COLUMNNAME_Postal);
  }

    /**
   * Get Unit Price.
   *
   * @return Actual Price
   */
  public BigDecimal getPriceActual() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PriceActual);
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
   * Get Ordered Quantity.
   *
   * @return Ordered Quantity
   */
  public BigDecimal getQtyOrdered() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_QtyOrdered);
    if (bd == null) return Env.ZERO;
    return bd;
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

    @Override
  public int getTableId() {
    return I_I_Order.Table_ID;
  }
}
