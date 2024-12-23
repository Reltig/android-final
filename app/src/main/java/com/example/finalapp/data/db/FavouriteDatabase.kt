package com.example.finalapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalapp.data.dao.FavouritesDao
import com.example.finalapp.data.model.dbEntity.FavouriteProductDbEntity

@Database(entities = [FavouriteProductDbEntity::class], version = 1, exportSchema = false)
abstract class FavouriteDatabase: RoomDatabase() {
    abstract fun favouritesDao(): FavouritesDao
}