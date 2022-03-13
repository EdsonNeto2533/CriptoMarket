package com.mctable.criptomarket.dashboard.data.network.api

import com.mctable.criptomarket.commons.utils.constraints.CriptoMarketConstraints
import com.mctable.criptomarket.commons.utils.constraints.Headers
import com.mctable.criptomarket.commons.utils.implementations.DataResponse
import com.mctable.criptomarket.dashboard.data.network.response.CoinsResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ICoinListWebService {

    @GET("coins")
    suspend fun getCoinsList(@Header(Headers.TOKEN) apiKey: String = CriptoMarketConstraints.API_KEY):
            DataResponse<CoinsResponse>
}