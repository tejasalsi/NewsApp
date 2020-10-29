package com.news.newsapp.view.feature.home

import com.news.newsapp.base.BaseNavigator
import com.news.newsapp.model.AllNewsResponse
import com.news.newsapp.model.SourcesResponse
import retrofit2.Response

interface HomeNavigator:BaseNavigator {

    fun sourceResult(sourcesResponse: Response<SourcesResponse>)
    fun newsResult(allNewsResponse: Response<AllNewsResponse>)
}
