package org.compiere.order;

import kotliquery.Row;
import org.compiere.util.Msg;
import org.idempiere.common.exceptions.AdempiereException;

import java.util.logging.Level;

public class MShippingTransaction extends X_M_ShippingTransaction {
    /**
     *
     */
    private static final long serialVersionUID = -2444841696998774096L;
    /**
     * Error Message
     */
    private String m_errorMessage = null;

    public MShippingTransaction(int M_ShippingTransaction_ID) {
        super(M_ShippingTransaction_ID);
    }

    public MShippingTransaction(Row row) {
        super(row);
    }

    public String getErrorMessage() {
        return m_errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        m_errorMessage = errorMessage;
    }

    public boolean processOnline() {
        setErrorMessage(null);

        boolean processed = false;
        try {
            MShipperFacade sf = new MShipperFacade(getMShipper());
            IShipmentProcessor processor = MShipperFacade.getShipmentProcessor(sf);
            if (processor == null) setErrorMessage(Msg.getMsg("ShippingNoProcessor"));
            else {
                switch (getAction()) {
                    case ACTION_ProcessShipment:
                        processed = processor.processShipment(this);
                        break;
                    case ACTION_RateInquiry:
                        processed = processor.rateInquiry(this, isPriviledgedRate(), null);
                        break;
                    case ACTION_VoidShipment:
                        processed = processor.voidShipment(this, null);
                        break;
                    default:
                        throw new AdempiereException(Msg.getMsg("ActionNotSupported"));
                }

                if (!processed)
                    setErrorMessage("From " + getMShipper().getName() + ": " + getShippingRespMessage());
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "processOnline", e);
            setErrorMessage(Msg.getMsg("ShippingNotProcessed") + ":\n" + e.getMessage());
        }

        MOnlineTrxHistory history = new MOnlineTrxHistory(0);
        history.setRowTableId(Table_ID);
        history.setRecordId(getShippingTransactionId());
        history.setIsError(!processed);
        history.setProcessed(processed);

        StringBuilder msg = new StringBuilder();
        if (processed) msg.append(getShippingRespMessage());
        else msg.append("ERROR: ").append(getErrorMessage());
        msg.append("\nAction: ").append(getAction());
        history.setTextMsg(msg.toString());

        history.saveEx();

        setProcessed(processed);
        return processed;
    }

    public MShipper getMShipper() {
        return new MShipper(getShipperId());
    }

    public boolean isPayBySender() {
        // Payment Type must be SENDER or THIRD_PARTY when COD is requested
        if (FREIGHTCHARGES_Prepaid.equals(getFreightCharges())
                || FREIGHTCHARGES_PrepaidAndBill.equals(getFreightCharges())) return true;
        else return !FREIGHTCHARGES_3rdParty.equals(getFreightCharges()) && isCashOnDelivery();
    }

    public X_M_CommodityShipment getCommodityShipment(int M_Product_ID) {
        return MBaseShippingTransactionKt.getCommodityShipment(M_Product_ID, getClientId(), getOrgId());
    }

    public void setADClientID(int AD_Client_ID) {
        super.setADClientID(AD_Client_ID);
    }

}
