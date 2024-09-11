package com.example.myapplication6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication6.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    var list= mutableListOf<User>()
    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set content view after initializing binding
        val navHost= supportFragmentManager.findFragmentById(R.id.fragmentContainerView)as NavHostFragment
        navController= navHost.navController
    }
}
