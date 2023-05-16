package gtpay.gtronicspay.cleanarchitect2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import gtpay.gtronicspay.domain.models.SaveUserNameParam
import gtpay.gtronicspay.domain.usecases.GetUserNameUseCase
import gtpay.gtronicspay.domain.usecases.SaveUserNameUseCase
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
    ) : ViewModel() {

        private val resultLiveDataMutable = MutableLiveData<String>()
        val resultLiveData: LiveData<String> = resultLiveDataMutable

    fun save(text: String){
        val params = SaveUserNameParam(text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveDataMutable.value = "The result is $resultData"
    }

    fun load(){
        val userName = getUserNameUseCase.execute()
        resultLiveDataMutable.value = "The firstName is ${userName.firstName}, The last name is ${userName.lastName}"
    }


}