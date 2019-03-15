package org.compiere.order;

import kotliquery.Row;

import java.util.Properties;

/**
 * @author Elaine
 */
public class MOnlineTrxHistory extends X_C_OnlineTrxHistory {

    /**
     *
     */
    private static final long serialVersionUID = 2160888813932490117L;

    public MOnlineTrxHistory(Properties ctx, int C_OnlineTrxHistory_ID) {
        super(ctx, C_OnlineTrxHistory_ID);
    }

    public MOnlineTrxHistory(Properties ctx, Row row) {
        super(ctx, row);
    }
}
