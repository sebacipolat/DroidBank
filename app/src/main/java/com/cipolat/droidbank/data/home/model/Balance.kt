package com.cipolat.droidbank.data.home.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Balance(val mount: String)