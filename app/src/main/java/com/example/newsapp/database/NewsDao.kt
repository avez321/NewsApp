package com.example.newsapp.database

import androidx.room.*
import com.example.newsapp.model.Article

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_table")
    fun getNewsData(): List<Article>

    @Insert
    suspend fun insert(article: Article)

    @Query("DELETE FROM news_table")
    fun deleteAll()

    @Update
    fun update(article: Article)

    @Insert
    suspend fun insertAll(article: List<Article>)
}