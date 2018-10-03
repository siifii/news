package ray7.com.ray7.data.services.responses

import com.google.gson.annotations.SerializedName
import ray7.com.ray7.data.models.Articles
import java.io.Serializable

open class GetNewsResponse(
        @SerializedName("status") var status: String,
        @SerializedName("totalResults") var totalResults: Int,
        @SerializedName("articles") var articles:List<Articles>
):Serializable

