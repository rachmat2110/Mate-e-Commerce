package com.example.local.repository

import com.example.domain.repository.PreferenceRepository
import com.example.local.preference.SharedPreference
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(
    private val sharedPreference: SharedPreference
) : PreferenceRepository{
    override fun getString(key: String): String = sharedPreference.getString(key)

    override fun saveString(key: String, value: String) {
        sharedPreference.saveString(key, value)
    }
}