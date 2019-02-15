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

    /** Eltron = E */
  public static final String LABELPRINTMETHOD_Eltron = "E";
  /** Image = I */
  public static final String LABELPRINTMETHOD_Image = "I";
  /** Zebra = Z */
  public static final String LABELPRINTMETHOD_Zebra = "Z";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ShipperLabels(Properties ctx, int M_ShipperLabels_ID) {
    super(ctx, M_ShipperLabels_ID);
  }

  /** Load Constructor */
  public X_M_ShipperLabels(Properties ctx, ResultSet rs) {
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
    StringBuffer sb = new StringBuffer("X_M_ShipperLabels[").append(getId()).append("]");
    return sb.toString();
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
   * Get Shipper.
   *
   * @return Method or manner of product delivery
   */
  public int getM_Shipper_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Shipper_ID);
    if (ii == null) return 0;
    return ii;
  }

    public org.compiere.model.I_M_ShipperLabelsCfg getM_ShipperLabelsCfg() throws RuntimeException {
    return (org.compiere.model.I_M_ShipperLabelsCfg)
        MTable.get(getCtx(), org.compiere.model.I_M_ShipperLabelsCfg.Table_Name)
            .getPO(getM_ShipperLabelsCfg_ID());
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

    @Override
  public int getTableId() {
    return I_M_ShipperLabels.Table_ID;
  }
}
