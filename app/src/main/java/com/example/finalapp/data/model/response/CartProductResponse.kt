package com.example.finalapp.data.model.response

data class CartProductResponse(
    val id: Int,
    val name: String,
    val description: String,
    val iconUrl: String,
    val price: Int,
    val rating: Float,
    val ratingsCount: Int,
    val commentsCount: Int,
    val count: Int
)
