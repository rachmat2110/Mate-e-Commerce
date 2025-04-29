package com.example.domain.mapper.signin

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.MateSigninDomainModel
import com.example.domain.model.ui.MateSigninUiModel

class MateSignUiMapper : Mapper<MateSigninDomainModel, MateSigninUiModel> {
    override fun to(t: MateSigninDomainModel): MateSigninUiModel {
        return MateSigninUiModel(
            name = t.name,
            address = t.address,
            token = t.token,
            profil = t.profil
        )
    }
}