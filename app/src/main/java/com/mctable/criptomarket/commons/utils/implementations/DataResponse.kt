package com.mctable.criptomarket.commons.utils.implementations

import com.google.gson.annotations.SerializedName

data class DataResponse<T>(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: T
)