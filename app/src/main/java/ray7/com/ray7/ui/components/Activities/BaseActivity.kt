package ray7.com.ray7.ui.components.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ray7.com.ray7.data.services.RetrofitWebService
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApplication.graph.inject(this)
    }
}
