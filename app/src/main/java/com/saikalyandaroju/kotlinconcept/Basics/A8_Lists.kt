package com.saikalyandaroju.kotlinconcept.Basics


fun main() {


    val arr = arrayOf(1, 2, 3)

    val list = listOf(1, 2, 3)

    arr[0] = 3 // possible array is mutable.

    // list[0]=9 not possible ,since list is immutable.

    val list2 = mutableListOf(1, 2, 3)

    list2[0] = 9 // possible for mutable list.

    // differnce b/w mutable list and array is mutable list can be expandable.

    list2.add(12)

    println(list2) // [9, 2, 3, 12]

    //------------------------------


    val list3 = mutableListOf<Int>()

    while (list3.size<5) {
        val x = readLine()?.toInt()

        if (x != null) {
            list3.add(x)
        }

    }

    println(list3)

}