package com.mctable.criptomarket.dashboard.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _coinsListUIState = MutableLiveData<UIState<List<CoinModel>>>()
    val coinsListUIState: LiveData<UIState<List<CoinModel>>> = _coinsListUIState

    fun getCoinsList() {
        viewModelScope.launch {
            getCoinsListUseCase.execute(null).onStart {
                _coinsListUIState.postValue(UIState.Loading)
            }.catch {
                _coinsListUIState.postValue(UIState.Failure)
            }.collect {
                _coinsListUIState.postValue(UIState.Success(it))
            }
        }
    }

}