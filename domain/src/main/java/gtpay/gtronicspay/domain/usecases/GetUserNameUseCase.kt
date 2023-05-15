package gtpay.gtronicspay.domain.usecases

import gtpay.gtronicspay.domain.models.UserName
import gtpay.gtronicspay.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}