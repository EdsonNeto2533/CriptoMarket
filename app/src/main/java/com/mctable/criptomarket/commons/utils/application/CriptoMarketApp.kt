package com.mctable.criptomarket.commons.utils.application

import android.app.Application
import com.mctable.criptomarket.commons.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CriptoMarketApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CriptoMarketApp)
            modules(
                webService,
                repositoryModule,
                useCaseModule,
                viewModelModule,
                interceptorsModule
            )
        }
    }
}