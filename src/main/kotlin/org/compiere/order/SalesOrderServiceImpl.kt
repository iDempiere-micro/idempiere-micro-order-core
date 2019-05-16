package org.compiere.order

import org.compiere.model.I_C_Order
import software.hsharp.core.orm.BaseDataServiceImpl
import software.hsharp.core.services.EnvironmentService
import software.hsharp.services.SalesOrderService

class SalesOrderServiceImpl(environmentService: EnvironmentService) :
    BaseDataServiceImpl<I_C_Order>(environmentService, I_C_Order.Table_Name, false),
    SalesOrderService {
    override fun andWhere(): String = " issotrx='Y' "
}