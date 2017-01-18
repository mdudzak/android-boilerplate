package sk.company.androidboilerplate.injection.component

import dagger.Subcomponent
import sk.company.androidboilerplate.injection.PerActivity
import sk.company.androidboilerplate.injection.module.ActivityModule
import sk.company.androidboilerplate.ui.main.MainActivity

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(kotlinActivity: MainActivity)
}