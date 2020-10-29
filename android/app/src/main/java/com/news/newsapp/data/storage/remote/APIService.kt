package com.news.newsapp.data.storage.remote


import com.news.newsapp.model.AllNewsResponse
import com.news.newsapp.model.SourcesResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class APIService {
    private var mApiHelper: APIHelper
    private var mRetrofit: Retrofit

    @Inject
    constructor(retrofit: Retrofit, apiHelper: APIHelper) {
        mApiHelper = apiHelper
        mRetrofit = retrofit
    }

    fun getSources(): Observable<Response<SourcesResponse>> {
        return mApiHelper.getNewsSources("sources")
    }

    fun getHeadLines(sources: String): Observable<Response<AllNewsResponse>> {
        return mApiHelper.getHeadLines("top-headlines", sources)
    }

    fun getAllNews(newsPhrase: String, page: Int): Observable<Response<AllNewsResponse>> {
        return mApiHelper.getAllNews("everything", newsPhrase, page)
    }
}
