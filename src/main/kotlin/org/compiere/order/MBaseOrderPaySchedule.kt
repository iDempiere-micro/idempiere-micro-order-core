package org.compiere.order

import software.hsharp.core.util.DB
import software.hsharp.core.util.queryOf
import java.util.Properties

/**
 * Get Payment Schedule of the Order
 *
 * @param ctx context
 * @param orderId order id (direct)
 * @param orderPayScheduleId id (indirect)
 * @return array of schedule
 */
fun getOrderPaySchedule(
    ctx: Properties,
    orderId: Int,
    orderPayScheduleId: Int
): Array<MOrderPaySchedule> {
    var sql = "SELECT * FROM C_OrderPaySchedule ips WHERE IsActive='Y' "
    if (orderId != 0)
        sql += "AND C_Order_ID=? "
    else
        sql += "AND EXISTS (SELECT * FROM C_OrderPaySchedule x" + " WHERE x.C_OrderPaySchedule_ID=? AND ips.C_Order_ID=x.C_Order_ID) "
    sql += "ORDER BY DueDate"

    val params =
        if (orderId != 0)
            listOf(orderId)
        else
            listOf(orderPayScheduleId)

    val query = queryOf(sql, params).map { row -> MOrderPaySchedule(ctx, row) }.asList
    return DB.current.run(query).toTypedArray()
} // 	getSchedule