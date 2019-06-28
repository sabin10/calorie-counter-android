package com.sabinhantu.caloriecounter.search


import android.util.Log
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

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    private val _searchListFood = MutableLiveData<List<Food>>()

    val searchListFood: LiveData<List<Food>>
        get() = _searchListFood


    fun getSearchFoodResponse() {
        viewModelScope.launch {
            var responseDeffered = FoodDatabaseApi.retrofitService.getSpecificFood(word.value!!)
            try {
                var responseJson = responseDeffered.await()
                var hintsList = responseJson.hints
                var auxFoodList: MutableList<Food> = mutableListOf()
                for (hint in hintsList) {
                    auxFoodList.add(hint.food)
                }
                _searchListFood.value = auxFoodList

                Log.i("raluk", _searchListFood.value?.size.toString())


            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

}