package com.news.newsapp.view.feature.splash

import android.os.Bundle
import com.news.newsapp.R
import com.news.newsapp.base.BaseActivity
import javax.inject.Inject

class SplashActivity: BaseActivity<SplashViewModel>(), SplashNavigator {

    @Inject
    lateinit var splashViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel.splashNavigator = this
    }

    override val viewModel: SplashViewModel
        get() = splashViewModel

    override fun setupViews() {

    }

    override fun openNextActivity() {

    }
}
