package gtpay.gtronicspay.domain.repository

import gtpay.gtronicspay.domain.models.SaveUserNameParam
import gtpay.gtronicspay.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam) : Boolean

    fun getName(): UserName

}