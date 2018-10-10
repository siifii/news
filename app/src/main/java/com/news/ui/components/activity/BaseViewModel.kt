package com.news.ui.components.activity

import androidx.lifecycle.ViewModel
import com.news.di.component.DaggerViewModelInjector
import com.news.di.component.ViewModelInjector
import com.news.di.module.NetworkModule
import com.news.ui.news.NewsViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is NewsViewModel -> injector.inject(this)
        }
    }
}