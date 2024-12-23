package com.example.finalapp.di

import com.example.finalapp.BuildConfig
import com.example.finalapp.data.api.IAuthApi
import com.example.finalapp.data.api.IShopApi
import com.example.finalapp.mocks.api.MockAuthApi
import com.example.finalapp.mocks.api.MockShopApi
import org.koin.dsl.module
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    //single<IShopApi> {MockShopApi()}
    //single<IAuthApi> { MockAuthApi() }
    factory { provideRetrofit() }
    single<IShopApi> { provideShopApi(get()) }
    single<IAuthApi> { provideAuthApi(get()) }
}

fun provideRetrofit(): Retrofit {
    val intercepter = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.HEADERS
    }
    val client = OkHttpClient.Builder()
        //.addInterceptor(TokenInterceptor())
        .addInterceptor(intercepter)
        .build()

    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun provideShopApi(retrofit: Retrofit): IShopApi =
    retrofit.create(IShopApi::class.java)

fun provideAuthApi(retrofit: Retrofit): IAuthApi =
    retrofit.create(IAuthApi::class.java)