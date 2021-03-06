package org.compiere.order;


import org.idempiere.common.util.CLogger;

import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.getSQLValueString;

/**
 * Facade for MShipper, providing accessor method for custom field
 *
 * @author Low Heng Sin
 */
public class MShipperFacade {
    private static final CLogger s_log = CLogger.getCLogger(MShipperFacade.class);
    private MShipper m_shipper;
    private MShippingProcessor m_processor;

    public MShipperFacade(MShipper shipper) {
        m_shipper = shipper;
        m_processor = getShippingProcessor();
    }

    /**
     * @param sf
     * @return shipment process instance or null if not found
     */
    public static IShipmentProcessor getShipmentProcessor(MShipperFacade sf) {
        if (s_log.isLoggable(Level.FINE)) s_log.fine("create for " + sf);
        return null;
    }

    private MShippingProcessor getShippingProcessor() {
        if (m_shipper.getShippingProcessorId() > 0)
            return new MShippingProcessor(
                    m_shipper.getShippingProcessorId());
        return null;
    }

    public String getShippingProcessorClass() {
        return m_processor.getShippingProcessorClass();
    }

    public String getShipperAccount(int AD_Org_ID) {
        StringBuilder sql = new StringBuilder();
        sql.append("Select ShipperAccount From C_BP_ShippingAcct ")
                .append("Where C_BPartner_ID = ? ")
                .append(" AND AD_Org_ID In (0, ")
                .append(AD_Org_ID)
                .append(") ")
                .append(" Order By AD_Org_ID Desc ");
        String ac = getSQLValueString(sql.toString(), m_shipper.getBusinessPartnerId());
        if (ac != null) {
            ac = ac.replaceAll("[-]", "");
            ac = ac.replaceAll(" ", "");
        }
        return ac;
    }

    public String getDutiesShipperAccount(int AD_Org_ID) {
        StringBuilder sql = new StringBuilder();
        sql.append("Select DutiesShipperAccount From C_BP_ShippingAcct ")
                .append("Where C_BPartner_ID = ? ")
                .append(" AND AD_Org_ID In (0, ")
                .append(AD_Org_ID)
                .append(") ")
                .append(" Order By AD_Org_ID Desc ");
        String ac = getSQLValueString(sql.toString(), m_shipper.getBusinessPartnerId());
        if (ac != null) {
            ac = ac.replaceAll("[-]", "");
            ac = ac.replaceAll(" ", "");
        }
        return ac;
    }

    public boolean isInternational() {
        return m_shipper.isInternational();
    }
}
