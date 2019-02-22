package org.compiere.order;

import java.util.Properties;

/**
 * @author Low Heng Sin
 */
public interface IShipmentProcessor {
    public boolean processShipment(
            Properties ctx, MShippingTransaction shippingTransaction);

    public boolean rateInquiry(
            Properties ctx,
            MShippingTransaction shippingTransaction,
            boolean isPriviledgedRate,
            String trxName);

    public boolean voidShipment(
            Properties ctx, MShippingTransaction shippingTransaction, String get_TrxName);
}
