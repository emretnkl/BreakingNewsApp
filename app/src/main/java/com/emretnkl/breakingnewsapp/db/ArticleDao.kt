package com.emretnkl.breakingnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.emretnkl.breakingnewsapp.models.Article

@Dao
interface ArticleDao {

    //Update if it exists or create if it doesn't exists
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}