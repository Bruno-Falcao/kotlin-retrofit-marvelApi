package com.falcao.retrofitmarvelapi.models.response

import com.falcao.retrofitmarvelapi.models.response.Character

data class DataContainer(
    val total: String,
    val results: List<Character>,
)