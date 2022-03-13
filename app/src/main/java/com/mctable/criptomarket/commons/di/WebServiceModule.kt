package com.mctable.criptomarket.commons.di

import com.mctable.criptomarket.commons.utils.constraints.CriptoMarketConstraints
import com.mctable.criptomarket.dashboard.data.network.api.ICoinListWebService
import com.mctable.criptomarket.dashboard.data.network.webservice.CoinListWebService
import org.koin.dsl.module

val webService = module {
    single<ICoinListWebService> { CoinListWebService(CriptoMarketConstraints.BASE_URL) }
}