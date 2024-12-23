package com.example.finalapp.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class CartProduct (
    val id: Int,
    val name: String,
    val description: String,
    val iconUrl: String,
    val price: Int,
    val rating: Float,
    val ratingsCount: Int,
    val commentsCount: Int,
    val count: Int
): Parcelable