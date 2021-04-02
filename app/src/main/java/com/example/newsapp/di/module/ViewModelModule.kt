package com.example.newsapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.di.factory.ViewModelFactory
import com.example.newsapp.di.ViewModelKey
import com.example.newsapp.di.scope.FragmentScoped
import com.example.newsapp.ui.top_news.TopNewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @FragmentScoped
    @ViewModelKey(TopNewsViewModel::class)
    abstract fun bindNewsViewModel(viewModel: TopNewsViewModel): ViewModel
}