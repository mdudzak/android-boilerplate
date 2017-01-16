package sk.company.androidboilerplate.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import sk.company.androidboilerplate.data.DataManager
import sk.company.androidboilerplate.data.local.PreferencesHelper
import sk.company.androidboilerplate.injection.ApplicationContext
import sk.company.androidboilerplate.injection.module.ApplicationModule
import sk.company.androidboilerplate.util.RxEventBus
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    @ApplicationContext fun context() : Context
    fun application() : Application
    //fun rest() : RestService
    fun preferencesHelper() : PreferencesHelper
    fun dataManager() : DataManager
    fun eventBus() : RxEventBus
}


