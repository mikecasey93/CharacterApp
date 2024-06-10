package com.example.characterapp.app.ui.compose

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SliceStringFunctionKtTest {

    @Test
    fun `is string less than least 22 characters returns false`() {
        val result = SliceStringFunction.cutString("aaaaaaaaaaaaaaaaaaaaaaa")
        assertThat(result).hasLength(22)
    }

    @Test
    fun `contains base URL`() {
        val result = SliceStringFunction.cutString("https://duckduckgo.com/")
        assertThat(result).contains("https://duckduckgo.com/")
    }
}