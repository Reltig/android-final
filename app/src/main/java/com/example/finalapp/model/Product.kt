package com.example.finalapp.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class Product (
    val name: String,
    val description: String,
    val iconUrl: String,
    val price: Int,
    val rating: Float,
    val ratingsCount: Int,
    val commentsCount: Int
): Parcelable