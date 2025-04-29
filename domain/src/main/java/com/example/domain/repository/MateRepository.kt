package com.example.domain.repository

import com.example.domain.model.base.DomainResource
import com.example.domain.model.domain.MateSigninDomainModel

interface MateRepository {

    //POST SIGN IN PARAM EMAIL AND PASSWORD
    suspend fun postSignIn(email: String, password: String) : DomainResource<MateSigninDomainModel>
}