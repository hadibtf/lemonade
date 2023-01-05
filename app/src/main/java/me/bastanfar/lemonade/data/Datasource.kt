package me.bastanfar.lemonade.data

import me.bastanfar.lemonade.R
import me.bastanfar.lemonade.model.Step

object Datasource {
    val steps = listOf(
        Step(R.string.tap_lemon_tree, R.drawable.lemon_tree, R.string.lemon_tree),
        Step(R.string.keep_tapping, R.drawable.lemon_squeeze, R.string.lemon),
        Step(R.string.drink_it, R.drawable.lemon_drink, R.string.glass_of_lemonade),
        Step(R.string.start_again, R.drawable.lemon_restart, R.string.empty_glass),
    )
}