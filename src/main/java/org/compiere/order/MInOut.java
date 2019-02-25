package org.compiere.order;

import org.compiere.crm.MBPartner;
import org.compiere.crm.MUser;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_Invoice;
import org.compiere.model.I_M_InOutConfirm;
import org.compiere.model.I_M_InOutLine;
import org.compiere.orm.MDocType;
import org.compiere.orm.PO;
import org.compiere.orm.Query;
import org.compiere.util.Msg;
import org.idempiere.common.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import static software.hsharp.core.orm.POKt.I_ZERO;
import static software.hsharp.core.util.DBKt.*;

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
    protected MInOutLine[] m_lines = null;
    /**
     * Confirmations
     */
    protected MInOutConfirm[] m_confirms = null;
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
     * @param ctx        context
     * @param M_InOut_ID
     * @param trxName    rx name
     */
    public MInOut(Properties ctx, int M_InOut_ID) {
        super(ctx, M_InOut_ID);
        if (M_InOut_ID == 0) {
            //	setDocumentNo (null);
            //	setC_BPartner_ID (0);
            //	setC_BPartner_Location_ID (0);
            //	setWarehouseId (0);
            //	setC_DocType_ID (0);
            setIsSOTrx(false);
            setMovementDate(new Timestamp(System.currentTimeMillis()));
            setDateAcct(getMovementDate());
            //	setMovementType (MOVEMENTTYPE_CustomerShipment);
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
     *
     * @param ctx     context
     * @param rs      result set record
     * @param trxName transaction
     */
    public MInOut(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    } //	MInOut

    /**
     * Order Constructor - create header only
     *
     * @param order                order
     * @param movementDate         optional movement date (default today)
     * @param C_DocTypeShipment_ID document type or 0
     */
    public MInOut(MOrder order, int C_DocTypeShipment_ID, Timestamp movementDate) {
        this(order.getCtx(), 0);
        setClientOrg(order);
        setC_BPartner_ID(order.getC_BPartner_ID());
        setC_BPartner_Location_ID(order.getC_BPartner_Location_ID()); // 	shipment address
        setAD_User_ID(order.getAD_User_ID());
        //
        setM_Warehouse_ID(order.getM_Warehouse_ID());
        setIsSOTrx(order.isSOTrx());
        if (C_DocTypeShipment_ID == 0)
            C_DocTypeShipment_ID =
                    getSQLValue(
                            null,
                            "SELECT C_DocTypeShipment_ID FROM C_DocType WHERE C_DocType_ID=?",
                            order.getC_DocType_ID());
        setC_DocType_ID(C_DocTypeShipment_ID);

        // patch suggested by Armen
        // setMovementType (order.isSOTrx() ? MOVEMENTTYPE_CustomerShipment :
        // MOVEMENTTYPE_VendorReceipts);
        String movementTypeShipment = null;
        MDocType dtShipment = new MDocType(order.getCtx(), C_DocTypeShipment_ID);
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
        setC_Order_ID(order.getC_Order_ID());
        setDeliveryRule(order.getDeliveryRule());
        setDeliveryViaRule(order.getDeliveryViaRule());
        setM_Shipper_ID(order.getM_Shipper_ID());
        setFreightCostRule(order.getFreightCostRule());
        setFreightAmt(order.getFreightAmt());
        setSalesRep_ID(order.getSalesRep_ID());
        //
        setC_Activity_ID(order.getC_Activity_ID());
        setC_Campaign_ID(order.getC_Campaign_ID());
        setC_Charge_ID(order.getC_Charge_ID());
        setChargeAmt(order.getChargeAmt());
        //
        setC_Project_ID(order.getC_Project_ID());
        setDateOrdered(order.getDateOrdered());
        setDescription(order.getDescription());
        setPOReference(order.getPOReference());
        setSalesRep_ID(order.getSalesRep_ID());
        setAD_OrgTrx_ID(order.getAD_OrgTrx_ID());
        setUser1_ID(order.getUser1_ID());
        setUser2_ID(order.getUser2_ID());
        setPriorityRule(order.getPriorityRule());
        // Drop shipment
        setIsDropShip(order.isDropShip());
        setDropShip_BPartner_ID(order.getDropShip_BPartner_ID());
        setDropShip_Location_ID(order.getDropShip_Location_ID());
        setDropShip_User_ID(order.getDropShip_User_ID());
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
        this(invoice.getCtx(), 0);
        setClientOrg(invoice);
        setC_BPartner_ID(invoice.getC_BPartner_ID());
        setC_BPartner_Location_ID(invoice.getC_BPartner_Location_ID()); // 	shipment address
        setAD_User_ID(invoice.getAD_User_ID());
        //
        setM_Warehouse_ID(M_Warehouse_ID);
        setIsSOTrx(invoice.isSOTrx());
        setMovementType(
                invoice.isSOTrx()
                        ? X_M_InOut.MOVEMENTTYPE_CustomerShipment
                        : X_M_InOut.MOVEMENTTYPE_VendorReceipts);
        MOrder order = null;
        if (invoice.getC_Order_ID() != 0)
            order = new MOrder(invoice.getCtx(), invoice.getC_Order_ID());
        if (C_DocTypeShipment_ID == 0 && order != null)
            C_DocTypeShipment_ID =
                    getSQLValue(
                            null,
                            "SELECT C_DocTypeShipment_ID FROM C_DocType WHERE C_DocType_ID=?",
                            order.getC_DocType_ID());
        if (C_DocTypeShipment_ID != 0) setC_DocType_ID(C_DocTypeShipment_ID);
        else setC_DocType_ID();

        //	Default - Today
        if (movementDate != null) setMovementDate(movementDate);
        setDateAcct(getMovementDate());

        //	Copy from Invoice
        setC_Order_ID(invoice.getC_Order_ID());
        setSalesRep_ID(invoice.getSalesRep_ID());
        //
        setC_Activity_ID(invoice.getC_Activity_ID());
        setC_Campaign_ID(invoice.getC_Campaign_ID());
        setC_Charge_ID(invoice.getC_Charge_ID());
        setChargeAmt(invoice.getChargeAmt());
        //
        setC_Project_ID(invoice.getC_Project_ID());
        setDateOrdered(invoice.getDateOrdered());
        setDescription(invoice.getDescription());
        setPOReference(invoice.getPOReference());
        setAD_OrgTrx_ID(invoice.getAD_OrgTrx_ID());
        setUser1_ID(invoice.getUser1_ID());
        setUser2_ID(invoice.getUser2_ID());

        if (order != null) {
            setDeliveryRule(order.getDeliveryRule());
            setDeliveryViaRule(order.getDeliveryViaRule());
            setM_Shipper_ID(order.getM_Shipper_ID());
            setFreightCostRule(order.getFreightCostRule());
            setFreightAmt(order.getFreightAmt());

            // Drop Shipment
            setIsDropShip(order.isDropShip());
            setDropShip_BPartner_ID(order.getDropShip_BPartner_ID());
            setDropShip_Location_ID(order.getDropShip_Location_ID());
            setDropShip_User_ID(order.getDropShip_User_ID());
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
        this(original.getCtx(), 0);
        setClientOrg(original);
        setC_BPartner_ID(original.getC_BPartner_ID());
        setC_BPartner_Location_ID(original.getC_BPartner_Location_ID()); // 	shipment address
        setAD_User_ID(original.getAD_User_ID());
        //
        setM_Warehouse_ID(original.getM_Warehouse_ID());
        setIsSOTrx(original.isSOTrx());
        setMovementType(original.getMovementType());
        if (C_DocTypeShipment_ID == 0) setC_DocType_ID(original.getC_DocType_ID());
        else setC_DocType_ID(C_DocTypeShipment_ID);

        //	Default - Today
        if (movementDate != null) setMovementDate(movementDate);
        setDateAcct(getMovementDate());

        //	Copy from Order
        setC_Order_ID(original.getC_Order_ID());
        setDeliveryRule(original.getDeliveryRule());
        setDeliveryViaRule(original.getDeliveryViaRule());
        setM_Shipper_ID(original.getM_Shipper_ID());
        setFreightCostRule(original.getFreightCostRule());
        setFreightAmt(original.getFreightAmt());
        setSalesRep_ID(original.getSalesRep_ID());
        //
        setC_Activity_ID(original.getC_Activity_ID());
        setC_Campaign_ID(original.getC_Campaign_ID());
        setC_Charge_ID(original.getC_Charge_ID());
        setChargeAmt(original.getChargeAmt());
        //
        setC_Project_ID(original.getC_Project_ID());
        setDateOrdered(original.getDateOrdered());
        setDescription(original.getDescription());
        setPOReference(original.getPOReference());
        setSalesRep_ID(original.getSalesRep_ID());
        setAD_OrgTrx_ID(original.getAD_OrgTrx_ID());
        setUser1_ID(original.getUser1_ID());
        setUser2_ID(original.getUser2_ID());

        // DropShipment
        setIsDropShip(original.isDropShip());
        setDropShip_BPartner_ID(original.getDropShip_BPartner_ID());
        setDropShip_Location_ID(original.getDropShip_Location_ID());
        setDropShip_User_ID(original.getDropShip_User_ID());
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
            StringBuilder msgd = new StringBuilder(desc).append(" | ").append(description);
            setDescription(msgd.toString());
        }
    } //	addDescription

    /**
     * String representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb =
                new StringBuilder("MInOut[")
                        .append(getId())
                        .append("-")
                        .append(getDocumentNo())
                        .append(",DocStatus=")
                        .append(getDocStatus())
                        .append("]");
        return sb.toString();
    } //	toString

    /**
     * Get Lines of Shipment
     *
     * @param requery refresh from db
     * @return lines
     */
    public MInOutLine[] getLines(boolean requery) {
        if (m_lines != null && !requery) {
            return m_lines;
        }
        List<MInOutLine> list =
                new Query(getCtx(), I_M_InOutLine.Table_Name, "M_InOut_ID=?")
                        .setParameters(getM_InOut_ID())
                        .setOrderBy(MInOutLine.COLUMNNAME_Line)
                        .list();
        //
        m_lines = new MInOutLine[list.size()];
        list.toArray(m_lines);
        return m_lines;
    } //	getMInOutLines

    /**
     * Get Lines of Shipment
     *
     * @return lines
     */
    public MInOutLine[] getLines() {
        return getLines(false);
    } //	getLines

    /**
     * Get Confirmations
     *
     * @param requery requery
     * @return array of Confirmations
     */
    public MInOutConfirm[] getConfirmations(boolean requery) {
        if (m_confirms != null && !requery) {
            return m_confirms;
        }
        List<MInOutConfirm> list =
                new Query(getCtx(), I_M_InOutConfirm.Table_Name, "M_InOut_ID=?")
                        .setParameters(getM_InOut_ID())
                        .list();
        m_confirms = new MInOutConfirm[list.size()];
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
        MInOutLine[] fromLines = otherShipment.getLines(false);
        int count = 0;
        for (int i = 0; i < fromLines.length; i++) {
            MInOutLine line = new MInOutLine(this);
            MInOutLine fromLine = fromLines[i];
            if (counter) //	header
                PO.copyValues(fromLine, line, getClientId(), getOrgId());
            else PO.copyValues(fromLine, line, fromLine.getClientId(), fromLine.getOrgId());
            line.setM_InOut_ID(getM_InOut_ID());
            line.set_ValueNoCheck("M_InOutLine_ID", I_ZERO); // 	new
            //	Reset
            if (!setOrder) {
                line.setC_OrderLine_ID(0);
                line.setM_RMALine_ID(0); // Reset RMA Line
            }
            if (!counter) line.setM_AttributeSetInstance_ID(0);
            //	line.setS_ResourceAssignment_ID(0);
            line.setRef_InOutLine_ID(0);
            line.setIsInvoiced(false);
            //
            line.setConfirmedQty(Env.ZERO);
            line.setPickedQty(Env.ZERO);
            line.setScrappedQty(Env.ZERO);
            line.setTargetQty(Env.ZERO);
            //	Set Locator based on header Warehouse
            if (getM_Warehouse_ID() != otherShipment.getM_Warehouse_ID()) {
                line.setM_Locator_ID(0);
                line.setM_Locator_ID(Env.ZERO);
            }
            //
            if (counter) {
                line.setRef_InOutLine_ID(fromLine.getM_InOutLine_ID());
                if (fromLine.getC_OrderLine_ID() != 0) {
                    MOrderLine peer = new MOrderLine(getCtx(), fromLine.getC_OrderLine_ID());
                    if (peer.getRef_OrderLine_ID() != 0) line.setC_OrderLine_ID(peer.getRef_OrderLine_ID());
                }
                // RMALine link
                if (fromLine.getM_RMALine_ID() != 0) {
                    MRMALine peer = new MRMALine(getCtx(), fromLine.getM_RMALine_ID());
                    if (peer.getRef_RMALine_ID() > 0) line.setM_RMALine_ID(peer.getRef_RMALine_ID());
                }
            }

            line.setQtyOverReceipt(fromLine.getQtyOverReceipt());

            //
            line.setProcessed(false);
            if (line.save()) count++;
            //	Cross Link
            if (counter) {
                fromLine.setRef_InOutLine_ID(line.getM_InOutLine_ID());
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
        StringBuilder sql =
                new StringBuilder("UPDATE M_InOutLine SET Processed='")
                        .append((processed ? "Y" : "N"))
                        .append("' WHERE M_InOut_ID=")
                        .append(getM_InOut_ID());
        int noLine = executeUpdate(sql.toString());
        m_lines = null;
        if (log.isLoggable(Level.FINE)) log.fine(processed + " - Lines=" + noLine);
    } //	setProcessed

    /**
     * Set Business Partner Defaults & Details
     *
     * @param bp business partner
     */
    public void setBPartner(MBPartner bp) {
        if (bp == null) return;

        setC_BPartner_ID(bp.getC_BPartner_ID());

        //	Set Locations
        I_C_BPartner_Location[] locs = bp.getLocations(false);
        if (locs != null) {
            for (int i = 0; i < locs.length; i++) {
                if (locs[i].isShipTo()) setC_BPartner_Location_ID(locs[i].getC_BPartner_Location_ID());
            }
            //	set to first if not set
            if (getC_BPartner_Location_ID() == 0 && locs.length > 0)
                setC_BPartner_Location_ID(locs[0].getC_BPartner_Location_ID());
        }
        if (getC_BPartner_Location_ID() == 0) log.log(Level.SEVERE, "Has no To Address: " + bp);

        //	Set Contact
        MUser[] contacts = bp.getContacts(false);
        if (contacts != null && contacts.length > 0) // 	get first User
            setAD_User_ID(contacts[0].getUserId());
    } //	setBPartner

    /**
     * Set Document Type
     *
     * @param DocBaseType doc type MDocType.DOCBASETYPE_
     */
    public void setC_DocType_ID(String DocBaseType) {
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
            setC_DocType_ID(C_DocType_ID);
            boolean isSOTrx = MDocType.DOCBASETYPE_MaterialDelivery.equals(DocBaseType);
            setIsSOTrx(isSOTrx);
        }
    } //	setC_DocType_ID

    /**
     * Set Default C_DocType_ID. Based on SO flag
     */
    public void setC_DocType_ID() {
        if (isSOTrx()) setC_DocType_ID(MDocType.DOCBASETYPE_MaterialDelivery);
        else setC_DocType_ID(MDocType.DOCBASETYPE_MaterialReceipt);
    } //	setC_DocType_ID

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
        if (getC_Order_ID() != 0 && getM_RMA_ID() != 0) {
            log.saveError("OrderOrRMA", "");
            return false;
        }

        String movementType = getMovementType();
        boolean condition1 =
                movementType != null && !movementType.contentEquals(X_M_InOut.MOVEMENTTYPE_CustomerReturns);
        //	Shipment - Needs Order/RMA
        if (condition1 && isSOTrx() && getC_Order_ID() == 0 && getM_RMA_ID() == 0) {
            log.saveError("FillMandatory", Msg.translate(getCtx(), "C_Order_ID"));
            return false;
        }

        if (isSOTrx() && getM_RMA_ID() != 0) {
            // Set Document and Movement type for this Receipt
            MRMA rma = new MRMA(getCtx(), getM_RMA_ID());
            MDocType docType = MDocType.get(getCtx(), rma.getC_DocType_ID());
            setC_DocType_ID(docType.getDocTypeShipmentId());
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

        if (is_ValueChanged("AD_Org_ID")) {
            final String sql =
                    "UPDATE M_InOutLine ol"
                            + " SET AD_Org_ID ="
                            + "(SELECT AD_Org_ID"
                            + " FROM M_InOut o WHERE ol.M_InOut_ID=o.M_InOut_ID) "
                            + "WHERE M_InOut_ID=?";
            int no = executeUpdateEx(sql, new Object[]{getM_InOut_ID()});
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
