package com.saikalyandaroju.kotlinconcept.Basics

fun main() {

    val set = mutableSetOf<String>("kalyan", "kalyan") // unique values will be stored.
    println(set)
    // same methods for list will be applicable.

    val set2= mutableSetOf<String>("a","kalyan","c")

    println(set.union(set2))

    println(set intersect  set2)


}