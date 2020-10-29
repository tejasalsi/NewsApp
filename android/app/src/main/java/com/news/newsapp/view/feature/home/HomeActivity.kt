package com.news.newsapp.view.feature.home

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.news.newsapp.R
import com.news.newsapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity:BaseActivity<HomeViewModel>() {

    private val navController by lazy { findNavController(R.id.home_nav_host_fragment) }

    @Inject
    lateinit var homeViewModel: HomeViewModel
    override val viewModel: HomeViewModel
        get() = homeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNav.selectedItemId = R.id.sourcesFragment
        bottomNav.setupWithNavController(navController)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            if(!navController.popBackStack(R.id.sourcesFragment, true)) {
                navController.popBackStack()
            }
            when (menuItem.itemId) {
                R.id.sourcesFragment -> {
                    navController.navigate(R.id.sourcesFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.allNewsFragment -> {
                    navController.navigate(R.id.allNewsFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}
