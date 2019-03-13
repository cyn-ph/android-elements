package com.test.abc.ui.offline

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.test.abc.R
import com.test.abc.beans.FoodDAO
import com.test.abc.ui.main.MainViewModel

class OfflineFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var progress: ProgressBar
    private var viewAdapter = OfflineAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        subscribeToModel(viewModel)
    }

    private fun subscribeToModel(viewModel: MainViewModel) {
        viewModel.offlineFood.observe(this, Observer<List<FoodDAO>> { result ->
            Log.d("OFFLINE", "update list with ${result!!.size}")
            viewAdapter.updateElements(result)
        })

        viewModel.loading.observe(this, Observer<Int> {
            progress.visibility = it!!
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
    }
}