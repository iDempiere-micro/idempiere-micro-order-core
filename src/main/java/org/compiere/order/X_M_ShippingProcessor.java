package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_ShippingProcessor;
import org.compiere.model.I_M_ShippingProcessorCfg;
import org.compiere.orm.BasePOName;
import software.hsharp.core.orm.MBaseTableKt;

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
    public X_M_ShippingProcessor(int M_ShippingProcessor_ID) {
        super(M_ShippingProcessor_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_ShippingProcessor(Row row) {
        super(row);
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
        return "X_M_ShippingProcessor[" + getId() + "]";
    }

    public I_M_ShippingProcessorCfg getShippingProcessorCfg()
            throws RuntimeException {
        return (I_M_ShippingProcessorCfg)
                MBaseTableKt.getTable(I_M_ShippingProcessorCfg.Table_Name)
                        .getPO(getShippingProcessorCfgId());
    }

    /**
     * Get Shipping Processor Configuration.
     *
     * @return Shipping Processor Configuration
     */
    public int getShippingProcessorCfgId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_ShippingProcessorCfg_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_ShippingProcessor.Table_ID;
    }
}
