package com.example.newsapp.database

import com.example.newsapp.model.Article

class NewsRepository(val newsDao: NewsDao) {

    suspend fun getNewsData() = newsDao.getNewsData()

     suspend fun insertNews(article: Article) {
        newsDao.insert(article)
    }

    suspend fun  insertAllNews(arraylist: List<Article>) {
        newsDao.insertAll(arraylist)
    }
}