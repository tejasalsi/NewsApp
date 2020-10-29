package com.news.newsapp.view.feature.home

import android.os.Bundle
import com.news.newsapp.R
import com.news.newsapp.base.BaseActivity
import javax.inject.Inject

class HomeActivity:BaseActivity<HomeViewModel>() {

    @Inject
    lateinit var homeViewModel: HomeViewModel
    override val viewModel: HomeViewModel
        get() = homeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
