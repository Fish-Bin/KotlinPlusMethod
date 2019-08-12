# KotlinPlusMethod
  版本信息说明,见：[version.md](https://github.com/Fish-Bin/KotlinPlusMethod/blob/master/version.md)  
  利用kotlin的灵活性,封装一些常用的拓展方法,便于使用,后续会根据需要不断增加此方法库  
# 一、引入依赖
  在项目build.gradle中添加依赖：
  ```
  compile 'com.fish.bin:kotlin-plus-method:1.0.0'
 ```
# 二、拓展方法介绍
## 1.想注释一段代码？
  ```
 fun empty(tip: String = "", undo: () -> Unit) {}
  ```
 使用方法：
 ```
 empty("隐藏这一段") {
           ...代码块
        }
 ```
 ## 2.想给多条件的分支方法加注释
 ```
infix fun <T : Any?> T.means(tip: String): T {
    return this
}
 ```
 使用方法：
 ```
val a: Int = 0
        when (a) {
            1 means "第一种情况" -> {
            }
            2 means "第二种情况" -> {
            }
            3 means "第三种情况" -> {
            }
        }
 ```
 
 ## 3.给view添加防抖
 ```
fun <T : View> T.dOnClick(action: T.() -> Unit) {
    this.setOnClickListener(object : DoubleClickListener() {
        override fun doClick(v: View) {
            action(this@dOnClick)
        }
    })
}
 ```
 使用方法：
 ```
 v.dOnClick{}
 ```
 ## 4.给多个方法添加防抖
 ```
 fun <T : List<View>> T.dOnClick(action: Int.() -> Unit) {
    this.mapIndexed { index, v ->
        v.setOnClickListener(object : DoubleClickListener() {
            override fun doClick(v: View) {
                action(index)
            }
        })
    }
}
 ```
 使用方法：
 ```
  listOf(tv1, tv2).dOnClick {
                when (this) {
                    0 -> 1 to "点击" means "one"
                    1 -> 2 means "two" to "点击"
                    else -> 0 to ""
                }.let {
                    L.i(it.second + it.first)
                }
            }
 ```
 ## 5.给方法添加一个过滤方法
 ```
 fun <T, F> T.filterLet(filter: (it: T) -> Boolean, block: (it: T) -> F): F? {
    return if (filter(this)) {
        block(this)
    } else null
}
```
使用方法：
```
 val datas = listOf(1, "a", true)
        datas.filterLet({ it.size > 2 }) {
             ...
        }
```

   

  
