package com.bin.fish.plusmethod

import android.view.View
import com.fish.classify.listener.DoubleClickListener

/**
 * 添加onClick防抖动监听
 */
fun <T : View> T.dOnClick(action: T.() -> Unit) {
    this.setOnClickListener(object : DoubleClickListener() {
        override fun doClick(v: View) {
            action(this@dOnClick)
        }
    })
}

/**
 * 给集合类型的view统一添加防抖动监听
 */
fun <T : List<View>> T.dOnClick(action: Int.() -> Unit) {
    this.mapIndexed { index, v ->
        v.setOnClickListener(object : DoubleClickListener() {
            override fun doClick(v: View) {
                action(index)
            }
        })
    }
}

/**
 * 给点击事件加过滤条件
 * 如果filter 返回ture 则执行，否则不执行
 */
fun <T : View> T.dOnClick(filter: () -> Boolean, action: T.() -> Unit) {
    if (filter()) {
        this.setOnClickListener(object : DoubleClickListener() {
            override fun doClick(v: View) {
                action(this@dOnClick)
            }
        })
    }
}

/**
 * 多用于给when语句添加注释
 */
infix fun <T : Any?> T.means(tip: String): T {
    return this
}


/**
 * 注释一个方法
 */
fun empty(tip: String = "", undo: () -> Unit) {}


/**
 * 用传的参数过滤后在操作
 */
fun <T, F> T.filterLet(filter: (it: T) -> Boolean, block: (it: T) -> F): F? {
    return if (filter(this)) {
        block(this)
    } else null
}

/**
 * 为Triple 添加方式(仿照Pair)
 */
infix fun <A, B, C> Pair<A, B>.too(that: C): Triple<A, B, C> = Triple(this.first, this.second, that)




