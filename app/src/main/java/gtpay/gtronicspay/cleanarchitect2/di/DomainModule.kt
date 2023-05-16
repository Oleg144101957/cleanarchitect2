package gtpay.gtronicspay.cleanarchitect2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import gtpay.gtronicspay.domain.repository.UserRepository
import gtpay.gtronicspay.domain.usecases.GetUserNameUseCase
import gtpay.gtronicspay.domain.usecases.SaveUserNameUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository ) : GetUserNameUseCase{
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository = userRepository)
    }

}