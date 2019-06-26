package com.sabinhantu.caloriecounter.network.model

import com.squareup.moshi.Json

data class Nutrients (
    @Json(name = "ENERC_KCAL") val kcal: Double,
    @Json(name = "PROCNT") val protein: Double,
    @Json(name = "FAT") val fat: Double,
    @Json(name = "CHOCDF") val carbs: Double,
    @Json(name = "FIBTG") val fiber: Double
)

//"nutrients": {
//    "ENERC_KCAL": 32,
//    "PROCNT": 0.67,
//    "FAT": 0.3,
//    "CHOCDF": 7.68,
//    "FIBTG": 2
//}