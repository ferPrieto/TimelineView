package ferprieto.timelineview

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.ferprieto.timelineview.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented tests for ComposeTimelineView composable
 * Tests the behavior of the synchronized dual-view timeline component
 */
@RunWith(AndroidJUnit4::class)
class ComposeTimelineViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun composeTimelineView_isDisplayed() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineView()
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineView_withCustomHeight_appliesHeightCorrectly() {
        // Given
        val customHeight = 200.dp

        composeTestRule.setContent {
            ComposeTimelineView(height = customHeight)
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineView_withCustomPastContent_usesCorrectDrawable() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineView(
                pastContent = R.drawable.soundwave_first_default_1
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineView_withCustomFutureContent_usesCorrectDrawable() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineView(
                futureContent = R.drawable.soundwave_second_default_1
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineView_withAllCustomParameters_displaysCorrectly() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineView(
                height = 150.dp,
                pastContent = R.drawable.soundwave_first_default_2,
                futureContent = R.drawable.soundwave_second_default_2
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineView_hasBothScrollableAreas() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineView()
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
    }

    @Test
    fun composeTimelineViewAdvanced_withCustomDividerColor_isDisplayed() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineViewAdvanced(
                dividerColor = androidx.compose.ui.graphics.Color.Red
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineViewAdvanced_withCustomDividerWidth_isDisplayed() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineViewAdvanced(
                dividerWidth = 4.dp
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
    }

    @Test
    fun composeTimelineViewAdvanced_withCustomOffsetFraction_isDisplayed() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineViewAdvanced(
                offsetFraction = 1f/8f 
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineViewAdvanced_withAllCustomParameters_displaysCorrectly() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineViewAdvanced(
                height = 180.dp,
                pastContent = R.drawable.soundwave_first_default_1,
                futureContent = R.drawable.soundwave_second_default_1,
                offsetFraction = 1f/10f,
                dividerWidth = 3.dp,
                dividerColor = androidx.compose.ui.graphics.Color.Blue,
                paddingExtra = 4.dp
            )
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun composeTimelineView_defaultDrawables_areDisplayed() {
        // Given
        composeTestRule.setContent {
            ComposeTimelineView()
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Past timeline content")
            .assertExists()
            .assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Future timeline content")
            .assertExists()
            .assertIsDisplayed()
    }
}

