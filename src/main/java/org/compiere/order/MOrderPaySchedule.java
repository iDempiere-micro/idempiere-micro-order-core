package org.compiere.order;

import kotliquery.Row;
import org.compiere.bo.MCurrencyKt;
import org.compiere.orm.TimeUtil;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
     * Parent
     */
    private MOrder m_parent = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param C_OrderPaySchedule_ID id
     */
    public MOrderPaySchedule(int C_OrderPaySchedule_ID) {
        super(C_OrderPaySchedule_ID);
        if (C_OrderPaySchedule_ID == 0) {
            setIsValid(false);
        }
    } //	MOrderPaySchedule

    /**
     * Load Constructor
     */
    public MOrderPaySchedule(Row row) {
        super(row);
    } //	MOrderPaySchedule

    /**
     * Parent Constructor
     *
     * @param order       order
     * @param paySchedule payment schedule
     */
    public MOrderPaySchedule(MOrder order, MPaySchedule paySchedule) {
        super(0);
        m_parent = order;
        setClientOrg(order);
        setOrderId(order.getOrderId());
        setPayScheduleId(paySchedule.getPayScheduleId());

        //	Amounts
        int scale = MCurrencyKt.getCurrencyStdPrecision(order.getCurrencyId());
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
     * @param orderId            order id (direct)
     * @param orderPayScheduleId id (indirect)
     * @return array of schedule
     */
    public static MOrderPaySchedule[] getOrderPaySchedule(
            int orderId, int orderPayScheduleId) {
        return MBaseOrderPayScheduleKt.getOrderPaySchedule(orderId, orderPayScheduleId);
    } //	getSchedule

    /**
     * @return Returns the parent.
     */
    public MOrder getParent() {
        if (m_parent == null) m_parent = new MOrder(getOrderId());
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
        return "MOrderPaySchedule[" + getId() +
                "-Due=" + getDueDate() + "/" + getDueAmt() +
                ";Discount=" +
                getDiscountDate() + "/" + getDiscountAmt() +
                "]";
    } //	toString

    /**
     * Before Save
     *
     * @param newRecord new
     * @return true
     */
    protected boolean beforeSave(boolean newRecord) {
        if (isValueChanged("DueAmt")) {
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
        if (isValueChanged("DueAmt") || isValueChanged("IsActive")) {
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
