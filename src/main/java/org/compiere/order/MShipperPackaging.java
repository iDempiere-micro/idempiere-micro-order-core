package org.compiere.order;

import java.sql.ResultSet;
import java.util.Properties;

public class MShipperPackaging extends X_M_ShipperPackaging {

    /**
     *
     */
    private static final long serialVersionUID = 6403993556547324865L;

    public MShipperPackaging(Properties ctx, int M_ShipperPackaging_ID) {
        super(ctx, M_ShipperPackaging_ID);
    }

    public MShipperPackaging(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    }

}
