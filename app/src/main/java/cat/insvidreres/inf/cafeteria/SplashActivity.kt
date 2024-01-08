package cat.insvidreres.inf.cafeteria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.insvidreres.inf.cafeteria.afterVerification.MainActivity
import cat.insvidreres.inf.cafeteria.verification.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
    }
}