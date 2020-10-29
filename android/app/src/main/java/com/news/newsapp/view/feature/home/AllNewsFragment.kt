package com.news.newsapp.view.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news.newsapp.R
import com.news.newsapp.base.BaseFragment
import javax.inject.Inject

class AllNewsFragment: BaseFragment<HomeViewModel>() {
    @Inject
    lateinit var homeViewModel: HomeViewModel
    override val viewModel: HomeViewModel
        get() = homeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_allnews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
