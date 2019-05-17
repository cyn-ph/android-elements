package com.test.abc.ui.search.di;

import com.test.abc.ui.search.SearchFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {

    @Provides
    static SearchFragment providesSearchFragment() {
        return new SearchFragment();
    }

}
