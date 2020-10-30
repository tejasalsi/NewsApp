package com.news.newsapp.data.storage.remote

import com.news.newsapp.model.AllNewsResponse
import com.news.newsapp.model.SourcesResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface APIHelper {

    @GET
    fun getNewsSources(
        @Url url: String
    ): Observable<Response<SourcesResponse>>

    @GET
    fun getHeadLines(
        @Url url: String,
        @Query("sources") source: String,
        @Query("page") page: Int
    ): Observable<Response<AllNewsResponse>>

    @GET
    fun getAllNews(
        @Url url: String,
        @Query("q") newsPhrase: String,
        @Query("page") page: Int
    ): Observable<Response<AllNewsResponse>>

}
