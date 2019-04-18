package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_Shipper;
import org.compiere.model.I_M_ShipperCfg;
import org.compiere.orm.BasePOName;
import software.hsharp.core.orm.MBaseTableKt;

/**
 * Generated Model for M_Shipper
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Shipper extends BasePOName implements I_M_Shipper {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_Shipper(int M_Shipper_ID) {
        super(M_Shipper_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_Shipper(Row row) {
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
        return "X_M_Shipper[" + getId() + "]";
    }

    /**
     * Get Business Partner .
     *
     * @return Identifies a Business Partner
     */
    public int getBusinessPartnerId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_BPartner_ID);
        if (ii == null) return 0;
        return ii;
    }

    public I_M_ShipperCfg getShipperCfg() throws RuntimeException {
        return (I_M_ShipperCfg)
                MBaseTableKt.getTable(I_M_ShipperCfg.Table_Name)
                        .getPO(getShipperCfgId());
    }

    /**
     * Get Shipper Configuration.
     *
     * @return Shipper Configuration
     */
    public int getShipperCfgId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_ShipperCfg_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Shipper.
     *
     * @return Method or manner of product delivery
     */
    public int getShipperId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Shipper_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Shipping Processor.
     *
     * @return Shipping Processor
     */
    public int getShippingProcessorId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_ShippingProcessor_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_Shipper.Table_ID;
    }
}
