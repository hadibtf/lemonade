package me.bastanfar.lemonade

import me.bastanfar.lemonade.data.Datasource.steps
import me.bastanfar.lemonade.model.LemonadeUiState
import me.bastanfar.lemonade.viewmodel.LemonadeViewModel
import org.junit.Assert.assertTrue
import org.junit.Test

const val STEP_ONE_INDEX = 0
const val STEP_TWO_INDEX = 1
const val STEP_THREE_INDEX = 2
const val STEP_FOUR_INDEX = 3

class LemonadeViewModelUnitTest {
    private var viewModel = LemonadeViewModel()

    @Test
    fun lemonadeViewModel_Initialization_StepOneLoaded() {
        val uiState = viewModel.uiState.value
        runTests(STEP_ONE_INDEX, uiState)
    }

    @Test
    fun lemonadeViewModel_LemonTreeTouched_StepTwoLoaded() {
        viewModel.onImageClicked()
        val uiState = viewModel.uiState.value
        runTests(STEP_TWO_INDEX, uiState)
    }

    @Test
    fun lemonadeViewModel_LemonTouchedEnoughTimesToSqueeze_StepThreeLoaded() {
        while (viewModel.uiState.value.currentStepIndex < STEP_THREE_INDEX) viewModel.onImageClicked()
        val uiState = viewModel.uiState.value
        runTests(STEP_THREE_INDEX, uiState)
    }

    @Test
    fun lemonadeViewModel_LemonadeTouched_StepFourLoaded() {
        while (viewModel.uiState.value.currentStepIndex < STEP_FOUR_INDEX) viewModel.onImageClicked()
        val uiState = viewModel.uiState.value
        runTests(STEP_FOUR_INDEX, uiState)
    }

    @Test
    fun lemonadeViewModel_EmptyGlassTouched_ResetToStepOne() {
        while (viewModel.uiState.value.currentStepIndex == STEP_FOUR_INDEX) viewModel.onImageClicked()
        val uiState = viewModel.uiState.value
        runTests(STEP_ONE_INDEX, uiState)
    }

    private fun runTests(expectedStepIndex: Int, uiState: LemonadeUiState) {
        assertTrue(uiState.currentStepIndex == expectedStepIndex)
        assertTrue(uiState.currentStepTextResourceId == steps[expectedStepIndex].stepTextResourceId)
        assertTrue(uiState.currentStepImageResourceId == steps[expectedStepIndex].stepImageResourceId)
        assertTrue(uiState.currentStepImageDescriptionResourceId == steps[expectedStepIndex].stepImageDescriptionResourceId)
    }
}