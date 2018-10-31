package com.news.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.news.data.local.room.NewsDatabase
import com.news.ui.news.NewsViewModel
import com.news.utils.DATABASE_NAME

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            val db = Room.databaseBuilder(context.applicationContext,
                    NewsDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build()
            @Suppress("UNCHECKED_CAST")
            return NewsViewModel(db.newsDoa()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}