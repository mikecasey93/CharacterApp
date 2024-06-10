package com.example.characterapp.app.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.characterapp.app.converters.SimpsonListConverter
import com.example.characterapp.app.model.SimpsonListModel
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListAction
import com.example.characterapp.common.state.UiState
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SimpsonListViewModelTest {

//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @get:Rule
//    //val coroutineTestRule = CoroutineTestRule()
//
//    private lateinit var viewModel: SimpsonListViewModel
//    private lateinit var useCase: GetSimpsonUseCase
//    private lateinit var converter: SimpsonListConverter
//
//    @Before
//    fun setUp() {
//        useCase = mock()
//        converter = mock()
//        viewModel = SimpsonListViewModel(useCase, converter)
//    }
//
//    @Test
//    fun `test loadSimpsons success`() = runTest {
//        // Given
//        val response = mock<GetSimpsonUseCase.Response>()
//        val convertedResponse = mock<UiState<SimpsonListModel>>()
//        `when`(useCase.execute(any())).thenReturn(flowOf(response))
//        `when`(converter.convert(response)).thenReturn(convertedResponse)
//
//        // When
//        viewModel.handleAction(SimpsonListAction.Load)
//
//        // Then
//        verify(useCase).execute(GetSimpsonUseCase.Request)
//        verify(converter).convert(response)
//        assert(viewModel.uiStateFlow.value == convertedResponse)
//    }
//}@get:Rule
//val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//@get:Rule
////val coroutineTestRule = CoroutineTestRule()
//
//private lateinit var viewModel: SimpsonListViewModel
//private lateinit var useCase: GetSimpsonUseCase
//private lateinit var converter: SimpsonListConverter
//
//@Before
//fun setUp() {
//    useCase = mock()
//    converter = mock()
//    viewModel = SimpsonListViewModel(useCase, converter)
//}
//
//@Test
//fun `test loadSimpsons success`() = runTest {
//    // Given
//    val response = mock<GetSimpsonUseCase.Response>()
//    val convertedResponse = mock<UiState<SimpsonListModel>>()
//    `when`(useCase.execute(any())).thenReturn(flowOf(response))
//    `when`(converter.convert(response)).thenReturn(convertedResponse)
//
//    // When
//    viewModel.handleAction(SimpsonListAction.Load)
//
//    // Then
//    verify(useCase).execute(GetSimpsonUseCase.Request)
//    verify(converter).convert(response)
//    assert(viewModel.uiStateFlow.value == convertedResponse)
}

