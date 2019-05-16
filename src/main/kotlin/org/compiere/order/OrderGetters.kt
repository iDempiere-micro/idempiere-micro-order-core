package org.compiere.order

import kotliquery.Row
import org.compiere.model.I_C_Order

/**
 * ORM Model getters for C_Order
 */
abstract class OrderGetters(row: Row?, id: Int) : OrderPO(row, id) {

    /**
     * Get Trx Organization.
     *
     * @return Performing or initiating organization
     */
    fun getTransactionOrganizationId(): Int {
        return getValue(I_C_Order.COLUMNNAME_AD_OrgTrx_ID) ?: return 0
    }

    /**
     * Get User/Contact.
     *
     * @return User within the system - Internal or Business Partner Contact
     */
    fun getUserId(): Int {
        return getValue(I_C_Order.COLUMNNAME_AD_User_ID) ?: return 0
    }

    /**
     * Get Invoice Partner.
     *
     * @return Business Partner to be invoiced
     */
    fun getInvoiceBusinessPartnerId(): Int {
        return getValue(I_C_Order.COLUMNNAME_Bill_BPartner_ID) ?: return 0
    }

    /**
     * Get Invoice Location.
     *
     * @return Business Partner Location for invoicing
     */
    fun getBusinessPartnerInvoicingLocationId(): Int {
        return getValue(I_C_Order.COLUMNNAME_Bill_Location_ID) ?: return 0
    }

    /**
     * Get Invoice Contact.
     *
     * @return Business Partner Contact for invoicing
     */
    fun getInvoiceUserId(): Int {
        return getValue(I_C_Order.COLUMNNAME_Bill_User_ID) ?: return 0
    }
}