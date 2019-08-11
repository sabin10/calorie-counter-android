package com.sabinhantu.caloriecounter.overview

import android.app.Application
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.database.FoodDatabaseDao

class OverviewViewModel(
    val database: FoodDatabaseDao,
    app: Application
) : ViewModel() {

    val foods = database.getAllFood()

    val displayTotalKcal = Transformations.map(foods) {foods ->

        if (foods.isEmpty()) {
            app.applicationContext.getString(R.string.format_total_kcal, "0".toDouble())
        } else {
            var totalKcal = 0.0
            for (food in foods) {
                totalKcal += food.kcal
            }

            app.applicationContext.getString(R.string.format_total_kcal, totalKcal)
        }




    }


}