package com.mctable.criptomarket.dashboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.criptomarket.dashboard.domain.model.CoinModel
import com.mctable.criptomarket.dashboard.domain.usecase.GetCoinsListUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val getCoinsListUseCase: GetCoinsListUseCase
) : ViewModel() {

    private val _coinsListUIState = MutableSharedFlow<List<CoinModel>>()
    val coinsListUIState = _coinsListUIState.asSharedFlow()

    fun getCoinsList() {
        viewModelScope.launch {
            getCoinsListUseCase.execute(null).collect {
                _coinsListUIState.emit(it)
            }
        }
    }

}