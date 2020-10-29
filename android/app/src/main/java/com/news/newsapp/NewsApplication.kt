package com.news.newsapp

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NewsApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return com.news.newsapp.di.component.DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityDestroyed(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }

            override fun onActivityResumed(activity: Activity) {

            }

        })
    }

}
