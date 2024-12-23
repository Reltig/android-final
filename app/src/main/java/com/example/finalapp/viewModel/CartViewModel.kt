package com.example.finalapp.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.data.repository.interfaces.IShopRepository
import com.example.finalapp.model.CartProduct
import com.example.finalapp.model.Product
import com.example.finalapp.services.AuthService
import com.example.finalapp.state.CartState
import com.example.finalapp.utils.launchLoadingAndError


class CartViewModel(
    private val repository: IShopRepository,
    private val auth: AuthService
) : ViewModel()
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
            mutableState.isAuthentificated = auth.isAuth()
            if (mutableState.isAuthentificated) {
                mutableState.items = repository.getProductsInCart()
            }
        }
    }

    private class MutableListState : CartState {
        override var items: List<CartProduct> by mutableStateOf(emptyList())
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
        override var isAuthentificated: Boolean by mutableStateOf(false)
    }
}