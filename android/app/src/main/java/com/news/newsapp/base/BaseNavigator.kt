package com.news.newsapp.base

/**
 * BaseNavigator for navigating in between the activity with it's data
 */
interface BaseNavigator {

    /**
     * default method to setup views and data.
     */
    fun setupViews()

    /**
     * default method for open next activity.
     */
    fun openNextActivity()

}
