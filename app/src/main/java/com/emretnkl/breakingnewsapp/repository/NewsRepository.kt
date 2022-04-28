package com.emretnkl.breakingnewsapp.repository

import com.emretnkl.breakingnewsapp.api.RetrofitInstance
import com.emretnkl.breakingnewsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode : String , pageNumber : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery : String , pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}