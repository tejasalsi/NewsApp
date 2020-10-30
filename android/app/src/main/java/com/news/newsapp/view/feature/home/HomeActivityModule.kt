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

    @Provides
    fun provideSourcesAdapter(dataManager: DataManager): SourcesAdapter {
        return SourcesAdapter(dataManager, dataManager.context)
    }

    @Provides
    fun provideNewsAdapter(dataManager: DataManager): AllNewsAdapter {
        return AllNewsAdapter(dataManager, dataManager.context)
    }

    @Provides
    fun provideSourceNewsAdapter(dataManager: DataManager): SourceNewsAdapter {
        return SourceNewsAdapter(dataManager, dataManager.context)
    }
}
