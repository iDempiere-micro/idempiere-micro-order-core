package org.compiere.order;

import kotliquery.Row;
import org.compiere.crm.MUser;
import org.compiere.crm.MUserKt;
import org.compiere.orm.MRefListKt;
import org.compiere.util.MsgKt;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

import java.sql.Timestamp;
import java.util.logging.Level;

/**
 * Shipment Confirmation Model
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 * <li>BF [ 2800460 ] System generate Material Receipt with no lines
 * https://sourceforge.net/tracker/?func=detail&atid=879332&aid=2800460&group_id=176962
 * @author Teo Sarca, teo.sarca@gmail.com
 * <li>BF [ 2993853 ] Voiding/Reversing Receipt should void confirmations
 * https://sourceforge.net/tracker/?func=detail&atid=879332&aid=2993853&group_id=176962
 * <li>FR [ 2994115 ] Add C_DocType.IsPrepareSplitDoc flag
 * https://sourceforge.net/tracker/?func=detail&aid=2994115&group_id=176962&atid=879335
 * @version $Id: MInOutConfirm.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MInOutConfirm extends X_M_InOutConfirm {
    /**
     *
     */
    private static final long serialVersionUID = 5270365186462536874L;

    /**
     * Static Logger
     */
    protected static CLogger s_log = CLogger.getCLogger(MInOutConfirm.class);
    /**
     * Just Prepared Flag
     */
    protected boolean m_justPrepared = false;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param M_InOutConfirm_ID id
     */
    public MInOutConfirm(int M_InOutConfirm_ID) {
        super(M_InOutConfirm_ID);
        if (M_InOutConfirm_ID == 0) {
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
     */
    public MInOutConfirm(Row row) {
        super(row);
    } //	MInOutConfirm

    /**
     * Parent Constructor
     *
     * @param ship        shipment
     * @param confirmType confirmation type
     */
    public MInOutConfirm(MInOut ship, String confirmType) {
        this(0);
        setClientOrg(ship);
        setInOutId(ship.getInOutId());
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
            setDescription(desc + " | " + description);
        }
    } //	addDescription

    /**
     * Get Name of ConfirmType
     *
     * @return confirm type
     */
    public String getConfirmTypeName() {
        return MRefListKt.getListName(
                X_M_InOutConfirm.CONFIRMTYPE_AD_Reference_ID, getConfirmType());
    } //	getConfirmTypeName

    /**
     * Set Approved
     *
     * @param IsApproved approval
     */
    public void setIsApproved(boolean IsApproved) {
        if (IsApproved && !isApproved()) {
            int AD_User_ID = Env.getUserId();
            MUser user = MUserKt.getUser(AD_User_ID);
            String info = user.getName() +
                    ": " +
                    MsgKt.translate("IsApproved") +
                    " - " +
                    new Timestamp(System.currentTimeMillis());
            addDescription(info);
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
