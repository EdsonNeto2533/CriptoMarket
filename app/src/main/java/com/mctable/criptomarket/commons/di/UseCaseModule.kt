package com.mctable.criptomarket.commons.di

import com.mctable.criptomarket.dashboard.domain.usecase.GetCoinsListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCoinsListUseCase(get()) }
}