package com.example.mateecommerce.di.chucker

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.RetentionManager

class ChuckerCrashHandler(
    private val defaultHandler: Thread.UncaughtExceptionHandler? = null,
    applicationContext: Context
) : Thread.UncaughtExceptionHandler{

    private val chuckerCollector : ChuckerCollector by lazy{
        ChuckerCollector(
            context = applicationContext,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.FOREVER
        )
    }
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        chuckerCollector.onError(
            "error", throwable
        )
        defaultHandler?.uncaughtException(
            thread, throwable
        )
    }

}