package org.compiere.order;

import org.compiere.orm.TimeUtil;
import org.compiere.product.MCurrency;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.prepareStatement;

/**
 * Order Payment Schedule Model
 *
 * @author Jorg Janke
 * @version $Id: MOrderPaySchedule.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MOrderPaySchedule extends X_C_OrderPaySchedule {
    /**
     *
     */
    private static final long serialVersionUID = 2158181283878369676L;
    /**
     * Static Logger
     */
    private static CLogger s_log = CLogger.getCLogger(MOrderPaySchedule.class);
    /**
     * Parent
     */
    private MOrder m_parent = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx                   context
     * @param C_OrderPaySchedule_ID id
     * @param trxName               transaction
     */
    public MOrderPaySchedule(Properties ctx, int C_OrderPaySchedule_ID) {
        super(ctx, C_OrderPaySchedule_ID);
        if (C_OrderPaySchedule_ID == 0) {
            //	setC_Order_ID (0);
            //	setDiscountAmt (Env.ZERO);
            //	setDiscountDate (new Timestamp(System.currentTimeMillis()));
            //	setDueAmt (Env.ZERO);
            //	setDueDate (new Timestamp(System.currentTimeMillis()));
            setIsValid(false);
        }
    } //	MOrderPaySchedule

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MOrderPaySchedule(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    } //	MOrderPaySchedule

    /**
     * Parent Constructor
     *
     * @param order       order
     * @param paySchedule payment schedule
     */
    public MOrderPaySchedule(MOrder order, MPaySchedule paySchedule) {
        super(order.getCtx(), 0);
        m_parent = order;
        setClientOrg(order);
        setC_Order_ID(order.getC_Order_ID());
        setC_PaySchedule_ID(paySchedule.getC_PaySchedule_ID());

        //	Amounts
        int scale = MCurrency.getStdPrecision(getCtx(), order.getC_Currency_ID());
        BigDecimal due = order.getGrandTotal();
        if (due.compareTo(Env.ZERO) == 0) {
            setDueAmt(Env.ZERO);
            setDiscountAmt(Env.ZERO);
            setIsValid(false);
        } else {
            due =
                    due.multiply(paySchedule.getPercentage())
                            .divide(Env.ONEHUNDRED, scale, BigDecimal.ROUND_HALF_UP);
            setDueAmt(due);
            BigDecimal discount =
                    due.multiply(paySchedule.getDiscount())
                            .divide(Env.ONEHUNDRED, scale, BigDecimal.ROUND_HALF_UP);
            setDiscountAmt(discount);
            setIsValid(true);
        }

        //	Dates
        Timestamp dueDate = TimeUtil.addDays(order.getDateOrdered(), paySchedule.getNetDays());
        setDueDate(dueDate);
        Timestamp discountDate =
                TimeUtil.addDays(order.getDateOrdered(), paySchedule.getDiscountDays());
        setDiscountDate(discountDate);
    } //	MOrderPaySchedule

    /**
     * Get Payment Schedule of the Order
     *
     * @param ctx                   context
     * @param C_Order_ID            order id (direct)
     * @param C_OrderPaySchedule_ID id (indirect)
     * @param trxName               transaction
     * @return array of schedule
     */
    public static MOrderPaySchedule[] getOrderPaySchedule(
            Properties ctx, int C_Order_ID, int C_OrderPaySchedule_ID) {
        String sql = "SELECT * FROM C_OrderPaySchedule ips WHERE IsActive='Y' ";
        if (C_Order_ID != 0) sql += "AND C_Order_ID=? ";
        else
            sql +=
                    "AND EXISTS (SELECT * FROM C_OrderPaySchedule x"
                            + " WHERE x.C_OrderPaySchedule_ID=? AND ips.C_Order_ID=x.C_Order_ID) ";
        sql += "ORDER BY DueDate";
        //
        ArrayList<MOrderPaySchedule> list = new ArrayList<MOrderPaySchedule>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            if (C_Order_ID != 0) pstmt.setInt(1, C_Order_ID);
            else pstmt.setInt(1, C_OrderPaySchedule_ID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MOrderPaySchedule(ctx, rs));
            }
        } catch (Exception e) {
            s_log.log(Level.SEVERE, "getOrderPaySchedule", e);
        } finally {
            rs = null;
            pstmt = null;
        }

        MOrderPaySchedule[] retValue = new MOrderPaySchedule[list.size()];
        list.toArray(retValue);
        return retValue;
    } //	getSchedule

    /**
     * @return Returns the parent.
     */
    public MOrder getParent() {
        if (m_parent == null) m_parent = new MOrder(getCtx(), getC_Order_ID());
        return m_parent;
    } //	getParent

    /**
     * @param parent The parent to set.
     */
    public void setParent(MOrder parent) {
        m_parent = parent;
    } //	setParent

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("MOrderPaySchedule[");
        sb.append(getId())
                .append("-Due=" + getDueDate() + "/" + getDueAmt())
                .append(";Discount=")
                .append(getDiscountDate() + "/" + getDiscountAmt())
                .append("]");
        return sb.toString();
    } //	toString

    /**
     * Before Save
     *
     * @param newRecord new
     * @return true
     */
    protected boolean beforeSave(boolean newRecord) {
        if (is_ValueChanged("DueAmt")) {
            log.fine("beforeSave");
            setIsValid(false);
        }
        return true;
    } //	beforeSave

    /**
     * After Save
     *
     * @param newRecord new
     * @param success   success
     * @return success
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success) return success;
        if (is_ValueChanged("DueAmt") || is_ValueChanged("IsActive")) {
            log.fine("afterSave");
            getParent();
            m_parent.validatePaySchedule();
            m_parent.saveEx();
        }
        return success;
    } //	afterSave

    @Override
    protected boolean afterDelete(boolean success) {
        if (!success) return success;
        log.fine("afterDelete");
        getParent();
        m_parent.validatePaySchedule();
        m_parent.saveEx();
        return success;
    }
} //	MOrderPaySchedule
