package com.sabinhantu.caloriecounter.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "food_table")
data class FoodModel (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    var name: String?,

    var grams: Double?,

    var carbs: Double?,

    var proteins: Double?,

    var fats: Double?
)