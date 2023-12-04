package com.cipolat.droidbank.data.network

import okhttp3.ResponseBody

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val errorType: ErrorType?,
    val extra: Any? = null
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    enum class ErrorType {
        NETWORK,
        API_ERROR
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(
            errorType: ErrorType? = null,
            errorBody: ResponseBody? = null,
            data: T? = null
        ): Resource<T> {
            return Resource(
                status = Status.ERROR,
                errorType = errorType,
                data = data,
                extra = errorBody
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
