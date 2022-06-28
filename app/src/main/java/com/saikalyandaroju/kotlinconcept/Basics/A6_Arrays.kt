package com.saikalyandaroju.kotlinconcept.Basics

import java.util.*


fun main() {

    val arr = arrayOf("a", "b", "c")

    val arr2 = arrayOf("a", "b", 3) // possible but not recommended.

    println(arr) // prints memory adresss of array.

    arr[0] = "d" //you can upadte array values even it is val.

    println(arr[0] + " " + arr[1] + " " + arr.last())

    val arr3 = intArrayOf(5, 1, 2, 3, 4)
    val sum = arr3.sum()
    val max = arr3.maxOrNull()
    println(sum)
    println(max)

    val sortarr = arr3.sortedArray()
    println(Arrays.toString(sortarr))

    val num = arr3.find {
        it % 2 == 0
    } // first num divisible by 2.

    println(num)

    val list=arr3.filter {
        it%2==0
    } // all numbers divible by 2.
    println(list)
}