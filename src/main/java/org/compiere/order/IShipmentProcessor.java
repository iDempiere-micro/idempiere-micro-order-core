package org.compiere.order;

/**
 * @author Low Heng Sin
 */
public interface IShipmentProcessor {
    boolean processShipment(
            MShippingTransaction shippingTransaction);

    boolean rateInquiry(

            MShippingTransaction shippingTransaction,
            boolean isPriviledgedRate,
            String trxName);

    boolean voidShipment(
            MShippingTransaction shippingTransaction, String get_TrxName);
}
