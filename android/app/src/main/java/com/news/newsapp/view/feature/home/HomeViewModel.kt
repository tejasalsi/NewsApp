package com.news.newsapp.view.feature.home

import com.news.newsapp.base.BaseViewModel
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.rx.SchedulerProvider

class HomeViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider):
    BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {

    var homeNavigator: HomeNavigator?
        get() = super.navigator
        set(navigator) {
            super.navigator = navigator
        }



    override fun onCleared() {
        super.onCleared()
    }
}
