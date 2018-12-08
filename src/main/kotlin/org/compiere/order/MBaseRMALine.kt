package org.compiere.order

import software.hsharp.core.util.DB
import software.hsharp.core.util.queryOf

fun getAllIDs(tableName: String, whereClause: String?): IntArray {
    val sql = StringBuilder("SELECT ")
    sql.append(tableName).append("_ID FROM ").append(tableName)
    if (whereClause != null && whereClause.isNotEmpty()) sql.append(" WHERE ").append(whereClause)
    val loadQuery = queryOf(sql.toString(), listOf()).map { row -> row.int(1) }.asList
    return DB.current.run(loadQuery).toIntArray()
}