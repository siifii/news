package com.news.data.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

class Source(
        @SerializedName("name") var newsName: String? = null
)


