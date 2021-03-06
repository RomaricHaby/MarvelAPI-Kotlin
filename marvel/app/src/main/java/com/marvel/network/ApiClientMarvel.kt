package com.marvel.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.marvel.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientMarvel {
    private const val BASE_URL: String = BuildConfig.BASE_URL

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(ApiInterceptorMarvel())
            //.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiServiceMarvel: ApiServiceMarvel by lazy {
        retrofit.create(ApiServiceMarvel::class.java)
    }
}