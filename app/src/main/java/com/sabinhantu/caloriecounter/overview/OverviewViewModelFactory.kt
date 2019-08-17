package com.sabinhantu.caloriecounter.overview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sabinhantu.caloriecounter.database.FoodDatabaseDao

class OverviewViewModelFactory (
    private val dataSource: FoodDatabaseDao,
    private val dateSelected: String,
    private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            return OverviewViewModel(dataSource, dateSelected, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}