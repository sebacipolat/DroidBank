package com.cipolat.droidbank.data.network.client

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // Permite la conversión de tipos de datos de Kotlin
            .build()

        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(url)
            .build()
    }
}
