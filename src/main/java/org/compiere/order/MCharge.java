package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_Charge;
import org.idempiere.common.util.CCache;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

/**
 * Charge Model
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 * <li>FR [ 2214883 ] Remove SQL code and Replace for Query
 * @version $Id: MCharge.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MCharge extends X_C_Charge {
    /**
     *
     */
    private static final long serialVersionUID = -4628105180010713510L;
    /**
     * Static Logger
     */
    protected static CLogger s_log = CLogger.getCLogger(MCharge.class);
    /**
     * Cache
     */
    private static CCache<Integer, MCharge> s_cache =
            new CCache<Integer, MCharge>(I_C_Charge.Table_Name, 10);

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx         context
     * @param C_Charge_ID id
     * @param trxName     transaction
     */
    public MCharge(int C_Charge_ID) {
        super(C_Charge_ID);
        if (C_Charge_ID == 0) {
            setChargeAmt(Env.ZERO);
            setIsSameCurrency(false);
            setIsSameTax(false);
            setIsTaxIncluded(false); // N
            //	setName (null);
            //	setTaxCategoryId (0);
        }
    } //	MCharge

    /**
     * Load Constructor
     *
     * @param ctx     ctx
     * @param rs      result set
     * @param trxName transaction
     */
    public MCharge(Row row) {
        super(row);
    } //	MCharge

    /**
     * Get MCharge from Cache
     *
     * @param ctx         context
     * @param C_Charge_ID id
     * @return MCharge
     */
    public static MCharge get(int C_Charge_ID) {
        Integer key = new Integer(C_Charge_ID);
        MCharge retValue = s_cache.get(key);
        if (retValue != null) return retValue;
        retValue = new MCharge(C_Charge_ID);
        if (retValue.getId() != 0) s_cache.put(key, retValue);
        return retValue;
    } //	get

    /**
     * After Save
     *
     * @param newRecord new
     * @param success   success
     * @return success
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (newRecord && success) insertAccounting("C_Charge_Acct", "C_AcctSchema_Default", null);

        return success;
    } //	afterSave
} //	MCharge
