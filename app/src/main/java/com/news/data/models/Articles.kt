package com.news.data.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "articles")
data class Articles(
        @SerializedName("url") var newsUrl: String? = null,
        @SerializedName("urlToImage") var newsImageUrl: String? = null,
        @SerializedName("publishedAt") var time: String? = null,
        @SerializedName("source") var source: Source
)


