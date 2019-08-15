package com.sabinhantu.caloriecounter.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDatabaseDao {

    @Insert
    fun insert(food: FoodModel)

    @Query("SELECT * FROM food_table ORDER BY id DESC")
    fun getAllFood(): LiveData<List<FoodModel>>

    @Query("SELECT * FROM food_table WHERE date LIKE :day ORDER BY id ASC")
    fun getAllFoodFromDay(day: String): LiveData<List<FoodModel>>

    @Query("DELETE FROM food_table")
    fun deleteAll()
}