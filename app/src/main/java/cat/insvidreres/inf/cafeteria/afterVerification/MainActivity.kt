package cat.insvidreres.inf.cafeteria.afterVerification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import cat.insvidreres.inf.cafeteria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerViewTag.id) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomMenuView

        setupWithNavController(bottomNavigationView, navController)
    }
}