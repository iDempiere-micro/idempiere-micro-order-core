package org.compiere.order;

import org.compiere.model.I_C_OnlineTrxHistory;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for C_OnlineTrxHistory
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_OnlineTrxHistory extends PO implements I_C_OnlineTrxHistory, I_Persistent {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_C_OnlineTrxHistory(Properties ctx, int C_OnlineTrxHistory_ID) {
        super(ctx, C_OnlineTrxHistory_ID);
        /**
         * if (C_OnlineTrxHistory_ID == 0) { setAD_Table_ID (0); setC_OnlineTrxHistory_ID (0);
         * setIsError (false); // N setProcessed (false); // N setRecord_ID (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_C_OnlineTrxHistory(Properties ctx, ResultSet rs) {
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
        StringBuffer sb = new StringBuffer("X_C_OnlineTrxHistory[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Table.
     *
     * @return Database Table information
     */
    public int getAD_Table_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_AD_Table_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Table.
     *
     * @param AD_Table_ID Database Table information
     */
    public void setAD_Table_ID(int AD_Table_ID) {
        if (AD_Table_ID < 1) set_Value(COLUMNNAME_AD_Table_ID, null);
        else set_Value(COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
    }

    /**
     * Set Error.
     *
     * @param IsError An Error occurred in the execution
     */
    public void setIsError(boolean IsError) {
        set_Value(COLUMNNAME_IsError, Boolean.valueOf(IsError));
    }

    /**
     * Set Processed.
     *
     * @param Processed The document has been processed
     */
    public void setProcessed(boolean Processed) {
        set_Value(COLUMNNAME_Processed, Boolean.valueOf(Processed));
    }

    /**
     * Set Record ID.
     *
     * @param Record_ID Direct internal record ID
     */
    public void setRecord_ID(int Record_ID) {
        if (Record_ID < 0) set_Value(COLUMNNAME_Record_ID, null);
        else set_Value(COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
    }

    /**
     * Set Text Message.
     *
     * @param TextMsg Text Message
     */
    public void setTextMsg(String TextMsg) {
        set_Value(COLUMNNAME_TextMsg, TextMsg);
    }

    @Override
    public int getTableId() {
        return I_C_OnlineTrxHistory.Table_ID;
    }
}
