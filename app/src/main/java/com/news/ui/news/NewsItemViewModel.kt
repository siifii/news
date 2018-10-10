package com.news.ui.news

import androidx.lifecycle.MutableLiveData
import com.news.data.models.Articles
import com.news.ui.components.activity.BaseViewModel
import java.text.SimpleDateFormat
import java.util.*


class NewsItemViewModel : BaseViewModel() {
    private val newsName = MutableLiveData<String>()
    private val newsTime = MutableLiveData<String>()
    private val newsImageURl = MutableLiveData<String>()


    fun bind(articles: Articles) {

        val outputFormat = SimpleDateFormat("EEEE dd MMM yyyy", Locale.getDefault())
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val inputText = articles.time
        val date = inputFormat.parse(inputText)

        newsTime.value = outputFormat.format(date)
        newsName.value = articles.source.newsName
        newsImageURl.value = articles.newsImageUrl
    }

    fun getNewsName(): MutableLiveData<String> {
        return newsName
    }

    fun getNewsTime(): MutableLiveData<String> {
        return newsTime
    }

    fun getNewsImage(): MutableLiveData<String> {
        return newsImageURl
    }
}
