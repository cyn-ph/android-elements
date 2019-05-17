package com.test.abc.ui.tabs.di;

import com.test.abc.ui.tabs.TabsFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {TabsModule.class})
public abstract class TabsAndroidInjector {

    @ContributesAndroidInjector
    abstract TabsFragment contributeWithSearchFragment();

}
