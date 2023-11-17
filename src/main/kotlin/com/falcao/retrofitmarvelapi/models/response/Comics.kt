package com.falcao.retrofitmarvelapi.models.response

data class Comics(
    val available: String,
    val returned: String,
    val collectionURI: String,
    val items: List<ComicSummary>,
)