package com.news.newsapp.view.feature.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.news.newsapp.R
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.model.Article
import kotlinx.android.synthetic.main.news_item.view.*

class AllNewsAdapter(dataManager: DataManager, context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mContext = context

    private var newsList = mutableListOf<Article>()

    fun addNewsItems(news: List<Article>) {
        newsList.addAll(news)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(mContext).load(newsList[position].urlToImage)
            .centerCrop()
            .into(holder.itemView.newsBanner)
        holder.itemView.newsTitle.text = newsList[position].title
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class NewsViewHolder(view: View): RecyclerView.ViewHolder(view)
}