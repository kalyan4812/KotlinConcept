package com.saikalyandaroju.kotlinconcept.Basics

import androidx.core.util.rangeTo


fun main() {

    val arr = arrayOf("a", "b", "c")


    //-------------while loop----------------------------------------------


    val len = arr.size

    var x = 0

    while (x < len) {
        println(arr[x])
        x++
    }

    //-------------------------for loop-------------------------------------------


    for (i in arr) {
        println(i)
    }

    for (i in 1..10) {    // 1 2 3 4 5 6 7 8 9 10
        print("$i ")
    }

    println()
    for (i in 1.rangeTo(10)) {  // 1 2 3 4 5 6 7 8 9 10
        print("$i ")
    }
    println()
    for (i in 10 downTo 1) {        // 10 9 8 7 6 5 4 3 2 1
        print("$i ")
    }

    println()

    for (i in 1..10 step 3) {    // 1 4 7 10
        print("$i ")
    }

    println()
    for (i in 10 downTo 1 step 3) { // 10 7 4 1
        print("$i ")
    }

    println()

    for (i in 1 until 10) {    // 1 2 3 4 5 6 7 8 9  exclude 10
        print("$i ")
    }

    println()

    for (i in 'a'..'z') {    // a b c d e f g h i j k l m n o p q r s t u v w x y z
        print("$i ")
    }



}