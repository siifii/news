package ray7.com.ray7.di.dagger

import afaqy.amanstudent.di.dagger.AndroidModule
import dagger.Component
import ray7.com.ray7.ui.components.Activities.BaseActivity
import ray7.com.ray7.ui.components.Activities.MyApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidModule::class, PlainModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)
    fun inject(activity: BaseActivity)
}

