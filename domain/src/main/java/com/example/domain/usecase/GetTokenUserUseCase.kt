package com.example.domain.usecase

import com.example.domain.repository.PreferenceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetTokenUserUseCase @Inject constructor(
    private val repository: PreferenceRepository
) {

    operator fun invoke(): Flow<String> = flow {
        emit(repository.getString("token_user"))
    }.flowOn(Dispatchers.IO)

}