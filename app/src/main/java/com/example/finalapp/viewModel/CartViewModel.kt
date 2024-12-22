package com.example.finalapp.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.data.repository.interfaces.IShopRepository
import com.example.finalapp.model.Product
import com.example.finalapp.state.CartState
import com.example.finalapp.utils.launchLoadingAndError


class CartViewModel(
    private val repository: IShopRepository
) : ViewModel(), IUpdatableViewModel
{
    private val mutableState = MutableListState()
    val viewState = mutableState as CartState

    init {
        loadCart()
    }

    private fun loadCart() {
        viewModelScope.launchLoadingAndError(
            handleError = { mutableState.error = it.localizedMessage },
            updateLoading = { mutableState.loading = it }
        ) {
            mutableState.items = emptyList()
            mutableState.error = null

            mutableState.items = repository.getProductsInCart()
        }
    }

    override fun update() {
        loadCart()
    }

    private class MutableListState : CartState {
        override var items: List<Product> by mutableStateOf(emptyList())
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
    }
}