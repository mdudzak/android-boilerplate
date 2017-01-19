package sk.company.androidboilerplate.ui.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import sk.company.androidboilerplate.BoilerplateApplication
import sk.company.androidboilerplate.injection.component.ActivityComponent
import sk.company.androidboilerplate.injection.component.ConfigPersistentComponent
import sk.company.androidboilerplate.injection.component.DaggerConfigPersistentComponent
import sk.company.androidboilerplate.injection.module.ActivityModule
import timber.log.Timber
import java.util.concurrent.atomic.AtomicLong

/**
 * Abstract activity that every other Activity in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent survive
 * across configuration changes.
 */

abstract class BaseActivity : AppCompatActivity() {
    private val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
    private val NEXT_ID = AtomicLong(0)
    private val sComponentsMap: MutableMap<Long, ConfigPersistentComponent> = hashMapOf()
    private var activityComponent: ActivityComponent? = null
    private var mActivityId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**** REUSE PRESENTERS WITH CONFIG PERSISTENT ****/
        mActivityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.andIncrement
        val configPersistentComponent: ConfigPersistentComponent?
        if (!sComponentsMap.containsKey(mActivityId)) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", mActivityId)
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(BoilerplateApplication.applicationComponent)
                    .build()
            sComponentsMap.put(mActivityId, configPersistentComponent)
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", mActivityId)
            configPersistentComponent = sComponentsMap[mActivityId]
        }

        activityComponent = configPersistentComponent?.activityComponent(ActivityModule(this))

        if (getLayoutRes() != 0) {
            setContentView(getLayoutRes())
        }
        if (getToolbar() != 0) {
            setSupportActionBar(findViewById(getToolbar()) as Toolbar)
        }

        injectDependencies(activityComponent)
    }

    @LayoutRes protected abstract fun getLayoutRes(): Int
    @IdRes protected fun getToolbar(): Int {
        return 0
    }

    abstract fun injectDependencies(activityComponent: ActivityComponent?)
}