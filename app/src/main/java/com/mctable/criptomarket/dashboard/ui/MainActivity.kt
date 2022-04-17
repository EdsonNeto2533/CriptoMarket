package com.mctable.criptomarket.dashboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mctable.criptomarket.R
import com.mctable.criptomarket.commons.utils.extensions.changeFragment
import com.mctable.criptomarket.dashboard.ui.fragment.DashboardFragment
import com.mctable.criptomarket.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            changeFragment(R.id.container, DashboardFragment())
        }
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bnvMain.selectedItemId = R.id.bottom_menu_home
        binding.bnvMain.setOnItemSelectedListener { menuId ->
            when (menuId.itemId) {
                R.id.bottom_menu_home -> {
                    changeFragment(R.id.container, DashboardFragment())
                }
                R.id.bottom_menu_exchanges -> {

                }
                R.id.bottom_menu_market -> {

                }
            }
            return@setOnItemSelectedListener true
        }
    }
}