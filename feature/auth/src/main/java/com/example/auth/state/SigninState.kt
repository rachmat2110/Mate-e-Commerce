package com.example.auth.state

import com.example.domain.model.ui.MateSigninUiModel

sealed class SigninState {
    data class OnSigninAvailable(
        val signinUiModel: MateSigninUiModel?
    ) : SigninState()

    object OnSigninLoading : SigninState()
    data class OnSigninError(
        val message: String
    ) : SigninState()
}