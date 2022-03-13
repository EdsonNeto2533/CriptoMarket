package com.mctable.criptomarket.dashboard.domain.repository

import com.mctable.criptomarket.commons.utils.implementations.DataResponse
import com.mctable.criptomarket.dashboard.data.network.response.CoinsResponse
import kotlinx.coroutines.flow.Flow

interface ICoinDashboardRepository {

    suspend fun getCoinsList(): DataResponse<CoinsResponse>
}