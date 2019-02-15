package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_C_OrderPaySchedule;
import org.compiere.model.I_C_PaymentTerm;
import org.compiere.orm.Query;
import org.compiere.util.Msg;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.Env;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

/**
 * Payment Term Model
 *
 * @author Jorg Janke
 * @author Cristina Ghita, www.arhipac.ro
 *     <li>BF [ 2889886 ] Net days in payment term
 *         https://sourceforge.net/tracker/index.php?func=detail&aid=2889886&group_id=176962&atid=879332
 * @version $Id: MPaymentTerm.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MPaymentTerm extends MBasePaymentTerm implements I_C_PaymentTerm {
  /** */
  private static final long serialVersionUID = -4506224598566445450L;

  /**
   * Standard Constructor
   *
   * @param ctx context
   * @param C_PaymentTerm_ID id
   * @param trxName transaction
   */
  public MPaymentTerm(Properties ctx, int C_PaymentTerm_ID) {
    super(ctx, C_PaymentTerm_ID);
    if (C_PaymentTerm_ID == 0) {
      setAfterDelivery(false);
      setNetDays(0);
      setDiscount(Env.ZERO);
      setDiscount2(Env.ZERO);
      setDiscountDays(0);
      setDiscountDays2(0);
      setGraceDays(0);
      setIsDueFixed(false);
      setIsValid(false);
    }
  } //	MPaymentTerm

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MPaymentTerm(Properties ctx, ResultSet rs) {
    super(ctx, rs);
  } //	MPaymentTerm
  public MPaymentTerm(Properties ctx, Row row) {
    super(ctx, row);
  } //	MPaymentTerm

  /**
   * Validate Payment Term & Schedule
   *
   * @return Validation Message @OK@ or error
   */
  public String validate() {
    String validMsg = Msg.parseTranslation(getCtx(), "@OK@");
    MPaySchedule[] m_schedule = getSchedule(true);
    if (m_schedule.length == 0) {
      if (!isValid()) setIsValid(true);
      return validMsg;
    }
    // Allow schedules with just one record
    // if (m_schedule.length == 1)
    // {
    // 	setIsValid(false);
    // 	if (m_schedule[0].isValid())
    // 	{
    // 		m_schedule[0].setIsValid(false);
    // 		m_schedule[0].saveEx();
    // 	}
    // 	return "@Invalid@ @Count@ # = 1 (@C_PaySchedule_ID@)";
    // }

    //	Add up
    BigDecimal total = Env.ZERO;
    for (int i = 0; i < m_schedule.length; i++) {
      BigDecimal percent = m_schedule[i].getPercentage();
      if (percent != null) total = total.add(percent);
    }
    boolean valid = total.compareTo(Env.ONEHUNDRED) == 0;
    if (isValid() != valid) setIsValid(valid);
    for (int i = 0; i < m_schedule.length; i++) {
      if (m_schedule[i].isValid() != valid) {
        m_schedule[i].setIsValid(valid);
        m_schedule[i].saveEx();
      }
    }
    if (valid) return validMsg;
    return "@Total@ = " + total + " - @Difference@ = " + Env.ONEHUNDRED.subtract(total);
  } //	validate

    /**
   * Apply Payment Term to Order
   *
   * @param order order
   * @return true if payment schedule is valid
   */
  public boolean applyOrder(MOrder order) {
    if (order == null || order.getId() == 0) {
      log.log(Level.SEVERE, "No valid order - " + order);
      return false;
    }

    // do not apply payment term if the order is not on credit or if total is zero
    if ((!(MOrder.PAYMENTRULE_OnCredit.equals(order.getPaymentRule())
            || MOrder.PAYMENTRULE_DirectDebit.equals(order.getPaymentRule())))
        || order.getGrandTotal().signum() == 0) return false;

    if (!isValid()) return applyOrderNoSchedule(order);
    //
    MPaySchedule[] m_schedule = getSchedule(true);
    if (m_schedule.length <= 0) // Allow schedules with just one record
    return applyOrderNoSchedule(order);
    else //	only if valid
    return applyOrderSchedule(order);
  } //	applyOrder

  /**
   * Apply Payment Term without schedule to Order
   *
   * @param order order
   * @return false as no payment schedule
   */
  private boolean applyOrderNoSchedule(MOrder order) {
    deleteOrderPaySchedule(order.getC_Order_ID());
    //	updateOrder
    if (order.getC_PaymentTerm_ID() != getC_PaymentTerm_ID())
      order.setC_PaymentTerm_ID(getC_PaymentTerm_ID());
    if (order.isPayScheduleValid()) order.setIsPayScheduleValid(false);
    return false;
  } //	applyOrderNoSchedule

  /**
   * Apply Payment Term with schedule to Order
   *
   * @param order order
   * @return true if payment schedule is valid
   */
  private boolean applyOrderSchedule(MOrder order) {
    deleteOrderPaySchedule(order.getC_Order_ID());
    //	Create Schedule
    MOrderPaySchedule ops = null;
    BigDecimal remainder = order.getGrandTotal();
    MPaySchedule[] m_schedule = getSchedule(true);
    for (int i = 0; i < m_schedule.length; i++) {
      ops = new MOrderPaySchedule(order, m_schedule[i]);
      ops.saveEx();
      if (log.isLoggable(Level.FINE)) log.fine(ops.toString());
      remainder = remainder.subtract(ops.getDueAmt());
    } //	for all schedules
    //	Remainder - update last
    if (remainder.compareTo(Env.ZERO) != 0 && ops != null) {
      ops.setDueAmt(ops.getDueAmt().add(remainder));
      ops.saveEx();
      if (log.isLoggable(Level.FINE)) log.fine("Remainder=" + remainder + " - " + ops);
    }

    //	updateOrder
    if (order.getC_PaymentTerm_ID() != getC_PaymentTerm_ID())
      order.setC_PaymentTerm_ID(getC_PaymentTerm_ID());
    return order.validatePaySchedule();
  } //	applyOrderSchedule

  /**
   * Delete existing Order Payment Schedule
   *
   * @param C_Order_ID id
   * @param trxName transaction
   */
  private void deleteOrderPaySchedule(int C_Order_ID) {
    Query query = new Query(Env.getCtx(), I_C_OrderPaySchedule.Table_Name, "C_Order_ID=?");
    List<MOrderPaySchedule> opsList = query.setParameters(C_Order_ID).list();
    for (MOrderPaySchedule ops : opsList) {
      ops.deleteEx(true);
    }
    if (log.isLoggable(Level.FINE)) log.fine("C_Order_ID=" + C_Order_ID + " - #" + opsList.size());
  } //	deleteOrderPaySchedule

  /**
   * ************************************************************************ String Representation
   *
   * @return info
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("MPaymentTerm[");
    sb.append(getId())
        .append("-")
        .append(getName())
        .append(",Valid=")
        .append(isValid())
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
    if (isDueFixed()) {
      int dd = getFixMonthDay();
      if (dd < 1 || dd > 31) {
        log.saveError("Error", Msg.parseTranslation(getCtx(), "@Invalid@ @FixMonthDay@"));
        return false;
      }
      dd = getFixMonthCutoff();
      if (dd < 1 || dd > 31) {
        log.saveError("Error", Msg.parseTranslation(getCtx(), "@Invalid@ @FixMonthCutoff@"));
        return false;
      }
    }

    if (Integer.signum(getNetDays()) < 0) {
      throw new AdempiereException(
          Msg.parseTranslation(getCtx(), "@NetDays@")
              + " "
              + Msg.parseTranslation(getCtx(), "@positive.number@"));
    }

    if (!newRecord || !isValid()) validate();
    return true;
  } //	beforeSave

  @Override
  public int getTableId() {
    return I_C_PaymentTerm.Table_ID;
  }

  @NotNull
  @Override
  public I_C_PaymentTerm self() {
    return this;
  }
} //	MPaymentTerm
