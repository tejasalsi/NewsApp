package com.news.newsapp.data.storage.local.sharedprefs

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject

/**
 * SharedPrefsService
 */
class SharedPrefsService @Inject
constructor(context: Context, @SharedPreferenceInfo preferenceFileName: String) :
    SharedPrefsHelper {

    private val mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = context.getSharedPreferences(preferenceFileName, Context.MODE_PRIVATE)
    }

    /**
     * This method is used to set String values in Preference file.
     *
     * @param key
     * @param value - String value to be set.
     */
    override fun setStringValue(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    /**
     * This method is used to get the String value from Preference file.
     *
     * @param key
     * @return value
     * @throws NullPointerException
     */
    @Throws(NullPointerException::class)
    override fun getStringValue(key: String): String {
        return mSharedPreferences.getString(key, "").toString()
    }


    /**
     * This method is used to set String values in Preference file.
     *
     * @param key
     * @param value - String value to be set.
     */
    override fun setBooleanValue(key: String, value: Boolean) {
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    /**
     * This method is used to get the String value from Preference file.
     *
     * @param key
     * @return value
     * @throws NullPointerException
     */
    @Throws(NullPointerException::class)
    override fun getBooleanValue(key: String): Boolean {
        return mSharedPreferences.getBoolean(key, false)
    }

    override fun clearAllSharedPref(): Boolean {
       return mSharedPreferences.edit().clear().commit();
    }

}
