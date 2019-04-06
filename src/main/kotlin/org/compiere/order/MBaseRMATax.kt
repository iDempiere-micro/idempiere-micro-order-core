package org.compiere.order

import software.hsharp.core.util.DB
import software.hsharp.core.util.queryOf

fun getRMATax(rmaId: Int, taxId: Int): MRMATax? {
    val sql = "SELECT * FROM M_RMATax WHERE M_RMA_ID=? AND C_Tax_ID=?"
    val query = queryOf(sql, listOf(rmaId, taxId)).map { row -> MRMATax(row) }.asSingle
    return DB.current.run(query)
}