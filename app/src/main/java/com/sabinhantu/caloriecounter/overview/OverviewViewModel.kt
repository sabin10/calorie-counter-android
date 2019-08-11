package com.sabinhantu.caloriecounter.overview

import android.app.Application
import androidx.lifecycle.ViewModel
import com.sabinhantu.caloriecounter.database.FoodDatabaseDao

class OverviewViewModel(
    val database: FoodDatabaseDao,
    application: Application
) : ViewModel() {


}