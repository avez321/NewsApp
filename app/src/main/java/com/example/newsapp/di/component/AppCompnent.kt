package com.example.newsapp.di.component


import android.app.Application
import com.example.newsapp.di.module.AppModule
import com.example.newsapp.di.module.DataBaseModule
import com.example.newsapp.di.module.NetworkModule
import com.example.newsapp.di.module.ViewModelModule
import com.example.newsapp.ui.top_news.TopNewsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(modules = [DataBaseModule::class, AppModule::class, NetworkModule::class, ViewModelModule::class])
@Singleton
interface AppComponent {

    fun inject(frag: TopNewsFragment)

    @Component.Builder
     interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}

