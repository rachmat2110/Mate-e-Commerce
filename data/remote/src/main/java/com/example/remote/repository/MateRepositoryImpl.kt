package com.example.remote.repository

import android.util.Log
import com.example.domain.model.base.DomainResource
import com.example.domain.model.domain.MateSigninDomainModel
import com.example.domain.repository.MateRepository
import com.example.remote.mapper.signin.MateSigninDomainMapper
import com.example.remote.service.MateService
import com.example.remote.utils.hanleApiCall
import javax.inject.Inject

class MateRepositoryImpl @Inject constructor(
    private val mateService: MateService
) : MateRepository {
    override suspend fun postSignIn(
        email: String,
        password: String
    ): DomainResource<MateSigninDomainModel> {
        Log.d("REPOSITORY", "email = $email")
        Log.d("REPOSITORY", "password = $password")
        return hanleApiCall(
            apiServiceTransform = {
              mateService.postSignIn(
                  email, password
              )
            },
            mapperToDomain = MateSigninDomainMapper()
        )
    }

}