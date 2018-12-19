package org.compiere.order.test

import mu.KotlinLogging
import org.compiere.model.I_C_Order
import org.compiere.order.MOrder
import org.compiere.orm.DefaultModelFactory
import org.compiere.orm.IModelFactory
import org.junit.Test
import software.hsharp.core.orm.DummyEventManager
import software.hsharp.core.util.DB
import software.hsharp.core.util.HikariCPI
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

private val log = KotlinLogging.logger {}
internal val sessionUrl = System.getenv("SESSION_URL") ?: "jdbc:postgresql://localhost:5433/idempiere"

class OrderTest {
    init {
        HikariCPI.default(sessionUrl, "adempiere", "adempiere")
        DummyEventManager()
        log.trace { "OrderTest initialized" }
    }

    @Test
    fun getUsingDefaultModelFactoryById() {
        DB.run {
            val order_id = 104

            val modelFactory: IModelFactory = DefaultModelFactory()
            val result = modelFactory.getPO(I_C_Order.Table_Name, order_id, null)
            println(result)
            assertNotNull(result)
            val order = result as MOrder
            assertNotNull(order)
            assertEquals(order_id, order.id)
            val lines = order.lines
            assertNotNull(lines)
            assertEquals(6, lines.count())
        }
    }
}