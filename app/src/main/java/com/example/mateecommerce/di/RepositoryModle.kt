package com.example.mateecommerce.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModle {
    @Provides
    fun providesMateRepository(mateService : MateService) : MateRepository{
        return MateRepository(mateService)
    }
}