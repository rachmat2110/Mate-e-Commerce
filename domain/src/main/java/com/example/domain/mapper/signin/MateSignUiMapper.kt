package com.example.domain.mapper.signin

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.MateSigninDomainModel
import com.example.domain.model.ui.MateSigninUiModel

class MateSignUiMapper : Mapper<MateSigninDomainModel, MateSigninUiModel> {
    override fun to(t: MateSigninDomainModel): MateSigninUiModel {
        return MateSigninUiModel(
            code = t.code,
            message = t.message,
            name = t.name,
            address = t.address,
            token = t.token,
            profil = t.profil
        )
    }
}