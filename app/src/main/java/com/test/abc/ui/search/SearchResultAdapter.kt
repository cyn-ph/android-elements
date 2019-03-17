package com.test.abc.ui.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.test.abc.R
import com.test.abc.data.remote.Food
import com.test.abc.ui.common.BaseRecyclerAdapter
import com.test.abc.ui.main.MainViewModel
import javax.inject.Inject

class SearchResultAdapter
@Inject constructor(val viewModel: MainViewModel) : BaseRecyclerAdapter<Food, SearchResultAdapter.RowViewHolder>() {

    override fun createViewHolder(convertView: View): SearchResultAdapter.RowViewHolder {
        return RowViewHolder(convertView)
    }

    override fun bindViewHolder(holder: SearchResultAdapter.RowViewHolder, item: Food) {
        holder.foodTitle.text = item.title
        holder.foodBrand.text = item.brand
        holder.foodCategory.text = item.category
        holder.btnSave.setOnClickListener {
            viewModel.saveFood(item)
        }
    }

    @LayoutRes
    override fun getLayoutId(): Int {
        return R.layout.search_item
    }

    class RowViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val foodTitle = row.findViewById<TextView>(R.id.food_title)
        val foodBrand = row.findViewById<TextView>(R.id.food_brand)
        val foodCategory = row.findViewById<TextView>(R.id.food_category)
        val btnSave = row.findViewById<ImageView>(R.id.btn_save)
    }
}