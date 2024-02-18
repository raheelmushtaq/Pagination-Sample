package com.app.assesmenttest.ui.screens.login.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.assesmenttest.utils.validator.validateEmail
import com.app.assesmenttest.utils.validator.validatePassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    var _uiState = mutableStateOf(LoginUserUIState())
    val uiState = _uiState

    fun setEmail(email: String) {
        _uiState.value = uiState.value.copy(
            email = email,
            isLoginButtonDisabled = validateEmailAndPassword(email, uiState.value.password)
        )
    }

    fun setPassword(password: String) {
        _uiState.value = uiState.value.copy(
            password = password.trim(),
            isLoginButtonDisabled = validateEmailAndPassword(uiState.value.email, password)
        )
    }

    private fun validateEmailAndPassword(email: String, password: String): Boolean {
        return email.validateEmail() && password.validatePassword()
    }
}


data class LoginUserUIState(
    val email: String = "",
    val password: String = "",
    val isLoginButtonDisabled: Boolean = false
)