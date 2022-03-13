package com.mctable.criptomarket.dashboard.data.network.webservice

import com.mctable.criptomarket.commons.utils.implementations.DataResponse
import com.mctable.criptomarket.commons.utils.interceptors.AuthInterceptor
import com.mctable.criptomarket.dashboard.data.network.api.ICoinListWebService
import com.mctable.criptomarket.dashboard.data.network.response.CoinsResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinListWebService(
    baseUrl: String,
    authInterceptor: AuthInterceptor
) : ICoinListWebService {

    private val okHttpBuilder = OkHttpClient.Builder().apply {
        interceptors().add(authInterceptor)
    }

    private val webService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpBuilder.build())
        .build()
        .create(ICoinListWebService::class.java)

    override suspend fun getCoinsList(): DataResponse<CoinsResponse> {
        return webService.getCoinsList()
    }
}