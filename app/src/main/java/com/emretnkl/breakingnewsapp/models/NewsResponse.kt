package com.emretnkl.breakingnewsapp.models

import com.emretnkl.breakingnewsapp.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)