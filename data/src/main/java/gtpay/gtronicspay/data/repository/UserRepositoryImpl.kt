package gtpay.gtronicspay.data.repository

import gtpay.gtronicspay.data.UserStorage
import gtpay.gtronicspay.data.storage.models.User
import gtpay.gtronicspay.domain.models.SaveUserNameParam
import gtpay.gtronicspay.domain.models.UserName
import gtpay.gtronicspay.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam = saveParam)
        userStorage.save(user = user)
        return true
    }

    override fun getName(): UserName {
        val user = userStorage.getName()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }
}