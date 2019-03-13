package com.test.abc.ui.main.di;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.test.abc.ui.main.MainActivity;
import com.test.abc.ui.main.MainViewModel;
import com.test.abc.ui.main.MainViewModelFactory;
import com.test.abc.ui.offline.OfflineFragment;
import com.test.abc.ui.offline.di.OfflineModule;
import com.test.abc.ui.search.SearchFragment;
import com.test.abc.ui.search.di.SearchModule;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {

    @Provides
    static FragmentManager providesFragmentManager(MainActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    static MainViewModel providesMainViewModel(MainActivity activity,
                                               MainViewModelFactory viewModelFactory) {
        return ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel.class);
    }

    @Provides
    static SearchFragment providesSearchFragment() {
        return new SearchFragment();
    }

    @ContributesAndroidInjector(modules = SearchModule.class)
    abstract SearchFragment contributeWithSearchFragment();

    @Provides
    static OfflineFragment providesOfflineFragment() {
        return new OfflineFragment();
    }

    @ContributesAndroidInjector(modules = OfflineModule.class)
    abstract OfflineFragment contributeWithOfflineFragment();
}
