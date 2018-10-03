package ray7.com.ray7.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import ray7.com.ray7.R
import ray7.com.ray7.data.services.RetrofitWebService
import ray7.com.ray7.data.services.responses.GetNewsResponse
import ray7.com.ray7.databinding.NewsFragmentBinding
import ray7.com.ray7.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: NewsFragmentBinding
    private lateinit var viewModel: NewsViewModel

    companion object {
        fun newInstance() = NewsFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.news_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.getNewsServices()
    }
}
