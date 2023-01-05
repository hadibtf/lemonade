package me.bastanfar.lemonade.model

import androidx.annotation.DrawableRes
import me.bastanfar.lemonade.data.Datasource.steps

data class LemonadeUiState(
    val currentStepIndex: Int = 0,
    val currentStepTextResourceId: Int = steps[currentStepIndex].stepTextResourceId,
    @DrawableRes
    val currentStepImageResourceId: Int = steps[currentStepIndex].stepImageResourceId,
    val currentStepImageDescriptionResourceId: Int = steps[currentStepIndex].stepImageDescriptionResourceId
)