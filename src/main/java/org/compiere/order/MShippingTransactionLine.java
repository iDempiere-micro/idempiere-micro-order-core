package org.compiere.order;

import kotliquery.Row;

public class MShippingTransactionLine extends X_M_ShippingTransactionLine {

    /**
     *
     */
    private static final long serialVersionUID = -8148869412130244360L;

    public MShippingTransactionLine(
            int M_ShippingTransactionLine_ID) {
        super(M_ShippingTransactionLine_ID);
    }

    public MShippingTransactionLine(Row row) {
        super(row);
    }

    public void setADClientID(int AD_Client_ID) {
        super.setADClientID(AD_Client_ID);
    }
}
