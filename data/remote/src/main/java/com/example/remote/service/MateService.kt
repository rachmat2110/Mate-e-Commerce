package com.example.remote.service

import com.example.remote.model.base.ErrorResponse
import com.example.remote.model.base.NetworkResource
import com.example.remote.model.signin.MateBaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MateService {
    @FormUrlEncoded
    @POST("signin.php")
    suspend fun postSignIn(
        @Field("email") email: String,
        @Field("password") password: String
    ) : NetworkResource<MateBaseResponse, ErrorResponse>
}