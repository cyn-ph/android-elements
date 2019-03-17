package com.test.abc.ui.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerAdapter<S, T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {

    private var itemList = mutableListOf<S>()

    private fun add(item: S) {
        itemList.add(item)
    }

    private fun addWithAnimation(item: S) {
        add(item)
        // Calculate the index based on the size of the itemList
        notifyItemInserted(itemList.size + 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        return createViewHolder(LayoutInflater.from(parent.context).inflate(getLayoutId(), parent, false))
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        bindViewHolder(holder, itemList.get(position))
    }

    override fun getItemCount() = itemList.size

    fun updateItemList(newItemList: List<S>) {
        itemList = newItemList.toMutableList()
        notifyDataSetChanged()
    }

    fun resetItemListWithAnimation(newItemList: List<S>) {
        updateItemList(emptyList())
        updateItemListWithAnimation(newItemList)
    }

    fun appendItemList(newItemList: List<S>) {
        if (!itemList.isEmpty()) {
            updateItemListWithAnimation(newItemList)
        } else {
            resetItemListWithAnimation(newItemList)
        }
    }

    fun updateItemListWithAnimation(newItemList: List<S>) {
        for (item in newItemList) {
            addWithAnimation(item)
        }
    }

    protected abstract fun createViewHolder(convertView: View): T

    protected abstract fun bindViewHolder(holder: T, item: S)

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}