package com.sabinhantu.caloriecounter.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlin.math.roundToInt

@Parcelize
data class Nutrients (
    @Json(name = "ENERC_KCAL") val kcal: Double = 0.0,
    @Json(name = "PROCNT") val protein: Double = 0.0,
    @Json(name = "FAT") val fat: Double = 0.0,
    @Json(name = "CHOCDF") val carbs: Double = 0.0,
    @Json(name = "FIBTG") val fiber: Double = 0.0
) : Parcelable {

    val totalNutrients = (protein + fat + carbs).roundToInt()
    val carbsPercent = (100 * carbs.roundToInt()) / totalNutrients
    val proteinPercent = (100 * protein.roundToInt()) / totalNutrients
    val fatPercent = (100 * fat.roundToInt()) / totalNutrients


}

