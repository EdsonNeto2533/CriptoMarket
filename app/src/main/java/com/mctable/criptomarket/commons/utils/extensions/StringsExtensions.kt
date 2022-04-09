package com.mctable.criptomarket.commons.utils.extensions

fun String.formatPriceVariation(): String {
    return if (this.startsWith("-")) {
        "$this%"
    } else {
        "+$this%"
    }
}

fun String.formatToCurrencyValue(): String {
    val numbers = this.toDouble()
    return this.reversed()
        .chunked(3)
        .joinToString(",")
        .reversed() + if (numbers % 1 > 0) ".${(numbers % 1).toString().split(".")[1].take(2)}" else ""
}