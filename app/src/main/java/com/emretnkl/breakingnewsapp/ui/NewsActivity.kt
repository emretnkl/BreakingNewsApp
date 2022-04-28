package com.emretnkl.breakingnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.emretnkl.breakingnewsapp.NewsViewModelProviderFactory
import com.emretnkl.breakingnewsapp.R
import com.emretnkl.breakingnewsapp.databinding.ActivityNewsBinding
import com.emretnkl.breakingnewsapp.db.ArticleDatabase
import com.emretnkl.breakingnewsapp.repository.NewsRepository


class NewsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityNewsBinding

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.setLogo(R.mipmap.ic_launcher_round)
        actionBar?.setDisplayUseLogoEnabled(true)

        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory)[NewsViewModel::class.java]

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)


        val appBarConfiguration = AppBarConfiguration(setOf(R.id.breakingNewsFragment, R.id.savedNewsFragment, R.id.searchNewsFragment))
        setupActionBarWithNavController(navController , appBarConfiguration)



    }

}


