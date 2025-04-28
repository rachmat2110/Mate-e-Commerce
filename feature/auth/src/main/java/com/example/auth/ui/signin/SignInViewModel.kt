package com.example.auth.ui.signin

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel(){
    fun onNavigateToHome(context: Context){
        navigator.navigateToFeatureHome(context)
    }
}