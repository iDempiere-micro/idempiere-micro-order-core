package org.compiere.order

import kotliquery.Row
import org.compiere.model.I_C_PaymentTerm
import software.hsharp.core.util.DB
import software.hsharp.core.util.asResource
import software.hsharp.core.util.queryOf
import java.sql.ResultSet
import java.util.Properties

abstract class MBasePaymentTerm : X_C_PaymentTerm {
    constructor(ctx: Properties, Id: Int) : super(ctx, Id)
    constructor(ctx: Properties, row: Row) : super(ctx, row)

    /** Payment Schedule children  */
    protected var schedule: Array<MPaySchedule> = arrayOf()

    abstract fun self(): I_C_PaymentTerm

    fun getSchedule(requery: Boolean): Array<MPaySchedule> {
        if (schedule.isNotEmpty() && !requery) return schedule

        return "/sql/getSchedule.sql".asResource { sql ->
            val loadQuery = queryOf(sql, listOf(getPaymentTermId())).map { MPaySchedule(ctx, it) }.asList
            val result = DB.current.run(loadQuery)
            result.forEach { it.parent = self() }
            result
        }.toTypedArray()
    }
}