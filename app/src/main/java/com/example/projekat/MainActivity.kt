package com.example.projekat


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.projekat.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

}