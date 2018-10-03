package ray7.com.ray7.ui.news

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ray7.com.ray7.data.services.Articles
import ray7.com.ray7.databinding.ItemListNewsBinding
import java.util.*

class NewsAdapter(val context: Context?, list: List<Articles>) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    val list = ArrayList<Articles>()

    init {
        addServices(list)
        notifyDataSetChanged()
    }

    private fun addServices(r: List<Articles>) {
        list.addAll(r)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(ItemListNewsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.binding.newsVM = NewsItemViewModel(list[position])
    }


    class NewsHolder(var binding: ItemListNewsBinding) : RecyclerView.ViewHolder(binding.root)
}