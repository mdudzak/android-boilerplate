package sk.company.androidboilerplate.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import sk.company.androidboilerplate.injection.ApplicationContext

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
}