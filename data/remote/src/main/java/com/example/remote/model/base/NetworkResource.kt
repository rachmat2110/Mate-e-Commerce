package com.example.remote.model.base

import java.io.IOException

sealed class NetworkResource<out V: Any, out T: Any> {
    data class NetworkSuccess<V: Any>(val data: V?) : NetworkResource<V, Nothing>()
    data class NetworkApiError<T: Any>(val errData: T?, val code: Int) : NetworkResource<Nothing, T>()
    data class NetworkError(val error: IOException?) : NetworkResource<Nothing, Nothing>()
    data class NetworkUnknownError(val error: Throwable?) : NetworkResource<Nothing, Nothing>()
}