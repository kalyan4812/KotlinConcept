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


    val newlist = list2.map {
        it * it + 1
    }  // transforming the list.
    println(newlist)


    val oddlist = list2.filterNot {
        it % 2 == 0
    }
    println(oddlist)


    // creating sublist using slice/sublist.
    val sublist = list2.slice(0..3)
    println(sublist)  // it prints 0,1,2,3 position.

    println(list2.subList(0, 3)) // it prints 0,1,2 position and it is mutable.

    println(list2.elementAtOrNull(9)) // if list doesn't have that index ,execution won't stop.

    //------------------------------


    val list3 = mutableListOf<Int>()

    while (list3.size < 5) {
        val x = readLine()?.toInt()

        if (x != null) {
            list3.add(x)
        }

    }

    println(list3)

}