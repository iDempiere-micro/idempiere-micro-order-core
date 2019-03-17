package org.compiere.order;

import kotliquery.Row;

import java.util.Properties;

public class MShippingProcessor extends X_M_ShippingProcessor {

    /**
     *
     */
    private static final long serialVersionUID = -7635817773750467895L;

    public MShippingProcessor(Properties ctx, int M_ShippingProcessor_ID) {
        super(ctx, M_ShippingProcessor_ID);
    }

    public MShippingProcessor(Properties ctx, Row row) {
        super(ctx, row);
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
