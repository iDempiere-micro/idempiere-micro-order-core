package org.compiere.order;

import kotliquery.Row;
import org.compiere.util.Msg;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.Env;

import java.util.Properties;
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

    public MShippingTransaction(Properties ctx, int M_ShippingTransaction_ID) {
        super(ctx, M_ShippingTransaction_ID);
    }

    public MShippingTransaction(Properties ctx, Row row) {
        super(ctx, row);
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
            if (processor == null) setErrorMessage(Msg.getMsg(Env.getCtx(), "ShippingNoProcessor"));
            else {
                if (getAction().equals(ACTION_ProcessShipment))
                    processed = processor.processShipment(getCtx(), this);
                else if (getAction().equals(ACTION_RateInquiry))
                    processed = processor.rateInquiry(getCtx(), this, isPriviledgedRate(), null);
                else if (getAction().equals(ACTION_VoidShipment))
                    processed = processor.voidShipment(getCtx(), this, null);
                else throw new AdempiereException(Msg.getMsg(Env.getCtx(), "ActionNotSupported"));

                if (!processed)
                    setErrorMessage("From " + getMShipper().getName() + ": " + getShippingRespMessage());
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "processOnline", e);
            setErrorMessage(Msg.getMsg(Env.getCtx(), "ShippingNotProcessed") + ":\n" + e.getMessage());
        }

        MOnlineTrxHistory history = new MOnlineTrxHistory(getCtx(), 0);
        history.setRowTableId(Table_ID);
        history.setRecordId(getShippingTransactionId());
        history.setIsError(!processed);
        history.setProcessed(processed);

        StringBuilder msg = new StringBuilder();
        if (processed) msg.append(getShippingRespMessage());
        else msg.append("ERROR: " + getErrorMessage());
        msg.append("\nAction: " + getAction());
        history.setTextMsg(msg.toString());

        history.saveEx();

        setProcessed(processed);
        return processed;
    }

    public MShipper getMShipper() {
        return new MShipper(getCtx(), getShipperId());
    }

    public boolean isPayBySender() {
        // Payment Type must be SENDER or THIRD_PARTY when COD is requested
        if (FREIGHTCHARGES_Prepaid.equals(getFreightCharges())
                || FREIGHTCHARGES_PrepaidAndBill.equals(getFreightCharges())) return true;
        else return !FREIGHTCHARGES_3rdParty.equals(getFreightCharges()) && isCashOnDelivery();
    }

    public X_M_CommodityShipment getCommodityShipment(int M_Product_ID) {
        return MBaseShippingTransactionKt.getCommodityShipment(getCtx(), M_Product_ID, getClientId(), getOrgId());
    }

    public void setADClientID(int AD_Client_ID) {
        super.setADClientID(AD_Client_ID);
    }

}
