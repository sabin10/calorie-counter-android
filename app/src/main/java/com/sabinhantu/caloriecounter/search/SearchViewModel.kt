package com.sabinhantu.caloriecounter.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabinhantu.caloriecounter.network.FoodDatabaseApi
import com.sabinhantu.caloriecounter.network.model.Food
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    // Word filter for API search
    val word = MutableLiveData<String>()

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    private val _searchListFood = MutableLiveData<List<Food>>()

    val searchListFood: LiveData<List<Food>>
        get() = _searchListFood

    // Internally, we use a MutableLiveData to handle navigation to the selected food
    private val _navigateToSelectedFood = MutableLiveData<Food>()

    val navigateToSelectedFood: LiveData<Food>
        get() = _navigateToSelectedFood

    val searchInProgress = MutableLiveData<Boolean>()

    init {
        searchInProgress.value = false
    }


    fun getSearchFoodResponse() {
        if (word.value == "" || word.value == null)
            return

        searchInProgress.value = true
        viewModelScope.launch {
            val responseDeffered = FoodDatabaseApi.retrofitService.getSpecificFood(word.value ?: "")
            try {
                val responseJson = responseDeffered.await()
                val hintsList = responseJson.hints
                searchInProgress.value = false
                val auxFoodList: MutableList<Food> = mutableListOf()
                for (hint in hintsList) {
                    auxFoodList.add(hint.food)
                }
                _searchListFood.value = auxFoodList

            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    /**
     * When the property is clicked, set the [_navigateToSelectedFood] [MutableLiveData]
     * @param food that was clicked
     */
    fun displayAddFood(food: Food) {
        _navigateToSelectedFood.value = food
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedFood is set to null
     */
    fun displayAddFoodIsComplete() {
        _navigateToSelectedFood.value = null
    }

}