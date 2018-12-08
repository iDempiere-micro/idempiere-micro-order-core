package org.compiere.order

import org.compiere.model.I_C_BPartner

/**
 * Thrown when Ship To Address is required for a BPartner but not found.
 * @author Teo Sarca, www.arhipac.ro
 */
class BPartnerNoShipToAddressException(bp: I_C_BPartner) : BPartnerException(AD_Message, bp) {
    companion object {
        /**
         *
         */
        private val serialVersionUID = 4388496060894704270L
        val AD_Message = "BPartnerNoShipToAddress"
    }
}