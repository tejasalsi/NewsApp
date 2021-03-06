package com.news.newsapp.view.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.newsapp.R
import com.news.newsapp.base.BaseFragment
import com.news.newsapp.model.AllNewsResponse
import com.news.newsapp.model.SourcesResponse
import com.news.newsapp.utils.ALL_NEWS
import com.news.newsapp.utils.PaginationScrollListener
import kotlinx.android.synthetic.main.fragment_allnews.*
import retrofit2.Response
import javax.inject.Inject

class AllNewsFragment: BaseFragment<HomeViewModel>(), HomeNavigator {
    @Inject
    lateinit var homeViewModel: HomeViewModel
    override val viewModel: HomeViewModel
        get() = homeViewModel

    @Inject
    lateinit var allNewsAdapter: AllNewsAdapter
    var newsCount = 0
    var pageNo = 1
    var newsFetchedCount = 0
    var isLoading = false
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel.homeNavigator = this
        return inflater.inflate(R.layout.fragment_allnews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getAllNews(pageNo)
        setupViews()
    }

    override fun sourceResult(sourcesResponse: Response<SourcesResponse>) {

    }

    override fun newsResult(allNewsResponse: Response<AllNewsResponse>) {
        newsCount = allNewsResponse.body()!!.totalResults
        newsFetchedCount += allNewsResponse.body()!!.articles.size
        isLoading = false

        allNewsAdapter.addNewsItems(allNewsResponse.body()!!.articles)
    }

    override fun setupViews() {
        allNewsAdapter.comingFrom(ALL_NEWS)
        layoutManager = LinearLayoutManager(requireContext())
        allNewsRecyclerView.layoutManager = layoutManager
        allNewsRecyclerView.adapter = allNewsAdapter
        allNewsRecyclerView.addOnScrollListener(object: PaginationScrollListener(layoutManager) {
            override fun isLastPage(): Boolean {
                return newsCount <= newsFetchedCount
            }

            override fun isLoading(): Boolean {
                return  isLoading
            }

            override fun loadMoreItems() {
                pageNo++
                isLoading = true
                homeViewModel.getAllNews(pageNo)
            }

        })
    }

    override fun openNextActivity() {

    }
}
