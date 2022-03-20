package com.mctable.criptomarket.commons.di

import com.mctable.criptomarket.dashboard.domain.repository.CoinDashboardRepository
import com.mctable.criptomarket.dashboard.domain.repository.ICoinDashboardRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ICoinDashboardRepository> { CoinDashboardRepository(get()) }
}