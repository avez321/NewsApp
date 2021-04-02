package com.example.newsapp.model

import androidx.room.Embedded
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class NewsResponse(
    @SerializedName("status")
    @Expose
    val status: String? = null,


    @SerializedName("totalResults")
    @Expose
    val totalResults: Int? = null,

    @SerializedName("articles")
    @Expose
    @Embedded
    var articles: List<Article>? = null
)