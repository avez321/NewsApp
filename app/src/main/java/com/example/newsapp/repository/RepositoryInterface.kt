package com.example.newsapp.repository

import com.example.newsapp.model.NewsResponse
import com.example.newsapp.network.ResultWrapper

interface RepositoryInterface {
   suspend fun getNewsFeeds(): ResultWrapper<NewsResponse>
}