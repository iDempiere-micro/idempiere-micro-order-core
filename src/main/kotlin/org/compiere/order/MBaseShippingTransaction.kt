package org.compiere.order

import software.hsharp.core.util.DB
import software.hsharp.core.util.queryOf
import java.util.Properties
import java.util.logging.Level

fun getCommodityShipment(ctx: Properties, productId: Int, clientId: Int, orgId: Int): X_M_CommodityShipment {
    val sql = StringBuilder()
    sql.append("SELECT * FROM M_CommodityShipment ")
    sql.append("WHERE M_Product_ID IN (0, ?) OR M_Product_ID IS NULL ")
    sql.append("AND AD_Client_ID IN (0, ?) ")
    sql.append("AND AD_Org_ID IN (0, ?) ")
    sql.append("ORDER BY M_Product_ID, AD_Org_ID, AD_Client_ID")

    val query = queryOf(sql.toString(), listOf(productId, clientId, orgId)).map { row -> X_M_CommodityShipment(ctx, row) }.asSingle
    return DB.current.run(query) ?: X_M_CommodityShipment(ctx, 0)
}