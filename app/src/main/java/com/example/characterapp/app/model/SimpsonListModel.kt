package com.example.characterapp.app.model

data class SimpsonListModel (
    val simpsons: List<Simpson> = listOf()
)

data class Simpson(
    val firstUrl: String? = "",
    val icon: String? = "",
    val text: String? = ""
)
