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

enum class MonthComplet {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOMBER,
    NOVEMBER,
    DECEMBER
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

fun String.monthToMonthComplete(): String = when(this) {
    Month.JAN.name.toLowerCase() -> MonthComplet.JANUARY.name.toLowerCase()
    Month.FEB.name.toLowerCase() -> MonthComplet.FEBRUARY.name.toLowerCase()
    Month.MAR.name.toLowerCase() -> MonthComplet.MARCH.name.toLowerCase()
    Month.APR.name.toLowerCase() -> MonthComplet.APRIL.name.toLowerCase()
    Month.MAY.name.toLowerCase() -> MonthComplet.MAY.name.toLowerCase()
    Month.JUN.name.toLowerCase() -> MonthComplet.JUNE.name.toLowerCase()
    Month.JUL.name.toLowerCase() -> MonthComplet.JULY.name.toLowerCase()
    Month.AUG.name.toLowerCase() -> MonthComplet.AUGUST.name.toLowerCase()
    Month.SEP.name.toLowerCase() -> MonthComplet.SEPTEMBER.name.toLowerCase()
    Month.OCT.name.toLowerCase() -> MonthComplet.OCTOMBER.name.toLowerCase()
    Month.NOV.name.toLowerCase() -> MonthComplet.NOVEMBER.name.toLowerCase()
    Month.DEC.name.toLowerCase() -> MonthComplet.DECEMBER.name.toLowerCase()
    else -> ""
}

/** aug.-15-2019 */
fun constructDate(year: Int, month: Int, dayOfMonth: Int): String = "${getMonthString(month)}.-$dayOfMonth-$year"

fun String.removeLastChar() = this.substring(0, this.length - 1)
fun String.firstCharToUpper() = this[0].toUpperCase() + this.substring(1, this.length)

fun String.makeDateReadable(): String {
    val strArr = this.split("-")
    val sb = StringBuilder()

    val monthDB = strArr[0].removeLastChar()
    sb.append(strArr[1]).append(" ").append(monthDB.monthToMonthComplete().firstCharToUpper()).append(" ").append(strArr[2])
    return sb.toString()
}

fun String.addTodayLabel() = "TODAY, " + this