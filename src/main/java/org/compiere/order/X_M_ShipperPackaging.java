package org.compiere.order;

import org.compiere.model.I_M_ShipperPackaging;
import org.compiere.orm.BasePOName;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_ShipperPackaging
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShipperPackaging extends BasePOName implements I_M_ShipperPackaging {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ShipperPackaging(Properties ctx, int M_ShipperPackaging_ID) {
        super(ctx, M_ShipperPackaging_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_ShipperPackaging(Properties ctx, ResultSet rs) {
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
        StringBuffer sb = new StringBuffer("X_M_ShipperPackaging[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Shipper Packaging Configuration.
     *
     * @return Shipper Packaging Configuration
     */
    public int getM_ShipperPackagingCfg_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_ShipperPackagingCfg_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Weight.
     *
     * @return Weight of a product
     */
    public BigDecimal getWeight() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_Weight);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    @Override
    public int getTableId() {
        return I_M_ShipperPackaging.Table_ID;
    }
}
