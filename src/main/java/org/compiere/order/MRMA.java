package org.compiere.order;

import kotliquery.Row;
import org.compiere.bo.MCurrency;
import org.compiere.model.I_M_RMA;
import org.compiere.model.I_M_RMALine;
import org.compiere.model.I_M_RMATax;
import org.compiere.orm.MDocType;
import org.compiere.orm.MSequence;
import org.compiere.orm.Query;
import org.compiere.tax.ITaxProvider;
import org.compiere.tax.MTax;
import org.compiere.tax.MTaxProvider;
import org.compiere.util.Msg;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import static software.hsharp.core.orm.POKt.I_ZERO;
import static software.hsharp.core.orm.POKt.getAllIDs;
import static software.hsharp.core.util.DBKt.executeUpdateEx;

/**
 * RMA Model
 *
 * @author Jorg Janke
 * @version $Id: MRMA.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 * <p>Modifications: Completed RMA functionality (Ashley Ramdass)
 */
public class MRMA extends X_M_RMA implements I_M_RMA {
    /**
     *
     */
    private static final long serialVersionUID = -6449007672684459651L;
    /**
     * Lines
     */
    protected MRMALine[] m_lines = null;
    /**
     * The Shipment
     */
    protected MInOut m_inout = null;
    /**
     * Process Message
     */
    protected String m_processMsg = null;
    /**
     * Just Prepared Flag
     */
    protected boolean m_justPrepared = false;
    /**
     * Tax Lines
     */
    private MRMATax[] m_taxes = null;

    /**
     * Standard Constructor
     *
     * @param ctx      context
     * @param M_RMA_ID id
     * @param trxName  transaction
     */
    public MRMA(Properties ctx, int M_RMA_ID) {
        super(ctx, M_RMA_ID);
        if (M_RMA_ID == 0) {
            //	setName (null);
            //	setSalesRepresentativeId (0);
            //	setDocumentTypeId (0);
            //	setInOutId (0);
            setDocAction(X_M_RMA.DOCACTION_Complete); // CO
            setDocStatus(X_M_RMA.DOCSTATUS_Drafted); // DR
            setIsApproved(false);
            setProcessed(false);
        }
    } //	MRMA

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MRMA(Properties ctx, Row row) {
        super(ctx, row);
    } //	MRMA

    /**
     * Create new RMA by copying
     *
     * @param from         RMA
     * @param C_DocType_ID doc type
     * @param isSOTrx      sales order
     * @param counter      create counter links
     * @param trxName      trx
     * @return MRMA
     */
    public static MRMA copyFrom(
            MRMA from, int C_DocType_ID, boolean isSOTrx, boolean counter) {
        MRMA to = new MRMA(from.getCtx(), 0);
        return doCopyFrom(from, C_DocType_ID, isSOTrx, counter, null, to);
    }

    protected static MRMA doCopyFrom(
            MRMA from, int C_DocType_ID, boolean isSOTrx, boolean counter, String trxName, MRMA to) {
        copyValues(from, to, from.getClientId(), from.getOrgId());
        to.setValueNoCheck("M_RMA_ID", I_ZERO);
        to.setValueNoCheck("DocumentNo", null);
        to.setDocStatus(X_M_RMA.DOCSTATUS_Drafted); // 	Draft
        to.setDocAction(X_M_RMA.DOCACTION_Complete);
        to.setDocumentTypeId(C_DocType_ID);
        to.setIsSOTrx(isSOTrx);
        to.setIsApproved(false);
        to.setProcessed(false);
        to.setProcessing(false);

        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setSalesRepresentativeId(from.getSalesRepresentativeId());
        to.setHelp(from.getHelp());
        to.setRMATypeId(from.getRMATypeId());
        to.setAmt(from.getAmt());

        to.setOrderId(0);
        //	Try to find Order/Shipment/Receipt link
        if (from.getOrderId() != 0) {
            MOrder peer = new MOrder(from.getCtx(), from.getOrderId());
            if (peer.getRef_OrderId() != 0) to.setOrderId(peer.getRef_OrderId());
        }
        if (from.getInOutId() != 0) {
            MInOut peer = new MInOut(from.getCtx(), from.getInOutId());
            if (peer.getReferencedInOutId() != 0) to.setInOutId(peer.getReferencedInOutId());
        }
        to.setRef_RMAId(from.getRMAId());

        to.saveEx();
        if (counter) from.setRef_RMAId(to.getRMAId());

        if (to.copyLinesFrom(from, counter) == 0)
            throw new IllegalStateException("Could not create RMA Lines");

        return to;
    } //	copyFrom

    /**
     * Get Lines
     *
     * @param requery requery
     * @return lines
     */
    public MRMALine[] getLines(boolean requery) {
        if (m_lines != null && !requery) {
            return m_lines;
        }
        List<MRMALine> list =
                new Query(getCtx(), I_M_RMALine.Table_Name, "M_RMA_ID=?")
                        .setParameters(getRMAId())
                        .setOrderBy(MRMALine.COLUMNNAME_Line)
                        .list();

        m_lines = new MRMALine[list.size()];
        list.toArray(m_lines);
        return m_lines;
    } //	getLines

    /**
     * Get Taxes of RMA
     *
     * @param requery requery
     * @return array of taxes
     */
    public MRMATax[] getTaxes(boolean requery) {
        if (m_taxes != null && !requery) return m_taxes;
        //
        List<MRMATax> list =
                new Query(getCtx(), I_M_RMATax.Table_Name, "M_RMA_ID=?")
                        .setParameters(getId())
                        .list();
        m_taxes = list.toArray(new MRMATax[list.size()]);
        return m_taxes;
    }

    /**
     * Get Shipment
     *
     * @return shipment
     */
    public MInOut getShipment() {
        if (m_inout == null && getInOutId() != 0)
            m_inout = new MInOut(getCtx(), getInOutId());
        return m_inout;
    } //	getShipment

    /**
     * Get the original order on which the shipment/receipt defined is based upon.
     *
     * @return order
     */
    public MOrder getOriginalOrder() {
        MInOut shipment = getShipment();
        if (shipment == null || shipment.getOrderId() == 0) {
            return null;
        }
        return new MOrder(getCtx(), shipment.getOrderId());
    }

    /**
     * Set M_InOut_ID
     *
     * @param M_InOut_ID id
     */
    public void setInOutId(int M_InOut_ID) {
        setInOutId(M_InOut_ID);
        setCurrencyId(0);
        setAmt(Env.ZERO);
        setBusinessPartnerId(0);
        m_inout = null;
    } //	setInOutId

    /**
     * Get Document Info
     *
     * @return document info (untranslated)
     */
    public String getDocumentInfo() {
        MDocType dt = MDocType.get(getCtx(), getDocumentTypeId());
        return dt.getNameTrl() + " " + getDocumentNo();
    } //	getDocumentInfo

    /**
     * Before Save Set BPartner, Currency
     *
     * @param newRecord new
     * @return true
     */
    protected boolean beforeSave(boolean newRecord) {
        if (newRecord) setOrderId(0);
        getShipment();
        //	Set BPartner
        if (getBusinessPartnerId() == 0) {
            if (m_inout != null) setBusinessPartnerId(m_inout.getBusinessPartnerId());
        }
        //	Set Currency
        if (getCurrencyId() == 0) {
            if (m_inout != null) {
                if (m_inout.getOrderId() != 0) {
                    MOrder order = new MOrder(getCtx(), m_inout.getOrderId());
                    setCurrencyId(order.getCurrencyId());
                }
            }
        }

        // Verification whether Shipment/Receipt matches RMA for sales transaction
        if (m_inout != null && m_inout.isSOTrx() != isSOTrx()) {
            log.saveError("RMA.IsSOTrx <> InOut.IsSOTrx", "");
            return false;
        }

        return true;
    } //	beforeSave

    /**
     * Unlock Document.
     *
     * @return true if success
     */
    public boolean unlockIt() {
        if (log.isLoggable(Level.INFO)) log.info("unlockIt - " + toString());
        setProcessing(false);
        return true;
    } //	unlockIt

    /**
     * Invalidate Document
     *
     * @return true if success
     */
    public boolean invalidateIt() {
        if (log.isLoggable(Level.INFO)) log.info("invalidateIt - " + toString());
        return true;
    } //	invalidateIt

    /**
     * Calculate Tax and Total
     *
     * @return true if tax total calculated
     */
    public boolean calculateTaxTotal() {
        log.fine("");
        //	Delete Taxes
        executeUpdateEx("DELETE M_RMATax WHERE M_RMA_ID=" + getRMAId());
        m_taxes = null;

        MTaxProvider[] providers = getTaxProviders();
        for (MTaxProvider provider : providers) {
            ITaxProvider calculator = MTaxProvider.getTaxProvider(provider, new StandardTaxProvider());
            if (calculator == null) throw new AdempiereException(Msg.getMsg(getCtx(), "TaxNoProvider"));

            if (!calculator.calculateRMATaxTotal(provider, this)) return false;
        }
        return true;
    }

    /**
     * Approve Document
     *
     * @return true if success
     */
    public boolean approveIt() {
        if (log.isLoggable(Level.INFO)) log.info("approveIt - " + toString());
        setIsApproved(true);
        return true;
    } //	approveIt

    /**
     * Reject Approval
     *
     * @return true if success
     */
    public boolean rejectIt() {
        if (log.isLoggable(Level.INFO)) log.info("rejectIt - " + toString());
        setIsApproved(false);
        return true;
    } //	rejectIt

    /**
     * Set the definite document number after completed
     */
    protected void setDefiniteDocumentNo() {
        MDocType dt = MDocType.get(getCtx(), getDocumentTypeId());
    /* No Document Date on RMA
    if (dt.isOverwriteDateOnComplete()) {
    	setDate???(new Timestamp (System.currentTimeMillis()));
    }
    */
        if (dt.isOverwriteSeqOnComplete()) {
            String value = MSequence.getDocumentNo(getDocumentTypeId(), true, this);
            if (value != null) setDocumentNo(value);
        }
    }

    /**
     * Copy Lines From other RMA
     *
     * @param otherRMA
     * @param counter  set counter info
     * @param setOrder set order link
     * @return number of lines copied
     */
    public int copyLinesFrom(MRMA otherRMA, boolean counter) {
        if (isProcessed() || otherRMA == null) return 0;
        MRMALine[] fromLines = otherRMA.getLines(false);
        int count = 0;
        for (int i = 0; i < fromLines.length; i++) {
            MRMALine line = new MRMALine(getCtx(), 0);
            MRMALine fromLine = fromLines[i];
            if (counter) //	header
                copyValues(fromLine, line, getClientId(), getOrgId());
            else copyValues(fromLine, line, fromLine.getClientId(), fromLine.getOrgId());
            line.setRMAId(getRMAId());
            line.setValueNoCheck(MRMALine.COLUMNNAME_M_RMALine_ID, I_ZERO); // 	new
            if (counter) {
                line.setRef_RMALineId(fromLine.getRMALineId());
                if (fromLine.getInOutLineId() != 0) {
                    MInOutLine peer = new MInOutLine(getCtx(), fromLine.getInOutLineId());
                    if (peer.getReferencedInOutLineId() != 0) line.setInOutLineId(peer.getReferencedInOutLineId());
                }
            }
            //
            line.setProcessed(false);
            if (line.save()) count++;
            //	Cross Link
            if (counter) {
                fromLine.setRef_RMALineId(line.getRMALineId());
                fromLine.saveEx();
            }
        }
        if (fromLines.length != count)
            log.log(Level.SEVERE, "Line difference - From=" + fromLines.length + " <> Saved=" + count);
        return count;
    } //	copyLinesFrom

    /**
     * Get Currency Precision
     *
     * @return precision
     */
    public int getPrecision() {
        return MCurrency.getStdPrecision(getCtx(), getCurrencyId());
    }

    /**
     * Set Processed. Propagate to Lines
     *
     * @param processed processed
     */
    public void setProcessed(boolean processed) {
        super.setProcessed(processed);
        if (getId() <= 0) return;
        int noLine =
                executeUpdateEx(
                        "UPDATE M_RMALine SET Processed=? WHERE M_RMA_ID=?",
                        new Object[]{processed, getId()}
                );
        m_lines = null;
        if (log.isLoggable(Level.FINE)) log.fine("setProcessed - " + processed + " - Lines=" + noLine);
    } //  setProcessed

    /**
     * Add to Description
     *
     * @param description text
     */
    public void addDescription(String description) {
        String desc = getDescription();
        if (desc == null) setDescription(description);
        else setDescription(desc + " | " + description);
    } //  addDescription

    /**
     * *********************************************************************** Get Summary
     *
     * @return Summary of Document
     */
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDocumentNo());
        //	: Total Lines = 123.00 (#1)
        sb.append(": ")
                .append(Msg.translate(getCtx(), "Amt"))
                .append("=")
                .append(getAmt())
                .append(" (#")
                .append(getLines(false).length)
                .append(")");
        //	 - Description
        if (getDescription() != null && getDescription().length() > 0)
            sb.append(" - ").append(getDescription());
        return sb.toString();
    } //	getSummary

    /**
     * Retrieves all the charge lines that is present on the document
     *
     * @return Charge Lines
     */
    public MRMALine[] getChargeLines() {
        StringBuilder whereClause = new StringBuilder();
        whereClause.append("IsActive='Y' AND M_RMA_ID=");
        whereClause.append(getId());
        whereClause.append(" AND C_Charge_ID IS NOT null");

        int[] rmaLineIds = getAllIDs(MRMALine.Table_Name, whereClause.toString());

        ArrayList<MRMALine> chargeLineList = new ArrayList<MRMALine>();

        for (int i = 0; i < rmaLineIds.length; i++) {
            MRMALine rmaLine = new MRMALine(getCtx(), rmaLineIds[i]);
            chargeLineList.add(rmaLine);
        }

        MRMALine[] lines = new MRMALine[chargeLineList.size()];
        chargeLineList.toArray(lines);

        return lines;
    }

    /**
     * Get whether Tax is included (based on the original order)
     *
     * @return True if tax is included
     */
    public boolean isTaxIncluded() {
        MOrder order = getOriginalOrder();

        if (order != null && order.getId() != 0) {
            return order.isTaxIncluded();
        }

        return true;
    }

    /**
     * Get Process Message
     *
     * @return clear text error message
     */
    public String getProcessMsg() {
        return m_processMsg;
    } //	getProcessMsg

    /**
     * Get Document Owner (Responsible)
     *
     * @return AD_User_ID
     */
    public int getDocumentUserId() {
        return getSalesRepresentativeId();
    } //	getDoc_User_ID

    /**
     * Get Document Approval Amount
     *
     * @return amount
     */
    public BigDecimal getApprovalAmt() {
        return getAmt();
    } //	getApprovalAmt

    /**
     * Document Status is Complete or Closed
     *
     * @return true if CO, CL or RE
     */
    public boolean isComplete() {
        String ds = getDocStatus();
        return X_M_RMA.DOCSTATUS_Completed.equals(ds)
                || X_M_RMA.DOCSTATUS_Closed.equals(ds)
                || X_M_RMA.DOCSTATUS_Reversed.equals(ds);
    } //	isComplete

    /**
     * Set process message
     *
     * @param processMsg
     */
    public void setProcessMessage(String processMsg) {
        m_processMsg = processMsg;
    }

    /**
     * Get tax providers
     *
     * @return array of tax provider
     */
    public MTaxProvider[] getTaxProviders() {
        Hashtable<Integer, MTaxProvider> providers = new Hashtable<Integer, MTaxProvider>();
        MRMALine[] lines = getLines(false);
        for (MRMALine line : lines) {
            MTax tax = new MTax(line.getCtx(), line.getTaxId());
            MTaxProvider provider = providers.get(tax.getTaxProviderId());
            if (provider == null)
                providers.put(
                        tax.getTaxProviderId(),
                        new MTaxProvider(tax.getCtx(), tax.getTaxProviderId()));
        }

        MTaxProvider[] retValue = new MTaxProvider[providers.size()];
        providers.values().toArray(retValue);
        return retValue;
    }
} //	MRMA
