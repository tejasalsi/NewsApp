package com.news.newsapp.utils

import android.util.Log
import com.news.newsapp.BuildConfig

/**
 * The AppLog class manage the logs in application in debug mode @property IS_DEVELOPER_BUILD
 */

object AppLogUtils {
    var IS_DEVELOPER_BUILD: Boolean = BuildConfig.DEBUG
    fun d(tag: String?, message: String?) {
        if (IS_DEVELOPER_BUILD) Log.d(tag, message)
    }

    fun i(tag: String?, message: String?) {
        if (IS_DEVELOPER_BUILD) Log.i(tag, message)
    }

    fun v(tag: String?, message: String?) {
        if (IS_DEVELOPER_BUILD) Log.v(tag, message)
    }

    fun w(tag: String?, message: String?) {
        if (IS_DEVELOPER_BUILD) Log.w(tag, message)
    }

    fun e(tag: String?, message: String?) {
        if (IS_DEVELOPER_BUILD) Log.e(tag, message)
    }
}
