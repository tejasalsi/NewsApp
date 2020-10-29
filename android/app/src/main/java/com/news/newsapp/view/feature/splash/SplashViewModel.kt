package com.news.newsapp.view.feature.splash

import com.news.newsapp.base.BaseViewModel
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.rx.SchedulerProvider

class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<SplashNavigator>(dataManager, schedulerProvider) {

    var splashNavigator: SplashNavigator?
        get() = super.navigator
        set(navigator) {
            super.navigator = navigator
        }

    override fun onCleared() {
        super.onCleared()
    }
}
