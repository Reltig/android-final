package com.example.finalapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalapp.model.Product
import com.example.finalapp.state.ShopState

class ShopViewModel(

) : ViewModel()
{
    private val mutableState = MutableListState()
    val viewState = mutableState as ShopState

    init {
        mutableState.items = listOf(
            Product(
                name = "String",
                description = "String",
                iconUrl = "String",
                price = 100,
                rating = 5f,
                ratingsCount = 1,
                commentsCount = 1
            ),
            Product(
                name = "String2",
                description = "String2",
                iconUrl = "String2",
                price = 200,
                rating = 4.5f,
                ratingsCount = 2,
                commentsCount = 2
            )
        )
    }

    private class MutableListState : ShopState {
        override var items: List<Product> by mutableStateOf(emptyList())
        override var error: String? by mutableStateOf(null)
        override var loading: Boolean by mutableStateOf(false)
    }
}