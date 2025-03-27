package com.example.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.StrongGreen

@Composable
fun MateCheckBox(
    label: String = "Remember me",
    checked: Boolean = false,
    onCheckedChanged: (Boolean) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChanged,
            colors = CheckboxDefaults.colors(
                checkedColor = StrongGreen
            )
        )
        Text(
            text = label,
            modifier = Modifier.padding(vertical = 16.dp)
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 14.sp,
                textAlign = TextAlign.Left
            )
        )
    }
}

@Preview
@Composable
fun MateCheckBoxPreview(

) {
    MateCheckBox()
}