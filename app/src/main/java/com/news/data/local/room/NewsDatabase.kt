package com.news.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.news.data.models.Articles


@Database(entities = [Articles::class], version = 5)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDoa(): NewsDao
}