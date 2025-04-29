package com.example.remote.model.signin


import com.google.gson.annotations.SerializedName

data class MateSignInResponse(
    @SerializedName("address")
    val address: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("profil")
    val profil: String?,
    @SerializedName("token")
    val token: String?
)