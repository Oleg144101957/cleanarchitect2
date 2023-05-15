package gtpay.gtronicspay.domain.usecases

import gtpay.gtronicspay.domain.models.SaveUserNameParam
import gtpay.gtronicspay.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean{
        val result = userRepository.saveName(saveParam = param)
        return result
    }

}