package com.example.vehicleinventory.presentation.screens.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class TopSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun topSection_displaysCorrectData() {
        val userName = "TestUser"
        val totalVehicles = 10
        val totalEVs = 3

        composeTestRule.setContent {
            TopSection(
                userName = userName,
                totalVehicles = totalVehicles,
                totalEV = totalEVs
            )
        }

        composeTestRule.onNodeWithText("Hi, $userName 👋").assertIsDisplayed()
        composeTestRule.onNodeWithText("Total Vehicles").assertIsDisplayed()
        composeTestRule.onNodeWithText(totalVehicles.toString()).assertIsDisplayed()
        composeTestRule.onNodeWithText("Total EV").assertIsDisplayed()
        composeTestRule.onNodeWithText(totalEVs.toString()).assertIsDisplayed()
    }
}