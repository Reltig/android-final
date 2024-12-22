package com.example.finalapp.mocks.api

import android.util.Log
import com.example.finalapp.data.api.IShopApi
import com.example.finalapp.data.model.response.ProductListResponse
import com.example.finalapp.data.model.response.ProductResponse
import com.example.finalapp.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MockShopApi: IShopApi {
    private val db = listOf(
        ProductResponse(
            id = 0,
            name = "String",
            description = "String",
            iconUrl = "String",
            price = 100,
            rating = 5f,
            ratingsCount = 1,
            commentsCount = 1
        ),
        ProductResponse(
            id = 1,
            name = "String2",
            description = "String2",
            iconUrl = "String2",
            price = 200,
            rating = 4.5f,
            ratingsCount = 2,
            commentsCount = 2
        ),
        ProductResponse(
            id = 2,
            name = "String3",
            description = "String3",
            iconUrl = "String3",
            price = 300,
            rating = 5.5f,
            ratingsCount = 3,
            commentsCount = 3
        )
    )

    private val cart = mutableListOf<ProductResponse>()

    override suspend fun getProducts(limit: Int): ProductListResponse {
        return withContext(Dispatchers.IO) {
            ProductListResponse(data = db)
        }
    }

    override suspend fun getProduct(id: Int): ProductResponse? {
        return withContext(Dispatchers.IO) {
            db.find { it.id == id }
        }
    }

    override suspend fun addProductToCart(id: Int) {
        return withContext(Dispatchers.IO) {
            val product = db.find{it.id == id}
            if (product == null)
                return@withContext
            if(cart.find{it.id == id} != null)
                return@withContext
            cart.add(product)
        }
    }

    override suspend fun getProductsInCart(): ProductListResponse {
        return withContext(Dispatchers.IO) {
            ProductListResponse(data = cart)
        }
    }
}