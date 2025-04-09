package com.example.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.theme.LightOrange
import com.example.ui.theme.ModerateBlue
import com.example.ui.theme.VeryDarkGrayBlue
import com.example.ui.theme.VividRed

@Composable
fun MateButtonPrimary(
    text: String = "Login Now",
    onClick: () -> Unit = {}
) {
    MateBaseButton(
        label = text,
        onClick = onClick,
        enabled = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        color = ButtonDefaults.buttonColors(
            containerColor = LightOrange,
            contentColor = VeryDarkGrayBlue
        )
    )
}

@Composable
fun MateButtonFacebook(
    text: String = "Facebook",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(56.dp)
) {
    MateWithIconBaseButton(
        label = text,
        onClick = onClick,
        enabled = true,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = ModerateBlue,
            contentColor = Color.White
        ),
        srcIcon = R.drawable.ic_facebook,
        descriptionIcon = "Facebook"
    )
}

@Composable
fun MateButtonGoogle(
    text: String = "Google",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(56.dp)
) {
    MateWithIconBaseButton(
        label = text,
        onClick = onClick,
        enabled = true,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = VividRed,
            contentColor = Color.White
        ),
        srcIcon = R.drawable.ic_google,
        descriptionIcon = "Google"
    )
}

@Composable
fun MateButtonSosmedRow(
    onClickGoogle: () -> Unit = {},
    onClickFacebook: () -> Unit = {},
    modifier: Modifier = Modifier.fillMaxWidth()
        .padding(16.dp)
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MateButtonGoogle(
            modifier = Modifier.weight(1f).height(56.dp),
            onClick = onClickGoogle
        )
        MateButtonFacebook(
            modifier = Modifier.weight(1f).height(56.dp),
            onClick = onClickFacebook
        )
    }
}

@Preview
@Composable
fun MateButtonPrimaryPreview() {
    MateButtonPrimary()
}

@Preview
@Composable
fun MateButtonFacebookPreview() {
    MateButtonFacebook()
}

@Preview
@Composable
fun MateButtonGooglePreview() {
    MateButtonGoogle()
}

@Preview
@Composable
fun MateButtonSosmedRowPreview(){
    MateButtonSosmedRow()
}