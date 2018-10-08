package ray7.com.ray7.data.services

import io.reactivex.Observable
import ray7.com.ray7.data.services.responses.GetNewsResponse
import retrofit2.http.GET

interface NewsService {

    @GET("v2/everything?q=bitcoin&apiKey=09673f79921a40238f6210a39f9f554b")
    fun getNewss(): Observable<GetNewsResponse>

}
