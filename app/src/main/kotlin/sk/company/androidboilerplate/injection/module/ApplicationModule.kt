package sk.company.androidboilerplate.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import sk.company.androidboilerplate.data.local.PreferencesHelper
import sk.company.androidboilerplate.data.remote.NetworkService
import sk.company.androidboilerplate.injection.ApplicationContext
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun provideApplication() : Application {
        return application
    }

    @Provides
    @ApplicationContext
    fun provideContext() : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideNetworkService() : NetworkService {
        return NetworkService.Builder.newNetworkService(getPreferencesHelper())
    }

    @Provides
    fun getPreferencesHelper() : PreferencesHelper {
        return PreferencesHelper(provideContext())
    }
}