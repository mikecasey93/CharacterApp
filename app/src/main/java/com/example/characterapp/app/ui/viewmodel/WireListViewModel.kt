package com.example.characterapp.app.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.characterapp.app.converters.SimpsonListConverter
import com.example.characterapp.app.converters.WireListConverter
import com.example.characterapp.app.model.SimpsonListModel
import com.example.characterapp.app.model.WireListModel
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListAction
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListSingleEvent
import com.example.characterapp.app.ui.uiaction.wire.WireListAction
import com.example.characterapp.app.ui.uiaction.wire.WireListSingleEvent
import com.example.characterapp.common.nav.routes.SimpsonInput
import com.example.characterapp.common.nav.routes.SimpsonsNavRoute
import com.example.characterapp.common.nav.routes.WireInput
import com.example.characterapp.common.nav.routes.WireNavRoute
import com.example.characterapp.common.state.MviViewModel
import com.example.characterapp.common.state.UiState
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import com.example.characterapp.domain.usecase.wire.GetWireUseCase
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class WireListViewModel @Inject constructor(
    private val useCase: GetWireUseCase,
    private val converter: WireListConverter
): MviViewModel<WireListModel, UiState<WireListModel>, WireListAction, WireListSingleEvent>() {

    override fun initState(): UiState<WireListModel> = UiState.Loading

    override fun handleAction(action: WireListAction) {
        when (action) {
            is WireListAction.Load -> {
                loadWires()
            }
            is WireListAction.WireItemClick -> {
                submitSingleEvent(
                    WireListSingleEvent.GoToDetailsScreen(
                        WireNavRoute.Details.routeForWire(
                            WireInput(
                                action.firstUrl,
                                action.icon,
                                action.text
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadWires() {
        viewModelScope.launch {
            useCase.execute(GetWireUseCase.Request)
                .map{
                    converter.convert(it)
                }
                .collect{
                    submitState(it)
                }
        }
    }
}