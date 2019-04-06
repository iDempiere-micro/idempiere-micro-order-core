package org.compiere.order;

import kotliquery.Row;

public class MShipperPackaging extends X_M_ShipperPackaging {

    /**
     *
     */
    private static final long serialVersionUID = 6403993556547324865L;

    public MShipperPackaging(int M_ShipperPackaging_ID) {
        super(M_ShipperPackaging_ID);
    }

    public MShipperPackaging(Row row) {
        super(row);
    }

}
