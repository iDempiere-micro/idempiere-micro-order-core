package org.compiere.order;

import org.compiere.model.I_M_ShipperPickupTypes;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_ShipperPickupTypes
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShipperPickupTypes extends BasePOName
    implements I_M_ShipperPickupTypes, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ShipperPickupTypes(Properties ctx, int M_ShipperPickupTypes_ID, String trxName) {
    super(ctx, M_ShipperPickupTypes_ID, trxName);
  }

  /** Load Constructor */
  public X_M_ShipperPickupTypes(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_ShipperPickupTypes[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Set Default.
   *
   * @param IsDefault Default value
   */
  public void setIsDefault(boolean IsDefault) {
    set_Value(COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
  }

  /**
   * Get Default.
   *
   * @return Default value
   */
  public boolean isDefault() {
    Object oo = get_Value(COLUMNNAME_IsDefault);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  public org.compiere.model.I_M_Shipper getM_Shipper() throws RuntimeException {
    return (org.compiere.model.I_M_Shipper)
        MTable.get(getCtx(), org.compiere.model.I_M_Shipper.Table_Name)
            .getPO(getM_Shipper_ID(), get_TrxName());
  }

  /**
   * Set Shipper.
   *
   * @param M_Shipper_ID Method or manner of product delivery
   */
  public void setM_Shipper_ID(int M_Shipper_ID) {
    if (M_Shipper_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Shipper_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Shipper_ID, Integer.valueOf(M_Shipper_ID));
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

  public org.compiere.model.I_M_ShipperPickupTypesCfg getM_ShipperPickupTypesCfg()
      throws RuntimeException {
    return (org.compiere.model.I_M_ShipperPickupTypesCfg)
        MTable.get(getCtx(), org.compiere.model.I_M_ShipperPickupTypesCfg.Table_Name)
            .getPO(getM_ShipperPickupTypesCfg_ID(), get_TrxName());
  }

  /**
   * Set Shipper Pickup Types Configuration.
   *
   * @param M_ShipperPickupTypesCfg_ID Shipper Pickup Types Configuration
   */
  public void setM_ShipperPickupTypesCfg_ID(int M_ShipperPickupTypesCfg_ID) {
    if (M_ShipperPickupTypesCfg_ID < 1) set_Value(COLUMNNAME_M_ShipperPickupTypesCfg_ID, null);
    else
      set_Value(COLUMNNAME_M_ShipperPickupTypesCfg_ID, Integer.valueOf(M_ShipperPickupTypesCfg_ID));
  }

  /**
   * Get Shipper Pickup Types Configuration.
   *
   * @return Shipper Pickup Types Configuration
   */
  public int getM_ShipperPickupTypesCfg_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperPickupTypesCfg_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipper Pickup Types.
   *
   * @param M_ShipperPickupTypes_ID Shipper Pickup Types
   */
  public void setM_ShipperPickupTypes_ID(int M_ShipperPickupTypes_ID) {
    if (M_ShipperPickupTypes_ID < 1) set_ValueNoCheck(COLUMNNAME_M_ShipperPickupTypes_ID, null);
    else
      set_ValueNoCheck(
          COLUMNNAME_M_ShipperPickupTypes_ID, Integer.valueOf(M_ShipperPickupTypes_ID));
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
   * Set M_ShipperPickupTypes_UU.
   *
   * @param M_ShipperPickupTypes_UU M_ShipperPickupTypes_UU
   */
  public void setM_ShipperPickupTypes_UU(String M_ShipperPickupTypes_UU) {
    set_Value(COLUMNNAME_M_ShipperPickupTypes_UU, M_ShipperPickupTypes_UU);
  }

  /**
   * Get M_ShipperPickupTypes_UU.
   *
   * @return M_ShipperPickupTypes_UU
   */
  public String getM_ShipperPickupTypes_UU() {
    return (String) get_Value(COLUMNNAME_M_ShipperPickupTypes_UU);
  }

  @Override
  public int getTableId() {
    return I_M_ShipperPickupTypes.Table_ID;
  }
}
