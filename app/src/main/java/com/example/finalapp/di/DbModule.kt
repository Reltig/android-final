package com.example.finalapp.di

import android.content.Context
import androidx.room.Room
import com.example.finalapp.data.dao.FavouritesDao
import com.example.finalapp.data.db.FavouriteDatabase
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

val dbModule = module {
    single { DatabaseBuilder.provideFavouriteDb(androidContext()) }
}

object DatabaseBuilder {
    private var INSTANCE: FavouriteDatabase? = null

    fun getInstance(context: Context): FavouriteDatabase {
        if (INSTANCE == null) {
            synchronized(FavouriteDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            FavouriteDatabase::class.java,
            "favourite-v1"
        ).build()

    fun provideFavouriteDb(applicationContext: Context): FavouritesDao {
        val db = getInstance(applicationContext)
        return db.favouritesDao()
    }
}