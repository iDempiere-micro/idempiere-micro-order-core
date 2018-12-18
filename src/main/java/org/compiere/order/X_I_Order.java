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

  /** DeliveryRule AD_Reference_ID=151 */
  public static final int DELIVERYRULE_AD_Reference_ID = 151;
  /** After Receipt = R */
  public static final String DELIVERYRULE_AfterReceipt = "R";
  /** Availability = A */
  public static final String DELIVERYRULE_Availability = "A";
  /** Complete Line = L */
  public static final String DELIVERYRULE_CompleteLine = "L";
  /** Complete Order = O */
  public static final String DELIVERYRULE_CompleteOrder = "O";
  /** Force = F */
  public static final String DELIVERYRULE_Force = "F";
  /** Manual = M */
  public static final String DELIVERYRULE_Manual = "M";
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
   * Set Address 1.
   *
   * @param Address1 Address line 1 for this location
   */
  public void setAddress1(String Address1) {
    set_Value(COLUMNNAME_Address1, Address1);
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
   * Set Address 2.
   *
   * @param Address2 Address line 2 for this location
   */
  public void setAddress2(String Address2) {
    set_Value(COLUMNNAME_Address2, Address2);
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

  public org.compiere.model.I_AD_User getAD_User() throws RuntimeException {
    return (org.compiere.model.I_AD_User)
        MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
            .getPO(getAD_User_ID(), null);
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

  public org.compiere.model.I_C_BPartner_Location getBillTo() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner_Location)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner_Location.Table_Name)
            .getPO(getBillTo_ID(), null);
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

  public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException {
    return (org.compiere.model.I_C_Activity)
        MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
            .getPO(getC_Activity_ID(), null);
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

  public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getC_BPartner_ID(), null);
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

  public org.compiere.model.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner_Location)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner_Location.Table_Name)
            .getPO(getC_BPartner_Location_ID(), null);
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

  public org.compiere.model.I_C_Campaign getC_Campaign() throws RuntimeException {
    return (org.compiere.model.I_C_Campaign)
        MTable.get(getCtx(), org.compiere.model.I_C_Campaign.Table_Name)
            .getPO(getC_Campaign_ID(), null);
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

  public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException {
    return (org.compiere.model.I_C_Charge)
        MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
            .getPO(getC_Charge_ID(), null);
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
    else set_Value(COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
  }

  public org.compiere.model.I_C_Country getC_Country() throws RuntimeException {
    return (org.compiere.model.I_C_Country)
        MTable.get(getCtx(), org.compiere.model.I_C_Country.Table_Name)
            .getPO(getC_Country_ID(), null);
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
   * Set Country.
   *
   * @param C_Country_ID Country
   */
  public void setC_Country_ID(int C_Country_ID) {
    if (C_Country_ID < 1) set_Value(COLUMNNAME_C_Country_ID, null);
    else set_Value(COLUMNNAME_C_Country_ID, Integer.valueOf(C_Country_ID));
  }

  public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException {
    return (org.compiere.model.I_C_Currency)
        MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
            .getPO(getC_Currency_ID(), null);
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

  public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException {
    return (org.compiere.model.I_C_DocType)
        MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
            .getPO(getC_DocType_ID(), null);
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
    if (C_DocType_ID < 0) set_Value(COLUMNNAME_C_DocType_ID, null);
    else set_Value(COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
  }

  /**
   * Get Charge Name.
   *
   * @return Name of the Charge
   */
  public String getChargeName() {
    return (String) get_Value(COLUMNNAME_ChargeName);
  }

  /**
   * Set Charge Name.
   *
   * @param ChargeName Name of the Charge
   */
  public void setChargeName(String ChargeName) {
    set_Value(COLUMNNAME_ChargeName, ChargeName);
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
   * Set City.
   *
   * @param City Identifies a City
   */
  public void setCity(String City) {
    set_Value(COLUMNNAME_City, City);
  }

  public org.compiere.model.I_C_Location getC_Location() throws RuntimeException {
    return (org.compiere.model.I_C_Location)
        MTable.get(getCtx(), org.compiere.model.I_C_Location.Table_Name)
            .getPO(getC_Location_ID(), null);
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
   * Set Contact Name.
   *
   * @param ContactName Business Partner Contact Name
   */
  public void setContactName(String ContactName) {
    set_Value(COLUMNNAME_ContactName, ContactName);
  }

  public org.compiere.model.I_C_Order getC_Order() throws RuntimeException {
    return (org.compiere.model.I_C_Order)
        MTable.get(getCtx(), org.compiere.model.I_C_Order.Table_Name)
            .getPO(getC_Order_ID(), null);
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

  public org.compiere.model.I_C_OrderLine getC_OrderLine() throws RuntimeException {
    return (org.compiere.model.I_C_OrderLine)
        MTable.get(getCtx(), org.compiere.model.I_C_OrderLine.Table_Name)
            .getPO(getC_OrderLine_ID(), null);
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
   * Set Order Source.
   *
   * @param C_OrderSource_ID Order Source
   */
  public void setC_OrderSource_ID(int C_OrderSource_ID) {
    if (C_OrderSource_ID < 1) set_Value(COLUMNNAME_C_OrderSource_ID, null);
    else set_Value(COLUMNNAME_C_OrderSource_ID, Integer.valueOf(C_OrderSource_ID));
  }

  /**
   * Get Order Source Key.
   *
   * @return Order Source Key
   */
  public String getC_OrderSourceValue() {
    return (String) get_Value(COLUMNNAME_C_OrderSourceValue);
  }

  /**
   * Set Order Source Key.
   *
   * @param C_OrderSourceValue Order Source Key
   */
  public void setC_OrderSourceValue(String C_OrderSourceValue) {
    set_Value(COLUMNNAME_C_OrderSourceValue, C_OrderSourceValue);
  }

  /**
   * Get ISO Country Code.
   *
   * @return Upper-case two-letter alphanumeric ISO Country code according to ISO 3166-1 -
   *     http://www.chemie.fu-berlin.de/diverse/doc/ISO_3166.html
   */
  public String getCountryCode() {
    return (String) get_Value(COLUMNNAME_CountryCode);
  }

  /**
   * Set ISO Country Code.
   *
   * @param CountryCode Upper-case two-letter alphanumeric ISO Country code according to ISO 3166-1
   *     - http://www.chemie.fu-berlin.de/diverse/doc/ISO_3166.html
   */
  public void setCountryCode(String CountryCode) {
    set_Value(COLUMNNAME_CountryCode, CountryCode);
  }

  public org.compiere.model.I_C_PaymentTerm getC_PaymentTerm() throws RuntimeException {
    return (org.compiere.model.I_C_PaymentTerm)
        MTable.get(getCtx(), org.compiere.model.I_C_PaymentTerm.Table_Name)
            .getPO(getC_PaymentTerm_ID(), null);
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
   * Set Payment Term.
   *
   * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
   */
  public void setC_PaymentTerm_ID(int C_PaymentTerm_ID) {
    if (C_PaymentTerm_ID < 1) set_Value(COLUMNNAME_C_PaymentTerm_ID, null);
    else set_Value(COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
  }

  public org.compiere.model.I_C_Project getC_Project() throws RuntimeException {
    return (org.compiere.model.I_C_Project)
        MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
            .getPO(getC_Project_ID(), null);
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

  public org.compiere.model.I_C_Region getC_Region() throws RuntimeException {
    return (org.compiere.model.I_C_Region)
        MTable.get(getCtx(), org.compiere.model.I_C_Region.Table_Name)
            .getPO(getC_Region_ID(), null);
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
   * Set Region.
   *
   * @param C_Region_ID Identifies a geographical Region
   */
  public void setC_Region_ID(int C_Region_ID) {
    if (C_Region_ID < 1) set_Value(COLUMNNAME_C_Region_ID, null);
    else set_Value(COLUMNNAME_C_Region_ID, Integer.valueOf(C_Region_ID));
  }

  public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException {
    return (org.compiere.model.I_C_Tax)
        MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
            .getPO(getC_Tax_ID(), null);
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

  public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException {
    return (org.compiere.model.I_C_UOM)
        MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
            .getPO(getC_UOM_ID(), null);
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
   * Set UOM.
   *
   * @param C_UOM_ID Unit of Measure
   */
  public void setC_UOM_ID(int C_UOM_ID) {
    if (C_UOM_ID < 1) set_Value(COLUMNNAME_C_UOM_ID, null);
    else set_Value(COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
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
    set_Value(COLUMNNAME_DateOrdered, DateOrdered);
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
   * Get Document Type Name.
   *
   * @return Name of the Document Type
   */
  public String getDocTypeName() {
    return (String) get_Value(COLUMNNAME_DocTypeName);
  }

  /**
   * Set Document Type Name.
   *
   * @param DocTypeName Name of the Document Type
   */
  public void setDocTypeName(String DocTypeName) {
    set_Value(COLUMNNAME_DocTypeName, DocTypeName);
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
   * Get EMail Address.
   *
   * @return Electronic Mail Address
   */
  public String getEMail() {
    return (String) get_Value(COLUMNNAME_EMail);
  }

  /**
   * Set EMail Address.
   *
   * @param EMail Electronic Mail Address
   */
  public void setEMail(String EMail) {
    set_Value(COLUMNNAME_EMail, EMail);
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
   * Get Import Error Message.
   *
   * @return Messages generated from import process
   */
  public String getI_ErrorMsg() {
    return (String) get_Value(COLUMNNAME_I_ErrorMsg);
  }

  /**
   * Set Import Error Message.
   *
   * @param I_ErrorMsg Messages generated from import process
   */
  public void setI_ErrorMsg(String I_ErrorMsg) {
    set_Value(COLUMNNAME_I_ErrorMsg, I_ErrorMsg);
  }

  /**
   * Get Imported.
   *
   * @return Has this import been processed
   */
  public boolean isI_IsImported() {
    Object oo = get_Value(COLUMNNAME_I_IsImported);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
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
   * Get Import Order.
   *
   * @return Import Orders
   */
  public int getI_Order_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_I_Order_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Import Order.
   *
   * @param I_Order_ID Import Orders
   */
  public void setI_Order_ID(int I_Order_ID) {
    if (I_Order_ID < 1) set_ValueNoCheck(COLUMNNAME_I_Order_ID, null);
    else set_ValueNoCheck(COLUMNNAME_I_Order_ID, Integer.valueOf(I_Order_ID));
  }

  /**
   * Get I_Order_UU.
   *
   * @return I_Order_UU
   */
  public String getI_Order_UU() {
    return (String) get_Value(COLUMNNAME_I_Order_UU);
  }

  /**
   * Set I_Order_UU.
   *
   * @param I_Order_UU I_Order_UU
   */
  public void setI_Order_UU(String I_Order_UU) {
    set_Value(COLUMNNAME_I_Order_UU, I_Order_UU);
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
   * Get Line Description.
   *
   * @return Description of the Line
   */
  public String getLineDescription() {
    return (String) get_Value(COLUMNNAME_LineDescription);
  }

  /**
   * Set Line Description.
   *
   * @param LineDescription Description of the Line
   */
  public void setLineDescription(String LineDescription) {
    set_Value(COLUMNNAME_LineDescription, LineDescription);
  }

  public org.compiere.model.I_M_PriceList getM_PriceList() throws RuntimeException {
    return (org.compiere.model.I_M_PriceList)
        MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
            .getPO(getM_PriceList_ID(), null);
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
   * Set Price List.
   *
   * @param M_PriceList_ID Unique identifier of a Price List
   */
  public void setM_PriceList_ID(int M_PriceList_ID) {
    if (M_PriceList_ID < 1) set_Value(COLUMNNAME_M_PriceList_ID, null);
    else set_Value(COLUMNNAME_M_PriceList_ID, Integer.valueOf(M_PriceList_ID));
  }

  public org.compiere.model.I_M_Product getM_Product() throws RuntimeException {
    return (org.compiere.model.I_M_Product)
        MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
            .getPO(getM_Product_ID(), null);
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
   * Set Product.
   *
   * @param M_Product_ID Product, Service, Item
   */
  public void setM_Product_ID(int M_Product_ID) {
    if (M_Product_ID < 1) set_Value(COLUMNNAME_M_Product_ID, null);
    else set_Value(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
  }

  public org.compiere.model.I_M_Shipper getM_Shipper() throws RuntimeException {
    return (org.compiere.model.I_M_Shipper)
        MTable.get(getCtx(), org.compiere.model.I_M_Shipper.Table_Name)
            .getPO(getM_Shipper_ID(), null);
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

  public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException {
    return (org.compiere.model.I_M_Warehouse)
        MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
            .getPO(getM_Warehouse_ID(), null);
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
   * Get Payment Term Key.
   *
   * @return Key of the Payment Term
   */
  public String getPaymentTermValue() {
    return (String) get_Value(COLUMNNAME_PaymentTermValue);
  }

  /**
   * Set Payment Term Key.
   *
   * @param PaymentTermValue Key of the Payment Term
   */
  public void setPaymentTermValue(String PaymentTermValue) {
    set_Value(COLUMNNAME_PaymentTermValue, PaymentTermValue);
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
   * Set Phone.
   *
   * @param Phone Identifies a telephone number
   */
  public void setPhone(String Phone) {
    set_Value(COLUMNNAME_Phone, Phone);
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
   * Set ZIP.
   *
   * @param Postal Postal code
   */
  public void setPostal(String Postal) {
    set_Value(COLUMNNAME_Postal, Postal);
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
   * Set Unit Price.
   *
   * @param PriceActual Actual Price
   */
  public void setPriceActual(BigDecimal PriceActual) {
    set_Value(COLUMNNAME_PriceActual, PriceActual);
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

  /**
   * Get Product Key.
   *
   * @return Key of the Product
   */
  public String getProductValue() {
    return (String) get_Value(COLUMNNAME_ProductValue);
  }

  /**
   * Set Product Key.
   *
   * @param ProductValue Key of the Product
   */
  public void setProductValue(String ProductValue) {
    set_Value(COLUMNNAME_ProductValue, ProductValue);
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
   * Set Ordered Quantity.
   *
   * @param QtyOrdered Ordered Quantity
   */
  public void setQtyOrdered(BigDecimal QtyOrdered) {
    set_Value(COLUMNNAME_QtyOrdered, QtyOrdered);
  }

  /**
   * Get Region.
   *
   * @return Name of the Region
   */
  public String getRegionName() {
    return (String) get_Value(COLUMNNAME_RegionName);
  }

  /**
   * Set Region.
   *
   * @param RegionName Name of the Region
   */
  public void setRegionName(String RegionName) {
    set_Value(COLUMNNAME_RegionName, RegionName);
  }

  public org.compiere.model.I_AD_User getSalesRep() throws RuntimeException {
    return (org.compiere.model.I_AD_User)
        MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
            .getPO(getSalesRep_ID(), null);
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
   * Get SKU.
   *
   * @return Stock Keeping Unit
   */
  public String getSKU() {
    return (String) get_Value(COLUMNNAME_SKU);
  }

  /**
   * Set SKU.
   *
   * @param SKU Stock Keeping Unit
   */
  public void setSKU(String SKU) {
    set_Value(COLUMNNAME_SKU, SKU);
  }

  /**
   * Get Tax Amount.
   *
   * @return Tax Amount for a document
   */
  public BigDecimal getTaxAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_TaxAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Tax Amount.
   *
   * @param TaxAmt Tax Amount for a document
   */
  public void setTaxAmt(BigDecimal TaxAmt) {
    set_Value(COLUMNNAME_TaxAmt, TaxAmt);
  }

  /**
   * Get Tax Indicator.
   *
   * @return Short form for Tax to be printed on documents
   */
  public String getTaxIndicator() {
    return (String) get_Value(COLUMNNAME_TaxIndicator);
  }

  /**
   * Set Tax Indicator.
   *
   * @param TaxIndicator Short form for Tax to be printed on documents
   */
  public void setTaxIndicator(String TaxIndicator) {
    set_Value(COLUMNNAME_TaxIndicator, TaxIndicator);
  }

  /**
   * Get UPC/EAN.
   *
   * @return Bar Code (Universal Product Code or its superset European Article Number)
   */
  public String getUPC() {
    return (String) get_Value(COLUMNNAME_UPC);
  }

  /**
   * Set UPC/EAN.
   *
   * @param UPC Bar Code (Universal Product Code or its superset European Article Number)
   */
  public void setUPC(String UPC) {
    set_Value(COLUMNNAME_UPC, UPC);
  }

  @Override
  public int getTableId() {
    return I_I_Order.Table_ID;
  }
}
