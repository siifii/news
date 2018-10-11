package com.news.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.news.data.local.room.NewsDatabase
import com.news.ui.news.NewsViewModel

class ViewModelFactory(private val context: Fragment) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            val db = Room.databaseBuilder(context.context!!, NewsDatabase::class.java, "articles").build()
            @Suppress("UNCHECKED_CAST")
            return NewsViewModel(db.newsDoa()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}