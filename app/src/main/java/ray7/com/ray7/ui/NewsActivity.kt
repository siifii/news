package ray7.com.ray7.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ray7.com.ray7.R
import ray7.com.ray7.ui.news.NewsFragment

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, NewsFragment.newInstance())
                    .commitNow()
        }
    }

}
