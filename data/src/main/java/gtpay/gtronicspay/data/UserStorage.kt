package gtpay.gtronicspay.data

import gtpay.gtronicspay.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun getName(): User

}