package org.compiere.order

import org.compiere.model.I_C_BPartner
import org.idempiere.common.exceptions.AdempiereException

/**
 * Thrown when an exception related to a BPartner happened.
 * @author Teo Sarca, www.arhipac.ro
 */
abstract class BPartnerException internal constructor(ad_message: String, bp: I_C_BPartner?) :
    AdempiereException("@" + ad_message + "@ - " + if (bp == null) "?" else bp.searchKey + "_" + bp.name) {
    /**
     * @return the c_BPartner_ID
     */
    val c_BPartner_ID: Int

    init {
        if (bp != null) {
            this.c_BPartner_ID = bp.businessPartnerId
        } else {
            this.c_BPartner_ID = -1
        }
    }

    companion object {
        private val serialVersionUID = -4311798678799373821L
    }
}