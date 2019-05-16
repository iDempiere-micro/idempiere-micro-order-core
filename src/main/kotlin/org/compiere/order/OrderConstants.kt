package org.compiere.order

/**
 * Constants for Order columns
 */
object OrderConstants {
    /**
     * Availability = A
     */
    const val DELIVERYRULE_Availability = "A"
    /**
     * Complete Line = L
     */
    const val DELIVERYRULE_CompleteLine = "L"
    /**
     * Complete Order = O
     */
    const val DELIVERYRULE_CompleteOrder = "O"
    /**
     * Force = F
     */
    const val DELIVERYRULE_Force = "F"
    /**
     * Manual = M
     */
    const val DELIVERYRULE_Manual = "M"
    /**
     * Pickup = P
     */
    const val DELIVERYVIARULE_Pickup = "P"
    /**
     * Shipper = S
     */
    const val DELIVERYVIARULE_Shipper = "S"
    /**
     * Complete = CO
     */
    const val DOCACTION_Complete = "CO"
    /**
     * Void = VO
     */
    const val DOCACTION_Void = "VO"
    /**
     * Close = CL
     */
    const val DOCACTION_Close = "CL"
    /**
     * <None> = --
    </None> */
    const val DOCACTION_None = "--"
    /**
     * Prepare = PR
     */
    const val DOCACTION_Prepare = "PR"
    /**
     * Wait Complete = WC
     */
    const val DOCACTION_WaitComplete = "WC"
    /**
     * Drafted = DR
     */
    const val DOCSTATUS_Drafted = "DR"
    /**
     * Completed = CO
     */
    const val DOCSTATUS_Completed = "CO"
    /**
     * Inconst valid = IN
     */
    const val DOCSTATUS_Invalid = "IN"
    /**
     * Reversed = RE
     */
    const val DOCSTATUS_Reversed = "RE"
    /**
     * Closed = CL
     */
    const val DOCSTATUS_Closed = "CL"
    /**
     * In Progress = IP
     */
    const val DOCSTATUS_InProgress = "IP"
    /**
     * Waiting Payment = WP
     */
    const val DOCSTATUS_WaitingPayment = "WP"
    /**
     * Freight included = I
     */
    const val FREIGHTCOSTRULE_FreightIncluded = "I"
    /**
     * Fix price = F
     */
    const val FREIGHTCOSTRULE_FixPrice = "F"
    /**
     * Calculated = C
     */
    const val FREIGHTCOSTRULE_Calculated = "C"
    /**
     * After Order delivered = O
     */
    const val INVOICERULE_AfterOrderDelivered = "O"
    /**
     * After Delivery = D
     */
    const val INVOICERULE_AfterDelivery = "D"
    /**
     * Customer Schedule after Delivery = S
     */
    const val INVOICERULE_CustomerScheduleAfterDelivery = "S"
    /**
     * Immediate = I
     */
    const val INVOICERULE_Immediate = "I"
    /**
     * Cash = B
     */
    const val PAYMENTRULE_Cash = "B"
    /**
     * Direct Deposit = T
     */
    const val PAYMENTRULE_DirectDeposit = "T"
    /**
     * On Credit = P
     */
    const val PAYMENTRULE_OnCredit = "P"
    /**
     * Direct Debit = D
     */
    const val PAYMENTRULE_DirectDebit = "D"
    /**
     * Mixed POS Payment = M
     */
    const val PAYMENTRULE_MixedPOSPayment = "M"
    /**
     * Medium = 5
     */
    const val PRIORITYRULE_Medium = "5"

    private const val serialVersionUID = 20171031L
}
