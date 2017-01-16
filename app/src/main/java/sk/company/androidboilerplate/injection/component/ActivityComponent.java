package sk.company.androidboilerplate.injection.component;

import dagger.Subcomponent;
import sk.company.androidboilerplate.injection.PerActivity;
import sk.company.androidboilerplate.injection.module.ActivityModule;
import sk.company.androidboilerplate.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
