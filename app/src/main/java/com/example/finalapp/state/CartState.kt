package com.example.finalapp.state

import androidx.compose.runtime.Stable
import com.example.finalapp.model.CartProduct

@Stable
interface CartState: BaseListState {
    val items: List<CartProduct>
    val isAuthentificated: Boolean
}