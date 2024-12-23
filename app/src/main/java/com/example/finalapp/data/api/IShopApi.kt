package com.example.finalapp.data.api

import com.example.finalapp.data.model.response.CartProductListResponse
import com.example.finalapp.data.model.response.ProductListResponse
import com.example.finalapp.data.model.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IShopApi {
    @GET("api/products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 10
    ): ProductListResponse

    @GET("api/products/{id}")
    suspend fun getProduct(@Path("id") id: Int): ProductResponse?

    @POST("api/cart/add/{id}")
    suspend fun addProductToCart(
        @Path("id") id: Int,
    )

    @GET("api/cart")
    suspend fun getProductsInCart(): CartProductListResponse
}