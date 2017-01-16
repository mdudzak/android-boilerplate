package sk.company.androidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import sk.company.androidboilerplate.data.DataManager;
import sk.company.androidboilerplate.data.SyncService;
import sk.company.androidboilerplate.data.local.DatabaseHelper;
import sk.company.androidboilerplate.data.local.PreferencesHelper;
import sk.company.androidboilerplate.data.remote.RibotsService;
import sk.company.androidboilerplate.injection.ApplicationContext;
import sk.company.androidboilerplate.injection.module.ApplicationModule;
import sk.company.androidboilerplate.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext
    Context context();
    Application application();
    RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
