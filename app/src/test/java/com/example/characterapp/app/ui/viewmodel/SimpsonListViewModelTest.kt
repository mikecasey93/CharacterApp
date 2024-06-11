package com.example.characterapp.app.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.characterapp.app.converters.SimpsonListConverter
import com.example.characterapp.app.converters.WireListConverter
import com.example.characterapp.app.model.Simpson
import com.example.characterapp.app.model.SimpsonListModel
import com.example.characterapp.app.model.Wire
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListAction
import com.example.characterapp.common.state.UiState
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import com.example.characterapp.domain.usecase.wire.GetWireUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import kotlin.coroutines.ContinuationInterceptor

class SimpsonListViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutine = MainCoroutineRule()

    @Mock
    private lateinit var useCase: GetSimpsonUseCase

    @Mock
    private lateinit var converter: SimpsonListConverter

    private lateinit var viewModel: SimpsonListViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = SimpsonListViewModel(useCase, converter)
    }

    @org.junit.Test
    fun `loadWires should submit converted wire state`() = mainCoroutine.runBlockingTest {
        val fakeSimpson = Simpson()
//        val convertedWire = SimpsonListConverter(context = Context)
//        whenever(useCase.execute(GetSimpsonUseCase.Request)).thenReturn(flowOf(fakeSimpson))
//        whenever(converter.convert(fakeSimpson)).thenReturn(convertedSimpson)
//
//        viewModel.loadWires()
//
//        verify(useCase).execute(GetWireUseCase.Request)
//        verify(converter).convert(fakeWire)
    }


    @ExperimentalCoroutinesApi
    class MainCoroutineRule : TestWatcher(), TestCoroutineScope by TestCoroutineScope() {

        override fun starting(description: Description) {
            super.starting(description)
            Dispatchers.setMain(this.coroutineContext[ContinuationInterceptor] as CoroutineDispatcher)
        }

        override fun finished(description: Description) {
            super.finished(description)
            Dispatchers.resetMain()
        }

    }
}

