package com.example.finalapp.di

import android.content.Context
import androidx.room.Room
import com.example.finalapp.data.db.FavouriteDatabase
import org.koin.dsl.module

val dbModule = module {
    single { DatabaseBuilder.getInstance(get()) }
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
}