package com.news.newsapp.view.feature.splash

import android.content.Intent
import android.os.Bundle
import com.news.newsapp.R
import com.news.newsapp.base.BaseActivity
import com.news.newsapp.utils.ACCESS_TOKEN
import com.news.newsapp.view.feature.home.HomeActivity
import javax.inject.Inject

class SplashActivity: BaseActivity<SplashViewModel>(), SplashNavigator {

    @Inject
    lateinit var splashViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel.splashNavigator = this
        if(splashViewModel.dataManager.sharedPrefsService.getStringValue(ACCESS_TOKEN).isNullOrEmpty()) {
            splashViewModel.dataManager.sharedPrefsService.setStringValue(ACCESS_TOKEN, "e999b58deb74491b9f2cf13555a210b1")
        }
        openNextActivity()
    }

    override val viewModel: SplashViewModel
        get() = splashViewModel

    override fun setupViews() {

    }

    override fun openNextActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
