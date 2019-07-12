package com.sabinhantu.caloriecounter

fun String.foodNameToShortString():String {
    if (this.length <= 20)
        return this
    return this.substring(0, 20) + "..."
}

fun Double.toKcalString(): String {
    val kcalString = " kcal"

    val doubleAsString = this.toString()
    val indexOfDecimal = doubleAsString.indexOf(".")

    if (doubleAsString.substring(indexOfDecimal + 1) == "0")
        return doubleAsString.substring(0, indexOfDecimal) + kcalString

    return doubleAsString.substring(0, indexOfDecimal + 2)  + kcalString
}