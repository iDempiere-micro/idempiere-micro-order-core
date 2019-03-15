package org.compiere.order;

import kotliquery.Row;

import java.util.Properties;

public class MShipperLabels extends X_M_ShipperLabels {

    /**
     *
     */
    private static final long serialVersionUID = 3903237243862044930L;

    public MShipperLabels(Properties ctx, int M_ShipperLabels_ID) {
        super(ctx, M_ShipperLabels_ID);
    }

    public MShipperLabels(Properties ctx, Row row) {
        super(ctx, row);
    }

}
