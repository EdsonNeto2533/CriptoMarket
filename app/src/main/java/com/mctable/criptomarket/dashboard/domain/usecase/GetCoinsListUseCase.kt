package com.mctable.criptomarket.dashboard.domain.usecase

import com.mctable.criptomarket.commons.utils.implementations.IUseCase
import com.mctable.criptomarket.dashboard.data.mapper.CoinResponseToModel
import com.mctable.criptomarket.dashboard.domain.model.CoinModel
import com.mctable.criptomarket.dashboard.domain.repository.ICoinDashboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoinsListUseCase(
    private val coinDashboardRepository: ICoinDashboardRepository
) : IUseCase<Void, List<CoinModel>> {

    override suspend fun execute(param: Void?): Flow<List<CoinModel>> {
        val mapper = CoinResponseToModel()
        return flow {
           val list = mapper.transform(coinDashboardRepository.getCoinsList().data)
            emit(list)
        }
    }
}