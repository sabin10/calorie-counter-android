package com.sabinhantu.caloriecounter

fun convertFoodNameToShortString(foodName: String): String {
    if (foodName.length <= 20)
        return foodName

    return foodName.substring(0, 20) + "..."
}

fun convertFoodKcalDoubletoString(foodKcal: Double): String {
    val kcalString = " kcal"

    val doubleAsString = foodKcal.toString()
    val indexOfDecimal = doubleAsString.indexOf(".")

    if (doubleAsString.substring(indexOfDecimal + 1) == "0")
        return doubleAsString.substring(0, indexOfDecimal) + kcalString

    return doubleAsString.substring(0, indexOfDecimal + 2)  + kcalString

}