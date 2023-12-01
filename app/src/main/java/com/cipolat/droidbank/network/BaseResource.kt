package com.cipolat.droidbank.network

import android.accounts.NetworkErrorException
import okhttp3.ResponseBody
import retrofit2.Response
import java.net.UnknownHostException

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
    try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            body?.let {
                return Resource.success(body)
            }
        }
        return error(Resource.ErrorType.API_ERROR, response.errorBody())
    } catch (e: Exception) {
        return if (e is UnknownHostException || e is NetworkErrorException) {
            error(Resource.ErrorType.NETWORK)
        } else {
            error(Resource.ErrorType.API_ERROR)
        }
    }
}

private fun <T> error(error: Resource.ErrorType, bodyError: ResponseBody? = null): Resource<T> =
    Resource.error(errorType = error, errorBody = bodyError)
