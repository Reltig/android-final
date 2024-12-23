package com.example.finalapp.data.api

import com.example.finalapp.data.model.response.MessageResponse
import com.example.finalapp.data.model.response.ProductListResponse
import com.example.finalapp.data.model.response.ProductResponse
import com.example.finalapp.data.model.response.UserAuthTokenResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface IAuthApi {
    @FormUrlEncoded
    @POST("api/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): UserAuthTokenResponse

    @FormUrlEncoded
    @POST("api/register")
    suspend fun register(
        @Field("email") email: String,
        @Field("login") login: String,
        @Field("password") password: String
    ): MessageResponse

    @POST("api/logout")
    suspend fun logout(): MessageResponse

    @GET("api/isAuth")
    suspend fun isAuth() : Boolean
}