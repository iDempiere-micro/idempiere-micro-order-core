package org.compiere.order;

import static software.hsharp.core.util.DBKt.getSQLValue;
import static software.hsharp.core.util.DBKt.getSQLValueString;

public class ShippingUtil {
  public static String getSenderShipperAccount(int shipper_id, int org_id) {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT sa.ShipperAccount ");
    sb.append("FROM C_BP_ShippingAcct sa, M_Shipper s ");
    sb.append("WHERE s.M_Shipper_ID= ? ");
    sb.append("AND sa.IsActive = 'Y' ");
    sb.append("AND sa.C_BPartner_ID = s.C_BPartner_ID ");
    sb.append("AND sa.AD_Org_ID= ? ");
    return getSQLValueString(null, sb.toString(), shipper_id, org_id);
  }

  public static String getSenderDutiesShipperAccount(int shipper_id, int org_id) {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT sa.DutiesShipperAccount ");
    sb.append("FROM C_BP_ShippingAcct sa, M_Shipper s ");
    sb.append("WHERE s.M_Shipper_ID= ? ");
    sb.append("AND sa.IsActive = 'Y' ");
    sb.append("AND sa.C_BPartner_ID = s.C_BPartner_ID ");
    sb.append("AND sa.AD_Org_ID= ? ");
    return getSQLValueString(null, sb.toString(), shipper_id, org_id);
  }

}
