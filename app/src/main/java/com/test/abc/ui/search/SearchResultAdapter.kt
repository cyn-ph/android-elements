package com.test.abc.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.abc.R
import com.test.abc.data.remote.Food
import com.test.abc.ui.main.MainViewModel

class SearchResultAdapter(val viewModel: MainViewModel) : RecyclerView.Adapter<SearchResultAdapter.RowViewHolder>() {

    private var searchResults = emptyList<Food>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultAdapter.RowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return RowViewHolder(view)
    }

    override fun getItemCount() = searchResults.size

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.foodTitle.text = searchResults.get(position).title
        holder.btnSave.setOnClickListener {
            viewModel.saveFood(searchResults.get(position))
        }
    }

    fun updateElements(newItems: List<Food>) {
        searchResults = newItems
        notifyDataSetChanged()
    }

    class RowViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val foodTitle = row.findViewById<TextView>(R.id.food_title)
        val btnSave = row.findViewById<ImageView>(R.id.btn_save)
    }

}