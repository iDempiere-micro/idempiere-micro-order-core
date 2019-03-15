package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_ShippingProcessor;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;

import java.util.Properties;

/**
 * Generated Model for M_ShippingProcessor
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShippingProcessor extends BasePOName
        implements I_M_ShippingProcessor {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ShippingProcessor(Properties ctx, int M_ShippingProcessor_ID) {
        super(ctx, M_ShippingProcessor_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_ShippingProcessor(Properties ctx, Row row) {
        super(ctx, row);
    }

    /**
     * AccessLevel
     *
     * @return 3 - Client - Org
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("X_M_ShippingProcessor[").append(getId()).append("]");
        return sb.toString();
    }

    public org.compiere.model.I_M_ShippingProcessorCfg getM_ShippingProcessorCfg()
            throws RuntimeException {
        return (org.compiere.model.I_M_ShippingProcessorCfg)
                MTable.get(getCtx(), org.compiere.model.I_M_ShippingProcessorCfg.Table_Name)
                        .getPO(getM_ShippingProcessorCfg_ID());
    }

    /**
     * Get Shipping Processor Configuration.
     *
     * @return Shipping Processor Configuration
     */
    public int getM_ShippingProcessorCfg_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_ShippingProcessorCfg_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_ShippingProcessor.Table_ID;
    }
}
