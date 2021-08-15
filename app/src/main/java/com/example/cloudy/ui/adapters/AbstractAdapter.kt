package com.example.cloudy.ui.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractAdapter<T>(
    @LayoutRes val layout: Int = LAYOUT_FAIL,
    protected var currentList: MutableList<T> = mutableListOf(),
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var eventsHandler: EventsHandler<T>? = null
    private var recyclerView: RecyclerView? = null

    protected abstract fun onBind(itemView: View, item: T, position: Int)

    companion object {
        private const val LAYOUT_FAIL = -1
    }

    fun addListeners(eventsBlock: EventsHandler<T>.() -> Unit) {
        eventsHandler = EventsHandler<T>().apply { eventsBlock() }
    }

    fun getEventHandler() = eventsHandler

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[holder.bindingAdapterPosition]
        onBind(holder.itemView, item, holder.bindingAdapterPosition)
        eventsHandler?.startListens(position, holder.itemView, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(getItemView(parent)) {}
    }

    fun getItemView(parent: ViewGroup): View {
        if (layout == LAYOUT_FAIL) {
            throw IllegalStateException("Invalid layout file!")
        }
        return LayoutInflater.from(parent.context).inflate(layout, parent, false)
    }

    override fun getItemCount(): Int = currentList.size

    fun getItem(position: Int): T = currentList[position]

    fun getItems(): List<T> = currentList

    fun isEmpty(): Boolean = currentList.isEmpty()

    fun setData(items: List<T>) {
        this.currentList = items.toMutableList()
    }

    fun remove(item: T) {
        val position = currentList.indexOf(item)
        currentList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun remove(position: Int) {
        if (position != -1 && position < currentList.size) {
            currentList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        }
    }

    fun addToEnd(items: List<T>) {
        val size = this.currentList.size
        this.currentList.addAll(items)
        notifyItemRangeInserted(size, this.currentList.size)
    }

    fun submitList(newItems: List<T>, callback: DiffUtil.Callback) {
        val value = DiffUtil.calculateDiff(callback)
        this@AbstractAdapter.setData(newItems)
        value.dispatchUpdatesTo(this)
    }

    protected fun rebindClicks(newList: List<T>, indicesRange: IntProgression) {
        currentList.forEachIndexed { index, item ->
            val newIndex = newList.indexOf(item)
            if (index in indicesRange && newIndex != -1) {
                recyclerView!!.findViewHolderForAdapterPosition(index)?.let { it ->
                    if (it.bindingAdapter == this) {
                        eventsHandler?.startListens(newIndex, it.itemView, item)
                    }
                }
            }
        }
    }

    fun update(items: List<T>) {
        val prevSize = this.currentList.size
        this.currentList = items.toMutableList()
        val size = items.size
        when {
            size in 1 until prevSize -> {
                notifyItemRangeRemoved(size, prevSize - size)
                notifyItemRangeChanged(0, size)
            }
            size > 0 && size > prevSize -> {
                notifyItemRangeChanged(0, prevSize)
                notifyItemRangeInserted(prevSize, size - prevSize)
            }
            size > 0 && size == prevSize -> {
                notifyItemRangeChanged(0, size)
            }
            else -> {
                notifyDataSetChanged()
            }
        }
    }

    fun update(item: T, position: Int) {
        this.currentList[position] = item
        notifyItemChanged(position)
    }

    fun getItemPosition(item: T): Int = currentList.indexOf(item)


    fun clear() {
        update(listOf())
    }

    fun append(item: List<T>) {
        val size = currentList.size
        currentList.addAll(item)
        notifyItemRangeChanged(size, this.itemCount)
    }

    fun append(item: T) {
        currentList.add(item)
        var size = currentList.size
        notifyItemInserted(--size)
    }
}