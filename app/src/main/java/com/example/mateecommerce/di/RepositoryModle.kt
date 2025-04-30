package com.example.mateecommerce.di

import com.example.domain.repository.MateRepository
import com.example.domain.repository.PreferenceRepository
import com.example.local.preference.SharedPreference
import com.example.local.repository.PreferenceRepositoryImpl
import com.example.remote.repository.MateRepositoryImpl
import com.example.remote.service.MateService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModle {
    @Provides
    fun providesMateRepository(mateService : MateService) : MateRepository {
        return MateRepositoryImpl(mateService)
    }

    @Provides
    @Singleton
    fun providesPreferenceRepository(sharedPreference: SharedPreference) : PreferenceRepository{
        return PreferenceRepositoryImpl(sharedPreference)
    }
}