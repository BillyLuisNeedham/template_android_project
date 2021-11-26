package com.billyluisneedham.mutliplemoduledetektprototype.commonui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test

class ButtonBaseKtTest {

    companion object {
        private const val TEST_TEXT = "test text"
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displaysTextPassedAsParams() {
        composeTestRule.setContent {
            ButtonBase(
                text = TEST_TEXT,
                onClick = {}
            )
        }

        composeTestRule.onNodeWithText(TEST_TEXT).assertIsDisplayed()
    }

    @Test
    fun runsOnClickPassedAsParam() {
        var clicked = false
        composeTestRule.setContent {
            ButtonBase(
                text = TEST_TEXT,
                onClick = {
                    clicked = true
                }
            )
        }

        assertThat(clicked, `is`(false))
        composeTestRule.onNodeWithText(TEST_TEXT).performClick()
        assertThat(clicked, `is`(true))
    }


}
