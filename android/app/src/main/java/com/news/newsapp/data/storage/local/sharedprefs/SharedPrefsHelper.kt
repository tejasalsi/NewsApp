package com.news.newsapp.data.storage.local.sharedprefs


/**
 * SharedPrefsHelper
 */
interface SharedPrefsHelper {

    /**
     * Set String value against the key
     * @param key
     * @param value
     */
    fun setStringValue(key: String, value: String)

    /**
     * return String against the key
     * @param key
     * @return String
     */
    fun getStringValue(key: String): String


    /**
     * Set Boolean value against the key
     * @param key
     * @param value
     */
    fun setBooleanValue(key: String, value: Boolean)

    /**
     * return Boolean against the key
     * @param key
     * @return String
     */
    fun getBooleanValue(key: String): Boolean

    /**
     * return Boolean against the key
     * @param key
     * @return String
     */
    fun clearAllSharedPref(): Boolean
}
