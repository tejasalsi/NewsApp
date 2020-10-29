package com.news.newsapp.data.storage.remote

import com.news.newsapp.data.storage.local.sharedprefs.SharedPrefsService
import com.news.newsapp.utils.ACCESS_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor(sharedPrefsService: SharedPrefsService): Interceptor {
    private val mSharedPrefsService = sharedPrefsService

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${mSharedPrefsService.getStringValue(ACCESS_TOKEN)}")
            .build()
        return chain.proceed(newRequest)
    }
}
