package com.mctable.criptomarket.commons.utils.interceptors

import com.mctable.criptomarket.commons.utils.constraints.CriptoMarketConstraints
import com.mctable.criptomarket.commons.utils.constraints.Headers
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader(Headers.TOKEN, CriptoMarketConstraints.API_KEY).build()

        return chain.proceed(newRequest)
    }
}