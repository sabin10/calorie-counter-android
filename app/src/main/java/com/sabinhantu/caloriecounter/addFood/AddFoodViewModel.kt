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

    val currentGramsString = MutableLiveData<String>()

    init {
        _selectedFood.value = food
        currentGramsString.value = "100"
    }

    val displayKcalPer100G = Transformations.map(selectedFood) { food ->
        app.applicationContext.getString(R.string.display_kcal_per_100g, food.nutrients.kcal)
    }


    val displayCurrentCarbs = Transformations.map(currentGramsString) { gramsString ->
        val carbsPerOneGram = selectedFood.value!!.nutrients.carbs / 100

        if (gramsString.isEmpty()) {
            app.applicationContext.getString(R.string.format_grams, "0".toDouble())
        } else {
            app.applicationContext.getString(R.string.format_grams, gramsString.toDouble().times(carbsPerOneGram))
        }
    }

    val displayCurrentProteins = Transformations.map(currentGramsString) { gramsString ->
        val proteinsPerOneGram = selectedFood.value!!.nutrients.protein / 100

        if (gramsString.isEmpty()) {
            app.applicationContext.getString(R.string.format_grams, "0".toDouble())
        } else {
            app.applicationContext.getString(R.string.format_grams, gramsString.toDouble().times(proteinsPerOneGram))
        }
    }

    val displayCurrentFats = Transformations.map(currentGramsString) { gramsString ->
        val fatsPerOneGram = selectedFood.value!!.nutrients.fat / 100

        if (gramsString.isEmpty()) {
            app.applicationContext.getString(R.string.format_grams, "0".toDouble())
        } else {
            app.applicationContext.getString(R.string.format_grams, gramsString.toDouble().times(fatsPerOneGram))
        }
    }

    val displayCurrentTotalKcal = Transformations.map(currentGramsString) { gramsString ->
        val kcalPerOneGram = selectedFood.value!!.nutrients.kcal / 100

        if (gramsString.isEmpty()) {
            app.applicationContext.getString(R.string.format_total_kcal, "0".toDouble())
        } else {
            app.applicationContext.getString(R.string.format_total_kcal, gramsString.toDouble().times(kcalPerOneGram))
        }
    }

    val displayCarbsPercent = Transformations.map(selectedFood) { food ->
        app.applicationContext.getString(R.string.format_percent, food.nutrients.carbsPercent)
    }

    val displayProteinsPercent = Transformations.map(selectedFood) { food ->
        app.applicationContext.getString(R.string.format_percent, food.nutrients.proteinPercent)
    }

    val displayFatsPercent = Transformations.map(selectedFood) { food ->
        app.applicationContext.getString(R.string.format_percent, food.nutrients.fatPercent)
    }
}