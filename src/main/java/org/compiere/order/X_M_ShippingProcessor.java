package org.compiere.order;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_ShippingProcessor;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_ShippingProcessor
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ShippingProcessor extends BasePOName
    implements I_M_ShippingProcessor, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ShippingProcessor(Properties ctx, int M_ShippingProcessor_ID, String trxName) {
    super(ctx, M_ShippingProcessor_ID, trxName);
  }

  /** Load Constructor */
  public X_M_ShippingProcessor(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_ShippingProcessor[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Connection Key.
   *
   * @return Connection Key
   */
  public String getConnectionKey() {
    return (String) get_Value(COLUMNNAME_ConnectionKey);
  }

  /**
   * Set Connection Key.
   *
   * @param ConnectionKey Connection Key
   */
  public void setConnectionKey(String ConnectionKey) {
    set_Value(COLUMNNAME_ConnectionKey, ConnectionKey);
  }

  /**
   * Get Connection Password.
   *
   * @return Connection Password
   */
  public String getConnectionPassword() {
    return (String) get_Value(COLUMNNAME_ConnectionPassword);
  }

  /**
   * Set Connection Password.
   *
   * @param ConnectionPassword Connection Password
   */
  public void setConnectionPassword(String ConnectionPassword) {
    set_Value(COLUMNNAME_ConnectionPassword, ConnectionPassword);
  }

  public org.compiere.model.I_M_ShippingProcessorCfg getM_ShippingProcessorCfg()
      throws RuntimeException {
    return (org.compiere.model.I_M_ShippingProcessorCfg)
        MTable.get(getCtx(), org.compiere.model.I_M_ShippingProcessorCfg.Table_Name)
            .getPO(getM_ShippingProcessorCfg_ID(), get_TrxName());
  }

  /**
   * Get Shipping Processor Configuration.
   *
   * @return Shipping Processor Configuration
   */
  public int getM_ShippingProcessorCfg_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShippingProcessorCfg_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipping Processor Configuration.
   *
   * @param M_ShippingProcessorCfg_ID Shipping Processor Configuration
   */
  public void setM_ShippingProcessorCfg_ID(int M_ShippingProcessorCfg_ID) {
    if (M_ShippingProcessorCfg_ID < 1) set_Value(COLUMNNAME_M_ShippingProcessorCfg_ID, null);
    else
      set_Value(COLUMNNAME_M_ShippingProcessorCfg_ID, Integer.valueOf(M_ShippingProcessorCfg_ID));
  }

  /**
   * Get Shipping Processor.
   *
   * @return Shipping Processor
   */
  public int getM_ShippingProcessor_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ShippingProcessor_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipping Processor.
   *
   * @param M_ShippingProcessor_ID Shipping Processor
   */
  public void setM_ShippingProcessor_ID(int M_ShippingProcessor_ID) {
    if (M_ShippingProcessor_ID < 1) set_ValueNoCheck(COLUMNNAME_M_ShippingProcessor_ID, null);
    else
      set_ValueNoCheck(COLUMNNAME_M_ShippingProcessor_ID, Integer.valueOf(M_ShippingProcessor_ID));
  }

  /**
   * Get M_ShippingProcessor_UU.
   *
   * @return M_ShippingProcessor_UU
   */
  public String getM_ShippingProcessor_UU() {
    return (String) get_Value(COLUMNNAME_M_ShippingProcessor_UU);
  }

  /**
   * Set M_ShippingProcessor_UU.
   *
   * @param M_ShippingProcessor_UU M_ShippingProcessor_UU
   */
  public void setM_ShippingProcessor_UU(String M_ShippingProcessor_UU) {
    set_Value(COLUMNNAME_M_ShippingProcessor_UU, M_ShippingProcessor_UU);
  }

  /**
   * Get User ID.
   *
   * @return User ID or account number
   */
  public String getUserID() {
    return (String) get_Value(COLUMNNAME_UserID);
  }

  /**
   * Set User ID.
   *
   * @param UserID User ID or account number
   */
  public void setUserID(String UserID) {
    set_Value(COLUMNNAME_UserID, UserID);
  }

  @Override
  public int getTableId() {
    return I_M_ShippingProcessor.Table_ID;
  }
}
