package com.news.newsapp.view.feature.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.news.newsapp.R
import com.news.newsapp.base.BaseFragment
import com.news.newsapp.model.AllNewsResponse
import com.news.newsapp.model.SourcesResponse
import kotlinx.android.synthetic.main.fragment_news_details.*
import retrofit2.Response
import javax.inject.Inject

class NewsDetailsFragment: BaseFragment<HomeViewModel>(), HomeNavigator {
    @Inject
    lateinit var homeViewModel: HomeViewModel
    override val viewModel: HomeViewModel
        get() = homeViewModel
    
    private val args: NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    override fun sourceResult(sourcesResponse: Response<SourcesResponse>) {

    }

    override fun newsResult(allNewsResponse: Response<AllNewsResponse>) {

    }

    override fun setupViews() {
        val article = args.article!!
        Glide.with(requireContext()).load(article.urlToImage)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(newsBannerImg)
        if(article.source.name.isNullOrEmpty()) {
            newsSource.text = getString(R.string.na)
        } else {
            newsSource.text = article.source.name
        }

        if(article.author.isNullOrEmpty()) {
            newsAuthor.text = getString(R.string.na)
        } else {
            newsAuthor.text = article.author
        }

        if(article.description.isNullOrEmpty()) {
            newsDesc.text = getString(R.string.na)
        } else {
            newsDesc.text = article.description
        }

        if(article.content.isNullOrEmpty()) {
            newsContent.text = getString(R.string.na)
        } else {
            newsContent.text = article.content
        }

        if(article.url.isNullOrEmpty()) {
            newsUrl.text = getString(R.string.na)
        } else {
            newsUrl.text = article.url
        }

        newsUrl.setOnClickListener {
            if(newsUrl.text.toString() != getString(R.string.na)) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl.text.toString()))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }

    }

    override fun openNextActivity() {

    }
}
