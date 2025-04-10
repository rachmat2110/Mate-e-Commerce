package com.example.auth.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
fun SignUpScreen(
    navController: NavController = rememberNavController()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .background(Color.White)
    ) {
        MateImageViewClick(
            onClick = {
                navController.popBackStack()
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
        MateTextHeader(
            text = "Create you account"
        )
        MateTextRegularWithClick(
            text = "Dou you already have account ?",
            textClick = " Sign In",
            modifier = Modifier.padding(horizontal = 16.dp),
            onClick = {
                navController.popBackStack()
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
        MateTextRegular(
            text = "Username",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        MateEditText(
        )

        Spacer(modifier = Modifier.height(24.dp))
        MateTextRegular(
            text = "Email",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        MateEditText(
        )

        Spacer(modifier = Modifier.height(20.dp))
        MateTextRegular(
            text = "Password",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        MateEditText(
            value = "Password",
            visualTransformation = PasswordVisualTransformation()
        )

        MateButtonPrimary(
            text = "Create account",
            onClick = {

            }
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun SignUpScreenPreview(
) {
    SignUpScreen()
}