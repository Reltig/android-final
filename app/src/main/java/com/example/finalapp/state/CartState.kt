package com.example.finalapp.state

import androidx.compose.runtime.Stable
import com.example.finalapp.model.Product

@Stable
interface CartState: BaseListState {
    val items: List<Product>
}