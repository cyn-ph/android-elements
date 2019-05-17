package com.test.abc.di;


import com.test.abc.ABCApplication;
import com.test.abc.ui.main.di.MainAndroidInjector;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class,
        MainAndroidInjector.class,
        AndroidSupportInjectionModule.class,})
interface AppComponent extends AndroidInjector<ABCApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ABCApplication> {
    }
}