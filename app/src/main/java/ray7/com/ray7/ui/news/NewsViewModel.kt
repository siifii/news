package ray7.com.ray7.ui.news

import android.view.View
import androidx.lifecycle.ViewModel
import ray7.com.ray7.R
import ray7.com.ray7.data.services.RetrofitWebService
import ray7.com.ray7.data.services.responses.GetNewsResponse
import ray7.com.ray7.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel() : ViewModel() {

    fun getNewsServices() {
        binding.pbNews.visibility = View.VISIBLE
        RetrofitWebService.getService().getNews().enqueue(object : Callback<GetNewsResponse> {
            override fun onFailure(call: Call<GetNewsResponse>, t: Throwable) {
                binding.pbNews.visibility = View.GONE
                RetrofitWebService.log(t)
                Utils.errorSnackbar(context, if (Utils.isNotConnected(t))
                    R.string.internet_error
                else
                    R.string.unable_to_get_new
                ) { i -> getNewsServices() }
            }

            override fun onResponse(call: Call<GetNewsResponse>, response: Response<GetNewsResponse>) {
                binding.pbNews.visibility = View.GONE
                val r = response.body()
                val article = r?.articles

                if (null == r || article!!.isEmpty()) {
                    onFailure(call, Throwable("Empty Response"))
                    binding.tvNoData.visibility = View.VISIBLE
                    return
                }
                when (r.status) {
                    "ok" -> {
                        binding.rvNews.adapter = NewsAdapter(context, article)
                    }
                }
            }
        })
    }
}


