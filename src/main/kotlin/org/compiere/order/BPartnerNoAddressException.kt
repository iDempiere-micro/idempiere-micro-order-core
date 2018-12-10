package org.compiere.order

import org.compiere.model.I_C_BPartner

/**
 * Thrown when an location/address is required for a BPartner but not found.
 * @author Teo Sarca, www.arhipac.ro
 */
class BPartnerNoAddressException
/**
 * @param message
 * @param bp
 */
    (bp: I_C_BPartner) : BPartnerException(AD_Message, bp) {
    companion object {
        /**
         *
         */
        private val serialVersionUID = -1892858395845764918L
        val AD_Message = "BPartnerNoAddress"
    }
}