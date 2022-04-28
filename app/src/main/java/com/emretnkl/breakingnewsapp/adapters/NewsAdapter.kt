package com.emretnkl.breakingnewsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emretnkl.breakingnewsapp.databinding.ItemArticlePreviewBinding
import com.emretnkl.breakingnewsapp.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {


    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article = differ.currentList[position]

        with(holder){
            with(differ.currentList[position]){
                val ivArticleImage = binding.ivArticleImage

                Glide.with(holder.itemView.context).load(article.urlToImage).into(ivArticleImage)
                binding.tvSource.text = article.source.name
                binding.tvDescription.text = article.description
                binding.tvTitle.text = article.title
                binding.tvPublishedAt.text = article.publishedAt

            }
        }
        holder.itemView.apply {
            setOnItemClickListener {
                onItemClickListener?.let { it(article) }
            }
        }

    }

    private var onItemClickListener : ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener : (Article) -> Unit) {
        onItemClickListener = listener
    }

}