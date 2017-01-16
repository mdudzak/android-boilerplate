package sk.company.androidboilerplate.ui

import android.app.Application
import sk.company.androidboilerplate.injection.component.ApplicationComponent

class App : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
    }
}