package com.mctable.criptomarket.dashboard.domain.repository

import com.mctable.criptomarket.commons.utils.implementations.DataResponse
import com.mctable.criptomarket.dashboard.data.network.response.CoinsResponse
import retrofit2.Response

interface ICoinDashboardRepository {

    suspend fun getCoinsList(): Response<DataResponse<CoinsResponse>>
}