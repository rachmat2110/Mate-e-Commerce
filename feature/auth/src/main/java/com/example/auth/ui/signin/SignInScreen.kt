package com.example.auth.ui.signin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.auth.MainActivity
import com.example.auth.state.SigninState
import com.example.ui.component.MateButtonPrimary
import com.example.ui.component.MateButtonSosmedRow
import com.example.ui.component.MateEditText
import com.example.ui.component.MateEditTextPreview
import com.example.ui.component.MateImageViewClick
import com.example.ui.component.MateTextHeader
import com.example.ui.component.MateTextRegular
import com.example.ui.component.MateTextRegularWithClick
import com.example.ui.component.MateTextViewRow

@Composable
fun SignInScreen(
    navController: NavController = rememberNavController(),
    viewModel: SignInViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    
    val signInState by viewModel.signIn.observeAsState()
    LaunchedEffect(signInState) {
        when(val state = signInState){
            is SigninState.OnSigninLoading -> {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }
            is SigninState.OnSigninError -> {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
            is SigninState.OnSigninAvailable -> {
                if (state.signinUiModel?.code == 200){
                    viewModel.onNavigateToHome(context)
                }else{
                    Toast.makeText(context, "Error ${state.signinUiModel?.message}", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
//            Toast.makeText(context, "Else", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .background(Color.White)
    ) {
        MateImageViewClick(
            onClick = {

            }
        )

        Spacer(modifier = Modifier.height(24.dp))
        MateTextHeader(
            text = "Welcome to Login"
        )
        MateTextRegularWithClick(
            text = "Please fill E-mail & password to login your app account.",
            textClick = " Sign Up",
            modifier = Modifier.padding(horizontal = 16.dp),
            onClick = {
                navController.navigate(MainActivity.Screen.AuthSignup.route)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
        MateTextRegular(
            text = "E-mail",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        MateEditText(
            value = email.value,
            onTyping = {
                email.value = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            errorMessage = "Email is required"
        )

        Spacer(modifier = Modifier.height(20.dp))
        MateTextRegular(
            text = "Password",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        MateEditText(
            visualTransformation = PasswordVisualTransformation(),
            value = password.value,
            onTyping = {
                password.value = it
            },
            errorMessage = "Password is required"
        )

        MateTextViewRow()

        MateButtonPrimary(
            onClick = {
                if(email.value.isBlank() || password.value.isBlank()){
                    Toast.makeText(context, "Isi semua data", Toast.LENGTH_SHORT).show()
                    return@MateButtonPrimary
                }else{
                    viewModel.postSignin(
                        email = email.value,
                        password = password.value
                    )
                }
            },
            enable = email.value.isNotBlank() && password.value.isNotBlank()
        )

        MateButtonSosmedRow(
            onClickFacebook = {
                
            },

            onClickGoogle = {

            }
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun SignInScreenPreview(
) {
    SignInScreen()
}