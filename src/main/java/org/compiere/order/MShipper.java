package org.compiere.order;

import org.compiere.model.I_M_Shipper;
import org.compiere.orm.Query;
import org.idempiere.common.util.Env;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

/**
 * Shipper Model
 *
 * @author Jorg Janke
 * @version $Id: MShipper.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MShipper extends X_M_Shipper {
  /** */
  private static final long serialVersionUID = -4026295839866634739L;

  /**
   * Standard Constructor
   *
   * @param ctx context
   * @param M_Shipper_ID id
   * @param trxName transaction
   */
  public MShipper(Properties ctx, int M_Shipper_ID, String trxName) {
    super(ctx, M_Shipper_ID, trxName);
  } //	MShipper

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MShipper(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MShipper

  /**
   * @param ctx
   * @param FreightCategory_ID
   * @param trxName
   * @return A list of shippers having the given freight category
   */
  public static List<MShipper> getShippersForFreightCategory(
      Properties ctx, int FreightCategory_ID, String trxName) {
    Query q =
        new Query(
            ctx,
            I_M_Shipper.Table_Name,
            "M_Shipper.AD_Client_ID=? AND M_Shipper.AD_Org_ID IN (0,?) AND M_Shipper_ID "
                + "IN (SELECT M_Shipper_ID FROM M_Freight WHERE M_FreightCategory_ID=?)",
            trxName);
    q.setParameters(Env.getClientId(ctx), Env.getOrgId(ctx), FreightCategory_ID);
    List<MShipper> result = q.list();
    return (result);
  }

  public String getShippingServiceCode() {
    return getM_ShipperCfg().getShippingServiceCode();
  }

  public boolean isInternational() {
    return getM_ShipperCfg().isInternational();
  }

  public boolean isResidential() {
    return getM_ShipperCfg().isResidential();
  }

  public boolean isSaturdayDelivery() {
    return getM_ShipperCfg().isSaturdayDelivery();
  }

  public String getTrackingURL() {
    return getM_ShipperCfg().getTrackingURL();
  }
} //	MShipper
