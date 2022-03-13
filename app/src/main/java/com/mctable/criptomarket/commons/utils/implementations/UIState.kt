package com.mctable.criptomarket.commons.utils.implementations

import java.lang.Exception

sealed class UIState {
    object Loading : UIState()

    class Success<T>(val data: T) : UIState()

    class Failure(e: Exception) : UIState()
}
