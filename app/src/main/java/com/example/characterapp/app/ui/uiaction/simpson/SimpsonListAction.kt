package com.example.characterapp.app.ui.uiaction.simpson

import com.example.characterapp.common.state.UiAction

sealed class SimpsonListAction: UiAction {

    data object Load : SimpsonListAction()

    data class SimpsonItemClick(
        val firstUrl: String?,
        val icon: String?,
        val text: String?
    ) : SimpsonListAction()
}