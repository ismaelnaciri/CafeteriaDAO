package cat.insvidreres.inf.cafeteria.verification.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cat.insvidreres.inf.cafeteria.verification.login.LoginModel
import cat.insvidreres.inf.cafeteria.verification.login.LoginProvider

class RegisterViewModel : ViewModel() {

    private val _newLogin = MutableLiveData<LoginModel>()
    val newLogin: LiveData<LoginModel> = _newLogin

    private var _logins = MutableLiveData<MutableList<LoginModel>>()
    val logins: LiveData<MutableList<LoginModel>> = _logins

    fun loadLogins() {
        _logins.value = LoginProvider.loadLogins()
    }

    fun addNewLogin(newLogin: LoginModel) {
        _logins.value?.add(newLogin)
    }

    fun checkAlreadyExistingLogin(newLogin: LoginModel): Boolean {
        return LoginProvider.checkIfEntryExists(newLogin)
    }
}