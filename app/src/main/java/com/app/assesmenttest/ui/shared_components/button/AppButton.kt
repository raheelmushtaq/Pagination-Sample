package com.app.assesmenttest.ui.shared_components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.assesmenttest.R
import com.app.assesmenttest.ui.shared_components.textfields.MediumText

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    buttonText: Int,
    isDisabled: Boolean = false,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            disabledContainerColor = Color.LightGray
        ),
        enabled = isDisabled,
        onClick = onClick
    ) {
        MediumText(
            text = stringResource(id = buttonText),
            color = if (isDisabled) Color.White else Color.Black,
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewAppComponent() {
    AppButton(buttonText = R.string.login, isDisabled = false)
}