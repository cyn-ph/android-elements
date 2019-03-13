package com.test.abc.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.abc.R
import com.test.abc.beans.Food
import com.test.abc.ui.main.MainViewModel


class SearchFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var progress: ProgressBar
    private lateinit var viewAdapter: SearchResultAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModel.init(context!!.applicationContext)

        viewAdapter = SearchResultAdapter(viewModel)

        subscribeToModel(viewModel)
    }

    private fun subscribeToModel(viewModel: MainViewModel) {
        viewModel.searchResult.observe(this, Observer<List<Food>> { result ->
            Log.d("SEARCH", "update list with ${result!!.size}")
            viewAdapter.updateElements(result)
        })

        viewModel.loading.observe(this, Observer<Int> {
            progress.visibility = it!!
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress = view.findViewById(R.id.progress)

        val editText = view.findViewById<EditText>(R.id.edit_search)

        val button = view.findViewById<Button>(R.id.btn_search)
        button.setOnClickListener {
            Log.d("SEARCH", "btn search on click")
            viewModel.searchFood(editText.text.toString())
        }

        view.findViewById<RecyclerView>(R.id.search_result).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = viewAdapter
        }

    }

}