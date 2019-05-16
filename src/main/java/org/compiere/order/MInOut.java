package org.compiere.order;

import kotliquery.Row;
import org.compiere.crm.MBPartner;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.User;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_Invoice;
import org.compiere.model.I_M_InOutConfirm;
import org.compiere.model.I_M_InOutLine;
import org.compiere.orm.MDocType;
import org.compiere.orm.MDocTypeKt;
import org.compiere.orm.PO;
import org.compiere.orm.Query;
import org.compiere.util.MsgKt;
import org.idempiere.common.util.Env;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;

import static software.hsharp.core.orm.POKt.I_ZERO;
import static software.hsharp.core.util.DBKt.executeUpdate;
import static software.hsharp.core.util.DBKt.executeUpdateEx;
import static software.hsharp.core.util.DBKt.getSQLValue;

/**
 * Shipment Model
 *
 * @author Jorg Janke
 * @author Karsten Thiemann, Schaeffer AG
 * <li>Bug [ 1759431 ] Problems with VCreateFrom
 * @author victor.perez@e-evolution.com, e-Evolution http://www.e-evolution.com
 * <li>FR [ 1948157 ] Is necessary the reference for document reverse
 * <li>FR [ 2520591 ] Support multiples calendar for Org
 * @author Armen Rizal, Goodwill Consulting
 * <li>BF [ 1745154 ] Cost in Reversing Material Related Docs
 * @author Teo Sarca, teo.sarca@gmail.com
 * <li>BF [ 2993853 ] Voiding/Reversing Receipt should void confirmations
 * https://sourceforge.net/tracker/?func=detail&atid=879332&aid=2993853&group_id=176962
 * @version $Id: MInOut.java,v 1.4 2006/07/30 00:51:03 jjanke Exp $
 * <p>Modifications: Added the RMA functionality (Ashley Ramdass)
 * @see http://sourceforge.net/tracker2/?func=detail&atid=879335&aid=2520591&group_id=176962
 * @see http://sourceforge.net/tracker/?func=detail&atid=879335&aid=1948157&group_id=176962
 */
public class MInOut extends X_M_InOut {
    /**
     *
     */
    private static final long serialVersionUID = 1226522383231204912L;
    /**
     * Lines
     */
    protected I_M_InOutLine[] m_lines = null;
    /**
     * Confirmations
     */
    protected I_M_InOutConfirm[] m_confirms = null;
    /**
     * Reversal Flag
     */
    protected boolean m_reversal = false;
    /**
     * Process Message
     */
    protected String m_processMsg = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param M_InOut_ID
     */
    public MInOut(int M_InOut_ID) {
        super(M_InOut_ID);
        if (M_InOut_ID == 0) {
            setIsSOTrx(false);
            setMovementDate(new Timestamp(System.currentTimeMillis()));
            setDateAcct(getMovementDate());
            setDeliveryRule(X_M_InOut.DELIVERYRULE_Availability);
            setDeliveryViaRule(X_M_InOut.DELIVERYVIARULE_Pickup);
            setFreightCostRule(X_M_InOut.FREIGHTCOSTRULE_FreightIncluded);
            setDocStatus(X_M_InOut.DOCSTATUS_Drafted);
            setDocAction(X_M_InOut.DOCACTION_Complete);
            setPriorityRule(X_M_InOut.PRIORITYRULE_Medium);
            setNoPackages(0);
            setIsInTransit(false);
            setIsPrinted(false);
            setSendEMail(false);
            setIsInDispute(false);
            //
            setIsApproved(false);
            super.setProcessed(false);
            setProcessing(false);
            setPosted(false);
        }
    } //	MInOut

    /**
     * Load Constructor
     */
    public MInOut(Row row) {
        super(row);
    } //	MInOut

    /**
     * Order Constructor - create header only
     *
     * @param order                order
     * @param movementDate         optional movement date (default today)
     * @param C_DocTypeShipment_ID document type or 0
     */
    public MInOut(MOrder order, int C_DocTypeShipment_ID, Timestamp movementDate) {
        this(0);
        setClientOrg(order);
        setBusinessPartnerId(order.getBusinessPartnerId());
        setBusinessPartnerLocationId(order.getBusinessPartnerLocationId()); // 	shipment address
        setUserId(order.getUserId());
        //
        setWarehouseId(order.getWarehouseId());
        setIsSOTrx(order.isSOTrx());
        if (C_DocTypeShipment_ID == 0)
            C_DocTypeShipment_ID =
                    getSQLValue(
                            "SELECT C_DocTypeShipment_ID FROM C_DocType WHERE C_DocType_ID=?",
                            order.getDocumentTypeId());
        setDocumentTypeId(C_DocTypeShipment_ID);

        // patch suggested by Armen
        // setMovementType (order.isSOTrx() ? MOVEMENTTYPE_CustomerShipment :
        // MOVEMENTTYPE_VendorReceipts);
        String movementTypeShipment = null;
        MDocType dtShipment = new MDocType(C_DocTypeShipment_ID);
        if (dtShipment.getDocBaseType().equals(MDocType.DOCBASETYPE_MaterialDelivery))
            movementTypeShipment =
                    dtShipment.isSOTrx()
                            ? X_M_InOut.MOVEMENTTYPE_CustomerShipment
                            : X_M_InOut.MOVEMENTTYPE_VendorReturns;
        else if (dtShipment.getDocBaseType().equals(MDocType.DOCBASETYPE_MaterialReceipt))
            movementTypeShipment =
                    dtShipment.isSOTrx()
                            ? X_M_InOut.MOVEMENTTYPE_CustomerReturns
                            : X_M_InOut.MOVEMENTTYPE_VendorReceipts;
        setMovementType(movementTypeShipment);

        //	Default - Today
        if (movementDate != null) setMovementDate(movementDate);
        setDateAcct(getMovementDate());

        //	Copy from Order
        setOrderId(order.getOrderId());
        setDeliveryRule(order.getDeliveryRule());
        setDeliveryViaRule(order.getDeliveryViaRule());
        setShipperId(order.getShipperId());
        setFreightCostRule(order.getFreightCostRule());
        setFreightAmt(order.getFreightAmt());
        setSalesRepresentativeId(order.getSalesRepresentativeId());
        //
        setBusinessActivityId(order.getBusinessActivityId());
        setCampaignId(order.getCampaignId());
        setChargeId(order.getChargeId());
        setChargeAmt(order.getChargeAmt());
        //
        setProjectId(order.getProjectId());
        setDateOrdered(order.getDateOrdered());
        setDescription(order.getDescription());
        setPOReference(order.getPOReference());
        setSalesRepresentativeId(order.getSalesRepresentativeId());
        setTransactionOrganizationId(order.getTransactionOrganizationId());
        setUser1Id(order.getUser1Id());
        setUser2Id(order.getUser2Id());
        setPriorityRule(order.getPriorityRule());
        // Drop shipment
        setIsDropShip(order.isDropShip());
        setDropShipBPartnerId(order.getDropShipBPartnerId());
        setDropShipLocationId(order.getDropShipLocationId());
        setDropShipUserId(order.getDropShipUserId());
    } //	MInOut

    /**
     * Invoice Constructor - create header only
     *
     * @param invoice              invoice
     * @param C_DocTypeShipment_ID document type or 0
     * @param movementDate         optional movement date (default today)
     * @param M_Warehouse_ID       warehouse
     */
    public MInOut(
            I_C_Invoice invoice, int C_DocTypeShipment_ID, Timestamp movementDate, int M_Warehouse_ID) {
        this(0);
        setClientOrg(invoice);
        setBusinessPartnerId(invoice.getBusinessPartnerId());
        setBusinessPartnerLocationId(invoice.getBusinessPartnerLocationId()); // 	shipment address
        setUserId(invoice.getUserId());
        //
        setWarehouseId(M_Warehouse_ID);
        setIsSOTrx(invoice.isSOTrx());
        setMovementType(
                invoice.isSOTrx()
                        ? X_M_InOut.MOVEMENTTYPE_CustomerShipment
                        : X_M_InOut.MOVEMENTTYPE_VendorReceipts);
        MOrder order = null;
        if (invoice.getOrderId() != 0)
            order = new MOrder(invoice.getOrderId());
        if (C_DocTypeShipment_ID == 0 && order != null)
            C_DocTypeShipment_ID =
                    getSQLValue(
                            "SELECT C_DocTypeShipment_ID FROM C_DocType WHERE C_DocType_ID=?",
                            order.getDocumentTypeId());
        if (C_DocTypeShipment_ID != 0) setDocumentTypeId(C_DocTypeShipment_ID);
        else setDocumentTypeId();

        //	Default - Today
        if (movementDate != null) setMovementDate(movementDate);
        setDateAcct(getMovementDate());

        //	Copy from Invoice
        setOrderId(invoice.getOrderId());
        setSalesRepresentativeId(invoice.getSalesRepresentativeId());
        //
        setBusinessActivityId(invoice.getBusinessActivityId());
        setCampaignId(invoice.getCampaignId());
        setChargeId(invoice.getChargeId());
        setChargeAmt(invoice.getChargeAmt());
        //
        setProjectId(invoice.getProjectId());
        setDateOrdered(invoice.getDateOrdered());
        setDescription(invoice.getDescription());
        setPOReference(invoice.getPOReference());
        setTransactionOrganizationId(invoice.getTransactionOrganizationId());
        setUser1Id(invoice.getUser1Id());
        setUser2Id(invoice.getUser2Id());

        if (order != null) {
            setDeliveryRule(order.getDeliveryRule());
            setDeliveryViaRule(order.getDeliveryViaRule());
            setShipperId(order.getShipperId());
            setFreightCostRule(order.getFreightCostRule());
            setFreightAmt(order.getFreightAmt());

            // Drop Shipment
            setIsDropShip(order.isDropShip());
            setDropShipBPartnerId(order.getDropShipBPartnerId());
            setDropShipLocationId(order.getDropShipLocationId());
            setDropShipUserId(order.getDropShipUserId());
        }
    } //	MInOut

    /**
     * Copy Constructor - create header only
     *
     * @param original             original
     * @param movementDate         optional movement date (default today)
     * @param C_DocTypeShipment_ID document type or 0
     */
    public MInOut(MInOut original, int C_DocTypeShipment_ID, Timestamp movementDate) {
        this(0);
        setClientOrg(original);
        setBusinessPartnerId(original.getBusinessPartnerId());
        setBusinessPartnerLocationId(original.getBusinessPartnerLocationId()); // 	shipment address
        setUserId(original.getUserId());
        //
        setWarehouseId(original.getWarehouseId());
        setIsSOTrx(original.isSOTrx());
        setMovementType(original.getMovementType());
        if (C_DocTypeShipment_ID == 0) setDocumentTypeId(original.getDocumentTypeId());
        else setDocumentTypeId(C_DocTypeShipment_ID);

        //	Default - Today
        if (movementDate != null) setMovementDate(movementDate);
        setDateAcct(getMovementDate());

        //	Copy from Order
        setOrderId(original.getOrderId());
        setDeliveryRule(original.getDeliveryRule());
        setDeliveryViaRule(original.getDeliveryViaRule());
        setShipperId(original.getShipperId());
        setFreightCostRule(original.getFreightCostRule());
        setFreightAmt(original.getFreightAmt());
        setSalesRepresentativeId(original.getSalesRepresentativeId());
        //
        setBusinessActivityId(original.getBusinessActivityId());
        setCampaignId(original.getCampaignId());
        setChargeId(original.getChargeId());
        setChargeAmt(original.getChargeAmt());
        //
        setProjectId(original.getProjectId());
        setDateOrdered(original.getDateOrdered());
        setDescription(original.getDescription());
        setPOReference(original.getPOReference());
        setSalesRepresentativeId(original.getSalesRepresentativeId());
        setTransactionOrganizationId(original.getTransactionOrganizationId());
        setUser1Id(original.getUser1Id());
        setUser2Id(original.getUser2Id());

        // DropShipment
        setIsDropShip(original.isDropShip());
        setDropShipBPartnerId(original.getDropShipBPartnerId());
        setDropShipLocationId(original.getDropShipLocationId());
        setDropShipUserId(original.getDropShipUserId());
    } //	MInOut

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
     * String representation
     *
     * @return info
     */
    public String toString() {
        return "MInOut[" +
                getId() +
                "-" +
                getDocumentNo() +
                ",DocStatus=" +
                getDocStatus() +
                "]";
    } //	toString

    /**
     * Get Lines of Shipment
     *
     * @param requery refresh from db
     * @return lines
     */
    public I_M_InOutLine[] getLines(boolean requery) {
        if (m_lines != null && !requery) {
            return m_lines;
        }
        List<I_M_InOutLine> list =
                new Query<I_M_InOutLine>(I_M_InOutLine.Table_Name, "M_InOut_ID=?")
                        .setParameters(getInOutId())
                        .setOrderBy(MInOutLine.COLUMNNAME_Line)
                        .list();
        //
        m_lines = new I_M_InOutLine[list.size()];
        list.toArray(m_lines);
        return m_lines;
    } //	getMInOutLines

    /**
     * Get Lines of Shipment
     *
     * @return lines
     */
    public I_M_InOutLine[] getLines() {
        return getLines(false);
    } //	getLines

    /**
     * Get Confirmations
     *
     * @param requery requery
     * @return array of Confirmations
     */
    public I_M_InOutConfirm[] getConfirmations(boolean requery) {
        if (m_confirms != null && !requery) {
            return m_confirms;
        }
        List<I_M_InOutConfirm> list =
                new Query<I_M_InOutConfirm>(I_M_InOutConfirm.Table_Name, "M_InOut_ID=?")
                        .setParameters(getInOutId())
                        .list();
        m_confirms = new I_M_InOutConfirm[list.size()];
        list.toArray(m_confirms);
        return m_confirms;
    } //	getConfirmations

    /**
     * Copy Lines From other Shipment
     *
     * @param otherShipment shipment
     * @param counter       set counter info
     * @param setOrder      set order link
     * @return number of lines copied
     */
    public int copyLinesFrom(MInOut otherShipment, boolean counter, boolean setOrder) {
        if (isProcessed() || isPosted() || otherShipment == null) return 0;
        I_M_InOutLine[] fromLines = otherShipment.getLines(false);
        int count = 0;
        for (I_M_InOutLine fromLine : fromLines) {
            MInOutLine line = new MInOutLine(this);
            if (counter) //	header
                PO.copyValues((PO)fromLine, line, getClientId(), getOrgId());
            else PO.copyValues((PO)fromLine, line, fromLine.getClientId(), fromLine.getOrgId());
            line.setInOutId(getInOutId());
            line.setValueNoCheck("M_InOutLine_ID", I_ZERO); // 	new
            //	Reset
            if (!setOrder) {
                line.setOrderLineId(0);
                line.setRMALineId(0); // Reset RMA Line
            }
            if (!counter) line.setAttributeSetInstanceId(0);
            //	line.setS_ResourceAssignmentId(0);
            line.setReferencedInOutLineId(0);
            line.setIsInvoiced(false);
            //
            line.setConfirmedQty(Env.ZERO);
            line.setPickedQty(Env.ZERO);
            line.setScrappedQty(Env.ZERO);
            line.setTargetQty(Env.ZERO);
            //	Set Locator based on header Warehouse
            if (getWarehouseId() != otherShipment.getWarehouseId()) {
                line.setLocatorId(0);
                line.setLocatorId(Env.ZERO);
            }
            //
            if (counter) {
                line.setReferencedInOutLineId(fromLine.getInOutLineId());
                if (fromLine.getOrderLineId() != 0) {
                    MOrderLine peer = new MOrderLine(fromLine.getOrderLineId());
                    if (peer.getRef_OrderLineId() != 0) line.setOrderLineId(peer.getRef_OrderLineId());
                }
                // RMALine link
                if (fromLine.getRMALineId() != 0) {
                    MRMALine peer = new MRMALine(fromLine.getRMALineId());
                    if (peer.getRef_RMALineId() > 0) line.setRMALineId(peer.getRef_RMALineId());
                }
            }

            line.setQtyOverReceipt(fromLine.getQtyOverReceipt());

            //
            line.setProcessed(false);
            if (line.save()) count++;
            //	Cross Link
            if (counter) {
                fromLine.setReferencedInOutLineId(line.getInOutLineId());
                fromLine.saveEx();
            }
        }
        if (fromLines.length != count) {
            log.log(Level.SEVERE, "Line difference - From=" + fromLines.length + " <> Saved=" + count);
            count = -1; // caller must validate error in count and rollback accordingly - BF [3160928]
        }
        return count;
    } //	copyLinesFrom

    /**
     * Is Reversal
     *
     * @return reversal
     */
    public boolean isReversal() {
        return m_reversal;
    } //	isReversal

    /**
     * Set Reversal
     *
     * @param reversal reversal
     */
    protected void setReversal(boolean reversal) {
        m_reversal = reversal;
    } //	setReversal

    /**
     * Set Processed. Propagate to Lines/Taxes
     *
     * @param processed processed
     */
    public void setProcessed(boolean processed) {
        super.setProcessed(processed);
        if (getId() == 0) return;
        String sql = "UPDATE M_InOutLine SET Processed='" +
                (processed ? "Y" : "N") +
                "' WHERE M_InOut_ID=" +
                getInOutId();
        int noLine = executeUpdate(sql);
        m_lines = null;
        if (log.isLoggable(Level.FINE)) log.fine(processed + " - Lines=" + noLine);
    } //	setProcessed

    @Override
    public boolean voidIt() {
        throw new Error("Use org.compiere.invoicing.MInOut if you need to voidIt()");
    }

    @Override
    public boolean reverseCorrectIt() {
        throw new Error("Use org.compiere.invoicing.MInOut if you need to reverseCorrectIt()");
    }

    /**
     * Set Business Partner Defaults & Details
     *
     * @param bp business partner
     */
    public void setBPartner(I_C_BPartner bp) {
        if (bp == null) return;

        setBusinessPartnerId(bp.getBusinessPartnerId());

        //	Set Locations
        List<I_C_BPartner_Location> locs = bp.getLocations();
        if (locs != null) {
            for (I_C_BPartner_Location loc : locs) {
                if (loc.getIsShipTo()) setBusinessPartnerLocationId(loc.getBusinessPartnerLocationId());
            }
            //	set to first if not set
            if (getBusinessPartnerLocationId() == 0 && locs.size() > 0)
                setBusinessPartnerLocationId(locs.get(0).getBusinessPartnerLocationId());
        }
        if (getBusinessPartnerLocationId() == 0) log.log(Level.SEVERE, "Has no To Address: " + bp);

        //	Set Contact
        List<User> contacts = bp.getContacts();
        if (contacts != null && contacts.size() == 1) setUserId(contacts.get(0).getUserId());
    } //	setBPartner

    /**
     * Set Document Type
     *
     * @param DocBaseType doc type MDocType.DOCBASETYPE_
     */
    public void setDocumentTypeId(String DocBaseType) {
        String sql =
                "SELECT C_DocType_ID FROM C_DocType "
                        + "WHERE AD_Client_ID=? AND DocBaseType=?"
                        + " AND IsActive='Y'"
                        + " AND IsSOTrx='"
                        + (isSOTrx() ? "Y" : "N")
                        + "' "
                        + "ORDER BY IsDefault DESC";
        int C_DocType_ID = getSQLValue(sql, getClientId(), DocBaseType);
        if (C_DocType_ID <= 0)
            log.log(Level.SEVERE, "Not found for AC_Client_ID=" + getClientId() + " - " + DocBaseType);
        else {
            if (log.isLoggable(Level.FINE))
                log.fine("DocBaseType=" + DocBaseType + " - C_DocType_ID=" + C_DocType_ID);
            setDocumentTypeId(C_DocType_ID);
            boolean isSOTrx = MDocType.DOCBASETYPE_MaterialDelivery.equals(DocBaseType);
            setIsSOTrx(isSOTrx);
        }
    } //	setDocumentTypeId

    /**
     * Set Default C_DocType_ID. Based on SO flag
     */
    public void setDocumentTypeId() {
        if (isSOTrx()) setDocumentTypeId(MDocType.DOCBASETYPE_MaterialDelivery);
        else setDocumentTypeId(MDocType.DOCBASETYPE_MaterialReceipt);
    } //	setDocumentTypeId

    /**
     * Before Save
     *
     * @param newRecord new
     * @return true or false
     */
    protected boolean beforeSave(boolean newRecord) {
        boolean disallowNegInv = true;
        String DeliveryRule = getDeliveryRule();
        if ((disallowNegInv && X_M_InOut.DELIVERYRULE_Force.equals(DeliveryRule))
                || (DeliveryRule == null || DeliveryRule.length() == 0))
            setDeliveryRule(X_M_InOut.DELIVERYRULE_Availability);

        // Shipment/Receipt can have either Order/RMA (For Movement type)
        if (getOrderId() != 0 && getRMAId() != 0) {
            log.saveError("OrderOrRMA", "");
            return false;
        }

        String movementType = getMovementType();
        boolean condition1 =
                movementType != null && !movementType.contentEquals(X_M_InOut.MOVEMENTTYPE_CustomerReturns);
        //	Shipment - Needs Order/RMA
        if (condition1 && isSOTrx() && getOrderId() == 0 && getRMAId() == 0) {
            log.saveError("FillMandatory", MsgKt.translate("C_Order_ID"));
            return false;
        }

        if (isSOTrx() && getRMAId() != 0) {
            // Set Document and Movement type for this Receipt
            MRMA rma = new MRMA(getRMAId());
            MDocType docType = MDocTypeKt.getDocumentType(rma.getDocumentTypeId());
            setDocumentTypeId(docType.getDocTypeShipmentId());
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
        if (!success || newRecord) return success;

        if (isValueChanged("AD_Org_ID")) {
            final String sql =
                    "UPDATE M_InOutLine ol"
                            + " SET AD_Org_ID ="
                            + "(SELECT AD_Org_ID"
                            + " FROM M_InOut o WHERE ol.M_InOut_ID=o.M_InOut_ID) "
                            + "WHERE M_InOut_ID=?";
            int no = executeUpdateEx(sql, new Object[]{getInOutId()});
            if (log.isLoggable(Level.FINE)) log.fine("Lines -> #" + no);
        }
        return true;
    } //	afterSave

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
        return X_M_InOut.DOCSTATUS_Completed.equals(ds)
                || X_M_InOut.DOCSTATUS_Closed.equals(ds)
                || X_M_InOut.DOCSTATUS_Reversed.equals(ds);
    } //	isComplete
} //	MInOut
