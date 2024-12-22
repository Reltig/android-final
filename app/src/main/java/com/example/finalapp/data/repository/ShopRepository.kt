package com.example.finalapp.data.repository

import com.example.finalapp.data.api.IShopApi
import com.example.finalapp.data.mapper.ShopResponseMapper
import com.example.finalapp.data.repository.interfaces.IShopRepository
import com.example.finalapp.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShopRepository(
    private val api: IShopApi,
    private val mapper: ShopResponseMapper
): IShopRepository {
    override suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            mapper.mapList(api.getProducts())
        }
    }

    override suspend fun getProduct(id: Int): Product? {
        return withContext(Dispatchers.IO) {
            api.getProduct(id)?.let { mapper.mapProduct(it) }
        }
    }

    override suspend fun addProductToCart(id: Int) {
        return withContext(Dispatchers.IO) {
            api.addProductToCart(id)
        }
    }

    override suspend fun getProductsInCart(): List<Product> {
        return withContext(Dispatchers.IO) {
            mapper.mapList(api.getProductsInCart())
        }
    }
}