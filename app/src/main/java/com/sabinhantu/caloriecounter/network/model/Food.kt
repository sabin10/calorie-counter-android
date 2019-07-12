package com.sabinhantu.caloriecounter.network.model

import android.os.Parcelable
import com.sabinhantu.caloriecounter.foodNameToShortString
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food (
    val foodId: String = "",
    val label: String = "",
    val nutrients: Nutrients,
    val category: String = "",
    val categoryLabel: String = ""
) : Parcelable {
    val shortName
        get() = label.foodNameToShortString()
}
