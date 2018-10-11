package com.news.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.news.data.models.Articles


@Dao
interface NewsDao {
    @get:Query("SELECT * FROM articles")
    val all: List<Articles>

    @Insert
    fun insertAll(vararg users: Articles)
}