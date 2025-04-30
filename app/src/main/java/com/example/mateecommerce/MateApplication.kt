package com.example.mateecommerce

import android.app.Application
import android.util.Log
import com.example.mateecommerce.di.chucker.ChuckerCrashHandler
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MateApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Log.e("GlobalCrash", "Uncaught exception in thread ${thread.name}", throwable)
        }

        if (BuildConfig.DEBUG){
            initChucker()
        }
    }

    private fun initChucker(){
        val systemHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(
            ChuckerCrashHandler(
                systemHandler,
                this@MateApplication
            )
        )
    }
}