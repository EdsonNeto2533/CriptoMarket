package com.mctable.criptomarket.dashboard.data.network.webservice

import com.mctable.criptomarket.commons.utils.response.DataResponse
import com.mctable.criptomarket.dashboard.data.network.api.ICoinListWebService
import com.mctable.criptomarket.dashboard.data.network.response.CoinsResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinListWebService(
    baseUrl: String
) : ICoinListWebService {

    private val webService = Retrofit.Builder()
        .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        .create(ICoinListWebService::class.java)

    override suspend fun getCoinsList(apiKey: String): Response<DataResponse<CoinsResponse>> =
        webService.getCoinsList()
}