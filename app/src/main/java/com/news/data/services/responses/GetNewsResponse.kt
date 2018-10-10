package com.news.data.services.responses

import com.google.gson.annotations.SerializedName
import com.news.data.models.Articles
import java.io.Serializable

open class GetNewsResponse(
        @SerializedName("status") var status: String,
        @SerializedName("totalResults") var totalResults: Int,
        @SerializedName("articles") var articles:List<Articles>
):Serializable

