package com.example.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.auth.ui.signin.SignInScreen
import com.example.auth.ui.signin.SignInViewModel
import com.example.auth.ui.signup.SignUpScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signInViewModel : SignInViewModel by viewModels()

    sealed class Screen(val route: String){
        object AuthSignin : Screen("auth/signin")
        object AuthSignup : Screen("auth/signup")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            com.example.ui.theme.MateECommerceTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.AuthSignin.route
                ) {
                    composable(Screen.AuthSignin.route){
                        SignInScreen(
                            navController = navController,
                            viewModel = signInViewModel
                        )
                    }

                    composable(Screen.AuthSignup.route){
                        SignUpScreen(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}