package com.example.cloudy.ui.adapters


import android.view.*

/**
 * Default state listener
 */
open class EventsHandler<T> {
    private var onClick: ((T, Int) -> Unit) = { _, _ -> }
    private var onLongClick: ((T, Int) -> Unit) = { _, _ -> }


    // Target view id, Position, Item
    private var onClickHandlers: Array<out Pair<Int, (Int, T) -> Unit>> = emptyArray()

    fun onClickItemById(vararg handlers: Pair<Int, (Int, T) -> Unit>) {
        onClickHandlers = handlers
    }

    fun onClickItem(handler: (T, Int) -> Unit) {
        onClick = handler
    }

    fun onLongClickItem(handler: (T, Int) -> Unit) {
        onLongClick = handler
    }


    fun startListens(
        position: Int,
        view: View,
        item: T,
    ) {
        with(view) {
            for ((id, onClickFunction) in onClickHandlers) {
                val v: View = view.findViewById(id)
                v.setOnClickListener {
                    onClickFunction.invoke(position, item)
                }
            }
            setOnClickListener {
                onClick.invoke(item, position)
            }
            run {
                setOnLongClickListener {
                    onLongClick.invoke(item, position)
                    return@setOnLongClickListener true
                }
            }

        }
    }
}