package com.mctable.criptomarket.dashboard.data.network.response

import com.google.gson.annotations.SerializedName

data class CoinsResponse(
    @SerializedName("coins")
    val coinsList: List<CoinResponse>
)

data class CoinResponse(
    @SerializedName("uuid")
    val id: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("iconUrl")
    val icon: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("change")
    val priceVariation: String,
    @SerializedName("sparkline")
    val variation: List<String>,
    @SerializedName("24hVolume")
    val dailyVolume: String
)
