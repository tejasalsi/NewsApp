package com.news.newsapp.view.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.newsapp.R
import com.news.newsapp.base.BaseFragment
import com.news.newsapp.model.SourcesResponse
import kotlinx.android.synthetic.main.fragment_sources.*
import retrofit2.Response
import javax.inject.Inject

class SourcesFragment: BaseFragment<HomeViewModel>(), HomeNavigator {

    @Inject
    lateinit var homeViewModel: HomeViewModel
    override val viewModel: HomeViewModel
        get() = homeViewModel

    @Inject
    lateinit var sourcesAdapter: SourcesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel.homeNavigator = this
        return inflater.inflate(R.layout.fragment_sources, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getSources()
    }

    override fun sourceResult(sourcesResponse: Response<SourcesResponse>) {
        sourcesAdapter.addItems(sourcesResponse.body()!!.sources)
        setupViews()
    }

    override fun setupViews() {
        sourcesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        sourcesRecyclerView.adapter = sourcesAdapter

    }

    override fun openNextActivity() {

    }

}
