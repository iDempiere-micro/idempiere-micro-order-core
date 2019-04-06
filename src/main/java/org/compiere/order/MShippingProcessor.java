package org.compiere.order;

import kotliquery.Row;

public class MShippingProcessor extends X_M_ShippingProcessor {

    /**
     *
     */
    private static final long serialVersionUID = -7635817773750467895L;

    public MShippingProcessor(int M_ShippingProcessor_ID) {
        super(M_ShippingProcessor_ID);
    }

    public MShippingProcessor(Row row) {
        super(row);
    }

    public String getShippingProcessorClass() {
        return getShippingProcessorCfg().getShippingProcessorClass();
    }

    public String getHostAddress() {
        return getShippingProcessorCfg().getHostAddress();
    }

    public int getHostPort() {
        return getShippingProcessorCfg().getHostPort();
    }

    public String getProxyAddress() {
        return getShippingProcessorCfg().getProxyAddress();
    }

    public int getProxyPort() {
        return getShippingProcessorCfg().getProxyPort();
    }

    public String getProxyLogon() {
        return getShippingProcessorCfg().getProxyLogon();
    }

    public String getProxyPassword() {
        return getShippingProcessorCfg().getProxyPassword();
    }

    public String getServicePath() {
        return getShippingProcessorCfg().getServicePath();
    }
}
