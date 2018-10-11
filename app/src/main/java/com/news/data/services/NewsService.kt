package com.news.data.services

import io.reactivex.Observable
import com.news.data.services.responses.GetNewsResponse
import retrofit2.http.GET

interface NewsService {

    @GET("v2/everything?q=bitcoin&apiKey=09673f79921a40238f6210a39f9f554b")
    fun getNews(): Observable<GetNewsResponse>

}
