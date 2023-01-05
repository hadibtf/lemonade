package me.bastanfar.lemonade.model

import androidx.annotation.DrawableRes

data class Step(
    val stepTextResourceId: Int,
    @DrawableRes val stepImageResourceId: Int,
    val stepImageDescriptionResourceId: Int
)