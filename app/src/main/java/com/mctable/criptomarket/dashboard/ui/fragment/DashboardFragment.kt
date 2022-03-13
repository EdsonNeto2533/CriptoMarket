package com.mctable.criptomarket.dashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mctable.criptomarket.R
import com.mctable.criptomarket.dashboard.ui.viewmodel.DashboardViewModel
import com.mctable.criptomarket.databinding.FragmentDashboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModel()
    private lateinit var binding: FragmentDashboardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadObservers()
    }

    private fun loadObservers(){
        lifecycleScope.launchWhenStarted {  }
    }

}