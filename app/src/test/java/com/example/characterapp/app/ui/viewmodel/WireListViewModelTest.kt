package com.example.characterapp.app.ui.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.characterapp.app.converters.WireListConverter
import com.example.characterapp.app.model.Wire
import com.example.characterapp.domain.usecase.wire.GetWireUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.manipulation.Ordering
import org.mockito.Mock
import org.mockito.MockedConstruction
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.coroutines.ContinuationInterceptor

@ExperimentalCoroutinesApi
class WireListViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutine = MainCoroutineRule()

    @Mock
    private lateinit var useCase: GetWireUseCase

    @Mock
    private lateinit var converter: WireListConverter

    private lateinit var viewModel: WireListViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = WireListViewModel(useCase, converter)
    }

    @Test
    fun `loadWires should submit converted wire state`() = mainCoroutine.runBlockingTest {
        val fakeWire = Wire()
//        val convertedWire = WireListConverter(context = Context)
//        whenever(useCase.execute(GetWireUseCase.Request)).thenReturn(flowOf(fakeWire))
//        whenever(converter.convert(fakeWire)).thenReturn(convertedWire)
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