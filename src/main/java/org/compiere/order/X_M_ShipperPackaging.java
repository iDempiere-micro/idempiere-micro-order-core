package org.compiere.order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_ShipperPackaging;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_ShipperPackaging
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShipperPackaging extends BasePOName implements I_M_ShipperPackaging, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ShipperPackaging(Properties ctx, int M_ShipperPackaging_ID) {
    super(ctx, M_ShipperPackaging_ID);
  }

  /** Load Constructor */
  public X_M_ShipperPackaging(Properties ctx, ResultSet rs) {
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
    StringBuffer sb = new StringBuffer("X_M_ShipperPackaging[").append(getId()).append("]");
    return sb.toString();
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

    public org.compiere.model.I_M_ShipperPackagingCfg getM_ShipperPackagingCfg()
      throws RuntimeException {
    return (org.compiere.model.I_M_ShipperPackagingCfg)
        MTable.get(getCtx(), org.compiere.model.I_M_ShipperPackagingCfg.Table_Name)
            .getPO(getM_ShipperPackagingCfg_ID());
  }

  /**
   * Get Shipper Packaging Configuration.
   *
   * @return Shipper Packaging Configuration
   */
  public int getM_ShipperPackagingCfg_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperPackagingCfg_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Weight.
   *
   * @return Weight of a product
   */
  public BigDecimal getWeight() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_Weight);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    @Override
  public int getTableId() {
    return I_M_ShipperPackaging.Table_ID;
  }
}
