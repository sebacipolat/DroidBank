package com.cipolat.droidbank.data.home.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val name: String,
    @Json(name = "avatar_url")
    val avatarUrl: String
)
