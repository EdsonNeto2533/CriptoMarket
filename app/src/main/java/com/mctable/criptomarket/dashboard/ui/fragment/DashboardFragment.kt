package com.mctable.criptomarket.dashboard.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mctable.criptomarket.R
import com.mctable.criptomarket.commons.utils.implementations.UIState
import com.mctable.criptomarket.dashboard.ui.viewmodel.DashboardViewModel
import com.mctable.criptomarket.databinding.FragmentDashboardBinding
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModel()
    private lateinit var binding: FragmentDashboardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadObservers()
        viewModel.getCoinsList()
    }

    private fun loadObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.coinsListUIState.onStart {
                print("carregando")
            }.catch {
                print("falhou")
            }.collect {
                print(it)
            }
        }
    }

}