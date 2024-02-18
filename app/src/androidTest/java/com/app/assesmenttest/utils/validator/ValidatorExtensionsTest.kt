package com.app.assesmenttest.utils.validator

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ValidatorExtensionsTest {

    @Test
    fun isEmailValid() {
        assertEquals(false, "Raheel".isEmailValid())
        assertEquals(true, "raheelMushtaq@gmail.com".isEmailValid())
    }

    @Test
    fun isPasswordValidLength() {
        assertEquals(false, "asfasf".isPasswordValidLength())
        assertEquals(true, "Asdf@12344".isPasswordValidLength())

    }

    @Test
    fun doesPasswordContainsLetterNumberSpecial() {
        assertEquals(false, "asfasf".doesPasswordContainsLetterNumberSpecial())
        assertEquals(true, "Asdf@1234".doesPasswordContainsLetterNumberSpecial())
    }

    @Test
    fun validateEmail() {
        assertEquals(false, "asfasf".validateEmail())
        assertEquals(true, "raheelmushtaq41@gmail.com".validateEmail())
    }

    @Test
    fun validatePassword() {
        assertEquals(false, "asds".validatePassword())
        assertEquals(true, "Asdf@1234".validatePassword())
    }
}