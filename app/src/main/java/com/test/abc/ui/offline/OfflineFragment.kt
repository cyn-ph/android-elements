package com.test.abc.ui.offline

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.abc.R
import com.test.abc.data.local.FoodEntity
import com.test.abc.ui.main.MainViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class OfflineFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainViewModel
    @Inject
    lateinit var viewAdapter: OfflineAdapter

    private lateinit var progress: ProgressBar

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToModel(viewModel)
    }

    private fun subscribeToModel(viewModel: MainViewModel) {
        viewModel.offlineFood.observe(this, Observer<List<FoodEntity>> { result ->
            viewAdapter.resetItemListWithAnimation(result)
        })

        viewModel.loading.observe(this, Observer<Int> { loading ->
            progress.visibility = loading!!
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_offline, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress = view.findViewById(R.id.progress)

        view.findViewById<RecyclerView>(R.id.offline_items).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = viewAdapter
        }

        viewModel.getAllSavedFood()
    }
}