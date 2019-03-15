package org.compiere.order;

import kotliquery.Row;

import java.util.Properties;

/**
 * Shipper Model
 *
 * @author Jorg Janke
 * @version $Id: MShipper.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MShipper extends X_M_Shipper {
    /**
     *
     */
    private static final long serialVersionUID = -4026295839866634739L;

    /**
     * Standard Constructor
     *
     * @param ctx          context
     * @param M_Shipper_ID id
     * @param trxName      transaction
     */
    public MShipper(Properties ctx, int M_Shipper_ID) {
        super(ctx, M_Shipper_ID);
    } //	MShipper

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MShipper(Properties ctx, Row row) {
        super(ctx, row);
    } //	MShipper

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
