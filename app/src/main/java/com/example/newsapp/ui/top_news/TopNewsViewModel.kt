package com.example.newsapp.ui.top_news

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.database.NewsRepository
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.repository.RepositoryImp
import kotlinx.coroutines.*

import com.example.newsapp.network.ResultWrapper
import com.example.newsapp.util.isInternetAvailable
import javax.inject.Inject

class TopNewsViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    @Inject
    lateinit var repositoryImp: RepositoryImp

    @Inject
    lateinit var newsRepository: NewsRepository
    private val newsDataObservableField: ObservableField<List<Article>?> =
        ObservableField()
    private val progressVisibilityObservableField: ObservableField<Int> = ObservableField()


    fun getNewsData() {
        progressVisibilityObservableField.set(View.VISIBLE)
        val context = getApplication<Application>().applicationContext
        if(context.isInternetAvailable()) {
            viewModelScope.launch {
                val resultWarraper = repositoryImp.getNewsFeeds()
                withContext(Dispatchers.Main) {
                    when (resultWarraper) {
                        is ResultWrapper.NetworkError -> showNetworkError()
                        is ResultWrapper.GenericError -> showGenericError(resultWarraper)
                        is ResultWrapper.Success ->
                            showSuccess(resultWarraper.value)
                    }
                }
            }
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                val news = newsRepository.getNewsData()
                GlobalScope.launch(Dispatchers.Main) {
                    progressVisibilityObservableField.set(View.GONE)
                    newsDataObservableField.set(news)
                }
            }
        }
    }

    fun getNewsDataObservableField() = newsDataObservableField

    fun getProgressVisibilityObservableField() = progressVisibilityObservableField


    private fun showSuccess(newsResponse: NewsResponse) {
        progressVisibilityObservableField.set(View.GONE)
        newsDataObservableField.set(newsResponse.articles)

        GlobalScope.launch(Dispatchers.IO) {
            newsRepository.insertAllNews(newsResponse.articles!!)
        }
    }

    private fun showGenericError(redditResponse: Any) {
        Toast.makeText(getApplication(), redditResponse.toString(), Toast.LENGTH_SHORT).show()

    }

    private fun showNetworkError() {
        Toast.makeText(getApplication(), "network error", Toast.LENGTH_SHORT).show()
    }
}

