package com.mctable.criptomarket.dashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mctable.criptomarket.R
import com.mctable.criptomarket.commons.ui.dialogs.LoadingDialog
import com.mctable.criptomarket.dashboard.ui.viewmodel.DashboardViewModel
import com.mctable.criptomarket.databinding.FragmentDashboardBinding
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModel()
    private lateinit var binding: FragmentDashboardBinding
    private val loadingDialog: LoadingDialog by inject { parametersOf(requireActivity()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadObservers()
        viewModel.getCoinsList()
    }

    private fun loadObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.coinsListUIState.onStart {
                loadingDialog.show()
            }.catch {
                print("falhou")
            }.collect {
                loadingDialog.dismiss()
                print(it)
            }
        }
    }

}