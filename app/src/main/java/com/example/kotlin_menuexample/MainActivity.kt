package com.example.kotlin_menuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.kotlin_menuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MENU NAVIGATION DRAWER
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().replace(R.id.flFragment, firstFragment).commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
//                R.id.home->setCurrentFragment(firstFragment)
                R.id.home -> supportFragmentManager.beginTransaction().replace(R.id.flFragment, firstFragment).commit()
                R.id.settings -> supportFragmentManager.beginTransaction().replace(R.id.flFragment, secondFragment).commit()
            }
            true
        }
    }
}