package com.example.mateecommerce.di

import com.example.domain.repository.MateRepository
import com.example.remote.repository.MateRepositoryImpl
import com.example.remote.service.MateService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModle {
    @Provides
    fun providesMateRepository(mateService : MateService) : MateRepository {
        return MateRepositoryImpl(mateService)
    }
}