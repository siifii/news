package ray7.com.ray7.data.services

import com.google.gson.annotations.SerializedName

class Articles(
        @SerializedName("url") var newsUrl: String? = null,
        @SerializedName("urlToImage") var newsImageUrl: String? = null,
        @SerializedName("publishedAt") var time: String? = null,
        @SerializedName("source") var source: Source
)


