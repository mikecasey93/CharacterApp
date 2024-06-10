package com.example.characterapp.app.model

data class WireListModel (
    val wires: List<Wire> = listOf()
)

data class Wire(
    val firstUrl: String? = "",
    val icon: String? = "",
    val text: String? = ""
)