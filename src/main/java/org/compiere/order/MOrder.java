package org.compiere.order;

import kotliquery.Row;
import org.compiere.bo.MCurrencyKt;
import org.compiere.crm.MBPartner;
import org.compiere.model.I_AD_User;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_Invoice;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_C_OrderTax;
import org.compiere.model.I_M_InOut;
import org.compiere.orm.MClientInfo;
import org.compiere.orm.MDocType;
import org.compiere.orm.MOrg;
import org.compiere.orm.MOrgKt;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.compiere.orm.Query;
import org.compiere.product.MPriceList;
import org.compiere.product.MPriceListVersion;
import org.compiere.product.MProduct;
import org.compiere.product.MProductBOM;
import org.compiere.tax.ITaxProvider;
import org.compiere.tax.MTax;
import org.compiere.tax.MTaxProvider;
import org.compiere.util.Msg;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.exceptions.FillMandatoryException;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.Util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;

import static org.compiere.order.SalesOrderRateInquiryProcessKt.createShippingTransaction;
import static software.hsharp.core.orm.POKt.I_ZERO;
import static software.hsharp.core.util.DBKt.executeUpdate;
import static software.hsharp.core.util.DBKt.executeUpdateEx;
import static software.hsharp.core.util.DBKt.getSQLValue;
import static software.hsharp.core.util.DBKt.getSQLValueEx;

/**
 * Order Model. Please do not set DocStatus and C_DocType_ID directly. They are set in the process()
 * method. Use DocAction and C_DocTypeTarget_ID instead.
 *
 * @author Jorg Janke
 * @author victor.perez@e-evolution.com, e-Evolution http://www.e-evolution.com
 * <li>FR [ 2520591 ] Support multiples calendar for Org
 * @author Teo Sarca, www.arhipac.ro
 * <li>BF [ 2419978 ] Voiding PO, requisition don't set on NULL
 * <li>BF [ 2892578 ] Order should autoset only active price lists
 * https://sourceforge.net/tracker/?func=detail&aid=2892578&group_id=176962&atid=879335
 * @author Michael Judd, www.akunagroup.com
 * <li>BF [ 2804888 ] Incorrect reservation of products with attributes
 * @version $Id: MOrder.java,v 1.5 2006/10/06 00:42:24 jjanke Exp $
 */
public class MOrder extends X_C_Order implements I_C_Order {
    /**
     * Sales Order Sub Type - SO
     */
    public static final String DocSubTypeSO_Standard = "SO";
    /**
     * Sales Order Sub Type - WR
     */
    public static final String DocSubTypeSO_POS = "WR";
    /**
     * Sales Order Sub Type - WI
     */
    public static final String DocSubTypeSO_OnCredit = "WI";
    /**
     *
     */
    private static final long serialVersionUID = -7784588474522162502L;

    protected static volatile boolean recursiveCall = false;
    /**
     * Order Lines
     */
    protected MOrderLine[] m_lines = null;
    /**
     * Tax Lines
     */
    protected MOrderTax[] m_taxes = null;
    /**
     * Force Creation of order
     */
    protected boolean m_forceCreation = false;
    /**
     * Process Message
     */
    protected String m_processMsg = null;
    /**
     * Just Prepared Flag
     */
    protected boolean m_justPrepared = false;

    /**
     * ************************************************************************ Default Constructor
     *
     * @param ctx        context
     * @param C_Order_ID order to load, (0 create new order)
     */
    public MOrder(int C_Order_ID) {
        super(C_Order_ID);
        //  New
        if (C_Order_ID == 0) {
            setDocStatus(DOCSTATUS_Drafted);
            setDocAction(DOCACTION_Prepare);
            //
            setDeliveryRule(DELIVERYRULE_Availability);
            setFreightCostRule(FREIGHTCOSTRULE_FreightIncluded);
            setInvoiceRule(INVOICERULE_Immediate);
            setPaymentRule(PAYMENTRULE_OnCredit);
            setPriorityRule(PRIORITYRULE_Medium);
            setDeliveryViaRule(DELIVERYVIARULE_Pickup);
            //
            setIsDiscountPrinted(false);
            setIsSelected(false);
            setIsTaxIncluded(false);
            setIsSOTrx(true);
            setIsDropShip(false);
            setSendEMail(false);
            //
            setIsApproved(false);
            setIsPrinted(false);
            setIsCreditApproved(false);
            setIsDelivered(false);
            setIsInvoiced(false);
            setIsTransferred(false);
            setIsSelfService(false);
            //
            super.setProcessed(false);
            setProcessing(false);
            setPosted(false);

            setDateAcct(new Timestamp(System.currentTimeMillis()));
            setDatePromised(new Timestamp(System.currentTimeMillis()));
            setDateOrdered(new Timestamp(System.currentTimeMillis()));

            setFreightAmt(Env.ZERO);
            setChargeAmt(Env.ZERO);
            setTotalLines(Env.ZERO);
            setGrandTotal(Env.ZERO);
        }
    } //	MOrder

    /**
     * Load Constructor
     *
     * @param ctx context
     */
    public MOrder(Row row) {
        super(row);
    } //	MOrder

    /**
     * *********************************************************************
     */
    protected static MOrder doCopyFrom(
            MOrder from,
            Timestamp dateDoc,
            int C_DocTypeTarget_ID,
            boolean isSOTrx,
            boolean counter,
            boolean copyASI,
            MOrder to) {
        copyValues(from, to, from.getClientId(), from.getOrgId());
        to.setValueNoCheck("C_Order_ID", I_ZERO);
        to.setValueNoCheck("DocumentNo", null);
        //
        to.setDocStatus(DOCSTATUS_Drafted); // 	Draft
        to.setDocAction(DOCACTION_Complete);
        //
        to.setDocumentTypeId(0);
        to.setTargetDocumentTypeId(C_DocTypeTarget_ID);
        to.setIsSOTrx(isSOTrx);
        //
        to.setIsSelected(false);
        to.setDateOrdered(dateDoc);
        to.setDateAcct(dateDoc);
        to.setDatePromised(dateDoc); // 	assumption
        to.setDatePrinted(null);
        to.setIsPrinted(false);
        //
        to.setIsApproved(false);
        to.setIsCreditApproved(false);
        to.setPaymentId(0);
        to.setCashLineId(0);
        //	Amounts are updated  when adding lines
        to.setGrandTotal(Env.ZERO);
        to.setTotalLines(Env.ZERO);
        //
        to.setIsDelivered(false);
        to.setIsInvoiced(false);
        to.setIsSelfService(false);
        to.setIsTransferred(false);
        to.setPosted(false);
        to.setProcessed(false);
        if (counter) {
            to.setRef_OrderId(from.getOrderId());
            MOrg org = MOrgKt.getOrg(from.getOrgId());
            int counterC_BPartner_ID = org.getLinkedBusinessPartnerId();
            if (counterC_BPartner_ID == 0) return null;
            to.setBPartner(MBPartner.get(counterC_BPartner_ID));
        } else to.setRef_OrderId(0);
        //
        if (!to.save()) throw new IllegalStateException("Could not create Order");
        if (counter) from.setRef_OrderId(to.getOrderId());

        if (to.copyLinesFrom(from, counter, copyASI) == 0)
            throw new IllegalStateException("Could not create Order Lines");

        // don't copy linked PO/SO
        to.setLink_OrderId(0);

        return to;
    } //	copyFrom

    /**
     * Overwrite Client/Org if required
     *
     * @param AD_Client_ID client
     * @param AD_Org_ID    org
     */
    public void setClientOrg(int AD_Client_ID, int AD_Org_ID) {
        super.setClientOrg(AD_Client_ID, AD_Org_ID);
    } //	setClientOrg

    /**
     * Add to Description
     *
     * @param description text
     */
    public void addDescription(String description) {
        String desc = getDescription();
        if (desc == null) setDescription(description);
        else setDescription(desc + " | " + description);
    } //	addDescription

    /**
     * Set Business Partner (Ship+Bill)
     *
     * @param C_BPartner_ID bpartner
     */
    public void setBusinessPartnerId(int C_BPartner_ID) {
        super.setBusinessPartnerId(C_BPartner_ID);
        super.setBill_BPartnerId(C_BPartner_ID);
    } //	setBusinessPartnerId

    /**
     * Set Business Partner Location (Ship+Bill)
     *
     * @param C_BPartner_Location_ID bp location
     */
    public void setBusinessPartnerLocationId(int C_BPartner_Location_ID) {
        super.setBusinessPartnerLocationId(C_BPartner_Location_ID);
        super.setBusinessPartnerInvoicingLocationId(C_BPartner_Location_ID);
    } //	setBusinessPartnerLocationId

    @Override
    public String getDateOrderedISOFormat() {
        Timestamp dateOrdered = getDateOrdered();
        return dateOrdered == null ? null : dateOrdered.toInstant().toString();
    }

    /**
     * Set Business Partner Contact (Ship+Bill)
     *
     * @param AD_User_ID user
     */
    public void setUserId(int AD_User_ID) {
        super.setUserId(AD_User_ID);
        super.setBill_UserId(AD_User_ID);
    } //	setUserId

    @Override
    public I_C_BPartner getCustomer() {
        return (I_C_BPartner) MTable.get(I_C_BPartner.Table_Name)
                .getPO(getBusinessPartnerId());
    }

    /**
     * Set Warehouse
     *
     * @param M_Warehouse_ID warehouse
     */
    public void setWarehouseId(int M_Warehouse_ID) {
        super.setWarehouseId(M_Warehouse_ID);
    } //	setWarehouseId

    /**
     * Set Drop Ship
     *
     * @param IsDropShip drop ship
     */
    public void setIsDropShip(boolean IsDropShip) {
        super.setIsDropShip(IsDropShip);
    } //	setIsDropShip

    /**
     * Set Target Sales Document Type
     *
     * @param DocSubTypeSO_x SO sub type - see DocSubTypeSO_*
     */
    public void setTargetDocumentTypeId(String DocSubTypeSO_x) {
        String sql =
                "SELECT C_DocType_ID FROM C_DocType "
                        + "WHERE AD_Client_ID=? AND AD_Org_ID IN (0,"
                        + getOrgId()
                        + ") AND DocSubTypeSO=? "
                        + " AND IsActive='Y' "
                        + "ORDER BY AD_Org_ID DESC, IsDefault DESC";
        int C_DocType_ID = getSQLValue(sql, getClientId(), DocSubTypeSO_x);
        if (C_DocType_ID <= 0)
            log.severe("Not found for AD_Client_ID=" + getClientId() + ", SubType=" + DocSubTypeSO_x);
        else {
            if (log.isLoggable(Level.FINE)) log.fine("(SO) - " + DocSubTypeSO_x);
            setTargetDocumentTypeId(C_DocType_ID);
            setIsSOTrx(true);
        }
    } //	setTargetDocumentTypeId

    /**
     * Set Target Document Type. Standard Order or PO
     */
    public void setTargetDocumentTypeId() {
        if (isSOTrx()) //	SO = Std Order
        {
            setTargetDocumentTypeId(DocSubTypeSO_Standard);
            return;
        }
        //	PO
        String sql =
                "SELECT C_DocType_ID FROM C_DocType "
                        + "WHERE AD_Client_ID=? AND AD_Org_ID IN (0,"
                        + getOrgId()
                        + ") AND DocBaseType='POO' "
                        + "ORDER BY AD_Org_ID DESC, IsDefault DESC";
        int C_DocType_ID = getSQLValue(sql, getClientId());
        if (C_DocType_ID <= 0) log.severe("No POO found for AD_Client_ID=" + getClientId());
        else {
            if (log.isLoggable(Level.FINE)) log.fine("(PO) - " + C_DocType_ID);
            setTargetDocumentTypeId(C_DocType_ID);
        }
    } //	setTargetDocumentTypeId

    /**
     * Set Business Partner Defaults & Details. SOTrx should be set.
     *
     * @param bp business partner
     */
    public void setBPartner(I_C_BPartner bp) {
        if (bp == null) return;

        setBusinessPartnerId(bp.getBusinessPartnerId());
        //	Defaults Payment Term
        int ii;
        if (isSOTrx()) ii = bp.getPaymentTermId();
        else ii = bp.getPurchaseOrderPaymentTermId();
        if (ii != 0) setPaymentTermId(ii);
        //	Default Price List
        if (isSOTrx()) ii = bp.getPriceListId();
        else ii = bp.getPurchaseOrderPriceListId();
        if (ii != 0) setPriceListId(ii);
        //	Default Delivery/Via Rule
        String ss = bp.getDeliveryRule();
        if (ss != null) setDeliveryRule(ss);
        ss = bp.getDeliveryViaRule();
        if (ss != null) setDeliveryViaRule(ss);
        //	Default Invoice/Payment Rule
        ss = bp.getInvoiceRule();
        if (ss != null) setInvoiceRule(ss);
        ss = bp.getPaymentRule();
        if (ss != null) setPaymentRule(ss);
        //	Sales Rep
        ii = bp.getSalesRepresentativeId();
        if (ii != 0) setSalesRepresentativeId(ii);

        //	Set Locations
        List<I_C_BPartner_Location> locs = bp.getLocations();
        if (locs != null) {
            for (I_C_BPartner_Location loc : locs) {
                if (loc.getIsShipTo())
                    super.setBusinessPartnerLocationId(loc.getBusinessPartnerLocationId());
                if (loc.getIsBillTo()) setBusinessPartnerInvoicingLocationId(loc.getBusinessPartnerLocationId());
            }
            //	set to first
            if (getBusinessPartnerLocationId() == 0 && locs.size() > 0)
                super.setBusinessPartnerLocationId(locs.get(0).getBusinessPartnerLocationId());
            if (getBusinessPartnerInvoicingLocationId() == 0 && locs.size() > 0)
                setBusinessPartnerInvoicingLocationId(locs.get(0).getBusinessPartnerLocationId());
        }
        if (getBusinessPartnerLocationId() == 0) {
            throw new BPartnerNoShipToAddressException(bp);
        }

        if (getBusinessPartnerInvoicingLocationId() == 0) {
            throw new BPartnerNoBillToAddressException(bp);
        }

        //	Set Contact
        List<I_AD_User> contacts = bp.getContacts();
        if (contacts != null && contacts.size() == 1) setUserId(contacts.get(0).getUserId());
    } //	setBPartner

    /**
     * Copy Lines From other Order
     *
     * @param otherOrder order
     * @param counter    set counter info
     * @param copyASI    copy line attributes Attribute Set Instance, Resaouce Assignment
     * @return number of lines copied
     */
    public int copyLinesFrom(MOrder otherOrder, boolean counter, boolean copyASI) {
        if (isProcessed() || isPosted() || otherOrder == null) return 0;
        MOrderLine[] fromLines = otherOrder.getLines(false, null);
        int count = 0;
        for (MOrderLine fromLine : fromLines) {
            MOrderLine line = new MOrderLine(this);
            copyValues(fromLine, line, getClientId(), getOrgId());
            line.setOrderId(getOrderId());
            //
            line.setQtyDelivered(Env.ZERO);
            line.setQtyInvoiced(Env.ZERO);
            line.setQtyReserved(Env.ZERO);
            line.setDateDelivered(null);
            line.setDateInvoiced(null);
            //
            line.setOrder(this);
            line.setValueNoCheck("C_OrderLine_ID", I_ZERO); // 	new
            //	References
            if (!copyASI) {
                line.setAttributeSetInstanceId(0);
                line.setS_ResourceAssignmentId(0);
            }
            if (counter) line.setRef_OrderLineId(fromLine.getOrderLineId());
            else line.setRef_OrderLineId(0);

            // don't copy linked lines
            line.setLink_OrderLineId(0);
            //	Tax
            if (getBusinessPartnerId() != otherOrder.getBusinessPartnerId()) line.setTax(); // 	recalculate
            //
            //
            line.setProcessed(false);
            if (line.save()) count++;
            //	Cross Link
            if (counter) {
                fromLine.setRef_OrderLineId(line.getOrderLineId());
                fromLine.saveEx();
            }
        }
        if (fromLines.length != count)
            log.log(Level.SEVERE, "Line difference - From=" + fromLines.length + " <> Saved=" + count);
        return count;
    } //	copyLinesFrom

    /**
     * ************************************************************************ String Representation
     *
     * @return info
     */
    public String toString() {
        return "MOrder[" +
                getId() +
                "-" +
                getDocumentNo() +
                ",IsSOTrx=" +
                isSOTrx() +
                ",C_DocType_ID=" +
                getDocumentTypeId() +
                ", GrandTotal=" +
                getGrandTotal() +
                "]";
    } //	toString

    /**
     * Get Document Info
     *
     * @return document info (untranslated)
     */
    public String getDocumentInfo() {
        MDocType dt =
                MDocType.get(getDocumentTypeId() > 0 ? getDocumentTypeId() : getTargetDocumentTypeId());
        return dt.getNameTrl() + " " + getDocumentNo();
    } //	getDocumentInfo

    /**
     * Set Price List (and Currency, TaxIncluded) when valid
     *
     * @param M_PriceList_ID price list
     */
    public void setPriceListId(int M_PriceList_ID) {
        MPriceList pl = MPriceList.get(M_PriceList_ID);
        if (pl.getId() == M_PriceList_ID) {
            super.setPriceListId(M_PriceList_ID);
            setCurrencyId(pl.getCurrencyId());
            setIsTaxIncluded(pl.isTaxIncluded());
        }
    } //	setPriceListId

    /**
     * ************************************************************************ Get Lines of Order
     *
     * @param whereClause where clause or null (starting with AND)
     * @param orderClause order clause
     * @return lines
     */
    public MOrderLine[] getLines(String whereClause, String orderClause) {
        // red1 - using new Query class from Teo / Victor's MDDOrder.java implementation
        StringBuilder whereClauseFinal = new StringBuilder(MOrderLine.COLUMNNAME_C_Order_ID + "=? ");
        if (!Util.isEmpty(whereClause, true)) whereClauseFinal.append(whereClause);
        if (orderClause.length() == 0) orderClause = MOrderLine.COLUMNNAME_Line;
        //
        List<MOrderLine> list =
                new Query(I_C_OrderLine.Table_Name, whereClauseFinal.toString())
                        .setParameters(getId())
                        .setOrderBy(orderClause)
                        .list();
        for (MOrderLine ol : list) {
            ol.setHeaderInfo(this);
        }
        //
        return list.toArray(new MOrderLine[0]);
    } //	getLines

    /**
     * Get Lines of Order
     *
     * @param requery requery
     * @param orderBy optional order by column
     * @return lines
     */
    public MOrderLine[] getLines(boolean requery, String orderBy) {
        if (m_lines != null && !requery) {
            return m_lines;
        }
        //
        String orderClause = "";
        if (orderBy != null && orderBy.length() > 0) orderClause += orderBy;
        else orderClause += "Line";
        m_lines = getLines(null, orderClause);
        return m_lines;
    } //	getLines

    /**
     * Get Lines of Order. (used by web store)
     *
     * @return lines
     */
    public MOrderLine[] getLines() {
        return getLines(false, null);
    } //	getLines

    /**
     * Renumber Lines
     *
     * @param step start and step
     */
    public void renumberLines(int step) {
        int number = step;
        MOrderLine[] lines = getLines(true, null); // 	Line is default
        for (MOrderLine line : lines) {
            line.setLine(number);
            line.saveEx();
            number += step;
        }
        m_lines = null;
    } //	renumberLines

    /**
     * Does the Order Line belong to this Order
     *
     * @param C_OrderLine_ID line
     * @return true if part of the order
     */
    public boolean isOrderLine(int C_OrderLine_ID) {
        if (m_lines == null) getLines();
        for (MOrderLine m_line : m_lines) if (m_line.getOrderLineId() == C_OrderLine_ID) return true;
        return false;
    } //	isOrderLine

    /**
     * Get Taxes of Order
     *
     * @param requery requery
     * @return array of taxes
     */
    public MOrderTax[] getTaxes(boolean requery) {
        if (m_taxes != null && !requery) return m_taxes;
        //
        List<MOrderTax> list =
                new Query(I_C_OrderTax.Table_Name, "C_Order_ID=?")
                        .setParameters(getId())
                        .list();
        m_taxes = list.toArray(new MOrderTax[0]);
        return m_taxes;
    } //	getTaxes

    /**
     * Get Invoices of Order
     *
     * @return invoices
     */
    public I_C_Invoice[] getInvoices() {
        final String whereClause =
                "EXISTS (SELECT 1 FROM C_InvoiceLine il, C_OrderLine ol"
                        + " WHERE il.C_Invoice_ID=C_Invoice.C_Invoice_ID"
                        + " AND il.C_OrderLine_ID=ol.C_OrderLine_ID"
                        + " AND ol.C_Order_ID=?)";
        List<PO> list =
                new Query(I_C_Invoice.Table_Name, whereClause)
                        .setParameters(getId())
                        .setOrderBy("C_Invoice_ID DESC")
                        .list();
        return list.toArray(new I_C_Invoice[0]);
    } //	getInvoices

    /**
     * Get latest Invoice of Order
     *
     * @return invoice id or 0
     */
    public int getInvoiceId() {
        String sql =
                "SELECT C_Invoice_ID FROM C_Invoice "
                        + "WHERE C_Order_ID=? AND DocStatus IN ('CO','CL') "
                        + "ORDER BY C_Invoice_ID DESC";
        return getSQLValue(sql, getId());
    } //	getInvoiceId

    /**
     * Get Shipments of Order
     *
     * @return shipments
     */
    public MInOut[] getShipments() {
        final String whereClause =
                "EXISTS (SELECT 1 FROM M_InOutLine iol, C_OrderLine ol"
                        + " WHERE iol.M_InOut_ID=M_InOut.M_InOut_ID"
                        + " AND iol.C_OrderLine_ID=ol.C_OrderLine_ID"
                        + " AND ol.C_Order_ID=?)";
        List<PO> list =
                new Query(I_M_InOut.Table_Name, whereClause)
                        .setParameters(getId())
                        .setOrderBy("M_InOut_ID DESC")
                        .list();
        return list.toArray(new MInOut[0]);
    } //	getShipments

    /**
     * Get Currency Precision
     *
     * @return precision
     */
    public int getPrecision() {
        return MCurrencyKt.getCurrencyStdPrecision(getCurrencyId());
    } //	getPrecision

    /**
     * Set DocAction
     *
     * @param DocAction doc action
     */
    public void setDocAction(String DocAction) {
        setDocAction(DocAction, false);
    } //	setDocAction

    /**
     * Set DocAction
     *
     * @param DocAction     doc action
     * @param forceCreation force creation
     */
    public void setDocAction(String DocAction, boolean forceCreation) {
        super.setDocAction(DocAction);
        m_forceCreation = forceCreation;
    } //	setDocAction

    /**
     * Set Processed. Propagate to Lines/Taxes
     *
     * @param processed processed
     */
    public void setProcessed(boolean processed) {
        super.setProcessed(processed);
        if (getId() == 0) return;
        String set =
                "SET Processed='" + (processed ? "Y" : "N") + "' WHERE C_Order_ID=" + getOrderId();
        int noLine = executeUpdateEx("UPDATE C_OrderLine " + set);
        int noTax = executeUpdateEx("UPDATE C_OrderTax " + set);
        m_lines = null;
        m_taxes = null;
        if (log.isLoggable(Level.FINE))
            log.fine("setProcessed - " + processed + " - Lines=" + noLine + ", Tax=" + noTax);
    } //	setProcessed

    /**
     * Validate Order Pay Schedule
     *
     * @return pay schedule is valid
     */
    public boolean validatePaySchedule() {
        MOrderPaySchedule[] schedule =
                MOrderPaySchedule.getOrderPaySchedule(getOrderId(), 0);
        if (log.isLoggable(Level.FINE)) log.fine("#" + schedule.length);
        if (schedule.length == 0) {
            setIsPayScheduleValid(false);
            return false;
        }
        //	Add up due amounts
        BigDecimal total = Env.ZERO;
        for (int i = 0; i < schedule.length; i++) {
            schedule[i].setParent(this);
            BigDecimal due = schedule[i].getDueAmt();
            if (due != null) total = total.add(due);
        }
        boolean valid = getGrandTotal().compareTo(total) == 0;
        setIsPayScheduleValid(valid);

        //	Update Schedule Lines
        for (MOrderPaySchedule mOrderPaySchedule : schedule) {
            if (mOrderPaySchedule.isValid() != valid) {
                mOrderPaySchedule.setIsValid(valid);
                mOrderPaySchedule.saveEx();
            }
        }
        return valid;
    } //	validatePaySchedule

    /**
     * ************************************************************************ Before Save
     *
     * @param newRecord new
     * @return save
     */
    protected boolean beforeSave(boolean newRecord) {
        //	Client/Org Check
        if (getOrgId() == 0) {
            int context_AD_Org_ID = Env.getOrgId();
            if (context_AD_Org_ID != 0) {
                setOrgId(context_AD_Org_ID);
                log.warning("Changed Org to Context=" + context_AD_Org_ID);
            }
        }
        if (getClientId() == 0) {
            m_processMsg = "AD_Client_ID = 0";
            return false;
        }

        //	New Record Doc Type - make sure DocType set to 0
        if (newRecord && getDocumentTypeId() == 0) setDocumentTypeId(0);

        //	Default Warehouse
        if (getWarehouseId() == 0) {
            int ii = Env.getContextAsInt("#M_Warehouse_ID");
            if (ii != 0) setWarehouseId(ii);
            else {
                throw new FillMandatoryException(COLUMNNAME_M_Warehouse_ID);
            }
        }

        boolean disallowNegInv = true;
        String DeliveryRule = getDeliveryRule();
        if ((disallowNegInv && DELIVERYRULE_Force.equals(DeliveryRule))
                || (DeliveryRule == null || DeliveryRule.length() == 0))
            setDeliveryRule(DELIVERYRULE_Availability);

        //	Reservations in Warehouse
        if (!newRecord && isValueChanged("M_Warehouse_ID")) {
            MOrderLine[] lines = getLines(false, null);
            for (MOrderLine line : lines) {
                if (!line.canChangeWarehouse()) return false;
            }
        }

        //	No Partner Info - set Template
        if (getBusinessPartnerId() == 0) setBPartner(MBPartner.getTemplate(getClientId()));
        if (getBusinessPartnerLocationId() == 0)
            setBPartner(new MBPartner(getBusinessPartnerId()));
        //	No Bill - get from Ship
        if (getBill_BPartnerId() == 0) {
            setBill_BPartnerId(getBusinessPartnerId());
            setBusinessPartnerInvoicingLocationId(getBusinessPartnerLocationId());
        }
        if (getBusinessPartnerInvoicingLocationId() == 0)
            setBusinessPartnerInvoicingLocationId(getBusinessPartnerLocationId());

        //	Default Price List
        if (getPriceListId() == 0) {
            int ii =
                    getSQLValueEx(
                            "SELECT M_PriceList_ID FROM M_PriceList "
                                    + "WHERE AD_Client_ID=? AND IsSOPriceList=? AND IsActive=?"
                                    + "ORDER BY IsDefault DESC",
                            getClientId(),
                            isSOTrx(),
                            true);
            if (ii != 0) setPriceListId(ii);
        }
        //	Default Currency
        if (getCurrencyId() == 0) {
            String sql = "SELECT C_Currency_ID FROM M_PriceList WHERE M_PriceList_ID=?";
            int ii = getSQLValue(sql, getPriceListId());
            if (ii != 0) setCurrencyId(ii);
            else setCurrencyId(Env.getContextAsInt("#C_Currency_ID"));
        }

        //	Default Sales Rep
        if (getSalesRepresentativeId() == 0) {
            int ii = Env.getContextAsInt("#SalesRep_ID");
            if (ii != 0) setSalesRepresentativeId(ii);
        }

        //	Default Document Type
        if (getTargetDocumentTypeId() == 0) setTargetDocumentTypeId(DocSubTypeSO_Standard);

        //	Default Payment Term
        if (getPaymentTermId() == 0) {
            int ii = Env.getContextAsInt("#C_PaymentTerm_ID");
            if (ii != 0) setPaymentTermId(ii);
            else {
                String sql =
                        "SELECT C_PaymentTerm_ID FROM C_PaymentTerm WHERE AD_Client_ID=? AND IsDefault='Y' AND IsActive='Y'";
                ii = getSQLValue(sql, getClientId());
                if (ii != 0) setPaymentTermId(ii);
            }
        }

        // IDEMPIERE-63
        // for documents that can be reactivated we cannot allow changing
        // C_DocTypeTarget_ID or C_DocType_ID if they were already processed and
        // isOverwriteSeqOnComplete
        // neither change the Date if isOverwriteDateOnComplete
        BigDecimal previousProcessedOn = (BigDecimal) getValueOld(COLUMNNAME_ProcessedOn);
        if (!newRecord && previousProcessedOn != null && previousProcessedOn.signum() > 0) {
            int previousDocTypeID = (Integer) getValueOld(COLUMNNAME_C_DocTypeTarget_ID);
            MDocType previousdt = MDocType.get(previousDocTypeID);
            if (isValueChanged(COLUMNNAME_C_DocType_ID)
                    || isValueChanged(COLUMNNAME_C_DocTypeTarget_ID)) {
                if (previousdt.isOverwriteSeqOnComplete()) {
                    log.saveError("Error", Msg.getMsg("CannotChangeProcessedDocType"));
                    return false;
                }
            }
            if (isValueChanged(COLUMNNAME_DateOrdered)) {
                if (previousdt.isOverwriteDateOnComplete()) {
                    log.saveError("Error", Msg.getMsg("CannotChangeProcessedDate"));
                    return false;
                }
            }
        }

        // IDEMPIERE-1597 Price List and Date must be not-updateable
        if (!newRecord
                && (isValueChanged(COLUMNNAME_M_PriceList_ID)
                || isValueChanged(COLUMNNAME_DateOrdered))) {
            int cnt =
                    getSQLValueEx(
                            "SELECT COUNT(*) FROM C_OrderLine WHERE C_Order_ID=? AND M_Product_ID>0",
                            getOrderId());
            if (cnt > 0) {
                if (isValueChanged(COLUMNNAME_M_PriceList_ID)) {
                    log.saveError("Error", Msg.getMsg("CannotChangePl"));
                    return false;
                }
                if (isValueChanged(COLUMNNAME_DateOrdered)) {
                    MPriceList pList = MPriceList.get(getPriceListId());
                    MPriceListVersion plOld =
                            pList.getPriceListVersion((Timestamp) getValueOld(COLUMNNAME_DateOrdered));
                    MPriceListVersion plNew =
                            pList.getPriceListVersion((Timestamp) getValue(COLUMNNAME_DateOrdered));
                    if (plNew == null || !plNew.equals(plOld)) {
                        log.saveError("Error", Msg.getMsg("CannotChangeDateOrdered"));
                        return false;
                    }
                }
            }
        }

        if (!recursiveCall && (!newRecord && isValueChanged(COLUMNNAME_C_PaymentTerm_ID))) {
            recursiveCall = true;
            try {
                MPaymentTerm pt = new MPaymentTerm(getPaymentTermId());
                boolean valid = pt.applyOrder(this);
                setIsPayScheduleValid(valid);
            } finally {
                recursiveCall = false;
            }
        }

        return true;
    } //	beforeSave

    /**
     * After Save
     *
     * @param newRecord new
     * @param success   success
     * @return true if can be saved
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success || newRecord) return success;

        // TODO: The changes here with UPDATE are not being saved on change log - audit problem

        //	Propagate Description changes
        if (isValueChanged("Description") || isValueChanged("POReference")) {
            String sql =
                    "UPDATE C_Invoice i"
                            + " SET (Description,POReference)="
                            + "(SELECT Description,POReference "
                            + "FROM C_Order o WHERE i.C_Order_ID=o.C_Order_ID) "
                            + "WHERE DocStatus NOT IN ('RE','CL') AND C_Order_ID="
                            + getOrderId();
            int no = executeUpdateEx(sql);
            if (log.isLoggable(Level.FINE)) log.fine("Description -> #" + no);
        }

        //	Propagate Changes of Payment Info to existing (not reversed/closed) invoices
        if (isValueChanged("PaymentRule")
                || isValueChanged("C_PaymentTerm_ID")
                || isValueChanged("C_Payment_ID")
                || isValueChanged("C_CashLine_ID")) {
            String sql =
                    "UPDATE C_Invoice i "
                            + "SET (PaymentRule,C_PaymentTerm_ID,C_Payment_ID,C_CashLine_ID)="
                            + "(SELECT PaymentRule,C_PaymentTerm_ID,C_Payment_ID,C_CashLine_ID "
                            + "FROM C_Order o WHERE i.C_Order_ID=o.C_Order_ID)"
                            + "WHERE DocStatus NOT IN ('RE','CL') AND C_Order_ID="
                            + getOrderId();
            //	Don't touch Closed/Reversed entries
            int no = executeUpdate(sql);
            if (log.isLoggable(Level.FINE)) log.fine("Payment -> #" + no);
        }

        //	Propagate Changes of Date Account to existing (not completed/reversed/closed) invoices
        if (isValueChanged("DateAcct")) {
            String sql =
                    "UPDATE C_Invoice i "
                            + "SET (DateAcct)="
                            + "(SELECT DateAcct "
                            + "FROM C_Order o WHERE i.C_Order_ID=o.C_Order_ID)"
                            + "WHERE DocStatus NOT IN ('CO','RE','CL') AND Processed='N' AND C_Order_ID="
                            + getOrderId();
            //	Don't touch Completed/Closed/Reversed entries
            int no = executeUpdate(sql);
            if (log.isLoggable(Level.FINE)) log.fine("DateAcct -> #" + no);
        }

        //	Sync Lines
        if (isValueChanged("AD_Org_ID")
                || isValueChanged(COLUMNNAME_C_BPartner_ID)
                || isValueChanged(COLUMNNAME_C_BPartner_Location_ID)
                || isValueChanged(COLUMNNAME_DateOrdered)
                || isValueChanged(COLUMNNAME_DatePromised)
                || isValueChanged(COLUMNNAME_M_Warehouse_ID)
                || isValueChanged(COLUMNNAME_M_Shipper_ID)
                || isValueChanged(COLUMNNAME_C_Currency_ID)) {
            MOrderLine[] lines = getLines();
            for (MOrderLine line : lines) {
                if (isValueChanged("AD_Org_ID")) line.setOrgId(getOrgId());
                if (isValueChanged(COLUMNNAME_C_BPartner_ID)) line.setBusinessPartnerId(getBusinessPartnerId());
                if (isValueChanged(COLUMNNAME_C_BPartner_Location_ID))
                    line.setBusinessPartnerLocationId(getBusinessPartnerLocationId());
                if (isValueChanged(COLUMNNAME_DateOrdered)) line.setDateOrdered(getDateOrdered());
                if (isValueChanged(COLUMNNAME_DatePromised)) line.setDatePromised(getDatePromised());
                if (isValueChanged(COLUMNNAME_M_Warehouse_ID)) line.setWarehouseId(getWarehouseId());
                if (isValueChanged(COLUMNNAME_M_Shipper_ID)) line.setShipperId(getShipperId());
                if (isValueChanged(COLUMNNAME_C_Currency_ID)) line.setCurrencyId(getCurrencyId());
                line.saveEx();
            }
        }
        //
        return true;
    } //	afterSave

    /**
     * Before Delete
     *
     * @return true of it can be deleted
     */
    protected boolean beforeDelete() {
        return !isProcessed();// automatic deletion of lines is driven by model cascade definition in dictionary - see
        // IDEMPIERE-2060
    } //	beforeDelete

    protected boolean calculateFreightCharge() {
        MClientInfo ci = MClientInfo.get(getClientId());
        if (ci.getChargeFreightId() == 0 && ci.getProductFreightId() == 0) {
            m_processMsg =
                    "Product or Charge for Freight is not defined at Client window > Client Info tab";
            return false;
        }

        MOrderLine[] ols = getLines(false, MOrderLine.COLUMNNAME_Line);
        if (ols.length == 0) {
            m_processMsg = "@NoLines@";
            return false;
        }

        MOrderLine freightLine = null;
        for (MOrderLine ol : ols) {
            if ((ol.getProductId() > 0 && ol.getProductId() == ci.getProductFreightId())
                    || (ol.getChargeId() > 0 && ol.getChargeId() == ci.getChargeFreightId())) {
                freightLine = ol;
                break;
            }
        }

        switch (getFreightCostRule()) {
            case FREIGHTCOSTRULE_FreightIncluded:
                if (freightLine != null) {
                    boolean deleted = freightLine.delete(false);
                    if (!deleted) {
                        freightLine.setBusinessPartnerLocationId(getBusinessPartnerLocationId());
                        freightLine.setShipperId(getShipperId());
                        freightLine.setQty(BigDecimal.ONE);
                        freightLine.setPrice(BigDecimal.ZERO);
                        freightLine.saveEx();
                    }
                }
                break;
            case FREIGHTCOSTRULE_FixPrice:
                if (freightLine == null) {
                    freightLine = new MOrderLine(this);

                    if (ci.getChargeFreightId() > 0) freightLine.setChargeId(ci.getChargeFreightId());
                    else if (ci.getProductFreightId() > 0)
                        freightLine.setProductId(ci.getProductFreightId());
                    else
                        throw new AdempiereException(
                                "Product or Charge for Freight is not defined at Client window > Client Info tab");
                }

                freightLine.setBusinessPartnerLocationId(getBusinessPartnerLocationId());
                freightLine.setShipperId(getShipperId());
                freightLine.setQty(BigDecimal.ONE);
                freightLine.setPrice(getFreightAmt());
                freightLine.saveEx();
                break;
            case FREIGHTCOSTRULE_Calculated:
                if (ci.getUOMWeightId() == 0) {
                    m_processMsg = "UOM for Weight is not defined at Client window > Client Info tab";
                    return false;
                }
                if (ci.getUOMLengthId() == 0) {
                    m_processMsg = "UOM for Length is not defined at Client window > Client Info ta";
                    return false;
                }

                for (MOrderLine ol : ols) {
                    if ((ol.getProductId() <= 0 || ol.getProductId() != ci.getProductFreightId())
                            && (ol.getChargeId() <= 0 || ol.getChargeId() != ci.getChargeFreightId())) {
                        if (ol.getProductId() > 0) {
                            MProduct product = new MProduct(ol.getProductId());

                            BigDecimal weight = product.getWeight();
                            if (weight == null || weight.compareTo(BigDecimal.ZERO) == 0) {
                                m_processMsg = "No weight defined for product " + product.toString();
                                return false;
                            }
                        }
                    }
                }

                boolean ok = false;
                MShippingTransaction st = null;
                try {
                    st =
                            createShippingTransaction(

                                    this,
                                    MShippingTransaction.ACTION_RateInquiry,
                                    isPriviledgedRate()
                            );
                    ok = st.processOnline();
                    st.saveEx();
                } catch (Exception e) {
                    log.log(Level.SEVERE, "processOnline", e);
                }

                if (ok) {
                    if (freightLine == null) {
                        freightLine = new MOrderLine(this);

                        if (ci.getChargeFreightId() > 0)
                            freightLine.setChargeId(ci.getChargeFreightId());
                        else if (ci.getProductFreightId() > 0)
                            freightLine.setProductId(ci.getProductFreightId());
                        else
                            throw new AdempiereException(
                                    "Product or Charge for Freight is not defined at Client window > Client Info tab");
                    }

                    freightLine.setBusinessPartnerLocationId(getBusinessPartnerLocationId());
                    freightLine.setShipperId(getShipperId());
                    freightLine.setQty(BigDecimal.ONE);
                    freightLine.setPrice(st.getPrice());
                    freightLine.saveEx();
                } else {
                    m_processMsg = st.getErrorMessage();
                    return false;
                }
                break;
        }

        return true;
    }

    /**
     * Explode non stocked BOM.
     *
     * @return true if bom exploded
     */
    protected boolean explodeBOM() {
        boolean retValue = false;
        String where =
                "AND IsActive='Y' AND EXISTS "
                        + "(SELECT * FROM M_Product p WHERE C_OrderLine.M_Product_ID=p.M_Product_ID"
                        + " AND	p.IsBOM='Y' AND p.IsVerified='Y' AND p.IsStocked='N')";
        //
        String sql = "SELECT COUNT(*) FROM C_OrderLine " + "WHERE C_Order_ID=? " + where;
        int count = getSQLValue(sql, getOrderId());
        while (count != 0) {
            retValue = true;
            renumberLines(1000); // 	max 999 bom items

            //	Order Lines with non-stocked BOMs
            MOrderLine[] lines = getLines(where, MOrderLine.COLUMNNAME_Line);
            for (MOrderLine line : lines) {
                MProduct product = MProduct.get(line.getProductId());
                if (log.isLoggable(Level.FINE)) log.fine(product.getName());
                //	New Lines
                int lineNo = line.getLine();

                for (MProductBOM bom : MProductBOM.getBOMLines(product)) {
                    MOrderLine newLine = new MOrderLine(this);
                    newLine.setLine(++lineNo);
                    newLine.setProductId(bom.getBOMProductId(), true);
                    newLine.setQty(line.getQtyOrdered().multiply(bom.getBOMQty()));
                    if (bom.getDescription() != null) newLine.setDescription(bom.getDescription());
                    newLine.setPrice();
                    newLine.saveEx();
                }

                //	Convert into Comment Line
                line.setProductId(0);
                line.setAttributeSetInstanceId(0);
                line.setPrice(Env.ZERO);
                line.setPriceLimit(Env.ZERO);
                line.setPriceList(Env.ZERO);
                line.setLineNetAmt(Env.ZERO);
                line.setFreightAmt(Env.ZERO);
                //
                String description = product.getName();
                if (product.getDescription() != null) description += " " + product.getDescription();
                if (line.getDescription() != null) description += " " + line.getDescription();
                line.setDescription(description);
                line.saveEx();
            } //	for all lines with BOM

            m_lines = null; // 	force requery
            count = getSQLValue(sql, getInvoiceId());
            renumberLines(10);
        } //	while count != 0
        return retValue;
    } //	explodeBOM

    /**
     * Calculate Tax and Total
     *
     * @return true if tax total calculated
     */
    public boolean calculateTaxTotal() {
        log.fine("");
        //	Delete Taxes
        executeUpdateEx("DELETE C_OrderTax WHERE C_Order_ID=" + getOrderId());
        m_taxes = null;

        MTaxProvider[] providers = getTaxProviders();
        for (MTaxProvider provider : providers) {
            ITaxProvider calculator = MTaxProvider.getTaxProvider(provider, new StandardTaxProvider());
            if (calculator == null) throw new AdempiereException(Msg.getMsg("TaxNoProvider"));

            if (!calculator.calculateOrderTaxTotal(provider, this)) return false;
        }
        return true;
    } //	calculateTaxTotal

    /**
     * (Re) Create Pay Schedule
     *
     * @return true if valid schedule
     */
    protected boolean createPaySchedule() {
        if (getPaymentTermId() == 0) return false;
        MPaymentTerm pt = new MPaymentTerm(getPaymentTermId());
        if (log.isLoggable(Level.FINE)) log.fine(pt.toString());

        int numSchema = pt.getSchedule(false).length;

        MOrderPaySchedule[] schedule =
                MOrderPaySchedule.getOrderPaySchedule(getOrderId(), 0);

        if (schedule.length > 0) {
            if (numSchema == 0)
                return false; // created a schedule for a payment term that doesn't manage schedule
            return validatePaySchedule();
        } else {
            boolean isValid = pt.applyOrder(this); // 	calls validate pay schedule
            if (numSchema == 0) return true; // no schedule, no schema, OK
            else return isValid;
        }
    } //	createPaySchedule

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
     * Get Process Message
     *
     * @return clear text error message
     */
    public String getProcessMsg() {
        return m_processMsg;
    } //	getProcessMsg

    /**
     * Document Status is Complete or Closed
     *
     * @return true if CO, CL or RE
     */
    public boolean isComplete() {
        String ds = getDocStatus();
        return DOCSTATUS_Completed.equals(ds)
                || DOCSTATUS_Closed.equals(ds)
                || DOCSTATUS_Reversed.equals(ds);
    } //	isComplete

    /**
     * Get tax providers
     *
     * @return array of tax provider
     */
    public MTaxProvider[] getTaxProviders() {
        Hashtable<Integer, MTaxProvider> providers = new Hashtable<Integer, MTaxProvider>();
        MOrderLine[] lines = getLines();
        for (MOrderLine line : lines) {
            MTax tax = new MTax(line.getTaxId());
            MTaxProvider provider = providers.get(tax.getTaxProviderId());
            if (provider == null)
                providers.put(
                        tax.getTaxProviderId(),
                        new MTaxProvider(tax.getTaxProviderId()));
        }

        MTaxProvider[] retValue = new MTaxProvider[providers.size()];
        providers.values().toArray(retValue);
        return retValue;
    }

    @Override
    public int getTableId() {
        return I_C_Order.Table_ID;
    }
} //	MOrder
