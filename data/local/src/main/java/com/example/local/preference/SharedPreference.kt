package com.example.local.preference

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreference @Inject constructor(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveString(key: String, value: String){
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String) : String{
        val value = sharedPreferences.getString(key, null)
        return value ?: ""
    }
}