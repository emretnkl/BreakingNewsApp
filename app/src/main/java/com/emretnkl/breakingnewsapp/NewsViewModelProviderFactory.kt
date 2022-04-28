package com.emretnkl.breakingnewsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emretnkl.breakingnewsapp.repository.NewsRepository
import com.emretnkl.breakingnewsapp.ui.NewsViewModel

class NewsViewModelProviderFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }


}