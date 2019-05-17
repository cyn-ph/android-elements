package com.test.abc.ui.tabs

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.test.abc.R
import javax.inject.Inject

class SimplePageAdapter
@Inject constructor(val resources: Resources) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return when (position) {
            0 -> getViewZero(container)
            1 -> resources.getString(R.string.offline)
            else -> throw IllegalStateException("This is not possible")
        }
    }

    private fun getViewZero(container: ViewGroup): View {
        val context = container.context
        val inflater = LayoutInflater.from(context)
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> resources.getString(R.string.search)
            1 -> resources.getString(R.string.offline)
            else -> throw IllegalStateException("This is not possible")
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

//    private View getProfileWiFiListView(ViewGroup container) {
//        Context context = container.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        BetterItemDecorator itemDecorator = new BetterItemDecorator(context,
//            ContextCompat.getColor(context, R.color.black_12));
//        itemDecorator.setDividerInLastPosition(true);
//        itemDecorator.setDividerInFirstPosition(true);
//
//        ProfileWifiListBinding wifiListBinding = ProfileWifiListBinding.inflate(inflater);
//        wifiListBinding.setViewModel(mWiFiListViewModel);
//        wifiListBinding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        wifiListBinding.recyclerView.setHasFixedSize(true);
//        wifiListBinding.recyclerView.addItemDecoration(itemDecorator);
//        wifiListBinding.recyclerView.setAdapter(mWiFiListViewModel.getAdapter());
//        if (!mIsOwner) {
//            wifiListBinding.recyclerView.addOnScrollListener(mEndlessScrollListener);
//        }
//        container.addView(wifiListBinding.getRoot());
//
//        return wifiListBinding.getRoot();
//    }

}