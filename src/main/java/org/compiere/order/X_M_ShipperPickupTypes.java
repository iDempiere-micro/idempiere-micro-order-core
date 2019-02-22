package org.compiere.order;

import org.compiere.model.I_M_ShipperPickupTypes;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_ShipperPickupTypes
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShipperPickupTypes extends BasePOName
        implements I_M_ShipperPickupTypes, I_Persistent {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ShipperPickupTypes(Properties ctx, int M_ShipperPickupTypes_ID) {
        super(ctx, M_ShipperPickupTypes_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_ShipperPickupTypes(Properties ctx, ResultSet rs) {
        super(ctx, rs);
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
        StringBuffer sb = new StringBuffer("X_M_ShipperPickupTypes[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Shipper.
     *
     * @return Method or manner of product delivery
     */
    public int getM_Shipper_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_M_Shipper_ID);
        if (ii == null) return 0;
        return ii;
    }

    public org.compiere.model.I_M_ShipperPickupTypesCfg getM_ShipperPickupTypesCfg()
            throws RuntimeException {
        return (org.compiere.model.I_M_ShipperPickupTypesCfg)
                MTable.get(getCtx(), org.compiere.model.I_M_ShipperPickupTypesCfg.Table_Name)
                        .getPO(getM_ShipperPickupTypesCfg_ID());
    }

    /**
     * Get Shipper Pickup Types Configuration.
     *
     * @return Shipper Pickup Types Configuration
     */
    public int getM_ShipperPickupTypesCfg_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_M_ShipperPickupTypesCfg_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_ShipperPickupTypes.Table_ID;
    }
}
