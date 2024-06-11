package com.example.characterapp.app.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.characterapp.app.converters.SimpsonListConverter
import com.example.characterapp.app.model.SimpsonListModel
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListAction
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListSingleEvent
import com.example.characterapp.common.nav.routes.SimpsonInput
import com.example.characterapp.common.nav.routes.SimpsonsNavRoute
import com.example.characterapp.common.state.MviViewModel
import com.example.characterapp.common.state.UiState
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SimpsonListViewModel @Inject constructor(
    private val useCase: GetSimpsonUseCase,
    private val converter: SimpsonListConverter
): MviViewModel<SimpsonListModel, UiState<SimpsonListModel>, SimpsonListAction, SimpsonListSingleEvent>() {

    override fun initState(): UiState<SimpsonListModel> = UiState.Loading

    override fun handleAction(action: SimpsonListAction) {
        when (action) {
            is SimpsonListAction.Load -> {
                loadSimpsons()
            }
            is SimpsonListAction.SimpsonItemClick -> {
                submitSingleEvent(
                    SimpsonListSingleEvent.GoToDetailsScreen(
                        SimpsonsNavRoute.Details.routeForSimpspn(
                            SimpsonInput(
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

    fun loadSimpsons() {
        viewModelScope.launch {
            useCase.execute(GetSimpsonUseCase.Request)
                .map{
                    converter.convert(it)
                }
                .collect{
                    submitState(it)
                }
        }
    }
}