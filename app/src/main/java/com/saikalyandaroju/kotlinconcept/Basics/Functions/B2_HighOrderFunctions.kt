package com.saikalyandaroju.kotlinconcept.Basics.Functions

fun main() {

    // takes function as parameter and returns Function.


    val add = doAddition()
    println(add(2, 3)) // now add is converted to a function.

    printMsg {


    }


}


fun doAddition(): (Int, Int) -> Int { // returning a lambda fun.
    return ::addNum
}

fun addNum(a: Int, b: Int): Int {
    return a.plus(b)
}

fun printMsg(print: (String) -> Unit) {

}