package com.test.abc.di;


import com.test.abc.ABCApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class, AppModule.class})
public interface AppComponent {
    void inject(ABCApplication app);
}