package org.compiere.order;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_C_OnlineTrxHistory;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for C_OnlineTrxHistory
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_OnlineTrxHistory extends PO implements I_C_OnlineTrxHistory, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_C_OnlineTrxHistory(Properties ctx, int C_OnlineTrxHistory_ID, String trxName) {
    super(ctx, C_OnlineTrxHistory_ID, trxName);
    /**
     * if (C_OnlineTrxHistory_ID == 0) { setAD_Table_ID (0); setC_OnlineTrxHistory_ID (0);
     * setIsError (false); // N setProcessed (false); // N setRecord_ID (0); }
     */
  }

  /** Load Constructor */
  public X_C_OnlineTrxHistory(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
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

  public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException {
    return (org.compiere.model.I_AD_Table)
        MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
            .getPO(getAD_Table_ID(), get_TrxName());
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
   * Get Online Transaction History.
   *
   * @return Online Transaction History
   */
  public int getC_OnlineTrxHistory_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_OnlineTrxHistory_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Online Transaction History.
   *
   * @param C_OnlineTrxHistory_ID Online Transaction History
   */
  public void setC_OnlineTrxHistory_ID(int C_OnlineTrxHistory_ID) {
    if (C_OnlineTrxHistory_ID < 1) set_ValueNoCheck(COLUMNNAME_C_OnlineTrxHistory_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_OnlineTrxHistory_ID, Integer.valueOf(C_OnlineTrxHistory_ID));
  }

  /**
   * Get C_OnlineTrxHistory_UU.
   *
   * @return C_OnlineTrxHistory_UU
   */
  public String getC_OnlineTrxHistory_UU() {
    return (String) get_Value(COLUMNNAME_C_OnlineTrxHistory_UU);
  }

  /**
   * Set C_OnlineTrxHistory_UU.
   *
   * @param C_OnlineTrxHistory_UU C_OnlineTrxHistory_UU
   */
  public void setC_OnlineTrxHistory_UU(String C_OnlineTrxHistory_UU) {
    set_Value(COLUMNNAME_C_OnlineTrxHistory_UU, C_OnlineTrxHistory_UU);
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
   * Get Error.
   *
   * @return An Error occurred in the execution
   */
  public boolean isError() {
    Object oo = get_Value(COLUMNNAME_IsError);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Processed.
   *
   * @return The document has been processed
   */
  public boolean isProcessed() {
    Object oo = get_Value(COLUMNNAME_Processed);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
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
   * Get Record ID.
   *
   * @return Direct internal record ID
   */
  public int getRecord_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Record_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Text Message.
   *
   * @return Text Message
   */
  public String getTextMsg() {
    return (String) get_Value(COLUMNNAME_TextMsg);
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