package com.news.newsapp.view.feature.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.newsapp.R
import com.news.newsapp.data.manager.DataManager
import com.news.newsapp.model.Source
import kotlinx.android.synthetic.main.source_item.view.*

class SourcesAdapter(dataManager: DataManager, context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mContext = context
    private lateinit var mSources: List<Source>
    fun addItems(sources: List<Source>) {
        mSources = sources
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SourcesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.source_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.sourceName.text = mSources[position].name
        holder.itemView.categoryTxt.text = mSources[position].category
        holder.itemView.sourceDesc.text = mSources[position].description
        holder.itemView.sourceUrl.text = mSources[position].url

        holder.itemView.sourceUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mSources[position].url))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mSources.size
    }

    class SourcesViewHolder(view: View): RecyclerView.ViewHolder(view)
}
