package com.sabinhantu.caloriecounter.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.database.FoodDatabaseDao
import com.sabinhantu.caloriecounter.getCurrentDayString
import kotlinx.coroutines.*

class OverviewViewModel(
    val database: FoodDatabaseDao,
    app: Application) : AndroidViewModel(app) {

    /** COROUTINES */
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    val foods = database.getAllFoodFromDay(getCurrentDayString())

    val displayTotalKcal = Transformations.map(foods) {foods ->

        if (foods.isEmpty()) {
            app.applicationContext.getString(R.string.format_double, "0".toDouble())
        } else {
            var totalKcal = 0.0
            for (food in foods) {
                totalKcal += food.kcal
            }
            app.applicationContext.getString(R.string.format_double, totalKcal)
        }
    }


    /** Database */

    private suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            database.deleteAll()
        }
    }

    fun onDeleteAll() {
        uiScope.launch {
            deleteAll()
        }
    }


    override fun onCleared() {
        super.onCleared()
        // cancel all coroutines
        viewModelJob.cancel()
    }


}