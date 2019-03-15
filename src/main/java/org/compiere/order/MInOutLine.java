package org.compiere.order;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeSet;
import org.compiere.model.I_M_InOutLine;
import org.compiere.product.MAttributeSetInstance;
import org.compiere.product.MProduct;
import org.compiere.product.MUOM;
import org.compiere.util.Msg;
import org.idempiere.common.exceptions.FillMandatoryException;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.util.Properties;

import static software.hsharp.core.util.DBKt.getSQLValueEx;

/**
 * InOut Line
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 * <li>BF [ 2784194 ] Check Warehouse-Locator conflict
 * https://sourceforge.net/tracker/?func=detail&aid=2784194&group_id=176962&atid=879332
 * @version $Id: MInOutLine.java,v 1.5 2006/07/30 00:51:03 jjanke Exp $
 */
public class MInOutLine extends X_M_InOutLine {
    /**
     *
     */
    private static final long serialVersionUID = 8630611882798722864L;
    /**
     * Product
     */
    private MProduct m_product = null;
    /**
     * Warehouse
     */
    private int m_M_Warehouse_ID = 0;
    /**
     * Parent
     */
    private MInOut m_parent = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx            context
     * @param M_InOutLine_ID id
     * @param trxName        trx name
     */
    public MInOutLine(Properties ctx, int M_InOutLine_ID) {
        super(ctx, M_InOutLine_ID);
        if (M_InOutLine_ID == 0) {
            //	setLine (0);
            //	setM_Locator_ID (0);
            //	setC_UOM_ID (0);
            //	setM_Product_ID (0);
            setM_AttributeSetInstance_ID(0);
            //	setMovementQty (Env.ZERO);
            setConfirmedQty(Env.ZERO);
            setPickedQty(Env.ZERO);
            setScrappedQty(Env.ZERO);
            setTargetQty(Env.ZERO);
            setIsInvoiced(false);
            setIsDescription(false);
        }
    } //	MInOutLine

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set record
     * @param trxName transaction
     */
    public MInOutLine(Properties ctx, Row row) {
        super(ctx, row);
    } //	MInOutLine

    /**
     * Parent Constructor
     *
     * @param inout parent
     */
    public MInOutLine(MInOut inout) {
        this(inout.getCtx(), 0);
        setClientOrg(inout);
        setM_InOut_ID(inout.getM_InOut_ID());
        setWarehouseId(inout.getWarehouseId());
        setProjectId(inout.getProjectId());
        m_parent = inout;
    } //	MInOutLine

    /**
     * Get Parent
     *
     * @return parent
     */
    public MInOut getParent() {
        if (m_parent == null) m_parent = new MInOut(getCtx(), getM_InOut_ID());
        return m_parent;
    } //	getParent

    /**
     * Set Order Line. Does not set Quantity!
     *
     * @param oLine        order line
     * @param M_Locator_ID locator
     * @param Qty          used only to find suitable locator
     */
    public void setOrderLine(MOrderLine oLine, int M_Locator_ID, BigDecimal Qty) {
        setC_OrderLine_ID(oLine.getC_OrderLine_ID());
        setLine(oLine.getLine());
        setC_UOM_ID(oLine.getC_UOM_ID());
        MProduct product = oLine.getProduct();
        if (product == null) {
            setValueNoCheck("M_Product_ID", null);
            setValueNoCheck("M_AttributeSetInstance_ID", null);
            setValueNoCheck("M_Locator_ID", null);
        } else {
            setM_Product_ID(oLine.getM_Product_ID());
            setM_AttributeSetInstance_ID(oLine.getMAttributeSetInstance_ID());
            //
            if (product.isItem()) {
                if (M_Locator_ID == 0) setM_Locator_ID(Qty); // 	requires warehouse, product, asi
                else setM_Locator_ID(M_Locator_ID);
            } else setValueNoCheck("M_Locator_ID", null);
        }
        setChargeId(oLine.getChargeId());
        setDescription(oLine.getDescription());
        setIsDescription(oLine.isDescription());
        //
        setProjectId(oLine.getProjectId());
        setC_ProjectPhase_ID(oLine.getC_ProjectPhase_ID());
        setC_ProjectTask_ID(oLine.getC_ProjectTask_ID());
        setBusinessActivityId(oLine.getBusinessActivityId());
        setCampaignId(oLine.getCampaignId());
        setTransactionOrganizationId(oLine.getTransactionOrganizationId());
        setUser1Id(oLine.getUser1Id());
        setUser2Id(oLine.getUser2Id());
    } //	setOrderLine

    /**
     * Get Warehouse
     *
     * @return Returns the m_Warehouse_ID.
     */
    public int getWarehouseId() {
        if (m_M_Warehouse_ID == 0) m_M_Warehouse_ID = getParent().getWarehouseId();
        return m_M_Warehouse_ID;
    } //	getWarehouseId

    /**
     * Set Warehouse
     *
     * @param warehouse_ID The m_Warehouse_ID to set.
     */
    public void setWarehouseId(int warehouse_ID) {
        m_M_Warehouse_ID = warehouse_ID;
    } //	setWarehouseId

    /**
     * Set M_Locator_ID
     *
     * @param M_Locator_ID id
     */
    @Override
    public void setM_Locator_ID(int M_Locator_ID) {
        if (M_Locator_ID < 0) throw new IllegalArgumentException("M_Locator_ID is mandatory.");
        //	set to 0 explicitly to reset
        setValue(I_M_InOutLine.COLUMNNAME_M_Locator_ID, new Integer(M_Locator_ID));
    } //	setM_Locator_ID

    /**
     * Set Movement/Movement Qty
     *
     * @param Qty Entered/Movement Qty
     */
    public void setQty(BigDecimal Qty) {
        setQtyEntered(Qty);
        setMovementQty(getQtyEntered());
    } //	setQtyInvoiced

    /**
     * Set Qty Entered - enforce entered UOM
     *
     * @param QtyEntered
     */
    public void setQtyEntered(BigDecimal QtyEntered) {
        if (QtyEntered != null && getC_UOM_ID() != 0) {
            int precision = MUOM.getPrecision(getCtx(), getC_UOM_ID());
            QtyEntered = QtyEntered.setScale(precision, BigDecimal.ROUND_HALF_UP);
        }
        super.setQtyEntered(QtyEntered);
    } //	setQtyEntered

    /**
     * Set Movement Qty - enforce Product UOM
     *
     * @param MovementQty
     */
    public void setMovementQty(BigDecimal MovementQty) {
        MProduct product = getProduct();
        if (MovementQty != null && product != null) {
            int precision = product.getUOMPrecision();
            MovementQty = MovementQty.setScale(precision, BigDecimal.ROUND_HALF_UP);
        }
        super.setMovementQty(MovementQty);
    } //	setMovementQty

    /**
     * Get Product
     *
     * @return product or null
     */
    public MProduct getProduct() {
        if (m_product == null && getM_Product_ID() != 0)
            m_product = MProduct.get(getCtx(), getM_Product_ID());
        return m_product;
    } //	getProduct

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
     * Get C_Project_ID
     *
     * @return project
     */
    public int getProjectId() {
        int ii = super.getProjectId();
        if (ii == 0) ii = getParent().getProjectId();
        return ii;
    } //	getProjectId

    /**
     * Get C_Activity_ID
     *
     * @return Activity
     */
    public int getBusinessActivityId() {
        int ii = super.getBusinessActivityId();
        if (ii == 0) ii = getParent().getBusinessActivityId();
        return ii;
    } //	getBusinessActivityId

    /**
     * Get C_Campaign_ID
     *
     * @return Campaign
     */
    public int getCampaignId() {
        int ii = super.getCampaignId();
        if (ii == 0) ii = getParent().getCampaignId();
        return ii;
    } //	getCampaignId

    /**
     * Get User2_ID
     *
     * @return User2
     */
    public int getUser1Id() {
        int ii = super.getUser1Id();
        if (ii == 0) ii = getParent().getUser1Id();
        return ii;
    } //	getUser1Id

    /**
     * Get User2_ID
     *
     * @return User2
     */
    public int getUser2Id() {
        int ii = super.getUser2Id();
        if (ii == 0) ii = getParent().getUser2Id();
        return ii;
    } //	getUser2Id

    /**
     * Get AD_OrgTrx_ID
     *
     * @return trx org
     */
    public int getTransactionOrganizationId() {
        int ii = super.getTransactionOrganizationId();
        if (ii == 0) ii = getParent().getTransactionOrganizationId();
        return ii;
    } //	getTransactionOrganizationId

    /**
     * ************************************************************************ Before Save
     *
     * @param newRecord new
     * @return save
     */
    protected boolean beforeSave(boolean newRecord) {
        log.fine("");
        if (newRecord && getParent().isComplete()) {
            log.saveError("ParentComplete", Msg.translate(getCtx(), "M_InOutLine"));
            return false;
        }
        // Locator is mandatory if no charge is defined - teo_sarca BF [ 2757978 ]
        if (getProduct() != null && MProduct.PRODUCTTYPE_Item.equals(getProduct().getProductType())) {
            if (getM_Locator_ID() <= 0 && getChargeId() <= 0) {
                throw new FillMandatoryException(I_M_InOutLine.COLUMNNAME_M_Locator_ID);
            }
        }

        //	Get Line No
        if (getLine() == 0) {
            String sql = "SELECT COALESCE(MAX(Line),0)+10 FROM M_InOutLine WHERE M_InOut_ID=?";
            int ii = getSQLValueEx(null, sql, getM_InOut_ID());
            setLine(ii);
        }
        //	UOM
        if (getC_UOM_ID() == 0) setC_UOM_ID(Env.getContextAsInt(getCtx(), "#C_UOM_ID"));
        if (getC_UOM_ID() == 0) {
            int C_UOM_ID = MUOM.getDefault_UOM_ID(getCtx());
            if (C_UOM_ID > 0) setC_UOM_ID(C_UOM_ID);
        }
        //	Qty Precision
        if (newRecord || is_ValueChanged("QtyEntered")) setQtyEntered(getQtyEntered());
        if (newRecord || is_ValueChanged("MovementQty")) setMovementQty(getMovementQty());

        //	Order/RMA Line
        if (getC_OrderLine_ID() == 0 && getM_RMALine_ID() == 0) {
            if (getParent().isSOTrx()) {
                log.saveError("FillMandatory", Msg.translate(getCtx(), "C_Order_ID"));
                return false;
            }
        }

        I_M_AttributeSet attributeset = getM_Product().getMAttributeSet();
        boolean isAutoGenerateLot = false;
        if (attributeset != null) isAutoGenerateLot = attributeset.isAutoGenerateLot();
        if (getReversalLine_ID() == 0
                && !getParent().isSOTrx()
                && !getParent().getMovementType().equals(MInOut.MOVEMENTTYPE_VendorReturns)
                && isAutoGenerateLot
                && getMAttributeSetInstance_ID() == 0) {
            MAttributeSetInstance asi =
                    MAttributeSetInstance.generateLot(getCtx(), (MProduct) getM_Product());
            setM_AttributeSetInstance_ID(asi.getMAttributeSetInstance_ID());
        }
        //	if (getChargeId() == 0 && getM_Product_ID() == 0)
        //		;

        /**
         * Qty on instance ASI if (getMAttributeSetInstance_ID() != 0) { MProduct product =
         * getProduct(); int M_AttributeSet_ID = product.getMAttributeSet_ID(); boolean isInstance =
         * M_AttributeSet_ID != 0; if (isInstance) { MAttributeSet mas = MAttributeSet.get(getCtx(),
         * M_AttributeSet_ID); isInstance = mas.isInstanceAttribute(); } // Max if (isInstance) {
         * MStorage storage = MStorage.get(getCtx(), getM_Locator_ID(), getM_Product_ID(),
         * getMAttributeSetInstance_ID(), null); if (storage != null) { BigDecimal qty =
         * storage.getQtyOnHand(); if (getMovementQty().compareTo(qty) > 0) { log.warning("Qty - Stock="
         * + qty + ", Movement=" + getMovementQty()); log.saveError("QtyInsufficient", "=" + qty);
         * return false; } } } } /*
         */

        /* Carlos Ruiz - globalqss
         * IDEMPIERE-178 Orders and Invoices must disallow amount lines without product/charge
         */
        if (getParent().getDocumentType().isChargeOrProductMandatory()) {
            if (getChargeId() == 0 && getM_Product_ID() == 0) {
                log.saveError("FillMandatory", Msg.translate(getCtx(), "ChargeOrProductMandatory"));
                return false;
            }
        }

        return true;
    } //	beforeSave

    /**
     * Before Delete
     *
     * @return true if drafted
     */
    protected boolean beforeDelete() {
        if (getParent().getDocStatus().equals(MInOut.DOCSTATUS_Drafted)) return true;
        log.saveError("Error", Msg.getMsg(getCtx(), "CannotDelete"));
        return false;
    } //	beforeDelete

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb =
                new StringBuilder("MInOutLine[")
                        .append(getId())
                        .append(",M_Product_ID=")
                        .append(getM_Product_ID())
                        .append(",QtyEntered=")
                        .append(getQtyEntered())
                        .append(",MovementQty=")
                        .append(getMovementQty())
                        .append(",M_AttributeSetInstance_ID=")
                        .append(getMAttributeSetInstance_ID())
                        .append("]");
        return sb.toString();
    } //	toString

    public boolean sameOrderLineUOM() {
        if (getC_OrderLine_ID() <= 0) return false;

        MOrderLine oLine = new MOrderLine(getCtx(), getC_OrderLine_ID());

        return oLine.getC_UOM_ID() == getC_UOM_ID();// inout has orderline and both has the same UOM
    }

    /* 	Set (default) Locator based on qty.
     * 	@param Qty quantity
     * 	Assumes Warehouse is set
     */
    public void setM_Locator_ID(BigDecimal Qty) {
        //	Locator established
        if (getM_Locator_ID() != 0) return;
        //	No Product
        if (getM_Product_ID() == 0) {
            setValueNoCheck(I_M_InOutLine.COLUMNNAME_M_Locator_ID, null);
            return;
        }
    } //	setM_Locator_ID
} //	MInOutLine
