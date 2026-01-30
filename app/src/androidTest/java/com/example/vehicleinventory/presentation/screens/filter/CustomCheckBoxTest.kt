package com.example.vehicleinventory.presentation.screens.filter

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.vehicleinventory.CustomCheckbox
import org.junit.Rule
import org.junit.Test

class CustomCheckboxTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun customCheckbox_displaysUncheckedState() {
        composeTestRule.setContent {
            CustomCheckbox(isSelected = false)
        }

        composeTestRule.onNodeWithContentDescription("Unchecked").assertIsDisplayed()
    }

    @Test
    fun customCheckbox_displaysCheckedState() {
        composeTestRule.setContent {
            CustomCheckbox(isSelected = true)
        }

        composeTestRule.onNodeWithContentDescription("Checked").assertIsDisplayed()
    }
}