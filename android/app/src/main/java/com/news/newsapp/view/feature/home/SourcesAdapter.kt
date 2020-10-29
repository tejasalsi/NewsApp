package com.news.newsapp.view.feature.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.newsapp.R
import com.news.newsapp.data.manager.DataManager

class SourcesAdapter(dataManager: DataManager, context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SourcesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.source_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    class SourcesViewHolder(view: View): RecyclerView.ViewHolder(view)
}