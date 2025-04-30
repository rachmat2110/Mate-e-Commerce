package com.example.remote.model.base

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("code")
    val code: Int? = 0,

    @SerializedName("message")
    val message: String? = null
)