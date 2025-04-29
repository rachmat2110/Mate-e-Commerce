package com.example.remote.mapper.signin

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.MateSigninDomainModel
import com.example.remote.model.signin.MateBaseResponse

class MateSigninDomainMapper : Mapper<MateBaseResponse, MateSigninDomainModel> {
    override fun to(t: MateBaseResponse): MateSigninDomainModel =
        MateSigninDomainModel(
            name = t.data?.name.orEmpty(),
            address = t.data?.address.orEmpty(),
            token = t.data?.token.orEmpty(),
            profil = t.data?.profil.orEmpty()
        )
}