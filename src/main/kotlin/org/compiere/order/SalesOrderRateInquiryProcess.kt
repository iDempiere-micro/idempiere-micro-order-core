package org.compiere.order

import org.compiere.crm.MClientInfo
import org.compiere.orm.MSysConfig
import org.compiere.product.MProduct
import org.compiere.product.MUOM
import org.compiere.util.DisplayType
import org.idempiere.common.exceptions.AdempiereException
import software.hsharp.core.orm.getAllIDs
import java.math.BigDecimal
import java.util.Hashtable
import java.util.Properties
import kotlin.collections.ArrayList
import kotlin.collections.set

fun createShippingTransaction(
    ctx: Properties,
    m_order: MOrder,
    action: String,
    isPriviledgedRate: Boolean
): MShippingTransaction {
    val shipper = MShipper(ctx, m_order.shipperId)
    val whereClause = "M_Shipper_ID = " + shipper.shipperId + " AND IsDefault='Y' AND IsActive='Y'"
    var M_ShipperLabels_ID = 0
    var ids = getAllIDs(MShipperLabels.Table_Name, whereClause)
    if (ids.isNotEmpty()) M_ShipperLabels_ID = ids[0]

    var M_ShipperPackaging_ID = 0
    ids = getAllIDs(MShipperPackaging.Table_Name, whereClause)
    if (ids.size > 0) M_ShipperPackaging_ID = ids[0]

    var M_ShipperPickupTypes_ID = 0
    ids = getAllIDs(MShipperPickupTypes.Table_Name, whereClause)
    if (ids.size > 0) M_ShipperPickupTypes_ID = ids[0]

    val ShipperAccount = ShippingUtil.getSenderShipperAccount(shipper.shipperId, shipper.orgId)
    val DutiesShipperAccount = ShippingUtil.getSenderDutiesShipperAccount(
        shipper.shipperId, shipper.orgId
    )

    // 1 kg = 2.20462 lb
    val ci = MClientInfo.get(ctx, m_order.clientId)
    val uom = MUOM(ctx, ci.uomWeightId)
    var unit: String? = uom.x12DE355
    var isPound = false
    if (unit != null) {
        unit = unit.toUpperCase()
        if (unit == "LB" || unit == "LBS") isPound = true
    }

    val sp = MShipperPackaging(ctx, M_ShipperPackaging_ID)
    var WeightPerPackage: BigDecimal? =
        sp.weight.multiply(if (isPound) BigDecimal.valueOf(2.20462) else BigDecimal.ONE)

    if (WeightPerPackage == null || WeightPerPackage.compareTo(BigDecimal.ZERO) == 0) {
        val defaultWeightPerPackage = BigDecimal.valueOf(
            MSysConfig.getDoubleValue(MSysConfig.SHIPPING_DEFAULT_WEIGHT_PER_PACKAGE, 30.0)
        )
        WeightPerPackage =
            defaultWeightPerPackage.multiply(if (isPound) BigDecimal.valueOf(2.20462) else BigDecimal.ONE)
    }

    val CODAmount = m_order.grandTotal
    var CustomsValue: BigDecimal
    val FreightAmt = BigDecimal.ZERO
    var TotalWeight = BigDecimal.ZERO

    val df = DisplayType.getNumberFormat(DisplayType.Quantity)

    val packages = ArrayList<ShippingPackage>()
    val items = ArrayList<Array<Any>>()
    val ols = m_order.getLines(false, MOrderLine.COLUMNNAME_Line)
    for (ol in ols) {
        if (ol.productId > 0 && ol.productId == ci.productFreightId || ol.chargeId > 0 && ol.chargeId == ci.chargeFreightId) {
            // 				FreightAmt = FreightAmt.add(ol.getLineNetAmt());
            continue
        } else if (ol.productId > 0) {
            val product = MProduct(ctx, ol.productId)

            val weight = product.weight
            if (weight == null || weight.compareTo(BigDecimal.ZERO) == 0)
                throw AdempiereException("No weight defined for product " + product.toString())

            val qty: BigDecimal = ol.qtyEntered ?: BigDecimal.ZERO

            if (product.isOwnBox) {
                var remainingQty: BigDecimal = qty
                while (remainingQty.compareTo(BigDecimal.ZERO) > 0) {
                    val itemQty = BigDecimal(Math.min(remainingQty.toDouble(), 1.0))
                    val shippingPackage = ShippingPackage()
                    shippingPackage.weight = weight.multiply(itemQty)
                    shippingPackage.description = df.format(itemQty) + " x " + product.value
                    shippingPackage.height = product.shelfHeight
                    shippingPackage.width = BigDecimal(product.shelfWidth)
                    shippingPackage.length = BigDecimal(product.shelfDepth)
                    packages.add(shippingPackage)
                    remainingQty = remainingQty.subtract(BigDecimal.ONE)
                }
            } else {
                var remainingQty: BigDecimal = qty
                while (remainingQty.compareTo(BigDecimal.ZERO) > 0) {
                    val itemQty = BigDecimal(Math.min(remainingQty.toDouble(), 1.0))
                    items.add(arrayOf(product, itemQty))
                    remainingQty = remainingQty.subtract(BigDecimal.ONE)
                }
            }

            TotalWeight = TotalWeight.add(weight.multiply(qty))
        }
    }

    val packageItems = Hashtable<MProduct, BigDecimal>()
    var TotalPackageWeight = BigDecimal.ZERO
    for (item in items) {
        val product = item[0] as MProduct
        val qty = item[1] as BigDecimal
        val itemWeight = product.weight.multiply(qty)

        if (itemWeight.compareTo(WeightPerPackage!!) >= 0) {
            val ownBoxProducts = ArrayList<MProduct>()
            ownBoxProducts.add(product)

            val shippingPackage = ShippingPackage()
            shippingPackage.weight = itemWeight
            shippingPackage.description = df.format(qty) + " x " + product.value
            shippingPackage.height = product.shelfHeight
            shippingPackage.width = BigDecimal(product.shelfWidth)
            shippingPackage.length = BigDecimal(product.shelfDepth)
            packages.add(shippingPackage)
        } else if (itemWeight.add(TotalPackageWeight).compareTo(WeightPerPackage) > 0) {
            val shippingPackage = ShippingPackage()
            shippingPackage.weight = TotalPackageWeight

            var description = ""
            val en = packageItems.keys()
            while (en.hasMoreElements()) {
                val packageProduct = en.nextElement()
                val packageQty = packageItems[packageProduct]
                description += df.format(packageQty) + " x " + packageProduct.value + ", "
            }
            if (description.length > 0)
                description = description.substring(0, description.length - 2)
            shippingPackage.description = description

            packages.add(shippingPackage)

            packageItems.clear()
            TotalPackageWeight = BigDecimal.ZERO

            TotalPackageWeight = TotalPackageWeight.add(itemWeight)
            var packageQty: BigDecimal? = packageItems[product]
            if (packageQty == null) packageQty = BigDecimal.ZERO
            packageItems[product] = packageQty!!.add(qty)
        } else {
            TotalPackageWeight = TotalPackageWeight.add(itemWeight)
            var packageQty: BigDecimal? = packageItems[product]
            if (packageQty == null) packageQty = BigDecimal.ZERO
            packageItems[product] = packageQty!!.add(qty)
        }
    }

    if (TotalPackageWeight.compareTo(BigDecimal.ZERO) > 0) {
        val shippingPackage = ShippingPackage()
        shippingPackage.weight = TotalPackageWeight

        var description = ""
        val en = packageItems.keys()
        while (en.hasMoreElements()) {
            val packageProduct = en.nextElement()
            val packageQty = packageItems[packageProduct]
            description += df.format(packageQty) + " x " + packageProduct.value + ", "
        }
        if (description.length > 0)
            description = description.substring(0, description.length - 2)
        shippingPackage.description = description

        packages.add(shippingPackage)
    }

    CustomsValue = CODAmount.subtract(FreightAmt)

    val BoxCount = packages.size

    val st = MShippingTransaction(ctx, 0)
    st.action = action
    // 		st.setADClientID(m_order.getADClientID());
    st.setOrgId(m_order.orgId)
    st.setUserId(m_order.userId)
    st.setBusinessPartnerInvoicingLocationId(m_order.businessPartnerInvoicingLocationId)
    st.setBoxCount(BoxCount)
    // 		st.setBP_ShippingAcctId(getBP_ShippingAcctId());
    st.setBusinessPartnerId(m_order.businessPartnerId)
    st.setBusinessPartnerLocationId(m_order.businessPartnerLocationId)
    st.setCurrencyId(m_order.currencyId)
    // 		st.setInvoiceId(0);
    st.setOrderId(m_order.orderId)
    st.setUOMLengthId(ci.uomLengthId)
    st.setUOMWeightId(ci.uomWeightId)
    // 		st.setCashOnDelivery(isCashOnDelivery());
    st.setCODAmount(CODAmount)
    st.setCustomsValue(CustomsValue)
    // 		st.setDateReceived(getDateReceived());
    // 		st.setDeliveryConfirmation(isDeliveryConfirmation());
    // 		st.setDeliveryConfirmationType(getDeliveryConfirmationType());
    // 		st.setDescription(getDescription());
    // 		st.setDotHazardClassOrDivision(getDotHazardClassOrDivision());
    // 		st.setDryIceWeight(getDryIceWeight());
    st.setDutiesShipperAccount(DutiesShipperAccount)
    // 		st.setFOB(getFOB());
    st.setFreightAmt(FreightAmt)
    st.freightCharges = MShippingTransaction.FREIGHTCHARGES_PrepaidAndBill
    // 		st.setHandlingCharge(getHandlingCharge());
    // 		st.setHeight(getHeight());
    // 		st.setHoldAddress(getHoldAddress());
    // 		st.setHomeDeliveryPremiumDate(getHomeDeliveryPremiumDate());
    // 		st.setHomeDeliveryPremiumPhone(getHomeDeliveryPremiumPhone());
    // 		st.setHomeDeliveryPremiumType(getHomeDeliveryPremiumType());
    // 		st.setInsurance(getInsurance());
    // 		st.setInsuredAmount(getInsuredAmount());
    // 		st.setIsAccessible(isAccessible());
    st.setIsActive(m_order.isActive)
    // 		st.setIsAddedHandling(isAddedHandling());
    // 		st.setIsAlternateReturnAddress(isAlternateReturnAddress());
    // 		st.setIsCargoAircraftOnly(isCargoAircraftOnly());
    // 		st.setIsDryIce(isDryIce());
    // 		st.setIsDutiable(isDutiable());
    // 		st.setIsFutureDayShipment(isFutureDayShipment());
    // 		st.setIsHazMat(isHazMat());
    // 		st.setIsHoldAtLocation(isHoldAtLocation());
    // 		st.setIsIgnoreZipNotFound(isIgnoreZipNotFound());
    // 		st.setIsIgnoreZipStateNotMatch(isIgnoreZipStateNotMatch());
    st.setIsPriviledgedRate(isPriviledgedRate)
    st.setIsResidential(shipper.isResidential)
    st.setIsSaturdayDelivery(shipper.isSaturdayDelivery)
    // 		st.setIsSaturdayPickup(isSaturdayPickup());
    // 		st.setIsVerbalConfirmation(isVerbalConfirmation());
    // 		st.setLatestPickupTime(getLatestPickupTime());
    // 		st.setLength(getLength());
    // 		st.setInOutId(0);
    // 		st.setPackageId(getPackageId());
    st.shipperId = m_order.shipperId
    st.setShipperLabelsId(M_ShipperLabels_ID)
    st.setShipperPackagingId(M_ShipperPackaging_ID)
    st.setShipperPickupTypesId(M_ShipperPickupTypes_ID)
    st.setShippingProcessorId(shipper.shippingProcessorId)
    st.setWarehouseId(m_order.warehouseId)
    // 		st.setNotificationMessage(getNotificationMessage());
    // 		st.setNotificationType(getNotificationType());
    st.setPaymentRule(m_order.paymentRule)
    st.setPOReference(m_order.poReference)
    // 		st.setPrice(getPrice());
    // 		st.setPriceActual(getPriceActual());
    // 		st.setProcessed(isProcessed());
    // 		st.setReceivedInfo(getReceivedInfo());
    // 		st.setReturnBPartnerId(getReturnBPartnerId());
    // 		st.setReturnLocationId(getReturnLocationId());
    // 		st.setReturnUserId(getReturnUserId());
    st.setSalesRepresentativeId(m_order.salesRepresentativeId)
    st.setShipDate(m_order.datePromised)
    st.setShipperAccount(ShipperAccount)
    // 		st.setShippingRespMessage(ShippingRespMessage);
    // 		st.setSurcharges(getSurcharges());
    st.setTrackingInfo(shipper.trackingURL)
    // 		st.setTrackingNo(getTrackingNo());
    st.setWeight(TotalWeight)
    // 		st.setWidth(getWidth());
    st.saveEx()

    for (i in packages.indices) {
        val shippingPackage = packages[i]

        val stl = MShippingTransactionLine(st.ctx, 0)
        stl.setOrgId(m_order.orgId)
        stl.setUOMLengthId(ci.uomLengthId)
        stl.setUOMWeightId(ci.uomWeightId)
        stl.setDescription(shippingPackage.description)
        stl.setHeight(shippingPackage.height)
        stl.setIsActive(m_order.isActive)
        stl.setLength(shippingPackage.length)
        stl.setShippingTransactionId(st.shippingTransactionId)
        stl.setSeqNo((i + 1) * 10)
        stl.setWeight(shippingPackage.weight)
        stl.setWidth(shippingPackage.width)
        stl.saveEx()
    }

    return st
}
