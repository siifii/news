package ray7.com.ray7.ui.components.Activities

import afaqy.amanstudent.di.dagger.AndroidModule
import ray7.com.ray7.di.dagger.ApplicationComponent
import androidx.multidex.MultiDexApplication
import ray7.com.ray7.di.dagger.DaggerApplicationComponent
import ray7.com.ray7.di.dagger.PlainModule


class MyApplication : MultiDexApplication() {

    companion object {
        @JvmStatic
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder()
                .androidModule(AndroidModule(this))
                .plainModule(PlainModule())
                .build()
        graph.inject(this)
    }
}
