package com.mctable.criptomarket.dashboard.domain.model

data class CoinModel(
    val id: String,
    val symbol: String,
    val name: String,
    val icon: String,
    val price: String,
    val priceVariation: String,
    val variation: List<String>,
    val dailyVolume: String
)
