package com.example.bottombarwithnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpbottomNavigationWithNavController()
    }

    private fun setUpbottomNavigationWithNavController(){
        navController = findNavController(R.id.navHostFragment)
        bottomNavView.setupWithNavController(navController)
    }

}