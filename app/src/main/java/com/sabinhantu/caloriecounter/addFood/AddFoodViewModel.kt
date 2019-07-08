package com.sabinhantu.caloriecounter.addFood

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.sabinhantu.caloriecounter.R
import com.sabinhantu.caloriecounter.network.model.Food

class AddFoodViewModel(food: Food, app: Application) : AndroidViewModel(app) {

    private val _selectedFood = MutableLiveData<Food>()

    val selectedFood: LiveData<Food>
        get() = _selectedFood

    private val _currentGram = MutableLiveData<Double>()



    init {
        _selectedFood.value = food
        _currentGram.value = 100.0
    }

    val displayKcalPer100G = Transformations.map(selectedFood) {
        app.applicationContext.getString(R.string.display_kcal_per_100g, it.nutrients.kcal)
    }

}