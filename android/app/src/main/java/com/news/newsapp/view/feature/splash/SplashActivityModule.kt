package com.news.newsapp.view.feature.splash

import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    fun provideSplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : SplashViewModel {
        return SplashViewModel(dataManager, schedulerProvider)
    }
}
