package com.example.finalapp.services

import com.example.finalapp.data.DataPreferences
import com.example.finalapp.data.api.IAuthApi

class AuthService(
    private val api: IAuthApi
) {
    suspend fun login(email: String, password: String) {
        val token = api.login(email, password).accessToken
        DataPreferences.saveToken(token)
    }

    suspend fun logout() {
        api.logout()
    }

    suspend fun isAuth(): Boolean {
        return api.isAuth()
    }
}