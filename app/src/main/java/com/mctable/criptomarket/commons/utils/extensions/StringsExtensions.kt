package com.mctable.criptomarket.commons.utils.extensions

fun String.formatPriceVariation(): String {
    return if (this.startsWith("-")) {
        "$this%"
    } else {
        "+$this%"
    }
}