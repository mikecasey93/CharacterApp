package com.example.characterapp.app.ui.viewmodel

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import com.example.characterapp.app.MainActivity
import com.example.characterapp.app.converters.SimpsonListConverter
import com.example.characterapp.app.model.SimpsonListModel
import com.example.characterapp.app.ui.compose.screens.simpsons.SimpsonDetailsScreen
import com.example.characterapp.app.ui.compose.screens.simpsons.SimpsonListScreen
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListAction
import com.example.characterapp.app.ui.uiaction.simpson.SimpsonListSingleEvent
import com.example.characterapp.common.nav.routes.SimpsonInput
import com.example.characterapp.common.nav.routes.SimpsonsNavRoute
import com.example.characterapp.domain.usecase.simpson.GetSimpsonUseCase
import com.google.common.base.Verify.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
@ExperimentalCoroutinesApi
class SimpsonListViewModelTest {


    private lateinit var viewModel: SimpsonListViewModel
    private lateinit var navController: NavController

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testLoadAction_triggersLoading() {
        composeTestRule.onNodeWithTag("Simpsons").performClick()

        composeTestRule.onNodeWithTag("isLoadingSimpsons").assertIsDisplayed()
    }

    @Test
    fun testSimpsonItemClick_navigation() {
        val testText = "Test Wire"
        composeTestRule.setContent {
            SimpsonListScreen(viewModel = viewModel, navController = navController)
        }

        composeTestRule.onNodeWithText(testText).performClick()

        composeTestRule.onNodeWithContentDescription("Simpson Details Screen").assertIsDisplayed()
    }
}