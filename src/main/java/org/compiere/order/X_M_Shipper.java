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
  public X_M_Shipper(Properties ctx, int M_Shipper_ID) {
    super(ctx, M_Shipper_ID);
  }

  /** Load Constructor */
  public X_M_Shipper(Properties ctx, ResultSet rs) {
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
    StringBuffer sb = new StringBuffer("X_M_Shipper[").append(getId()).append("]");
    return sb.toString();
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

    public org.compiere.model.I_M_ShipperCfg getM_ShipperCfg() throws RuntimeException {
    return (org.compiere.model.I_M_ShipperCfg)
        MTable.get(getCtx(), org.compiere.model.I_M_ShipperCfg.Table_Name)
            .getPO(getM_ShipperCfg_ID());
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
   * Get Shipping Processor.
   *
   * @return Shipping Processor
   */
  public int getM_ShippingProcessor_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShippingProcessor_ID);
    if (ii == null) return 0;
    return ii;
  }

    @Override
  public int getTableId() {
    return I_M_Shipper.Table_ID;
  }
}
