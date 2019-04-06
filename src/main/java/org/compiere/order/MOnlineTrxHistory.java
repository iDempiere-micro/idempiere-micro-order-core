package org.compiere.order;

import kotliquery.Row;

/**
 * @author Elaine
 */
public class MOnlineTrxHistory extends X_C_OnlineTrxHistory {

    /**
     *
     */
    private static final long serialVersionUID = 2160888813932490117L;

    public MOnlineTrxHistory(int C_OnlineTrxHistory_ID) {
        super(C_OnlineTrxHistory_ID);
    }

    public MOnlineTrxHistory(Row row) {
        super(row);
    }
}
