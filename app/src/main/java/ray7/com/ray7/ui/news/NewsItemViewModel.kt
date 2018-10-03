package ray7.com.ray7.ui.news

import androidx.lifecycle.ViewModel
import ray7.com.ray7.data.services.Articles
import java.text.SimpleDateFormat
import java.util.*

class NewsItemViewModel(private val articles: Articles) : ViewModel() {

    fun getNewsName() = articles.source.newsName
    fun getNewsTime(): String {
        val outputFormat = SimpleDateFormat("EEEE dd MMM yyyy", Locale.getDefault())
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val inputText = articles.time
        val date = inputFormat.parse(inputText)
        return outputFormat.format(date)
    }

    fun getNewsImage() = articles.newsImageUrl

}
