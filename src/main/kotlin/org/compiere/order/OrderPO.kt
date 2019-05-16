package org.compiere.order

import kotliquery.Row
import org.compiere.orm.PO
import software.hsharp.core.util.Environment
import software.hsharp.modules.Module

abstract class OrderPO(row: Row?, id: Int) : PO(row, id), Module by Environment<Module>().module