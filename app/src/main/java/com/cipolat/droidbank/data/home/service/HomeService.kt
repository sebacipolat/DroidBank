package com.cipolat.droidbank.data.home.service

import com.cipolat.droidbank.data.home.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("home")
    suspend fun getHome(): Response<HomeResponse>
}
