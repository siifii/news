package com.news.di.component

import dagger.Component
import com.news.di.module.NetworkModule
import com.news.ui.news.NewsViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified NewsItemViewModel.
     * @param NewsItemViewModel NewsItemViewModel in which to inject the dependencies
     */
    fun inject(NewsViewModel: NewsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}