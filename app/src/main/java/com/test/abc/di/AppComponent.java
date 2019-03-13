package com.test.abc.di;


import com.test.abc.ABCApplication;
import dagger.Component;
import dagger.android.AndroidInjector;

import javax.inject.Singleton;

@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<ABCApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ABCApplication> {
    }
}