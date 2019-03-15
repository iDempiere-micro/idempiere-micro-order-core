package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_PaymentTerm;
import org.idempiere.common.util.Env;

import java.util.Properties;

/**
 * Payment Term Schedule Model
 *
 * @author Jorg Janke
 * @version $Id: MPaySchedule.java,v 1.3 2006/07/30 00:51:04 jjanke Exp $
 */
public class MPaySchedule extends X_C_PaySchedule {
    /**
     *
     */
    private static final long serialVersionUID = 7773501661681911294L;
    /**
     * Parent
     */
    public I_C_PaymentTerm m_parent = null;

    /**
     * Standard Constructor
     *
     * @param ctx              context
     * @param C_PaySchedule_ID id
     * @param trxName          transaction
     */
    public MPaySchedule(Properties ctx, int C_PaySchedule_ID) {
        super(ctx, C_PaySchedule_ID);
        if (C_PaySchedule_ID == 0) {
            //	setPaymentTermId (0);	//	Parent
            setPercentage(Env.ZERO);
            setDiscount(Env.ZERO);
            setDiscountDays(0);
            setGraceDays(0);
            setNetDays(0);
            setIsValid(false);
        }
    } //	MPaySchedule

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MPaySchedule(Properties ctx, Row row) {
        super(ctx, row);
    } //	MPaySchedule

    /**
     * @return Returns the parent.
     */
    public I_C_PaymentTerm getParent() {
        if (m_parent == null)
            m_parent = new MPaymentTerm(getCtx(), getPaymentTermId());
        return m_parent;
    } //	getParent

    /**
     * @param parent The parent to set.
     */
    public void setParent(I_C_PaymentTerm parent) {
        m_parent = parent;
    } //	setParent

    /**
     * Before Save
     *
     * @param newRecord new
     * @return true
     */
    protected boolean beforeSave(boolean newRecord) {
        if (is_ValueChanged("Percentage") || is_ValueChanged("IsActive")) {
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
        if (newRecord || is_ValueChanged("Percentage") || is_ValueChanged("IsActive")) {
            log.fine("afterSave");
            getParent();
            m_parent.validate();
            m_parent.saveEx();
        }
        return success;
    } //	afterSave

    @Override
    protected boolean afterDelete(boolean success) {
        if (!success) return false;
        getParent();
        m_parent.validate();
        m_parent.saveEx();
        return true;
    }
} //	MPaySchedule
