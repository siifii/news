package ray7.com.ray7.data.services

import ray7.com.ray7.data.services.responses.GetNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {

    @GET("v2/everything?q=bitcoin&apiKey=09673f79921a40238f6210a39f9f554b")
    fun getNews(): Call<GetNewsResponse>

}
