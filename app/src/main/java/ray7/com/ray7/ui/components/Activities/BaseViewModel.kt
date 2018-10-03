package ray7.com.ray7.ui.components.Activities

import androidx.lifecycle.ViewModel
import ray7.com.ray7.di.component.DaggerViewModelInjector
import ray7.com.ray7.di.component.ViewModelInjector
import ray7.com.ray7.di.module.NetworkModule
import ray7.com.ray7.ui.news.NewsViewModel

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