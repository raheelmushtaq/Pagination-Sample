package com.app.assesmenttest.utils.validator

import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.regex.Pattern


fun String.isEmailValid() = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isPasswordValidLength(): Boolean {
    val validatePattern = ".{8,}\$"
    val pattern: Pattern = Pattern.compile(validatePattern)
    return pattern.matcher(this).matches()
}

fun String.doesPasswordContainsLetterNumberSpecial(): Boolean {
    val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])((?=.*[@#$%^&+= ])|(?=.*[0-9])).{8,}$"
    return Pattern.compile(passwordPattern).matcher(this).matches()
}

fun String.validateEmail(): Boolean {
    return if (isEmpty()) {
        false
    } else isEmailValid()
}

fun String.validatePassword(): Boolean {
    return if (isEmpty()) {
        false
    } else if (!isPasswordValidLength()) {
        false
    } else {
        true
    }
}