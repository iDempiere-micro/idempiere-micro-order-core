package org.compiere.order;

import org.compiere.model.I_M_ShipperPickupTypes;
import org.compiere.orm.BasePOName;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_ShipperPickupTypes
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShipperPickupTypes extends BasePOName
        implements I_M_ShipperPickupTypes {

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
     * Get Shipper Pickup Types Configuration.
     *
     * @return Shipper Pickup Types Configuration
     */
    public int getM_ShipperPickupTypesCfg_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_ShipperPickupTypesCfg_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_ShipperPickupTypes.Table_ID;
    }
}
