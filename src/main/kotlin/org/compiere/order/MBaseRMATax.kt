package org.compiere.order

import software.hsharp.core.util.DB
import software.hsharp.core.util.queryOf
import java.util.Properties

fun getRMATax(ctx: Properties, rmaId: Int, taxId: Int) : MRMATax? {
    val sql = "SELECT * FROM M_RMATax WHERE M_RMA_ID=? AND C_Tax_ID=?"
    val query = queryOf(sql, listOf(rmaId, taxId)).map { row -> MRMATax(ctx, row) }.asSingle
    return DB.current.run(query)
}