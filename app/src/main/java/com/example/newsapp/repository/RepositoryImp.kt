package com.example.newsapp.repository


import com.example.newsapp.Constants
import com.example.newsapp.network.ResultWrapper
import com.example.newsapp.network.safeApiCall
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.network.NewsApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RepositoryImp(private val newsApi: NewsApi, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    RepositoryInterface {
    override suspend fun getNewsFeeds(): ResultWrapper<NewsResponse> {

        return safeApiCall(dispatcher) { newsApi.getNewsFeed( Constants.country, Constants.apiKey) }
    }
}


