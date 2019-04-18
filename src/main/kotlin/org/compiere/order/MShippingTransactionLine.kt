package org.compiere.order

import kotliquery.Row

class MShippingTransactionLine : X_M_ShippingTransactionLine {

    constructor(
        M_ShippingTransactionLine_ID: Int
    ) : super(M_ShippingTransactionLine_ID) {
    }

    constructor(row: Row) : super(row) {}

    companion object {
        private const val serialVersionUID = -8148869412130244360L
    }
}
