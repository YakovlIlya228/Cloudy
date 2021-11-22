package com.example.cloudy.ui.utils

import android.view.View

object Extensions {

    fun View.gone() {
        visibility = View.GONE
    }

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.invisible() {
        visibility = View.INVISIBLE
    }


    fun gone(vararg views: View) {
        views.forEach {
            it.gone()
        }
    }

    fun visible(vararg views: View) {
        views.forEach {
            it.visible()
        }
    }
}