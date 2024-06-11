package com.example.characterapp.app.ui.viewmodel

import com.example.characterapp.app.converters.WireListConverter
import com.example.characterapp.app.ui.uiaction.wire.WireListAction
import com.example.characterapp.app.ui.uiaction.wire.WireListSingleEvent
import com.example.characterapp.common.nav.routes.WireInput
import com.example.characterapp.common.nav.routes.WireNavRoute
import com.example.characterapp.domain.usecase.wire.GetWireUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class WireListViewModelHandleActionTest {

    @Mock
    private lateinit var viewModel: WireListViewModel

    @Mock
    private lateinit var converter: WireListConverter

    @Mock
    private lateinit var useCase: GetWireUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = WireListViewModel(useCase, converter)
    }

    @Test
    fun `handleAction Load should trigger loadWires`() {
        verify(viewModel).loadWires()
    }

    @Test
    fun `handleAction WireItemClick should trigger navigation to details screen`() {
        val action = WireListAction.WireItemClick("firstUrl", "icon", "text")

        viewModel.handleAction(action)

        verify(viewModel).submitSingleEvent(
            WireListSingleEvent.GoToDetailsScreen(
                WireNavRoute.Details.routeForWire(
                    WireInput(action.firstUrl, action.icon, action.text)
                )
            )
        )
    }


}