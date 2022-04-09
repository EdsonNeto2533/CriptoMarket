package com.mctable.criptomarket.dashboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mctable.criptomarket.R
import com.mctable.criptomarket.commons.utils.extensions.changeFragment
import com.mctable.criptomarket.dashboard.ui.fragment.DashboardFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            changeFragment(R.id.container, DashboardFragment())
        }
    }
}