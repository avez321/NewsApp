package com.example.newsapp.di.module

import android.app.Application
import com.example.newsapp.database.NewsDatabase
import com.example.newsapp.database.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideNewsRepository(application: Application): NewsRepository{
       val newsDao = NewsDatabase.getDatabase(application).newsDao()
        return NewsRepository(newsDao)
    }
}