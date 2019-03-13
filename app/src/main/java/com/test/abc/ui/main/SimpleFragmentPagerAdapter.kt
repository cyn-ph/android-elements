package com.test.abc.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.test.abc.ui.offline.OfflineFragment
import com.test.abc.ui.search.SearchFragment

class SimpleFragmentPagerAdapter(fragmentManager: FragmentManager) :
    androidx.fragment.app.FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return SearchFragment()
            1 -> return OfflineFragment()
            else -> throw RuntimeException("This is not possible")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Search"
            1 -> return "Offline"
            else -> return ""
        }
    }

    override fun getCount() = 2
}