package com.test.abc.ui.offline

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.abc.R
import com.test.abc.data.local.FoodEntity
import com.test.abc.ui.common.BaseRecyclerAdapter
import javax.inject.Inject

class OfflineAdapter
@Inject constructor() : BaseRecyclerAdapter<FoodEntity, OfflineAdapter.RowViewHolder>() {

    override fun createViewHolder(convertView: View): RowViewHolder {
        return RowViewHolder(convertView)
    }

    override fun bindViewHolder(holder: RowViewHolder, item: FoodEntity) {
        holder.foodTitle.text = item.title
        holder.foodCategory.text = item.category
    }

    override fun getLayoutId(): Int {
        return R.layout.offline_item
    }

    class RowViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val foodTitle = row.findViewById<TextView>(R.id.food_title)
        val foodCategory = row.findViewById<TextView>(R.id.food_category)
    }
}