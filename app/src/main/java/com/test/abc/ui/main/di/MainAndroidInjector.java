package com.test.abc.ui.main.di;

import com.test.abc.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = MainModule.class)
public abstract class MainAndroidInjector {

    @ContributesAndroidInjector
    abstract MainActivity contributeWithMainActivity();

}
