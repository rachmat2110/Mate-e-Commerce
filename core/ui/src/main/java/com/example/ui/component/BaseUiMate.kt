package com.example.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R

@Composable
fun MateBaseButton(
    modifier: Modifier = Modifier,
    label:String = "Default Text",
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    color: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Black,
        contentColor = Color.White
    )
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = color,
        onClick = {onClick()}
    ) {
        Text(text = label)
    }
}

@Preview
@Composable
fun MateBaseButtonPreview() {
    MateBaseButton()
}

@Composable
fun MateWithIconBaseButton(
    modifier: Modifier = Modifier,
    label:String = "Default Text",
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Black,
        contentColor = Color.White
    ),
    color: Color = Color.White,
    srcIcon: Int = R.drawable.ic_facebook,
    descriptionIcon: String = "Facebook"
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        onClick = {onClick()}
    ) {
        Icon(
            painter = painterResource(id = srcIcon),
            contentDescription = descriptionIcon,
            modifier = Modifier.size(24.dp),
            tint = color
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label)
    }
}

@Preview
@Composable
fun MateWithIconBaseButtonPreview() {
    MateWithIconBaseButton()
}