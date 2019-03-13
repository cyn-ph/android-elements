package com.test.abc.ui.search.di;

import com.test.abc.ui.main.MainViewModel;
import com.test.abc.ui.search.SearchResultAdapter;
import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {

    @Provides
    static SearchResultAdapter providesSearchResultAdapter(MainViewModel viewModel) {
        return new SearchResultAdapter(viewModel);
    }


}
