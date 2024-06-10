package com.example.characterapp.app.ui.uiaction.simpson

import com.example.characterapp.common.state.UiSingleEvent

sealed class SimpsonListSingleEvent: UiSingleEvent {

    data class GoToDetailsScreen(val route: String): SimpsonListSingleEvent()
}