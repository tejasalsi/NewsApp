package com.news.newsapp.base

import androidx.lifecycle.ViewModel
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


/**
 * Base View Model for all View model which attached to activity
 */
open class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModel() {
    open var navigator: N? = null
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    //TODO:handle common error response here

}



