package com.sabinhantu.caloriecounter.dayOverview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sabinhantu.caloriecounter.network.FoodDatabaseApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DayOverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    init {
        getFoodResponse()
    }


    private fun getFoodResponse() {
        FoodDatabaseApi.retrofitService.getBanana().enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
    }
}