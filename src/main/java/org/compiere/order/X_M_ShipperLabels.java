package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_ShipperLabels;
import org.compiere.orm.BasePOName;

/**
 * Generated Model for M_ShipperLabels
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShipperLabels extends BasePOName implements I_M_ShipperLabels {

    /**
     * Eltron = E
     */
    public static final String LABELPRINTMETHOD_Eltron = "E";
    /**
     * Image = I
     */
    public static final String LABELPRINTMETHOD_Image = "I";
    /**
     * Zebra = Z
     */
    public static final String LABELPRINTMETHOD_Zebra = "Z";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ShipperLabels(int M_ShipperLabels_ID) {
        super(M_ShipperLabels_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_ShipperLabels(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_ShipperLabels[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Shipper Labels Configuration.
     *
     * @return Shipper Labels Configuration
     */
    public int getShipperLabelsCfgId() {
        Integer ii = getValue(COLUMNNAME_M_ShipperLabelsCfg_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_ShipperLabels.Table_ID;
    }
}
