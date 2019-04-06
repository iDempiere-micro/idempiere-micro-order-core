package org.compiere.order;

import kotliquery.Row;

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
    public MShipper(int M_Shipper_ID) {
        super(M_Shipper_ID);
    } //	MShipper

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MShipper(Row row) {
        super(row);
    } //	MShipper

    public String getShippingServiceCode() {
        return getShipperCfg().getShippingServiceCode();
    }

    public boolean isInternational() {
        return getShipperCfg().isInternational();
    }

    public boolean isResidential() {
        return getShipperCfg().isResidential();
    }

    public boolean isSaturdayDelivery() {
        return getShipperCfg().isSaturdayDelivery();
    }

    public String getTrackingURL() {
        return getShipperCfg().getTrackingURL();
    }
} //	MShipper
