package com.falcao.retrofitmarvelapi.models.response

data class Character(
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val comics: Comics,
    val series: SeriesList,
)