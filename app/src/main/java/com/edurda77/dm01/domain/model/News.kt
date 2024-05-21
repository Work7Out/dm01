package com.edurda77.dm01.domain.model

import com.edurda77.dm01.R

data class News(
    val id: Int,
    val title: String,
    val content: String,
    val image: Int,
)

val news= listOf(
    News(
        id  = 1,
        title = "Название новости: Интригующий анонс от OpenAI \uD83E\uDEE8\n",
        content = "Интригующий анонс от OpenAI \uD83E\uDEE8  В понедельник на сайте OpenAI пройдёт прямая трансляция — обещают показать демо-версию новые обновления ChatGPT и GPT-4   Ждём трансляцию в 20:00 по московскому времени — и обязательно будем держать вас в курсе всех новостей",
        image = R.drawable.news_1
    ),
    News(
        id  = 2,
        title = "Награждение Workspace Digital Awards",
        content = "Недавно состоялось награждение Workspace Digital Awards, и мы заняли второе место в номинации «Фирменный стиль и брендинг» с проектом Gaga.team \uD83E\uDD73  Мы гоготали от радости, думаем, что нас слышал весь зал. Спасибо, что голосовали за нас \uD83E\uDEF6\uD83C\uDFFB  Кстати, проект можно посмотреть в нашем портфолио, там описали весь процесс: от концепции до полученных результатов  \n",
        image = R.drawable.news_2
    )
)
