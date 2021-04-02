package com.example.newsapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.newsapp.R
import com.example.newsapp.model.Article
import com.example.newsapp.ui.top_news.TopNewsAdapter


object BindingUtils {
    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide
            .with(imageView.context)
            .load(url)
            .placeholder(R.drawable.loading_wait_time)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(imageView);
    }

    @JvmStatic
    @BindingAdapter("android:articleData")
    fun setArticleData(recyclerView: RecyclerView, articleArrayList: List<Article>?) {
        articleArrayList?.let {
            val newsAdapter = recyclerView.adapter as TopNewsAdapter
            newsAdapter.setData(it as ArrayList<Article>)
        }
    }
 }



