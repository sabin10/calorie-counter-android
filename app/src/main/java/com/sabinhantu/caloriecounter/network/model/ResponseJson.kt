package com.sabinhantu.caloriecounter.network.model

import com.squareup.moshi.Json

data class ResponseJson (
    val text: String,
    val parsed: List<Parsed>,
    val hints: List<Hint>,
    @Json(name = "_links") val links: Links

)