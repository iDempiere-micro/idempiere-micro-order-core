package org.compiere.order;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_CommodityShipment;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

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
  public X_M_CommodityShipment(Properties ctx, int M_CommodityShipment_ID) {
    super(ctx, M_CommodityShipment_ID);
    /**
     * if (M_CommodityShipment_ID == 0) { setCountryOfManufacture_ID (0); setHarmonizedCode (null);
     * setM_CommodityShipment_ID (0); }
     */
  }

  /** Load Constructor */
  public X_M_CommodityShipment(Properties ctx, ResultSet rs) {
    super(ctx, rs);
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
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
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
   * Get Harmonized Code.
   *
   * @return Harmonized Code
   */
  public String getHarmonizedCode() {
    return (String) get_Value(COLUMNNAME_HarmonizedCode);
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
