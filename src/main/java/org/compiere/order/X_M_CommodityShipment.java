package org.compiere.order;

import org.compiere.model.I_M_CommodityShipment;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_CommodityShipment
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_CommodityShipment extends PO implements I_M_CommodityShipment, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_CommodityShipment(Properties ctx, int M_CommodityShipment_ID, String trxName) {
    super(ctx, M_CommodityShipment_ID, trxName);
    /**
     * if (M_CommodityShipment_ID == 0) { setCountryOfManufacture_ID (0); setHarmonizedCode (null);
     * setM_CommodityShipment_ID (0); }
     */
  }

  /** Load Constructor */
  public X_M_CommodityShipment(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_CommodityShipment[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Set Country Of Manufacture.
   *
   * @param CountryOfManufacture_ID Country Of Manufacture
   */
  public void setCountryOfManufacture_ID(int CountryOfManufacture_ID) {
    if (CountryOfManufacture_ID < 1) set_Value(COLUMNNAME_CountryOfManufacture_ID, null);
    else set_Value(COLUMNNAME_CountryOfManufacture_ID, Integer.valueOf(CountryOfManufacture_ID));
  }

  /**
   * Get Country Of Manufacture.
   *
   * @return Country Of Manufacture
   */
  public int getCountryOfManufacture_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_CountryOfManufacture_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
  }

  /**
   * Set Export License Number.
   *
   * @param ExportLicenseNum Export License Number
   */
  public void setExportLicenseNum(String ExportLicenseNum) {
    set_Value(COLUMNNAME_ExportLicenseNum, ExportLicenseNum);
  }

  /**
   * Get Export License Number.
   *
   * @return Export License Number
   */
  public String getExportLicenseNum() {
    return (String) get_Value(COLUMNNAME_ExportLicenseNum);
  }

  /**
   * Set Harmonized Code.
   *
   * @param HarmonizedCode Harmonized Code
   */
  public void setHarmonizedCode(String HarmonizedCode) {
    set_Value(COLUMNNAME_HarmonizedCode, HarmonizedCode);
  }

  /**
   * Get Harmonized Code.
   *
   * @return Harmonized Code
   */
  public String getHarmonizedCode() {
    return (String) get_Value(COLUMNNAME_HarmonizedCode);
  }

  /**
   * Set Commodity Shipment.
   *
   * @param M_CommodityShipment_ID Commodity Shipment
   */
  public void setM_CommodityShipment_ID(int M_CommodityShipment_ID) {
    if (M_CommodityShipment_ID < 1) set_ValueNoCheck(COLUMNNAME_M_CommodityShipment_ID, null);
    else
      set_ValueNoCheck(COLUMNNAME_M_CommodityShipment_ID, Integer.valueOf(M_CommodityShipment_ID));
  }

  /**
   * Get Commodity Shipment.
   *
   * @return Commodity Shipment
   */
  public int getM_CommodityShipment_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_CommodityShipment_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set M_CommodityShipment_UU.
   *
   * @param M_CommodityShipment_UU M_CommodityShipment_UU
   */
  public void setM_CommodityShipment_UU(String M_CommodityShipment_UU) {
    set_Value(COLUMNNAME_M_CommodityShipment_UU, M_CommodityShipment_UU);
  }

  /**
   * Get M_CommodityShipment_UU.
   *
   * @return M_CommodityShipment_UU
   */
  public String getM_CommodityShipment_UU() {
    return (String) get_Value(COLUMNNAME_M_CommodityShipment_UU);
  }

  public org.compiere.model.I_M_Product getM_Product() throws RuntimeException {
    return (org.compiere.model.I_M_Product)
        MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
            .getPO(getM_Product_ID(), get_TrxName());
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

  @Override
  public int getTableId() {
    return I_M_CommodityShipment.Table_ID;
  }
}
