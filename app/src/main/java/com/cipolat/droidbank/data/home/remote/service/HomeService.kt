package com.cipolat.droidbank.data.home.remote.service

import com.cipolat.droidbank.data.home.remote.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("home")
    suspend fun getHome(): Response<HomeResponse>
}
