package com.sabinhantu.caloriecounter

import android.app.Application
import timber.log.Timber

class CalorieCounterApplication : Application() {
    companion object {
        lateinit var instance: CalorieCounterApplication
    }


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        instance = this
    }
}