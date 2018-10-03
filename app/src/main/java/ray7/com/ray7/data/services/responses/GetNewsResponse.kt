package ray7.com.ray7.data.services.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import ray7.com.ray7.data.services.Articles
import ray7.com.ray7.data.services.Source
import java.io.Serializable

open class GetNewsResponse(
        @SerializedName("status") var status: String,
        @SerializedName("totalResults") var totalResults: Int,
        @SerializedName("articles") var articles:List<Articles>
):Serializable

