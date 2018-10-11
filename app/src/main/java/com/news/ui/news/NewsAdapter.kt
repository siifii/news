package com.news.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.data.models.Articles
import com.news.databinding.ItemListNewsBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    private lateinit var list: List<Articles>

    fun addServices(r: List<Articles>) {
        this.list = r
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(ItemListNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return if (::list.isInitialized) list.size else 0
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(list[position])
    }


    class NewsHolder(private val binding: ItemListNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = NewsItemViewModel()

        fun bind(articles: Articles) {
            viewModel.bind(articles)
            binding.newsVM = viewModel
        }
    }
}