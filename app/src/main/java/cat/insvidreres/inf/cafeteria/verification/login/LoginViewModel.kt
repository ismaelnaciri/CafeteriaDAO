package cat.insvidreres.inf.cafeteria.verification.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _login = MutableLiveData<MutableList<LoginModel>>()
    val login: LiveData<MutableList<LoginModel>> = _login

    fun getLogins() {
        _login.value = LoginProvider.loadLogins()
    }

    fun checkEmailPw(loginArray: List<LoginModel>?, email: String, password: String): Boolean {
        if (loginArray != null) {
            for (login in loginArray) {
                if (login.email == email && login.password == password) {
                    return true
                }
            }
        }
        return false
    }
}