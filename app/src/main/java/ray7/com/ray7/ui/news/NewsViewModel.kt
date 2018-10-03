package ray7.com.ray7.ui.news

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ray7.com.ray7.R
import ray7.com.ray7.data.local.room.ArticlesDao
import ray7.com.ray7.data.models.Articles
import ray7.com.ray7.data.services.NewsService
import ray7.com.ray7.ui.components.Activities.BaseViewModel
import javax.inject.Inject

class NewsViewModel(private val newsDao: ArticlesDao) : BaseViewModel() {
    @Inject
    lateinit var newsService: NewsService
    val newsAdapter: NewsAdapter = NewsAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadNews() }

    private lateinit var subscription: Disposable

    init {
        loadNews()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadNews() {
        subscription = Observable.fromCallable { newsDao.all }
                .concatMap { dbNewsList ->
                    if (dbNewsList.isEmpty())
                        newsService.getNewss().concatMap { apiNewsList ->
                            newsDao.insertAll(*apiNewsList.toTypedArray())
                            Observable.just(apiNewsList)
                        }
                    else
                        Observable.just(dbNewsList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result) },
                        { onRetrievePostListError() }
                )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(articleList: List<Articles>) {
        newsAdapter.addServices(articleList)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.unable_to_get_new
    }
}

