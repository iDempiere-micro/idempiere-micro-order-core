package org.compiere.order;

import org.compiere.crm.MUser;
import org.compiere.orm.MRefList;
import org.compiere.util.Msg;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.logging.Level;

/**
 * Shipment Confirmation Model
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 *     <li>BF [ 2800460 ] System generate Material Receipt with no lines
 *         https://sourceforge.net/tracker/?func=detail&atid=879332&aid=2800460&group_id=176962
 * @author Teo Sarca, teo.sarca@gmail.com
 *     <li>BF [ 2993853 ] Voiding/Reversing Receipt should void confirmations
 *         https://sourceforge.net/tracker/?func=detail&atid=879332&aid=2993853&group_id=176962
 *     <li>FR [ 2994115 ] Add C_DocType.IsPrepareSplitDoc flag
 *         https://sourceforge.net/tracker/?func=detail&aid=2994115&group_id=176962&atid=879335
 * @version $Id: MInOutConfirm.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MInOutConfirm extends X_M_InOutConfirm {
  /** */
  private static final long serialVersionUID = 5270365186462536874L;

  /** Static Logger */
  protected static CLogger s_log = CLogger.getCLogger(MInOutConfirm.class);
  /** Just Prepared Flag */
  protected boolean m_justPrepared = false;

  /**
   * ************************************************************************ Standard Constructor
   *
   * @param ctx context
   * @param M_InOutConfirm_ID id
   * @param trxName transaction
   */
  public MInOutConfirm(Properties ctx, int M_InOutConfirm_ID) {
    super(ctx, M_InOutConfirm_ID);
    if (M_InOutConfirm_ID == 0) {
      //	setConfirmType (null);
      setDocAction(X_M_InOutConfirm.DOCACTION_Complete); // CO
      setDocStatus(X_M_InOutConfirm.DOCSTATUS_Drafted); // DR
      setIsApproved(false);
      setIsCancelled(false);
      setIsInDispute(false);
      super.setProcessed(false);
    }
  } //	MInOutConfirm

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MInOutConfirm(Properties ctx, ResultSet rs) {
    super(ctx, rs);
  } //	MInOutConfirm

  /**
   * Parent Constructor
   *
   * @param ship shipment
   * @param confirmType confirmation type
   */
  public MInOutConfirm(MInOut ship, String confirmType) {
    this(ship.getCtx(), 0);
    setClientOrg(ship);
    setM_InOut_ID(ship.getM_InOut_ID());
    setConfirmType(confirmType);
  } //	MInOutConfirm

  /**
   * Add to Description
   *
   * @param description text
   */
  public void addDescription(String description) {
    String desc = getDescription();
    if (desc == null) setDescription(description);
    else {
      StringBuilder msgd = new StringBuilder(desc).append(" | ").append(description);
      setDescription(msgd.toString());
    }
  } //	addDescription

  /**
   * Get Name of ConfirmType
   *
   * @return confirm type
   */
  public String getConfirmTypeName() {
    return MRefList.getListName(
        getCtx(), X_M_InOutConfirm.CONFIRMTYPE_AD_Reference_ID, getConfirmType());
  } //	getConfirmTypeName

    /**
   * Set Approved
   *
   * @param IsApproved approval
   */
  public void setIsApproved(boolean IsApproved) {
    if (IsApproved && !isApproved()) {
      int AD_User_ID = Env.getAD_User_ID(getCtx());
      MUser user = MUser.get(getCtx(), AD_User_ID);
      StringBuilder info =
          new StringBuilder()
              .append(user.getName())
              .append(": ")
              .append(Msg.translate(getCtx(), "IsApproved"))
              .append(" - ")
              .append(new Timestamp(System.currentTimeMillis()));
      addDescription(info.toString());
    }
    super.setIsApproved(IsApproved);
  } //	setIsApproved

    /**
   * Approve Document
   *
   * @return true if success
   */
  public boolean approveIt() {
    if (log.isLoggable(Level.INFO)) log.info(toString());
    setIsApproved(true);
    return true;
  } //	approveIt

} //	MInOutConfirm
