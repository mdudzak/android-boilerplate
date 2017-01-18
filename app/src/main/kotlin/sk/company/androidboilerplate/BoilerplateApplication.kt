package sk.company.androidboilerplate

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import sk.company.androidboilerplate.injection.component.ApplicationComponent
import sk.company.androidboilerplate.injection.component.DaggerApplicationComponent
import sk.company.androidboilerplate.injection.module.ApplicationModule
import timber.log.Timber

class BoilerplateApplication: Application() {
    companion object {
        @JvmStatic lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            LeakCanary.install(this)

        }
    }
}