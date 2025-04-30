package com.example.mateecommerce

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MateApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Log.e("GlobalCrash", "Uncaught exception in thread ${thread.name}", throwable)
        }
    }
}