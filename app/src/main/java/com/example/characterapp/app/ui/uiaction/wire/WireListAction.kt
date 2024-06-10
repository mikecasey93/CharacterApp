package com.example.characterapp.app.ui.uiaction.wire

import com.example.characterapp.common.state.UiAction

sealed class WireListAction: UiAction {

    data object Load : WireListAction()

    data class WireItemClick(
        val firstUrl: String?,
        val icon: String?,
        val text: String?
    ) : WireListAction()
}