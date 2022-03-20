package com.mctable.criptomarket.commons.di

import com.mctable.criptomarket.commons.utils.interceptors.AuthInterceptor
import org.koin.dsl.module

val interceptorsModule = module {
    factory { AuthInterceptor() }
}