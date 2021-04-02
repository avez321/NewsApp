package com.example.newsapp.ui.top_news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.Article


class TopNewsAdapter : RecyclerView.Adapter<TopNewsAdapter.ContentViewHolder>() {
    private var articleArrayList: ArrayList<Article>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val newsBinding = DataBindingUtil.inflate<ItemNewsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_news,
            parent,
            false
        )

        return ContentViewHolder(newsBinding)
    }

    override fun getItemCount(): Int = articleArrayList?.size ?: 0


    override fun onBindViewHolder(contentViewHolder: ContentViewHolder, position: Int) {
        contentViewHolder.bind(articleArrayList?.get(position))
    }


    fun setData(newsArrayList: ArrayList<Article>) {
        this.articleArrayList = newsArrayList
        notifyDataSetChanged()
    }

    class ContentViewHolder(
        val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(article: Article?) {
            binding.article = article
        }
    }

}