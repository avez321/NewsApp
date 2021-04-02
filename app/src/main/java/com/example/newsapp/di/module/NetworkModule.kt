package com.example.newsapp.di.module

import com.example.newsapp.network.NewsApi
import com.example.newsapp.model.NewsClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideNewsApi(): NewsApi = NewsClient.makeNewsApi()
}