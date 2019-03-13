package com.test.abc.ui.main

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.test.abc.R
import com.test.abc.ui.offline.OfflineFragment
import com.test.abc.ui.search.SearchFragment
import javax.inject.Inject

class SimpleFragmentPagerAdapter
@Inject constructor(
    fragmentManager: FragmentManager,
    val searchFragment: SearchFragment,
    val offlineFragment: OfflineFragment,
    val resources: Resources
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return searchFragment
            1 -> return offlineFragment
            else -> throw IllegalStateException("This is not possible")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return resources.getString(R.string.search)
            1 -> return resources.getString(R.string.offline)
            else -> throw IllegalStateException("This is not possible")
        }
    }

    override fun getCount() = 2
}