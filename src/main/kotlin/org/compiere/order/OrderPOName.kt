package org.compiere.order

import kotliquery.Row
import org.compiere.orm.BasePOName
import software.hsharp.core.util.Environment
import software.hsharp.modules.Module

/**
 * Order Persistent Object with Name
 */
abstract class OrderPOName(row: Row?, id: Int) : BasePOName(row, id), Module by Environment<Module>().module