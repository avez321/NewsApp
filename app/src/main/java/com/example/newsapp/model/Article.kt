package com.example.newsapp.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Entity(tableName = "news_table")
data class Article (
    @PrimaryKey(autoGenerate = true)  var id: Int = 0,

    @SerializedName("source")
    @Expose
    @Ignore
     var source: Source? = null,

    @SerializedName("author")
    @Expose
    @Ignore
     var author: String? = null,

    @SerializedName("title")
    @Expose
     var title: String? = null,

    @SerializedName("description")
    @Expose
     var description: String? = null,

    @SerializedName("url")
    @Expose
    @Ignore
     var url: String? = null,

    @SerializedName("urlToImage")
    @Expose
     var urlToImage: String? = null,

    @SerializedName("publishedAt")
    @Expose
    @Ignore
     var publishedAt: String? = null,

    @SerializedName("content")
    @Expose
    @Ignore
     var content: String? = null
)