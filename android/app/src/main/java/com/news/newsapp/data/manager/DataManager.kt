package com.news.newsapp.data.manager

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.news.newsapp.data.storage.local.sharedprefs.SharedPrefsService
import com.news.newsapp.data.storage.remote.APIService

/**
 * DataManager
 */
interface DataManager {

    /** Returns an [Context] of [AppCompatActivity].  */
    val context: Context

    /** Returns an [sharedPrefsService] of [SharedPreferences]  */
    val sharedPrefsService: SharedPrefsService

    val apiService: APIService
}
