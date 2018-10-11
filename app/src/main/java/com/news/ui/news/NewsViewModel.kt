package com.news.ui.news

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.news.R
import com.news.data.local.room.NewsDao
import com.news.data.models.Articles
import com.news.data.services.NewsService
import com.news.ui.components.activity.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel(private val newsDoa: NewsDao) : BaseViewModel() {
    @Inject
    lateinit var newsService: NewsService
    val newsAdapter: NewsAdapter = NewsAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadNewss() }

    private lateinit var subscription: Disposable

    init {
        loadNewss()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadNewss() {
        subscription = Observable.fromCallable { newsDoa.all }
                .concatMap { dbNewsList ->
                    if (dbNewsList.isEmpty())
                        newsService.getNewss().concatMap { apiNewsList ->
                            newsDoa.insertAll(*apiNewsList.articles.toTypedArray())
                            Observable.just(apiNewsList.articles)
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

    private fun loadNews() {
        newsService.getNewss()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result.articles) },
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

    private fun onRetrievePostListSuccess(newsList: List<Articles>) {
        newsAdapter.addServices(newsList)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.unable_to_get_new
    }
}

