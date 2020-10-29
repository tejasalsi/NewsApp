package com.news.newsapp.view.feature.home

import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    fun provideHomeViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : HomeViewModel {
        return HomeViewModel(dataManager, schedulerProvider)
    }
}
