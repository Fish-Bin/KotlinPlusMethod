package com.fish.classify.listener

import android.view.View

abstract class DoubleClickListener : View.OnClickListener {

    override fun onClick(v: View) {
        if (enabled) {
            enabled = false
            v.post(ENABLE_AGAIN)
            doClick(v)
        }
    }

    abstract fun doClick(v: View)

    companion object {
        internal var enabled = true
        private val ENABLE_AGAIN = Runnable { enabled = true }
    }
}
