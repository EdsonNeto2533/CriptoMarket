package com.mctable.criptomarket.commons.di

import com.mctable.criptomarket.dashboard.ui.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DashboardViewModel(get()) }
}