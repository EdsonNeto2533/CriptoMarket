package com.mctable.criptomarket.dashboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.criptomarket.commons.utils.implementations.UIState
import com.mctable.criptomarket.dashboard.domain.model.CoinModel
import com.mctable.criptomarket.dashboard.domain.usecase.GetCoinsListUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val getCoinsListUseCase: GetCoinsListUseCase
) : ViewModel() {

    private val _coinsListUIState = MutableSharedFlow<UIState<List<CoinModel>>>()
    val coinsListUIState = _coinsListUIState.asSharedFlow()

    fun getCoinsList() {
        viewModelScope.launch {
            getCoinsListUseCase.execute(null).onStart {
                _coinsListUIState.emit(UIState.Loading)
            }.catch {
                _coinsListUIState.emit(UIState.Failure)
            }.collect {
                UIState.Success(it)
            }
        }
    }

}