package com.example.newsapp

import androidx.multidex.MultiDexApplication
import com.example.newsapp.di.component.DaggerAppComponent


class NewsApp : MultiDexApplication() {

    lateinit var appComponent: DaggerAppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build() as DaggerAppComponent

    }

}