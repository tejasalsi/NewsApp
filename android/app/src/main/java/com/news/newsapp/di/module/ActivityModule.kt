package com.news.newsapp.di.module

import com.news.newsapp.view.feature.splash.SplashActivityModule
import com.news.newsapp.view.feature.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * ActivityModule provides android injection of it's module in activity.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity
}
