package org.compiere.order;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_Shipper;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_Shipper
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Shipper extends BasePOName implements I_M_Shipper, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_Shipper(Properties ctx, int M_Shipper_ID, String trxName) {
    super(ctx, M_Shipper_ID, trxName);
  }

  /** Load Constructor */
  public X_M_Shipper(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_Shipper[").append(getId()).append("]");
    return sb.toString();
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

  /**
   * Get Create lines from.
   *
   * @return Process which will generate a new document lines based on an existing document
   */
  public String getCreateFrom() {
    return (String) get_Value(COLUMNNAME_CreateFrom);
  }

  /**
   * Set Create lines from.
   *
   * @param CreateFrom Process which will generate a new document lines based on an existing
   *     document
   */
  public void setCreateFrom(String CreateFrom) {
    set_Value(COLUMNNAME_CreateFrom, CreateFrom);
  }

  public org.compiere.model.I_M_ShipperCfg getM_ShipperCfg() throws RuntimeException {
    return (org.compiere.model.I_M_ShipperCfg)
        MTable.get(getCtx(), org.compiere.model.I_M_ShipperCfg.Table_Name)
            .getPO(getM_ShipperCfg_ID(), null);
  }

  /**
   * Get Shipper Configuration.
   *
   * @return Shipper Configuration
   */
  public int getM_ShipperCfg_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperCfg_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipper Configuration.
   *
   * @param M_ShipperCfg_ID Shipper Configuration
   */
  public void setM_ShipperCfg_ID(int M_ShipperCfg_ID) {
    if (M_ShipperCfg_ID < 1) set_Value(COLUMNNAME_M_ShipperCfg_ID, null);
    else set_Value(COLUMNNAME_M_ShipperCfg_ID, Integer.valueOf(M_ShipperCfg_ID));
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
    if (M_Shipper_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Shipper_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Shipper_ID, Integer.valueOf(M_Shipper_ID));
  }

  /**
   * Get M_Shipper_UU.
   *
   * @return M_Shipper_UU
   */
  public String getM_Shipper_UU() {
    return (String) get_Value(COLUMNNAME_M_Shipper_UU);
  }

  /**
   * Set M_Shipper_UU.
   *
   * @param M_Shipper_UU M_Shipper_UU
   */
  public void setM_Shipper_UU(String M_Shipper_UU) {
    set_Value(COLUMNNAME_M_Shipper_UU, M_Shipper_UU);
  }

  public org.compiere.model.I_M_ShippingProcessor getM_ShippingProcessor() throws RuntimeException {
    return (org.compiere.model.I_M_ShippingProcessor)
        MTable.get(getCtx(), org.compiere.model.I_M_ShippingProcessor.Table_Name)
            .getPO(getM_ShippingProcessor_ID(), null);
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
    if (M_ShippingProcessor_ID < 1) set_Value(COLUMNNAME_M_ShippingProcessor_ID, null);
    else set_Value(COLUMNNAME_M_ShippingProcessor_ID, Integer.valueOf(M_ShippingProcessor_ID));
  }

  @Override
  public int getTableId() {
    return I_M_Shipper.Table_ID;
  }
}
