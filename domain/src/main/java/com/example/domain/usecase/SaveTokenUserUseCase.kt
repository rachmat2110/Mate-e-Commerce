package com.example.domain.usecase

import com.example.domain.repository.PreferenceRepository
import javax.inject.Inject

class SaveTokenUserUseCase @Inject constructor(
    private val repository: PreferenceRepository
) {

    operator fun invoke(token: String) {
        repository.saveString("token_user", token)
    }


}