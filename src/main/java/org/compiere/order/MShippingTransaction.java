package org.compiere.order;

import org.compiere.util.Msg;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.prepareStatement;

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

    public MShippingTransaction(Properties ctx, ResultSet rs) {
        super(ctx, rs);
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
        history.setAD_Table_ID(Table_ID);
        history.setRecord_ID(getM_ShippingTransaction_ID());
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
        else if (!FREIGHTCHARGES_3rdParty.equals(getFreightCharges()) && isCashOnDelivery())
            return true;
        else return false;
    }

    public X_M_CommodityShipment getCommodityShipment(int M_Product_ID) {
        X_M_CommodityShipment commodityShipment = null;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM M_CommodityShipment ");
        sql.append("WHERE M_Product_ID IN (0, ?) OR M_Product_ID IS NULL ");
        sql.append("AND AD_Client_ID IN (0, ?) ");
        sql.append("AND AD_Org_ID IN (0, ?) ");
        sql.append("ORDER BY M_Product_ID, AD_Org_ID, AD_Client_ID");

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = prepareStatement(sql.toString());
            stmt.setInt(1, M_Product_ID);
            stmt.setInt(2, getClientId());
            stmt.setInt(3, getOrgId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                commodityShipment = new X_M_CommodityShipment(getCtx(), rs);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getLocalizedMessage(), e);
        } finally {
        }

        if (commodityShipment == null) commodityShipment = new X_M_CommodityShipment(getCtx(), 0);

        return commodityShipment;
    }

    public void setADClientID(int AD_Client_ID) {
        super.setADClientID(AD_Client_ID);
    }

}
