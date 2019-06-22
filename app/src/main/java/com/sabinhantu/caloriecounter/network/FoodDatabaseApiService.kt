package com.sabinhantu.caloriecounter.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.edamam.com/api/food-database/"
private const val APP_ID = "fe644ac9"
private const val APP_KEY = "652ca904c80725291f88f7e3a033615c"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FoodDatabaseApiService {
    @GET("parser?ingr=banana&app_id=fe644ac9&app_key=652ca904c80725291f88f7e3a033615c")
    fun getBanana():
            Call<String>
}

object FoodDatabaseApi {
    val retrofitService: FoodDatabaseApiService by lazy { retrofit.create(FoodDatabaseApiService::class.java) }
}