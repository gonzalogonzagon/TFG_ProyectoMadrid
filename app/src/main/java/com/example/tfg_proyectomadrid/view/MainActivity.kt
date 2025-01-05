package com.example.tfg_proyectomadrid.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tfg_proyectomadrid.R
import com.example.tfg_proyectomadrid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initUI()
    }

    // (Made by user) Function to initialize the UI and call other functions
    private fun initUI() {
        initNavigation()
    }

    // (Made by user) Function to initialize the navigation
    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as? NavHostFragment
        if (navHostFragment != null) {
            navController = navHostFragment.navController
            binding.bottomNavMenu.setupWithNavController(navController)
        } else {
            // Manejo del caso en que el fragmento no se encuentra
            handleError("NavHostFragment no encontrado")
        }
    }

    // (Made by user) Function to handle errors
    private fun handleError(message: String) {
        // Mostrar mensaje al usuario
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        // Registrar el error en la consola
        Log.e("MainActivity", message)
    }
}