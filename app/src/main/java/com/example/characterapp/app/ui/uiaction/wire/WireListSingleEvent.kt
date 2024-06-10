package com.example.characterapp.app.ui.uiaction.wire

import com.example.characterapp.common.state.UiSingleEvent

sealed class WireListSingleEvent: UiSingleEvent {

    data class GoToDetailsScreen(val route: String): WireListSingleEvent()
}