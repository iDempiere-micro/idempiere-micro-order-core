package org.compiere.order;

import java.sql.ResultSet;
import java.util.Properties;

public class MShipperPickupTypes extends X_M_ShipperPickupTypes {

  /** */
  private static final long serialVersionUID = 2836350317204286835L;

  public MShipperPickupTypes(Properties ctx, int M_ShipperPickupTypes_ID) {
    super(ctx, M_ShipperPickupTypes_ID);
  }

  public MShipperPickupTypes(Properties ctx, ResultSet rs) {
    super(ctx, rs);
  }

}
