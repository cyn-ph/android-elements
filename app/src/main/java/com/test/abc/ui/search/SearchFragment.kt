package com.test.abc.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.abc.R
import com.test.abc.data.remote.Food
import com.test.abc.ui.main.MainViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class SearchFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainViewModel
    @Inject
    lateinit var viewAdapter: SearchResultAdapter

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
        viewModel.searchResult.observe(this, Observer<List<Food>> { result ->
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

        val searchEdit = view.findViewById<EditText>(R.id.edit_search)

        val searchButton = view.findViewById<ImageView>(R.id.btn_search)
        searchButton.setOnClickListener {
            viewModel.searchFood(searchEdit.text.toString())
        }

        view.findViewById<RecyclerView>(R.id.search_result).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = viewAdapter
        }

    }

}