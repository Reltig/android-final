package com.example.finalapp.data.repository.interfaces

import com.example.finalapp.model.Product

interface IShopRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProduct(id: Int): Product?
    suspend fun addProductToCart(id: Int)
    suspend fun getProductsInCart(): List<Product>
}