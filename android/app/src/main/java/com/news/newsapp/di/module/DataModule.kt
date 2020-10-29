package com.news.newsapp.di.module

import android.app.Application
import android.content.Context
import com.news.newsapp.utils.PREF_NAME
import com.news.newsapp.BuildConfig
import com.news.newsapp.data.manager.AppDataManager
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.data.storage.local.sharedprefs.SharedPreferenceInfo
import com.news.newsapp.data.storage.local.sharedprefs.SharedPrefsHelper
import com.news.newsapp.data.storage.local.sharedprefs.SharedPrefsService
import com.news.newsapp.data.storage.remote.APIHelper
import com.news.newsapp.data.storage.remote.APIService
import com.news.newsapp.data.storage.remote.SupportInterceptor
import com.news.newsapp.rx.AppSchedulerProvider
import com.news.newsapp.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
class
DataModule {


    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }


    @Provides
    @SharedPreferenceInfo
    internal fun providePreferenceName(): String {
        return PREF_NAME
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(sharedPrefsService: SharedPrefsService): SharedPrefsHelper {
        return sharedPrefsService
    }

    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(
        cache: Cache,
        interceptors: Array<Interceptor?>
    ): OkHttpClient {
        val client = OkHttpClient.Builder()

        // add interceptors
        for (interceptor in interceptors) {
            if (interceptor != null) {
                client.addInterceptor(interceptor)
            }
        }
        return client.build()
    }

    /**
     * Generic method to provide OkhttpInterceptors.
     */
    @Provides
    @Singleton
    fun provideOkhttpInterceptors(sharedPrefsService: SharedPrefsService): Array<Interceptor> {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return arrayOf(logging, SupportInterceptor(sharedPrefsService))
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASEURL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesNetworkService(
        retrofit: Retrofit
    ): APIHelper {
        return retrofit.create<APIHelper>(APIHelper::class.java)
    }

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit,
        apiHelper: APIHelper
    ): APIService {
        return APIService(retrofit, apiHelper)
    }


}