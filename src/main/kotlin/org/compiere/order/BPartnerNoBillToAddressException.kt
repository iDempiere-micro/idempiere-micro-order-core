package org.compiere.order

import org.compiere.model.I_C_BPartner

/**
 * Thrown when Bill To Address is required for a BPartner but not found.
 * @author Teo Sarca, www.arhipac.ro
 */
class BPartnerNoBillToAddressException(bp: I_C_BPartner) : BPartnerException(AD_Message, bp) {
    companion object {
        private val serialVersionUID = -8423260338845096466L
        val AD_Message = "BPartnerNoBillToAddress"
    }
}