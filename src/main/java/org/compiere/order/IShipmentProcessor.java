package org.compiere.order;

import java.util.Properties;

/**
 * @author Low Heng Sin
 */
public interface IShipmentProcessor {
    boolean processShipment(
            Properties ctx, MShippingTransaction shippingTransaction);

    boolean rateInquiry(
            Properties ctx,
            MShippingTransaction shippingTransaction,
            boolean isPriviledgedRate,
            String trxName);

    boolean voidShipment(
            Properties ctx, MShippingTransaction shippingTransaction, String get_TrxName);
}
