package org.compiere.order;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_ShipperLabels;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_ShipperLabels
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShipperLabels extends BasePOName implements I_M_ShipperLabels, I_Persistent {

  /** LabelPrintMethod AD_Reference_ID=200027 */
  public static final int LABELPRINTMETHOD_AD_Reference_ID = 200027;
  /** Eltron = E */
  public static final String LABELPRINTMETHOD_Eltron = "E";
  /** Image = I */
  public static final String LABELPRINTMETHOD_Image = "I";
  /** Zebra = Z */
  public static final String LABELPRINTMETHOD_Zebra = "Z";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ShipperLabels(Properties ctx, int M_ShipperLabels_ID, String trxName) {
    super(ctx, M_ShipperLabels_ID, trxName);
  }

  /** Load Constructor */
  public X_M_ShipperLabels(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_ShipperLabels[").append(getId()).append("]");
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

  /**
   * Get Label Print Method.
   *
   * @return Label Print Method
   */
  public String getLabelPrintMethod() {
    return (String) get_Value(COLUMNNAME_LabelPrintMethod);
  }

  /**
   * Set Label Print Method.
   *
   * @param LabelPrintMethod Label Print Method
   */
  public void setLabelPrintMethod(String LabelPrintMethod) {

    set_Value(COLUMNNAME_LabelPrintMethod, LabelPrintMethod);
  }

  public org.compiere.model.I_M_Shipper getM_Shipper() throws RuntimeException {
    return (org.compiere.model.I_M_Shipper)
        MTable.get(getCtx(), org.compiere.model.I_M_Shipper.Table_Name)
            .getPO(getM_Shipper_ID(), get_TrxName());
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

  public org.compiere.model.I_M_ShipperLabelsCfg getM_ShipperLabelsCfg() throws RuntimeException {
    return (org.compiere.model.I_M_ShipperLabelsCfg)
        MTable.get(getCtx(), org.compiere.model.I_M_ShipperLabelsCfg.Table_Name)
            .getPO(getM_ShipperLabelsCfg_ID(), get_TrxName());
  }

  /**
   * Get Shipper Labels Configuration.
   *
   * @return Shipper Labels Configuration
   */
  public int getM_ShipperLabelsCfg_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperLabelsCfg_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipper Labels Configuration.
   *
   * @param M_ShipperLabelsCfg_ID Shipper Labels Configuration
   */
  public void setM_ShipperLabelsCfg_ID(int M_ShipperLabelsCfg_ID) {
    if (M_ShipperLabelsCfg_ID < 1) set_Value(COLUMNNAME_M_ShipperLabelsCfg_ID, null);
    else set_Value(COLUMNNAME_M_ShipperLabelsCfg_ID, Integer.valueOf(M_ShipperLabelsCfg_ID));
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
    if (M_ShipperLabels_ID < 1) set_ValueNoCheck(COLUMNNAME_M_ShipperLabels_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_ShipperLabels_ID, Integer.valueOf(M_ShipperLabels_ID));
  }

  /**
   * Get M_ShipperLabels_UU.
   *
   * @return M_ShipperLabels_UU
   */
  public String getM_ShipperLabels_UU() {
    return (String) get_Value(COLUMNNAME_M_ShipperLabels_UU);
  }

  /**
   * Set M_ShipperLabels_UU.
   *
   * @param M_ShipperLabels_UU M_ShipperLabels_UU
   */
  public void setM_ShipperLabels_UU(String M_ShipperLabels_UU) {
    set_Value(COLUMNNAME_M_ShipperLabels_UU, M_ShipperLabels_UU);
  }

  @Override
  public int getTableId() {
    return I_M_ShipperLabels.Table_ID;
  }
}
