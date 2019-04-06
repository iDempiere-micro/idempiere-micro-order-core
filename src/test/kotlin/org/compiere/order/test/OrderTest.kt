package org.compiere.order.test

import mu.KotlinLogging
import org.compiere.model.I_C_Order
import org.compiere.order.MOrder
import org.compiere.order.SalesOrderServiceImpl
import org.compiere.orm.DefaultModelFactory
import org.compiere.orm.IModelFactory
import org.idempiere.common.util.EnvironmentServiceImpl
import org.junit.Test
import software.hsharp.core.modules.BaseModuleImpl
import software.hsharp.core.util.DB
import software.hsharp.core.util.Environment
import software.hsharp.core.util.HikariCPI
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull

private val log = KotlinLogging.logger {}
internal val sessionUrl = System.getenv("SESSION_URL") ?: "jdbc:postgresql://localhost:5433/idempiere"

internal const val clientId = 11

internal val environmentService = EnvironmentServiceImpl(clientId, 0, 0)
internal val salesOrderService = SalesOrderServiceImpl(environmentService)
internal val baseModule = BaseModuleImpl(environmentService = environmentService, modelFactory = DefaultModelFactory())

class OrderTest {
    init {
        HikariCPI.default(sessionUrl, "adempiere", "adempiere")
        log.trace { "OrderTest initialized" }
    }

    @Test
    fun getUsingDefaultModelFactoryById() {
        Environment.run(baseModule) {
            DB.run {
                val order_id = 104

                val modelFactory: IModelFactory = DefaultModelFactory()
                val order: MOrder = modelFactory.getPO(I_C_Order.Table_Name, order_id)
                println(order)
                assertNotNull(order)
                assertEquals(order_id, order.id)
                val lines = order.lines
                assertNotNull(lines)
                assertEquals(6, lines.count())
            }
        }
    }

    @Test
    fun `get sales orders works`() {
        Environment.run(baseModule) {
            DB.run {
                val salesOrders = salesOrderService.getAll()
                assertFalse { salesOrders.isEmpty() }
            }
        }
    }
}