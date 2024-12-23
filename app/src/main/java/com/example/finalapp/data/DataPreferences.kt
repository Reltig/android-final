package com.example.finalapp.data

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.preferences.preferencesDataStore

private val Context.dataStore by preferencesDataStore(name = "app_preferences")

object DataPreferences {
    private const val PREF_NAME = "SharedPreferences"
    private lateinit var sharedPreferences: SharedPreferences
    private const val API_TOKEN = "API_TOKEN"

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun getToken(defaultValue: String = ""): String {
        return sharedPreferences.getString(API_TOKEN, defaultValue) ?: defaultValue
    }

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(API_TOKEN, token).apply()
    }
}