package com.sabinhantu.caloriecounter.addFood

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sabinhantu.caloriecounter.network.model.Food

class AddFoodViewModel(food: Food, app: Application) : AndroidViewModel(app) {

    private val _selectedFood = MutableLiveData<Food>()

    val selectedFood: LiveData<Food>
        get() = _selectedFood

    init {
        _selectedFood.value = food
    }

}