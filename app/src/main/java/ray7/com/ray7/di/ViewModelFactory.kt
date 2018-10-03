package ray7.com.ray7.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import ray7.com.ray7.data.local.room.NewsDatabase
import ray7.com.ray7.ui.news.NewsViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            val db = Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "articles").build()
            @Suppress("UNCHECKED_CAST")
            return NewsViewModel(db.articleDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}