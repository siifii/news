package com.news.ui.news

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import news.ray7.R
import com.news.data.services.NewsService
import com.news.data.services.responses.GetNewsResponse
import com.news.ui.components.activity.BaseViewModel
import javax.inject.Inject

class NewsViewModel : BaseViewModel() {
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

    //    private fun loadNews() {
//        subscription = Observable.fromCallable { newsDao.all }
//                .concatMap { dbNewsList ->
//                    if (dbNewsList.isEmpty())
//                        newsService.getNewss().concatMap { apiNewsList ->
//                            newsDao.insertAll(*apiNewsList.toTypedArray())
//                            Observable.just(apiNewsList)
//                        }
//                    else
//                        Observable.just(dbNewsList)
//                }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe { onRetrievePostListStart() }
//                .doOnTerminate { onRetrievePostListFinish() }
//                .subscribe(
//                        { result -> onRetrievePostListSuccess(result) },
//                        { onRetrievePostListError() }
//                )
//    }

    private fun loadNews() {
        newsService.getNewss()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result) },
                        { t ->
                            onRetrievePostListError()
                            Log.d("error massage", t.toString())
                        })
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(getNewsResponse: GetNewsResponse) {
        newsAdapter.addServices(getNewsResponse.articles)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.unable_to_get_new
    }
}

