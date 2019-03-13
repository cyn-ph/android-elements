package com.test.abc.di;

import com.test.abc.ui.main.MainActivity;
import com.test.abc.ui.main.di.MainModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {AndroidSupportInjectionModule.class})
public abstract class AppModule {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();

}
