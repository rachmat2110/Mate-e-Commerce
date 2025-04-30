package com.example.auth.ui.signin

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.state.SigninState
import com.example.domain.model.base.UiState
import com.example.domain.usecase.PostMateSigninUseCase
import com.example.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigator: Navigator,
    private val postMateSigninUseCase: PostMateSigninUseCase
) : ViewModel(){

    private val _signIn: MutableLiveData<SigninState> = MutableLiveData()
    val signIn: LiveData<SigninState> = _signIn

    fun postSignin(email: String, password: String) =
        viewModelScope.launch(Dispatchers.Main) {
            postMateSigninUseCase.invoke(email, password).collect{
                when(it){
                    is UiState.OnFailed -> {
                        _signIn.value = SigninState.OnSigninError(it.domainResourceError?.message.orEmpty())
                    }
                    is UiState.OnLoading -> {
                        _signIn.value = SigninState.OnSigninLoading
                    }
                    is UiState.OnSuccess -> {
                        _signIn.value = SigninState.OnSigninAvailable(it.data)
                    }
                }
            }
        }

    fun onNavigateToHome(context: Context){
        navigator.navigateToFeatureHome(context)
    }
}