package com.sabinhantu.caloriecounter.addFood

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sabinhantu.caloriecounter.database.FoodDatabaseDao
import com.sabinhantu.caloriecounter.network.model.Food


/**
 * View Model Factory that provides the Food and context to the ViewModel
 */
class AddFoodViewModelFactory(
    private val food: Food,
    private val dataSource: FoodDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddFoodViewModel::class.java)) {
            return AddFoodViewModel(food, dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}