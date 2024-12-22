package com.example.finalapp.data.mapper

import com.example.finalapp.data.model.response.ProductListResponse
import com.example.finalapp.data.model.response.ProductResponse
import com.example.finalapp.model.Product

class ShopResponseMapper {
    fun mapList(response: ProductListResponse): List<Product> {
        return response.data?.map {
            mapProduct(it)
        }.orEmpty()
    }

    fun mapProduct(response: ProductResponse): Product {
        return Product(
            id = response.id,
            name = response.name,
            description = response.description,
            iconUrl = response.iconUrl,
            commentsCount = response.commentsCount,
            price = response.price,
            ratingsCount = response.ratingsCount,
            rating = response.rating
        )
    }
}