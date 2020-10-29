package com.news.newsapp.view.feature.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun bindSourcesFragment(): SourcesFragment

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun bindAllNewsFragment(): AllNewsFragment

}
