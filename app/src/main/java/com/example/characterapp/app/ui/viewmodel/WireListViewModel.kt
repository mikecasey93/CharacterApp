package com.example.characterapp.app.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.characterapp.app.converters.WireListConverter
import com.example.characterapp.app.model.Wire
import com.example.characterapp.app.model.WireListModel
import com.example.characterapp.app.ui.uiaction.wire.WireListAction
import com.example.characterapp.app.ui.uiaction.wire.WireListSingleEvent
import com.example.characterapp.common.nav.routes.WireInput
import com.example.characterapp.common.nav.routes.WireNavRoute
import com.example.characterapp.common.state.MviViewModel
import com.example.characterapp.common.state.UiState
import com.example.characterapp.domain.usecase.wire.GetWireUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WireListViewModel @Inject constructor(
    private val useCase: GetWireUseCase,
    private val converter: WireListConverter
): MviViewModel<WireListModel, UiState<WireListModel>, WireListAction, WireListSingleEvent>() {

    private val originalList = mutableListOf<Wire>()
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

    fun loadWires() {
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

//    fun filterWire(query: String) {
//        val filteredList = if (query.isEmpty()) {
//            originalList
//        } else {
//            originalList.filter { it.firstUrl!!.contains(query, ignoreCase = true) }
//        }
//        submitState(WireListModel(filteredList))
//    }
}