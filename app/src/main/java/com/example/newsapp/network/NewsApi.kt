package com.example.newsapp.network

import com.example.newsapp.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNewsFeed(@Query("country") country:String, @Query("apiKey") apiKey: String): NewsResponse
}