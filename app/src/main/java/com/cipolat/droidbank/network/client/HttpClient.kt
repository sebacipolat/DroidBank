package com.cipolat.droidbank.network.client


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpClient {
    private lateinit var client: Retrofit

    fun init(url: String) {
        client = build(url)
    }

    fun getClient(): Retrofit {
        return client
    }

    private fun build(url: String): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .build()

        return Retrofit.Builder().client(okHttpClient)
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}