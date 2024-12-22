package com.example.finalapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.data.repository.interfaces.IShopRepository
import com.example.finalapp.model.Product
import com.example.finalapp.state.ShopState
import com.example.finalapp.utils.launchLoadingAndError

class ShopViewModel(
    private val repository: IShopRepository
) : ViewModel()
{
    private val mutableState = MutableListState()
    val viewState = mutableState as ShopState

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launchLoadingAndError(
            handleError = { mutableState.error = it.localizedMessage },
            updateLoading = { mutableState.loading = it }
        ) {
            mutableState.items = emptyList()
            mutableState.error = null

            mutableState.items = repository.getProducts()
        }
    }

    private class MutableListState : ShopState {
        override var items: List<Product> by mutableStateOf(emptyList())
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
    }
}