package com.mctable.criptomarket.dashboard.data.mapper

import com.mctable.criptomarket.commons.utils.implementations.IMapper
import com.mctable.criptomarket.dashboard.data.network.response.CoinsResponse
import com.mctable.criptomarket.dashboard.domain.model.CoinModel

class CoinResponseToModel : IMapper<CoinsResponse , List<CoinModel>> {

    override fun transform(data: CoinsResponse): List<CoinModel> {
        return data.coinsList.map {
            CoinModel(
                id = it.id,
                symbol = it.symbol,
                name = it.name,
                icon = it.icon,
                price = it.price,
                priceVariation = it.priceVariation,
                variation = it.variation,
                dailyVolume = it.dailyVolume
            )
        }
    }
}