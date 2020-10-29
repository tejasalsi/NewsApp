package com.news.newsapp.data.manager

import android.content.Context
import com.news.newsapp.data.storage.local.sharedprefs.SharedPrefsService
import com.news.newsapp.data.storage.remote.APIService

import javax.inject.Inject

/**
 * AppDataManager is implementation of [DataManager]
 */
class AppDataManager @Inject
constructor(
    override val context: Context,
    override val sharedPrefsService: SharedPrefsService,
    override val apiService: APIService,
) : DataManager
