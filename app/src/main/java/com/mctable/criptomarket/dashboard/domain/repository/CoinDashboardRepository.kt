package com.mctable.criptomarket.dashboard.domain.repository

import com.mctable.criptomarket.commons.utils.implementations.DataResponse
import com.mctable.criptomarket.dashboard.data.network.api.ICoinListWebService
import com.mctable.criptomarket.dashboard.data.network.response.CoinsResponse
import retrofit2.Response

class CoinDashboardRepository(
    private val coinWebService: ICoinListWebService
) : ICoinDashboardRepository {

    override suspend fun getCoinsList(): Response<DataResponse<CoinsResponse>> {
        return coinWebService.getCoinsList()
    }
}