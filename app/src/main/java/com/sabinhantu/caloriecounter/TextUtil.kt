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

enum class Month {
    JAN,
    FEB,
    MAR,
    APR,
    MAY,
    JUN,
    JUL,
    AUG,
    SEP,
    OCT,
    NOV,
    DEC
}

fun getMonthString(month: Int): String = when(month) {
    1 -> Month.JAN.name.toLowerCase()
    2 -> Month.FEB.name.toLowerCase()
    3 -> Month.MAR.name.toLowerCase()
    4 -> Month.APR.name.toLowerCase()
    5 -> Month.MAY.name.toLowerCase()
    6 -> Month.JUN.name.toLowerCase()
    7 -> Month.JUL.name.toLowerCase()
    8 -> Month.AUG.name.toLowerCase()
    9 -> Month.SEP.name.toLowerCase()
    10 -> Month.OCT.name.toLowerCase()
    11 -> Month.NOV.name.toLowerCase()
    12 -> Month.DEC.name.toLowerCase()
    else -> ""
}

/** aug.-15-2019 */
fun constructDate(year: Int, month: Int, dayOfMonth: Int): String = "${getMonthString(month)}.-$dayOfMonth-$year"