package com.example.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.VividMagenta

@Composable
fun MateTextHeader(
    text: String = "Welcome to Login",
    color: Color = Color.Black,
    modifier: Modifier = Modifier.padding(16.dp)
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Left
        ),
        overflow = TextOverflow.Ellipsis,
        color = color,
        maxLines = 1
    )
}

@Composable
fun MateTextRegularWithClick(
    text: String = "Please fill E-mail & password to login your app account.",
    textClick: String = " Sign Up",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier.padding(16.dp)
){
    val annotatedText = buildAnnotatedString {
        append(text)

        //Untuk kliknya menggunakan ini
        pushStringAnnotation(
            tag = "TEXT_CLICK",
            annotation = textClick
        )
        withStyle(
            style = SpanStyle(
                color = VividMagenta,
                fontWeight = FontWeight.Bold
            )
        ){
            append(textClick)
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        modifier = modifier,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
            textAlign = TextAlign.Left
        ),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "TEXT_CLICK",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                onClick()
            }
        }
    )
}

@Composable
fun MateTextRegular(
    text: String = "Email",
    modifier: Modifier = Modifier.padding(16.dp),
    color: Color = Color.Black
){
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            textAlign = TextAlign.Left
        ),
        color = color
    )
}

@Composable
fun MateTextViewRow(
    checked: Boolean = false,
    onCheckedChanged: (Boolean) -> Unit = {},
    onTextClick: () -> Unit = {}
){
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        MateCheckBox(
            checked = checked,
            onCheckedChanged = onCheckedChanged
        )

        val annotationString = buildAnnotatedString {
            append(" Forgot password ?")
        }

        ClickableText(
            text = annotationString,
            onClick = {
                onTextClick()
            }
        )
    }
}

@Preview
@Composable
fun MateTextHeaderPreview(){
    MateTextHeader(
        text = "Hallo mamat"
    )
}

@Preview
@Composable
fun MateTextRegularWithClickPreview(){
    MateTextRegularWithClick()
}

@Preview
@Composable
fun MateTextRegularPreview(){
    MateTextRegular()
}

@Preview
@Composable
fun MateTextViewRowPreview(){
    MateTextViewRow()
}