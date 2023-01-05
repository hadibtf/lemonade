package me.bastanfar.lemonade.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.bastanfar.lemonade.data.Datasource.steps
import me.bastanfar.lemonade.model.LemonadeUiState

class LemonadeViewModel : ViewModel() {
    private val _lemonUiState = MutableStateFlow(LemonadeUiState())
    val uiState: StateFlow<LemonadeUiState> = _lemonUiState.asStateFlow()

    private var currentStepIndex: Int = 0
    private var lemonSqueezedCount = 0


    fun onImageClicked() {
        when (currentStepIndex) {
            0 -> {
                currentStepIndex++
                updateUiState(false)
            }
            1 -> {
                val random = (2..4).random()
                if (lemonSqueezedCount <= random) {
                    lemonSqueezedCount++
                } else {
                    currentStepIndex++
                    updateUiState(false)
                }
            }
            2 -> {
                currentStepIndex++
                updateUiState(false)
            }
            3 -> {
                currentStepIndex = 0
                lemonSqueezedCount = 0
                updateUiState(reset = true)
            }
        }
    }

    private fun updateUiState(reset: Boolean) {
        if (reset) {
            _lemonUiState.value = LemonadeUiState()
        } else {
            _lemonUiState.update { currentStep ->
                currentStep.copy(
                    currentStepIndex = currentStepIndex,
                    currentStepTextResourceId = steps[currentStepIndex].stepTextResourceId,
                    currentStepImageResourceId = steps[currentStepIndex].stepImageResourceId,
                    currentStepImageDescriptionResourceId = steps[currentStepIndex].stepImageDescriptionResourceId
                )
            }
        }
    }
}