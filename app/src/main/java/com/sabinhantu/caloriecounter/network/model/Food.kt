package com.sabinhantu.caloriecounter.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food (
    val foodId: String = "",
    val label: String = "",
    val nutrients: Nutrients,
    val category: String = "",
    val categoryLabel: String = ""
) : Parcelable



//"food": {
//    "foodId": "food_b4e1z96ar77klzaziix6kb1hmv6b",
//    "label": "Strawberries, raw",
//    "nutrients": {...},
//    "category": "Generic foods",
//    "categoryLabel": "food",
//    "image": "https://www.edamam.com/food-img/00c/00c8851e401bf7975be7f73499b4b573.jpg"
//}