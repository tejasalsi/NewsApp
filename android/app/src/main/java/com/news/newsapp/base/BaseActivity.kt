package com.news.newsapp.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.news.newsapp.R
import com.news.newsapp.utils.NetworkUtils
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject


/**
 * Base class for app activities that use the common feature like action bar and theme
 * with some common function support which needs to available to activity.
 */
abstract class BaseActivity<V : BaseViewModel<*>> : DaggerAppCompatActivity(), BaseFragment.Callback {

    private val mViewModel: V? = null

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkNetworkAvailability()
    }


    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun checkForPermissions(permissions: Array<String>, permissionRequestCode: Int): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var result: Int
            val listPermissions = ArrayList<String>()
            for (permission in permissions) {
                result = ContextCompat.checkSelfPermission(this, permission)
                if (result != PackageManager.PERMISSION_GRANTED) {
                    listPermissions.add(permission)
                }
            }
            if (!listPermissions.isEmpty()) {
                requestPermissionsSafely(
                    listPermissions.toTypedArray<String>(),
                    permissionRequestCode
                )
                return false
            }
        }
        return true
    }


    companion object {

        val TAG = BaseActivity::class.java.name
    }


    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String?) {}


    fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkAvailable(applicationContext)
    }

    override fun onResume() {
        super.onResume()
    }

    /**
     * Function: showToast will show message in Toast
     */
    fun showToast(resId: Int) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show()

    }

    /**
     * Function : checkNetworkAvailability for checking
     * network availability on Android P and above OS version
     */
    @TargetApi(Build.VERSION_CODES.P)
    fun checkNetworkAvailability() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            connectivityManager.registerNetworkCallback(
                NetworkRequest.Builder()
                    .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                    .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
                    .build(),
                object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        NetworkUtils.isNetworkAvailableOnAndroidP = true
                    }

                    override fun onLost(network: Network) {
                        super.onLost(network)
                        NetworkUtils.isNetworkAvailableOnAndroidP = false
                    }
                })
        }
    }


}
