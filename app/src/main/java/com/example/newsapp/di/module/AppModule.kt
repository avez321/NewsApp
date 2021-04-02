package com.example.newsapp.di.module

import com.example.newsapp.network.NewsApi
import com.example.newsapp.repository.RepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideRepositoryImp(newsApi: NewsApi): RepositoryImp = RepositoryImp(newsApi)
}