package com.news.newsapp.model

import com.google.gson.annotations.SerializedName

data class AllNewsResponse(
    @SerializedName("articles")
    val articles: List<Article> = listOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0
)

data class Article(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("content")
    val content: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("source")
    val source: NewsSources = NewsSources(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: String = ""
)

data class NewsSources(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)

