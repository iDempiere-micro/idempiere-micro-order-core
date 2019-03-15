package org.compiere.order;

import kotliquery.Row;

import java.util.Properties;

public class MShippingTransactionLine extends X_M_ShippingTransactionLine {

    /**
     *
     */
    private static final long serialVersionUID = -8148869412130244360L;

    public MShippingTransactionLine(
            Properties ctx, int M_ShippingTransactionLine_ID) {
        super(ctx, M_ShippingTransactionLine_ID);
    }

    public MShippingTransactionLine(Properties ctx, Row row) {
        super(ctx, row);
    }

    public void setADClientID(int AD_Client_ID) {
        super.setADClientID(AD_Client_ID);
    }
}
