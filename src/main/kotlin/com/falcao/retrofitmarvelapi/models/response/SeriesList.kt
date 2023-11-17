package com.falcao.retrofitmarvelapi.models.response

import com.falcao.retrofitmarvelapi.models.response.ComicSummary

data class SeriesList(
    val available: String,
    val collectionURI: String,
    val items: List<ComicSummary>,
    val returned: String
)