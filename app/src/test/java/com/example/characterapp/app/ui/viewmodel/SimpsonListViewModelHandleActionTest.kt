package com.example.characterapp.app.ui.viewmodel

import com.example.characterapp.app.converters.SimpsonListConverter
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListAction
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListSingleEvent
import com.example.characterapp.common.nav.routes.SimpsonInput
import com.example.characterapp.common.nav.routes.SimpsonsNavRoute
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class SimpsonListViewModelHandleActionTest {

    @Mock
    private lateinit var viewModel: SimpsonListViewModel

    @Mock
    private lateinit var converter: SimpsonListConverter

    @Mock
    private lateinit var useCase: GetSimpsonUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = SimpsonListViewModel(useCase, converter)
    }

    @Test
    fun `handleAction Load should trigger loadSimpsons`() {
        verify(viewModel).loadSimpsons()
    }

    @Test
    fun `handleAction SimpsonItemClick should trigger navigation to details screen`() {
        val action = SimpsonListAction.SimpsonItemClick("firstUrl", "icon", "text")

        viewModel.handleAction(action)

        verify(viewModel).submitSingleEvent(
            SimpsonListSingleEvent.GoToDetailsScreen(
                SimpsonsNavRoute.Details.routeForSimpspn(
                    SimpsonInput(action.firstUrl, action.icon, action.text)
                )
            )
        )
    }

}

