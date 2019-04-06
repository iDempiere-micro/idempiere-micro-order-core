package org.compiere.order;

import kotliquery.Row;
import org.compiere.bo.MCurrency;
import org.compiere.bo.MCurrencyKt;
import org.compiere.model.IDocLine;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_C_OrderLine;
import org.compiere.orm.MRole;
import org.compiere.product.IProductPricing;
import org.compiere.product.MAttributeSet;
import org.compiere.product.MPriceList;
import org.compiere.product.MProduct;
import org.compiere.product.MUOM;
import org.compiere.product.ProductNotOnPriceListException;
import org.compiere.tax.ITaxProvider;
import org.compiere.tax.MTax;
import org.compiere.tax.MTaxCategory;
import org.compiere.tax.MTaxProvider;
import org.compiere.tax.Tax;
import org.compiere.util.Msg;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.getSQLValue;

/**
 * Order Line Model. <code>
 * MOrderLine ol = new MOrderLine(m_order);
 * ol.setProductId(wbl.getProductId());
 * ol.setQtyOrdered(wbl.getQuantity());
 * ol.setPrice();
 * ol.setPriceActual(wbl.getPrice());
 * ol.setTax();
 * ol.saveEx();
 *
 * </code>
 *
 * @author Jorg Janke
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 * <li>BF [ 2588043 ] Insufficient message ProductNotOnPriceList
 * @author Michael Judd, www.akunagroup.com
 * <li>BF [ 1733602 ] Price List including Tax Error - when a user changes the orderline or
 * invoice line for a product on a price list that includes tax, the net amount is
 * incorrectly calculated.
 * @version $Id: MOrderLine.java,v 1.6 2006/10/02 05:18:39 jjanke Exp $
 */
public class MOrderLine extends X_C_OrderLine implements I_C_OrderLine, IDocLine {
    /**
     *
     */
    private static final long serialVersionUID = -7152360636393521683L;

    protected int m_M_PriceList_ID = 0;
    //
    protected boolean m_IsSOTrx = true;
    //	Product Pricing
    protected IProductPricing m_productPrice = null;
    /**
     * Tax
     */
    protected MTax m_tax = null;
    /**
     * Cached Currency Precision
     */
    protected Integer m_precision = null;
    /**
     * Product
     */
    protected MProduct m_product = null;
    /**
     * Charge
     */
    protected MCharge m_charge = null;
    /**
     * Parent
     */
    protected I_C_Order m_parent = null;

    /**
     * ************************************************************************ Default Constructor
     *
     * @param C_OrderLine_ID order line to load
     */
    public MOrderLine(int C_OrderLine_ID) {
        super(C_OrderLine_ID);
        if (C_OrderLine_ID == 0) {
            setFreightAmt(Env.ZERO);
            setLineNetAmt(Env.ZERO);
            //
            setPriceEntered(Env.ZERO);
            setPriceActual(Env.ZERO);
            setPriceLimit(Env.ZERO);
            setPriceList(Env.ZERO);
            //
            setAttributeSetInstanceId(0);
            //
            setQtyEntered(Env.ZERO);
            setQtyOrdered(Env.ZERO); // 1
            setQtyDelivered(Env.ZERO);
            setQtyInvoiced(Env.ZERO);
            setQtyReserved(Env.ZERO);
            //
            setIsDescription(false); // N
            setProcessed(false);
            setLine(0);
        }
    } //	MOrderLine

    /**
     * Parent Constructor. ol.setProductId(wbl.getProductId());
     * ol.setQtyOrdered(wbl.getQuantity()); ol.setPrice(); ol.setPriceActual(wbl.getPrice());
     * ol.setTax(); ol.saveEx();
     *
     * @param order parent order
     */
    public MOrderLine(MOrder order) {
        this(0);
        if (order.getId() == 0) throw new IllegalArgumentException("Header not saved");
        setOrderId(order.getOrderId()); // 	parent
        setOrder(order);
    } //	MOrderLine

    /**
     * Load Constructor
     */
    public MOrderLine(Row row) {
        super(row);
    } //	MOrderLine

    /**
     * Set Defaults from Order. Does not set Parent !!
     *
     * @param order order
     */
    public void setOrder(I_C_Order order) {
        setClientOrg(order);
        setBusinessPartnerId(order.getBusinessPartnerId());
        setBusinessPartnerLocationId(order.getBusinessPartnerLocationId());
        setWarehouseId(order.getWarehouseId());
        setDateOrdered(order.getDateOrdered());
        setDatePromised(order.getDatePromised());
        setCurrencyId(order.getCurrencyId());
        //
        setHeaderInfo(order); // 	sets m_order
        //	Don't set Activity, etc as they are overwrites
    } //	setOrder

    /**
     * Set Header Info
     *
     * @param order order
     */
    public void setHeaderInfo(I_C_Order order) {
        m_parent = order;
        m_precision = order.getPrecision();
        m_M_PriceList_ID = order.getPriceListId();
        m_IsSOTrx = order.isSOTrx();
    } //	setHeaderInfo

    /**
     * Get Parent
     *
     * @return parent
     */
    public I_C_Order getParent() {
        if (m_parent == null) m_parent = new MOrder(getOrderId());
        return m_parent;
    } //	getParent

    /**
     * Set Price Entered/Actual. Use this Method if the Line UOM is the Product UOM
     *
     * @param PriceActual price
     */
    public void setPrice(BigDecimal PriceActual) {
        setPriceEntered(PriceActual);
        setPriceActual(PriceActual);
    } //	setPrice

    /**
     * Set Price Actual. (actual price is not updateable)
     *
     * @param PriceActual actual price
     */
    public void setPriceActual(BigDecimal PriceActual) {
        if (PriceActual == null) throw new IllegalArgumentException("PriceActual is mandatory");
        setValueNoCheck("PriceActual", PriceActual);
    } //	setPriceActual

    /**
     * Set Price for Product and PriceList. Use only if newly created. Uses standard price list of not
     * set by order constructor
     */
    public void setPrice() {
        if (getProductId() == 0) return;
        if (m_M_PriceList_ID == 0) throw new IllegalStateException("PriceList unknown!");
        setPrice(m_M_PriceList_ID);
    } //	setPrice

    /**
     * Set Price for Product and PriceList
     *
     * @param M_PriceList_ID price list
     */
    public void setPrice(int M_PriceList_ID) {
        if (getProductId() == 0) return;
        //
        if (log.isLoggable(Level.FINE)) log.fine(toString() + " - M_PriceList_ID=" + M_PriceList_ID);
        getProductPricing(M_PriceList_ID);
        setPriceActual(m_productPrice.getPriceStd());
        setPriceList(m_productPrice.getPriceList());
        setPriceLimit(m_productPrice.getPriceLimit());
        //
        if (getQtyEntered().compareTo(getQtyOrdered()) == 0) setPriceEntered(getPriceActual());
        else
            setPriceEntered(
                    getPriceActual()
                            .multiply(
                                    getQtyOrdered()
                                            .divide(getQtyEntered(), 12, BigDecimal.ROUND_HALF_UP))); // 	recision

        //	Calculate Discount
        setDiscount(m_productPrice.getDiscount());
        //	Set UOM
        setUOMId(m_productPrice.getUOMId());
    } //	setPrice

    /**
     * Get and calculate Product Pricing
     *
     * @param M_PriceList_ID id
     * @return product pricing
     */
    protected IProductPricing getProductPricing(int M_PriceList_ID) {
        m_productPrice = MProduct.getProductPricing();
        m_productPrice.setOrderLine(this);
        m_productPrice.setPriceListId(M_PriceList_ID);
        //
        m_productPrice.calculatePrice();
        return m_productPrice;
    } //	getProductPrice

    /**
     * Set Tax
     *
     * @return true if tax is set
     */
    public boolean setTax() {
        int ii =
                Tax.get(

                        getProductId(),
                        getChargeId(),
                        getDateOrdered(),
                        getDateOrdered(),
                        getOrgId(),
                        getWarehouseId(),
                        getBusinessPartnerLocationId(), //	should be bill to
                        getBusinessPartnerLocationId(),
                        m_IsSOTrx,
                        null);
        if (ii == 0) {
            log.log(Level.SEVERE, "No Tax found");
            return false;
        }
        setTaxId(ii);
        return true;
    } //	setTax

    /**
     * Calculate Extended Amt. May or may not include tax
     */
    public void setLineNetAmt() {
        BigDecimal bd = getPriceActual().multiply(getQtyOrdered());

        boolean documentLevel = getTax().isDocumentLevel();

        //	juddm: Tax Exempt & Tax Included in Price List & not Document Level - Adjust Line Amount
        //  http://sourceforge.net/tracker/index.php?func=detail&aid=1733602&group_id=176962&atid=879332
        if (isTaxIncluded() && !documentLevel) {
            BigDecimal taxStdAmt = Env.ZERO, taxThisAmt = Env.ZERO;

            MTax orderTax = getTax();
            MTax stdTax = null;

            //	get the standard tax
            if (getProduct() == null) {
                if (getCharge() != null) // Charge
                {
                    stdTax =
                            new MTax(
                                    ((MTaxCategory) getCharge().getTaxCategory()).getDefaultTax().getTaxId());
                }

            } else // Product
                stdTax =
                        new MTax(
                                ((MTaxCategory) getProduct().getTaxCategory()).getDefaultTax().getTaxId());

            if (stdTax != null) {
                if (log.isLoggable(Level.FINE)) {
                    log.fine("stdTax rate is " + stdTax.getRate());
                    log.fine("orderTax rate is " + orderTax.getRate());
                }

                taxThisAmt = taxThisAmt.add(orderTax.calculateTax(bd, isTaxIncluded(), getPrecision()));
                taxStdAmt = taxStdAmt.add(stdTax.calculateTax(bd, isTaxIncluded(), getPrecision()));

                bd = bd.subtract(taxStdAmt).add(taxThisAmt);

                if (log.isLoggable(Level.FINE))
                    log.fine(
                            "Price List includes Tax and Tax Changed on Order Line: New Tax Amt: "
                                    + taxThisAmt
                                    + " Standard Tax Amt: "
                                    + taxStdAmt
                                    + " Line Net Amt: "
                                    + bd);
            }
        }
        int precision = getPrecision();
        if (bd.scale() > precision) bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        super.setLineNetAmt(bd);
    } //	setLineNetAmt

    /**
     * Get Charge
     *
     * @return product or null
     */
    public MCharge getCharge() {
        if (m_charge == null && getChargeId() != 0)
            m_charge = MCharge.get(getChargeId());
        return m_charge;
    }

    /**
     * Get Tax
     *
     * @return tax
     */
    protected MTax getTax() {
        if (m_tax == null) m_tax = MTax.get(getTaxId());
        return m_tax;
    } //	getTax

    /**
     * Get Currency Precision from Currency
     *
     * @return precision
     */
    public int getPrecision() {
        if (m_precision != null) return m_precision;
        //
        if (getCurrencyId() == 0) {
            setOrder(getParent());
            if (m_precision != null) return m_precision;
        }
        if (getCurrencyId() != 0) {
            MCurrency cur = MCurrencyKt.getCurrency(getCurrencyId());
            if (cur.getId() != 0) {
                m_precision = cur.getStdPrecision();
                return m_precision;
            }
        }
        //	Fallback
        String sql =
                "SELECT c.StdPrecision "
                        + "FROM C_Currency c INNER JOIN C_Order x ON (x.C_Currency_ID=c.C_Currency_ID) "
                        + "WHERE x.C_Order_ID=?";
        m_precision = getSQLValue(sql, getOrderId());
        return m_precision;
    } //	getPrecision

    /**
     * Set M_Product_ID
     *
     * @param M_Product_ID product
     * @param setUOM       set also UOM
     */
    public void setProductId(int M_Product_ID, boolean setUOM) {
        if (setUOM) setProduct(MProduct.get(M_Product_ID));
        else super.setProductId(M_Product_ID);
        setAttributeSetInstanceId(0);
    } //	setProductId

    /**
     * Set Product and UOM
     *
     * @param M_Product_ID product
     * @param C_UOM_ID     uom
     */
    public void setProductId(int M_Product_ID, int C_UOM_ID) {
        super.setProductId(M_Product_ID);
        if (C_UOM_ID != 0) super.setUOMId(C_UOM_ID);
        setAttributeSetInstanceId(0);
    } //	setProductId

    /**
     * Get Product
     *
     * @return product or null
     */
    public MProduct getProduct() {
        if (m_product == null && getProductId() != 0)
            m_product = MProduct.get(getProductId());
        return m_product;
    } //	getProduct

    /**
     * Set Product
     *
     * @param product product
     */
    public void setProduct(MProduct product) {
        m_product = product;
        if (m_product != null) {
            setProductId(m_product.getProductId());
            setUOMId(m_product.getUOMId());
        } else {
            setProductId(0);
            setValueNoCheck("C_UOM_ID", null);
        }
        setAttributeSetInstanceId(0);
    } //	setProduct

    /**
     * Set M_AttributeSetInstance_ID
     *
     * @param M_AttributeSetInstance_ID id
     */
    public void setAttributeSetInstanceId(int M_AttributeSetInstance_ID) {
        if (M_AttributeSetInstance_ID == 0) // 	 0 is valid ID
            setValue("M_AttributeSetInstance_ID", 0);
        else super.setAttributeSetInstanceId(M_AttributeSetInstance_ID);
    } //	setAttributeSetInstanceId

    /**
     * Set Warehouse
     *
     * @param M_Warehouse_ID warehouse
     */
    public void setWarehouseId(int M_Warehouse_ID) {
        if (getWarehouseId() > 0 && getWarehouseId() != M_Warehouse_ID && !canChangeWarehouse())
            log.severe("Ignored - Already Delivered/Invoiced/Reserved");
        else super.setWarehouseId(M_Warehouse_ID);
    } //	setWarehouseId

    /**
     * Can Change Warehouse
     *
     * @return true if warehouse can be changed
     */
    public boolean canChangeWarehouse() {
        if (getQtyDelivered().signum() != 0) {
            log.saveError("Error", Msg.translate("QtyDelivered") + "=" + getQtyDelivered());
            return false;
        }
        if (getQtyInvoiced().signum() != 0) {
            log.saveError("Error", Msg.translate("QtyInvoiced") + "=" + getQtyInvoiced());
            return false;
        }
        if (getQtyReserved().signum() != 0) {
            log.saveError("Error", Msg.translate("QtyReserved") + "=" + getQtyReserved());
            return false;
        }
        //	We can change
        return true;
    } //	canChangeWarehouse

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
     * ************************************************************************ String Representation
     *
     * @return info
     */
    public String toString() {
        return "MOrderLine[" +
                getId() +
                ", Line=" +
                getLine() +
                ", Ordered=" +
                getQtyOrdered() +
                ", Delivered=" +
                getQtyDelivered() +
                ", Invoiced=" +
                getQtyInvoiced() +
                ", Reserved=" +
                getQtyReserved() +
                ", LineNet=" +
                getLineNetAmt() +
                "]";
    } //	toString

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
     * Set C_Charge_ID
     *
     * @param C_Charge_ID charge
     */
    public void setChargeId(int C_Charge_ID) {
        super.setChargeId(C_Charge_ID);
        if (C_Charge_ID > 0) setValueNoCheck("C_UOM_ID", null);
    } //	setChargeId

    /**
     * Set Discount
     */
    public void setDiscount() {
        BigDecimal list = getPriceList();
        //	No List Price
        if (Env.ZERO.compareTo(list) == 0) return;
        BigDecimal discount =
                list.subtract(getPriceActual())
                        .multiply(Env.ONEHUNDRED)
                        .divide(list, getPrecision(), BigDecimal.ROUND_HALF_UP);
        setDiscount(discount);
    } //	setDiscount

    /**
     * Is Tax Included in Amount
     *
     * @return true if tax calculated
     */
    public boolean isTaxIncluded() {
        if (m_M_PriceList_ID == 0) {
            m_M_PriceList_ID =
                    getSQLValue(
                            "SELECT M_PriceList_ID FROM C_Order WHERE C_Order_ID=?",
                            getOrderId());
        }
        MPriceList pl = MPriceList.get(m_M_PriceList_ID);
        return pl.isTaxIncluded();
    } //	isTaxIncluded

    /**
     * Set Qty Entered/Ordered. Use this Method if the Line UOM is the Product UOM
     *
     * @param Qty QtyOrdered/Entered
     */
    public void setQty(BigDecimal Qty) {
        super.setQtyEntered(Qty);
        super.setQtyOrdered(getQtyEntered());
    } //	setQty

    /**
     * Set Qty Entered - enforce entered UOM
     *
     * @param QtyEntered
     */
    public void setQtyEntered(BigDecimal QtyEntered) {
        if (QtyEntered != null && getUOMId() != 0) {
            int precision = MUOM.getPrecision(getUOMId());
            QtyEntered = QtyEntered.setScale(precision, BigDecimal.ROUND_HALF_UP);
        }
        super.setQtyEntered(QtyEntered);
    } //	setQtyEntered

    /**
     * Set Qty Ordered - enforce Product UOM
     *
     * @param QtyOrdered
     */
    public void setQtyOrdered(BigDecimal QtyOrdered) {
        MProduct product = getProduct();
        if (QtyOrdered != null && product != null) {
            int precision = product.getUOMPrecision();
            QtyOrdered = QtyOrdered.setScale(precision, BigDecimal.ROUND_HALF_UP);
        }
        super.setQtyOrdered(QtyOrdered);
    } //	setQtyOrdered

    /**
     * ************************************************************************ Before Save
     *
     * @param newRecord
     * @return true if it can be saved
     */
    protected boolean beforeSave(boolean newRecord) {
        if (newRecord && getParent().isComplete()) {
            log.saveError("ParentComplete", Msg.translate("C_OrderLine"));
            return false;
        }
        //	Get Defaults from Parent
        if (getBusinessPartnerId() == 0
                || getBusinessPartnerLocationId() == 0
                || getWarehouseId() == 0
                || getCurrencyId() == 0) setOrder(getParent());
        if (m_M_PriceList_ID == 0) setHeaderInfo(getParent());

        //	R/O Check - Product/Warehouse Change
        if (!newRecord && (isValueChanged("M_Product_ID") || isValueChanged("M_Warehouse_ID"))) {
            if (!canChangeWarehouse()) return false;
        } //	Product Changed

        //	Charge
        if (getChargeId() != 0 && getProductId() != 0) setProductId(0);
        //	No Product
        if (getProductId() == 0) setAttributeSetInstanceId(0);
            //	Product
        else //	Set/check Product Price
        {
            //	Set Price if Actual = 0
            if (m_productPrice == null
                    && Env.ZERO.compareTo(getPriceActual()) == 0
                    && Env.ZERO.compareTo(getPriceList()) == 0) setPrice();
            //	Check if on Price list
            if (m_productPrice == null) getProductPricing(m_M_PriceList_ID);
            // IDEMPIERE-1574 Sales Order Line lets Price under the Price Limit when updating
            //	Check PriceLimit
            boolean enforce = m_IsSOTrx && getParent().getPriceList().isEnforcePriceLimit();
            if (enforce && MRole.getDefault().isOverwritePriceLimit()) enforce = false;
            //	Check Price Limit?
            if (enforce
                    && !getPriceLimit().equals(Env.ZERO)
                    && getPriceActual().compareTo(getPriceLimit()) < 0) {
                log.saveError(
                        "UnderLimitPrice",
                        "PriceEntered=" + getPriceEntered() + ", PriceLimit=" + getPriceLimit());
                return false;
            }
            //
            if (!m_productPrice.isCalculated()) {
                throw new ProductNotOnPriceListException(m_productPrice, getLine());
            }
        }

        //	UOM
        if (getUOMId() == 0
                && (getProductId() != 0
                || getPriceEntered().compareTo(Env.ZERO) != 0
                || getChargeId() != 0)) {
            int C_UOM_ID = MUOM.getDefault_UOMId();
            if (C_UOM_ID > 0) setUOMId(C_UOM_ID);
        }
        //	Qty Precision
        if (newRecord || isValueChanged("QtyEntered")) setQtyEntered(getQtyEntered());
        if (newRecord || isValueChanged("QtyOrdered")) setQtyOrdered(getQtyOrdered());

        //	Qty on instance ASI for SO
        if (m_IsSOTrx
                && getAttributeSetInstanceId() != 0
                && (newRecord
                || isValueChanged("M_Product_ID")
                || isValueChanged("M_AttributeSetInstance_ID")
                || isValueChanged("M_Warehouse_ID"))) {
            MProduct product = getProduct();
            if (product.isStocked()) {
                int M_AttributeSet_ID = product.getAttributeSetId();
                boolean isInstance = M_AttributeSet_ID != 0;
                if (isInstance) {
                    MAttributeSet mas = MAttributeSet.get(M_AttributeSet_ID);
                    isInstance = mas.isInstanceAttribute();
                }
            } //	stocked
        } //	SO instance

        //	FreightAmt Not used
        if (Env.ZERO.compareTo(getFreightAmt()) != 0) setFreightAmt(Env.ZERO);

        //	Set Tax
        if (getTaxId() == 0) setTax();

        //	Get Line No
        if (getLine() == 0) {
            String sql = "SELECT COALESCE(MAX(Line),0)+10 FROM C_OrderLine WHERE C_Order_ID=?";
            int ii = getSQLValue(sql, getOrderId());
            setLine(ii);
        }

        //	Calculations & Rounding
        setLineNetAmt(); //	extended Amount with or without tax
        setDiscount();

        /* Carlos Ruiz - globalqss
         * IDEMPIERE-178 Orders and Invoices must disallow amount lines without product/charge
         */
        if (getParent().getTargetDocumentType().isChargeOrProductMandatory()) {
            if (getChargeId() == 0
                    && getProductId() == 0
                    && (getPriceEntered().signum() != 0 || getQtyEntered().signum() != 0)) {
                log.saveError("FillMandatory", Msg.translate("ChargeOrProductMandatory"));
                return false;
            }
        }

        return true;
    } //	beforeSave

    /**
     * Before Delete
     *
     * @return true if it can be deleted
     */
    protected boolean beforeDelete() {
        //	R/O Check - Something delivered. etc.
        if (Env.ZERO.compareTo(getQtyDelivered()) != 0) {
            log.saveError(
                    "DeleteError", Msg.translate("QtyDelivered") + "=" + getQtyDelivered());
            return false;
        }
        if (Env.ZERO.compareTo(getQtyInvoiced()) != 0) {
            log.saveError("DeleteError", Msg.translate("QtyInvoiced") + "=" + getQtyInvoiced());
            return false;
        }
        if (Env.ZERO.compareTo(getQtyReserved()) != 0) {
            //	For PO should be On Order
            log.saveError("DeleteError", Msg.translate("QtyReserved") + "=" + getQtyReserved());
            return false;
        }

        return true;
    } //	beforeDelete

    /**
     * After Save
     *
     * @param newRecord new
     * @param success   success
     * @return saved
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success) return success;
        if (getParent().isProcessed()) return success;
        if (newRecord
                || isValueChanged(I_C_OrderLine.COLUMNNAME_C_Tax_ID)
                || isValueChanged(I_C_OrderLine.COLUMNNAME_LineNetAmt)) {
            MTax tax = new MTax(getTaxId());
            MTaxProvider provider =
                    new MTaxProvider(tax.getTaxProviderId());
            ITaxProvider calculator = MTaxProvider.getTaxProvider(provider, new StandardTaxProvider());
            if (calculator == null) throw new AdempiereException(Msg.getMsg("TaxNoProvider"));
            return calculator.recalculateTax(provider, this, newRecord);
        }
        return success;
    } //	afterSave

    /**
     * After Delete
     *
     * @param success success
     * @return deleted
     */
    protected boolean afterDelete(boolean success) {
        if (!success) return success;

        return updateHeaderTax();
    } //	afterDelete

    /**
     * Recalculate order tax
     *
     * @param oldTax true if the old C_Tax_ID should be used
     * @return true if success, false otherwise
     * @author teo_sarca [ 1583825 ]
     */
    public boolean updateOrderTax(boolean oldTax) {
        MOrderTax tax = MOrderTax.get(this, getPrecision(), oldTax);
        if (tax != null) {
            if (!tax.calculateTaxFromLines()) return false;
            if (tax.getTaxAmt().signum() != 0) {
                return tax.save();
            } else {
                return tax.isNew() || tax.delete(false);
            }
        }
        return true;
    }

    /**
     * Update Tax & Header
     *
     * @return true if header updated
     */
    public boolean updateHeaderTax() {

        // Update header only if the document is not processed
        if (isProcessed() && !isValueChanged(I_C_OrderLine.COLUMNNAME_Processed)) return true;

        MTax tax = new MTax(getTaxId());
        MTaxProvider provider =
                new MTaxProvider(tax.getTaxProviderId());
        ITaxProvider calculator = MTaxProvider.getTaxProvider(provider, new StandardTaxProvider());
        if (calculator == null) throw new AdempiereException(Msg.getMsg("TaxNoProvider"));
        if (!calculator.updateOrderTax(provider, this)) return false;

        return calculator.updateHeaderTax(provider, this);
    } //	updateHeaderTax

    public void clearParent() {
        this.m_parent = null;
    }

    @Override
    public int getTableId() {
        return I_C_OrderLine.Table_ID;
    }
} //	MOrderLine
