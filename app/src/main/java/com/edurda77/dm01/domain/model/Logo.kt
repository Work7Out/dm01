package com.edurda77.dm01.domain.model

import com.edurda77.dm01.R

data class Logo(
    val id: Int,
    val image: Int,
    val title: String,
    val date: String,
    val url: String,
)


val logos = listOf(
    Logo(
        id = 1,
        image = R.drawable.logo_1,
        title = "Нейропикник",
        date = "06.05 - 07.05",
        url = "https://salebot.site/md/neurobeginner"
    ),
    Logo(
        id = 2,
        image = R.drawable.logo_2,
        title = "Иллюстрация",
        date = "13.05 - 15.05",
        url = "https://salebot.site/md/illustratorslm "
    ),
    Logo(
        id = 3,
        image = R.drawable.logo_3,
        title = "Волшебный пинок",
        date = "20.05 - 23.05",
        url = "https://salebot.site/md/magickkickorg"
    ),
    Logo(
        id = 4,
        image = R.drawable.logo_4,
        title = "Нейро для дизов",
        date = "27.05 - 28.05",
        url = "https://salebot.site/md/neuradesignersubs"
    ),
)
