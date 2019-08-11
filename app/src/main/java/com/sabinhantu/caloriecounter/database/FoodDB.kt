package com.sabinhantu.caloriecounter.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "food")
data class FoodDB (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    var name: String?,

    var grams: Int = 100,

    var carbs: Int?,

    var proteins: Int?,

    var fats: Int?
)