package com.mctable.criptomarket.commons.utils.implementations

import java.lang.Exception

sealed class UIState<out T> {
    object Loading : UIState<Nothing>()

    class Success<T>(val data: T) : UIState<T>()

    object Failure : UIState<Nothing>()
}
