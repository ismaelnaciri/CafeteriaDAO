package cat.insvidreres.inf.cafeteria.verification.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cat.insvidreres.inf.cafeteria.afterVerification.MainActivity
import cat.insvidreres.inf.cafeteria.databinding.ActivityLoginBinding
import cat.insvidreres.inf.cafeteria.verification.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getLogins()
        val loginsArray: MutableList<LoginModel>? = viewModel.login.value

        binding.LoginButton.setOnClickListener {
            val emailText = binding.emailLoginField.text.toString()
            val passwordText = binding.passwordLoginField.text.toString()

            val result = viewModel.checkEmailPw(loginsArray, emailText, passwordText)
            if (result) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }

}