package com.example.domain.usecase

import com.example.domain.mapper.signin.MateSignUiMapper
import com.example.domain.model.base.DomainResource
import com.example.domain.model.base.UiState
import com.example.domain.model.ui.MateSigninUiModel
import com.example.domain.repository.MateRepository
import com.example.domain.utils.mapTo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostMateSigninUseCase @Inject constructor(
    private val repository: MateRepository
){
    operator fun invoke(
        email: String,
        password: String
    ) : Flow<UiState<MateSigninUiModel>> = flow{
        emit(UiState.OnLoading())

        when(val result = repository.postSignIn(email, password)){
            is DomainResource.OnError -> {
                emit(UiState.OnFailed(domainResourceError = result.domainResourceError))
            }
            is DomainResource.OnSuccess ->{
                val dataResult = result.data
                emit(UiState.OnSuccess(dataResult.mapTo(MateSignUiMapper())))
            }
            else -> Unit
        }
    }
}