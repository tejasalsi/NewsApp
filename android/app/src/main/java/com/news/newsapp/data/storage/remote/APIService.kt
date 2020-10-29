package com.news.newsapp.data.storage.remote


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
}
