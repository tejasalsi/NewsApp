package com.news.newsapp.view.feature.home

import com.news.newsapp.base.BaseViewModel
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.rx.SchedulerProvider
import com.news.newsapp.utils.SUCCESS

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

    fun getSources() {
        compositeDisposable.add(dataManager.apiService.getSources().subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui()).subscribe({
            sourcesResponse ->
            if(sourcesResponse.code() == SUCCESS) {
                homeNavigator!!.sourceResult(sourcesResponse)
            }

        }, {
            error ->
            //Do error handling
        }))
    }

    fun getAllNews(page: Int) {
        compositeDisposable.add(dataManager.apiService.getAllNews("+news", page).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui()).subscribe({
                newsResponse ->
            if(newsResponse.code() == SUCCESS) {
                homeNavigator!!.newsResult(newsResponse)
            }

        }, {
                error ->
            //Do error handling
        }))
    }

    fun getHeadlines(source: String, page: Int) {
        compositeDisposable.add(dataManager.apiService.getHeadLines(source, page).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui()).subscribe({
                newsResponse ->
            if(newsResponse.code() == SUCCESS) {
                homeNavigator!!.newsResult(newsResponse)
            }

        }, {
                error ->
            //Do error handling
        }))
    }
}
