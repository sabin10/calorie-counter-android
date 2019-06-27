package com.sabinhantu.caloriecounter.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabinhantu.caloriecounter.network.FoodDatabaseApi
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    // Word filter for API search
    val word = MutableLiveData<String>()

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response


    fun getSearchFoodResponse() {
        viewModelScope.launch {
            var responseDeffered = FoodDatabaseApi.retrofitService.getSpecificFood(word.value!!)
            try {
                var responseJson = responseDeffered.await()
                _response.value = responseJson.parsed.get(0).food.nutrients.kcal.toString() + " kcal"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

}