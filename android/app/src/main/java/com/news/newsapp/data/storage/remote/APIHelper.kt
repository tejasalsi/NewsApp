package com.news.newsapp.data.storage.remote

import com.news.newsapp.model.AllNewsResponse
import com.news.newsapp.model.SourcesResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Query
import retrofit2.http.Url


interface APIHelper {

    fun getNewsSources(
        @Url url: String
    ): Observable<Response<SourcesResponse>>

    fun getHeadLines(
        @Url url: String,
        @Query("sources") source: String
    ): Observable<Response<AllNewsResponse>>

}
