package com.falcao.retrofitmarvelapi.models.response

data class CharacterWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: DataContainer,
)