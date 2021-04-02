package com.example.newsapp.ui.top_news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.NewsApp
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsListBinding

import javax.inject.Inject


class TopNewsFragment : Fragment() {
    private lateinit var FragmentNewsListBinding: FragmentNewsListBinding
    @Inject lateinit var topNewsViewModel: TopNewsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newsApp = requireActivity().application as NewsApp
        newsApp.appComponent.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().setTitle(R.string.top_news)
        FragmentNewsListBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        FragmentNewsListBinding.viewmodel = topNewsViewModel
        initRecycleView()
        topNewsViewModel.getNewsData()
        return FragmentNewsListBinding.root
    }


    private fun initRecycleView() {
        val adapter = TopNewsAdapter()
        val layoutManager =
                 LinearLayoutManager(requireContext())
        
        FragmentNewsListBinding.rvUpcomingNews.layoutManager = layoutManager
        FragmentNewsListBinding.rvUpcomingNews.adapter = adapter

    }

}
