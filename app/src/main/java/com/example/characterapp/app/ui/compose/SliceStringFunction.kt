package com.example.characterapp.app.ui.compose

object SliceStringFunction {
    fun cutString(str: String?): String? {
        return str?.slice(22..<str.length)
    }
}