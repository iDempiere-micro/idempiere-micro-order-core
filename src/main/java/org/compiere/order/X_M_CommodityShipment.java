package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_CommodityShipment;
import org.compiere.orm.PO;

import java.util.Properties;

/**
 * Generated Model for M_CommodityShipment
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_CommodityShipment extends PO implements I_M_CommodityShipment {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_CommodityShipment(Properties ctx, int M_CommodityShipment_ID) {
        super(ctx, M_CommodityShipment_ID);
        /**
         * if (M_CommodityShipment_ID == 0) { setCountryOfManufacture_ID (0); setHarmonizedCode (null);
         * setCommodityShipment_ID (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_CommodityShipment(Properties ctx, Row row) {
        super(ctx, row);
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
        StringBuffer sb = new StringBuffer("X_M_CommodityShipment[").append(getId()).append("]");
        return sb.toString();
    }

    @Override
    public int getTableId() {
        return I_M_CommodityShipment.Table_ID;
    }
}
