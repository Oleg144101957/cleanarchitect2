package gtpay.gtronicspay.cleanarchitect2.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import gtpay.gtronicspay.data.UserStorage
import gtpay.gtronicspay.data.repository.UserRepositoryImpl
import gtpay.gtronicspay.data.storage.sharedprefs.SharedPrefUserStorage
import gtpay.gtronicspay.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }

}