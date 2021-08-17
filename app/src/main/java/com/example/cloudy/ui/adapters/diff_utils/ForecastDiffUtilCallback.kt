package com.example.cloudy.ui.adapters.diff_utils

import androidx.recyclerview.widget.DiffUtil
import com.example.cloudy.source.api.model.Forecast

class ForecastDiffUtilCallback(
    private val oldItems: List<Forecast>,
    private val newItems: List<Forecast>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].temp == newItems[newItemPosition].temp
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}