package com.example.finalapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.finalapp.data.model.dbEntity.FavouriteProductDbEntity

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM FavouriteProductDbEntity")
    suspend fun getAll(): List<FavouriteProductDbEntity>

    @Insert
    suspend fun insert(favouriteDbEntity: FavouriteProductDbEntity)

    @Query("DELETE FROM FavouriteProductDbEntity WHERE id = :id")
    suspend fun deleteById(id: Int);
}