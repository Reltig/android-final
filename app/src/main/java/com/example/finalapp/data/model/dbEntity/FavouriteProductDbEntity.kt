package com.example.finalapp.data.model.dbEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FavouriteProductDbEntity (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "iconUrl") val iconUrl: String?,
    @ColumnInfo(name = "price") val price: Int?,
    @ColumnInfo(name = "rating") val rating: Float?,
    @ColumnInfo(name = "ratingsCount") val ratingsCount: Int?,
    @ColumnInfo(name = "commentsCount") val commentsCount: Int?
)