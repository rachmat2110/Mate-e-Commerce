package com.example.mateecommerce.di

import com.example.mateecommerce.annotation.MateRetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    fun provideMateService(@MateRetrofitInstance retrofit: Retrofit) : MateService =
        retrofit.create(MateService::class.java)
}