package org.compiere.order.test

import company.bigger.test.support.BaseComponentTest
import org.compiere.order.MOrder
import org.compiere.orm.DefaultModelFactory
import org.compiere.orm.IModelFactory
import org.compiere.model.I_C_Order
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class OrderTests : BaseComponentTest() {
    @Test
    fun getUsingDefaultModelFactoryById() {
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