package com.sabinhantu.caloriecounter

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

fun String.foodNameToShortString():String {
    if (this.length <= 20)
        return this
    return this.substring(0, 20) + "..."
}

fun String.foodNameForLayout(): String {
    if (this.length <= 35)
        return this
    return this.substring(0, 35) + "..."
}

fun Double.toKcalString(): String {
    val kcalString = " kcal"

    val doubleAsString = this.toString()
    val indexOfDecimal = doubleAsString.indexOf(".")

    if (doubleAsString.substring(indexOfDecimal + 1) == "0")
        return doubleAsString.substring(0, indexOfDecimal) + kcalString

    return doubleAsString.substring(0, indexOfDecimal + 2)  + kcalString
}

fun getCurrentDayString(): String {
    val date = Date();
    val formatter = SimpleDateFormat("MMM-dd-yyyy")
    return formatter.format(date)
}

fun doublesToIntOrOne(a: Double, b: Double, c: Double): Int {
    if ((a + b + c).roundToInt() > 0) {
        return (a + b + c).roundToInt()
    }
    return 1
}