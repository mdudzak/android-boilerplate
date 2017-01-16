package sk.company.androidboilerplate.injection.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import sk.company.androidboilerplate.injection.ActivityContext

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity(): Context {
        return activity
    }
    @Provides
    @ActivityContext
    fun providesContext(): Context {
        return activity
    }



}