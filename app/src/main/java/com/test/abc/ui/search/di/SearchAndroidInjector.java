package com.test.abc.ui.search.di;

import com.test.abc.ui.search.SearchFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {SearchModule.class})
public abstract class SearchAndroidInjector {

    @ContributesAndroidInjector
    abstract SearchFragment contributeWithSearchFragment();

}
