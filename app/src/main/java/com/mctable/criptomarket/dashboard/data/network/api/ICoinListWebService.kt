package com.mctable.criptomarket.dashboard.data.network.api

import com.mctable.criptomarket.commons.utils.response.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ICoinListWebService {

    @GET("/coins")
    fun getCoinsList(): Response<DataResponse<String>>
}