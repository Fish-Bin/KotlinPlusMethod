package com.bin.fish.kotlinplusmethod

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bin.fish.plusmethod.dOnClick
import com.bin.fish.plusmethod.empty
import com.bin.fish.plusmethod.means
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        empty("隐藏这一段") {
            listOf(tv1, tv2).dOnClick {
                when (this) {
                    0 -> 1 to "点击" means "one"
                    1 -> 2 means "two" to "点击"
                    else -> 0 to ""
                }.let {
                    L.i(it.second + it.first)
                }
            }
        }
    }
}
