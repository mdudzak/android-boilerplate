package sk.company.androidboilerplate.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import sk.company.androidboilerplate.injection.component.ApplicationComponent;
import sk.company.androidboilerplate.test.common.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
