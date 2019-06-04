package com.sabinhantu.caloriecounter

import android.app.Application
import timber.log.Timber

class CalorieCounterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}