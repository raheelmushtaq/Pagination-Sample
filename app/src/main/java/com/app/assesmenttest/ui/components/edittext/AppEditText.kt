package com.app.assesmenttest.ui.components.edittext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.app.assesmenttest.R
import com.app.assesmenttest.ui.screens.login.viewmodel.LoginUserUIState

@Composable
fun AppEditTextField(
    textFieldValue: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit = {},
) {

    OutlinedTextField(
        value = textFieldValue,
        label = { Text(text = hint) },
        singleLine = true,
        visualTransformation = VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDone() }),
    )
}

@Composable
fun AppPasswordEditTextField(
    textFieldValue: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit = {},
) {
    var isPasswordVisible: Boolean by remember { mutableStateOf(false) }

    OutlinedTextField(value = textFieldValue,
        label = { Text(text = hint) },
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDone() }),
        trailingIcon = {
            val image = if (isPasswordVisible) R.drawable.password_visibility_off
            else R.drawable.password_visibility
            val description =
                if (isPasswordVisible) R.string.hide_password else R.string.show_passwod

            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            }) {
                Icon(painterResource(id = image), stringResource(id = description))
            }
        })
}

@Preview
@Composable
fun PreviewAppEditText() {
    AppEditTextField(textFieldValue = "awdf", hint = "asdf", onValueChange = {})
    AppPasswordEditTextField(textFieldValue = "awdf", hint = "asdf", onValueChange = {})
}