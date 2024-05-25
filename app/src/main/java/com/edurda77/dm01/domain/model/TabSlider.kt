package com.edurda77.dm01.domain.model

import com.edurda77.dm01.R

data class TabSlider(
    val image: Int,
    val slider: Int?,
    val title: Int,
    val description: Int,
)

val tabs = listOf(
    TabSlider(
        image = R.drawable.welcome_image_1,
        slider = R.drawable.welcome_sl_1,
        title = R.string.welcome_1_title,
        description = R.string.welcome_1_dis
    ),
    TabSlider(
        image = R.drawable.welcome_image_2,
        slider = R.drawable.welcome_sl_2,
        title = R.string.welcome_2_title,
        description = R.string.welcome_2_dis
    ),
    TabSlider(
        image = R.drawable.welcome_image_3,
        slider = R.drawable.welcome_sl_3,
        title = R.string.welcome_3_title,
        description = R.string.welcome_3_dis
    ),
    TabSlider(
        image = R.drawable.welcome_image_4,
        slider = R.drawable.welcome_sl_4,
        title = R.string.welcome_4_title,
        description = R.string.welcome_4_dis
    ),
    TabSlider(
        image = R.drawable.welcome_image_5,
        slider = null,
        title = R.string.welcome_5_title,
        description = R.string.welcome_5_dis
    ),
)
