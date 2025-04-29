package com.example.remote.model.signin


import com.google.gson.annotations.SerializedName

data class MateBaseResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val data: MateSignInResponse?,
    @SerializedName("message")
    val message: String?
)