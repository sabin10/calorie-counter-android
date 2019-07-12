package com.sabinhantu.caloriecounter.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sabinhantu.caloriecounter.network.model.ResponseJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.edamam.com/api/food-database/"
private const val APP_ID = "fe644ac9"
private const val APP_KEY = "652ca904c80725291f88f7e3a033615c"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface FoodDatabaseApiService {

    @GET("parser?")
    fun getSpecificFood(@Query("ingr") food: String,
                        @Query("app_id") appId: String = APP_ID,
                        @Query("app_key") appKey: String = APP_KEY):
            Deferred<ResponseJson>
}

object FoodDatabaseApi {
    val retrofitService: FoodDatabaseApiService by lazy { retrofit.create(FoodDatabaseApiService::class.java) }
}