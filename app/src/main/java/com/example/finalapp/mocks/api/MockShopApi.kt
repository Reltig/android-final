package com.example.finalapp.mocks.api

import android.util.Log
import com.example.finalapp.data.api.IShopApi
import com.example.finalapp.data.model.response.CartProductListResponse
import com.example.finalapp.data.model.response.CartProductResponse
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
            iconUrl = "https://placehold.co/400x400/F00/0FF/png",
            price = 100,
            rating = 5f,
            ratingsCount = 1,
            commentsCount = 1
        ),
        ProductResponse(
            id = 1,
            name = "String2",
            description = "String2",
            iconUrl = "https://placehold.co/400x400/FF0/00F/png",
            price = 200,
            rating = 4.5f,
            ratingsCount = 2,
            commentsCount = 2
        ),
        ProductResponse(
            id = 2,
            name = "String3",
            description = "String3",
            iconUrl = "https://placehold.co/400x400/F0F/FFF/png",
            price = 300,
            rating = 5.5f,
            ratingsCount = 3,
            commentsCount = 3
        )
    )

    private val cart = mutableListOf<CartProductResponse>()

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
            cart.add(CartProductResponse(
                id = product.id,
                name = product.name,
                description = product.description,
                iconUrl = product.iconUrl,
                commentsCount = product.commentsCount,
                price = product.price,
                ratingsCount = product.ratingsCount,
                rating = product.rating,
                count = 1
            ))
        }
    }

    override suspend fun getProductsInCart(): CartProductListResponse {
        return withContext(Dispatchers.IO) {
            CartProductListResponse(data = cart)
        }
    }
}