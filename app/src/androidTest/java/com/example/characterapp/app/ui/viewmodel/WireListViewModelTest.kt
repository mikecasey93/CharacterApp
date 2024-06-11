package com.example.characterapp.app.ui.viewmodel

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import com.example.characterapp.app.MainActivity
import com.example.characterapp.app.ui.compose.screens.simpsons.SimpsonListScreen
import com.example.characterapp.app.ui.compose.screens.wire.WireListScreen
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class WireListViewModelTest {

    private lateinit var viewModel: WireListViewModel
    private lateinit var navController: NavController

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testLoadAction_triggersLoading() {
        composeTestRule.onNodeWithTag("Wire").performClick()

        composeTestRule.onNodeWithTag("isLoadingWire").assertIsDisplayed()
    }

    @Test
    fun testSimpsonItemClick_navigation() {
        val testText = "Test Wire"
        composeTestRule.setContent {
            WireListScreen(viewModel = viewModel, navController = navController)
        }

        composeTestRule.onNodeWithText(testText).performClick()

        composeTestRule.onNodeWithContentDescription("Wire Details Screen").assertIsDisplayed()
    }
}