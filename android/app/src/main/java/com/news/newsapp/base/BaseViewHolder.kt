package com.news.newsapp.base

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * Base class for all [ViewHolder] which help the data object
 * to get hold when recycler view
 * bind it self to them.
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

   abstract fun onBind(position: Int)
}