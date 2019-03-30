package org.compiere.order.test

import mu.KotlinLogging
import org.compiere.model.I_C_Order
import org.compiere.order.MOrder
import org.compiere.order.SalesOrderServiceImpl
import org.compiere.orm.DefaultModelFactory
import org.compiere.orm.IModelFactory
import org.idempiere.common.util.Env
import org.junit.Test
import software.hsharp.core.models.EnvironmentService
import software.hsharp.core.util.DB
import software.hsharp.core.util.HikariCPI
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

private val log = KotlinLogging.logger {}
internal val sessionUrl = System.getenv("SESSION_URL") ?: "jdbc:postgresql://localhost:5433/idempiere"

internal const val clientId = 11

internal class FakeEnvironmentService(override val clientId: Int, override val context: Properties) :
    EnvironmentService {
    override val userId = 0
}

internal val environmentService = FakeEnvironmentService(clientId, Env.getCtx())
internal val salesOrderService = SalesOrderServiceImpl(environmentService)

class OrderTest {
    init {
        HikariCPI.default(sessionUrl, "adempiere", "adempiere")
        log.trace { "OrderTest initialized" }
    }

    @Test
    fun getUsingDefaultModelFactoryById() {
        DB.run {
            val order_id = 104

            val modelFactory: IModelFactory = DefaultModelFactory()
            val result = modelFactory.getPO(I_C_Order.Table_Name, order_id)
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

    @Test
    fun `get sales orders works`() {
        DB.run {
            val salesOrders = salesOrderService.getAll()
            assertFalse { salesOrders.isEmpty() }
        }
    }
}