package com.news.newsapp.view.feature.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.news.newsapp.R
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.model.Article
import com.news.newsapp.utils.ALL_NEWS
import kotlinx.android.synthetic.main.news_item.view.*

class AllNewsAdapter(dataManager: DataManager, context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mContext = context

    private var newsList = mutableListOf<Article>()
    private var mScreen = ""

    fun addNewsItems(news: List<Article>) {
        newsList.addAll(news)
        notifyDataSetChanged()
    }

    fun comingFrom(screen: String) {
        mScreen = screen
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(mContext).load(newsList[position].urlToImage)
            .centerCrop()
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(holder.itemView.newsBanner)
        holder.itemView.newsTitle.text = newsList[position].title

        holder.itemView.setOnClickListener {
            val action = if(mScreen == ALL_NEWS) {
                AllNewsFragmentDirections.allNewsToNewsDetails(newsList[position])
            } else {
                SourceNewsFragmentDirections.sourceNewsToNewsDetails(newsList[position])
            }
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class NewsViewHolder(view: View): RecyclerView.ViewHolder(view)
}