package com.example.finalapp.mocks.api

import com.example.finalapp.data.api.IAuthApi
import com.example.finalapp.data.model.response.MessageResponse
import com.example.finalapp.data.model.response.UserAuthTokenResponse

class MockAuthApi: IAuthApi {
    private val users = mutableListOf(
        User(
            "1",
            "danil",
            "123"
        ),
        User(
            "2",
            "danil1",
            "123"
        )
    )

    private var user: User? = null

    override suspend fun login(email: String, password: String): UserAuthTokenResponse {
        user = users.find{ it.email == email && it.password == password }
        return UserAuthTokenResponse("token")
    }

    override suspend fun register(email: String, login: String, password: String): MessageResponse {
        user = User(
            email,
            login,
            password
        )
        users.add(user!!)
        return MessageResponse("message")
    }

    override suspend fun logout(): MessageResponse {
        user = null
        return MessageResponse("Log out")
    }

    override suspend fun isAuth() : Boolean {
        return user != null
    }
}

private data class User(
    val email: String,
    val username: String,
    val password: String
)