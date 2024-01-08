package cat.insvidreres.inf.cafeteria.verification.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import cat.insvidreres.inf.cafeteria.afterVerification.MainActivity
import cat.insvidreres.inf.cafeteria.databinding.ActivityRegisterBinding
import cat.insvidreres.inf.cafeteria.verification.login.LoginModel

class RegisterActivity : AppCompatActivity() {
    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Wrong login credentials", Toast.LENGTH_SHORT).show()
        viewModel.loadLogins()

        binding.registerButton.setOnClickListener {
            val emailText = binding.emailLoginField.text.toString()
            val passwordText = binding.passwordLoginField.text.toString()

            val newLogin = LoginModel(emailText, passwordText)

            if (!viewModel.checkAlreadyExistingLogin(newLogin)) {
                viewModel.addNewLogin(newLogin)
                viewModel.loadLogins()
                Toast.makeText(this, "Created login successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login already exists!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}