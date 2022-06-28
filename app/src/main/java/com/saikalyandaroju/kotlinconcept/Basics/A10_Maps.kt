package com.saikalyandaroju.kotlinconcept.Basics

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {


    val mapper = mapOf<String, Int>("a" to 1, "b" to 2, "c" to 3)

    println(mapper["a"])
    println(mapper)
    println(mapper.count())
    println(mapper.count {
        it.value >= 2
    })

    val newmap = mutableMapOf<String, Int>("d" to 100, "b" to 200)
    newmap.put("c", 300)

    println(newmap.filter {
        it.value >= 200
    })

    println(newmap.toSortedMap()) // sort based on key

    println(newmap.getOrDefault("e", -1))

    println(newmap.keys)
    println(newmap.values)


    // sort based on values in descending order.
    println(newmap.toSortedMap(object : Comparator<String> {
        override fun compare(p0: String?, p1: String?): Int {
            return newmap.get(p1)?.compareTo(newmap.get(p0)!!)!!
        }


    }))
}