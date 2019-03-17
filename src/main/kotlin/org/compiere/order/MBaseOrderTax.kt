package org.compiere.order

import software.hsharp.core.util.DB
import software.hsharp.core.util.queryOf
import java.util.Properties

fun getOrderTax(ctx: Properties, orderId: Int, taxId: Int): MOrderTax? {
    val sql = "SELECT * FROM C_OrderTax WHERE C_Order_ID=? AND C_Tax_ID=?"
    val query = queryOf(sql, listOf(orderId, taxId)).map { row -> MOrderTax(ctx, row) }.asSingle
    return DB.current.run(query)
}