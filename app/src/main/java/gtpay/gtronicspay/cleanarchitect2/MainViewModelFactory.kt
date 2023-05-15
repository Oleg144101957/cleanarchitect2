package gtpay.gtronicspay.cleanarchitect2

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import gtpay.gtronicspay.data.repository.UserRepositoryImpl
import gtpay.gtronicspay.data.storage.sharedprefs.SharedPrefUserStorage
import gtpay.gtronicspay.domain.usecases.GetUserNameUseCase
import gtpay.gtronicspay.domain.usecases.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

        private val userRepository by lazy (LazyThreadSafetyMode.NONE){
            UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
        }

        private val getUserNameUseCase by lazy (LazyThreadSafetyMode.NONE){
            GetUserNameUseCase(userRepository = userRepository)
        }
        private val saveUserNameUseCase by lazy (LazyThreadSafetyMode.NONE){
            SaveUserNameUseCase(userRepository = userRepository)
        }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }

}