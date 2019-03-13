package com.test.abc.ui.offline

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.test.abc.R
import com.test.abc.data.FoodEntity

class OfflineAdapter : RecyclerView.Adapter<OfflineAdapter.RowViewHolder>() {

    private var offlineItems = emptyList<FoodEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfflineAdapter.RowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.offline_item, parent, false)
        return RowViewHolder(view)
    }

    override fun getItemCount() = offlineItems.size


    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.foodTitle.text = offlineItems.get(position).title
        holder.foodCategory.text = offlineItems.get(position).category
    }

    fun updateElements(newItems: List<FoodEntity>) {
        offlineItems = newItems
        notifyDataSetChanged()
    }

    class RowViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val foodTitle = row.findViewById<TextView>(R.id.food_title)
        val foodCategory = row.findViewById<TextView>(R.id.food_category)
    }


}