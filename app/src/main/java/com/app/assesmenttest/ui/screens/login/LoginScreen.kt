package com.app.assesmenttest.ui.screens.login

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.assesmenttest.R
import com.app.assesmenttest.ui.components.button.AppButton
import com.app.assesmenttest.ui.components.edittext.AppEditTextField
import com.app.assesmenttest.ui.components.edittext.AppPasswordEditTextField
import com.app.assesmenttest.ui.components.textfields.MediumText
import com.app.assesmenttest.ui.screens.destinations.HomeScreenDestination
import com.app.assesmenttest.ui.screens.destinations.LoginScreenDestination
import com.app.assesmenttest.ui.screens.login.viewmodel.LoginUserUIState
import com.app.assesmenttest.ui.screens.login.viewmodel.LoginViewModel
import com.app.assesmenttest.ui.theme.Raheel_Assessment_TestTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo

@Destination(start = true)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator, viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.value

    LoginComponent(state = uiState,
        onEmailChange = { viewModel.setEmail(it) },
        onPasswordChange = { viewModel.setPassword(it) },
        onLoginButtonClick = {
            navigator.navigate(HomeScreenDestination(uiState.email)) {
                popUpTo(LoginScreenDestination.route) {
                    inclusive = true
                }
            }
        }
    )
}

@Composable
fun LoginComponent(
    modifier: Modifier = Modifier,
    state: LoginUserUIState,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onLoginButtonClick: () -> Unit = {}
) {
    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(10.dp)
            .clickable {
                focusManager.clearFocus()
            }
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = "logo",
                modifier = Modifier
                    .width(150.dp)
                    .align(Alignment.CenterHorizontally)
                    .height(150.dp)
            )

            AppEditTextField(
                textFieldValue = state.email,
                hint = stringResource(id = R.string.email),
                onValueChange = onEmailChange,
                onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
            AppPasswordEditTextField(
                textFieldValue = state.password,
                hint = stringResource(id = R.string.password),
                onValueChange = onPasswordChange,
                onDone = {
                    focusManager.clearFocus()
                }
            )

            MediumText(text = stringResource(id = R.string.password_message), color = Color.LightGray)

            AppButton(
                buttonText = R.string.login,
                onClick = onLoginButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(top = 10.dp),
                isDisabled = state.isLoginButtonDisabled
            )
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    Raheel_Assessment_TestTheme {
        LoginComponent(
            modifier = Modifier.fillMaxSize(),
            LoginUserUIState("asdfasdf@gmail.com", "asfaasf123@A")
        )
    }
}