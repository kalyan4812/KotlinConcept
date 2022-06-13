package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A24_InlineClass {
}

inline class width(val wd: Long)

inline class Height(val hg: Long)

class Rectangle(val wd: width, val hg: Height) {
    fun printSpec() {
        println("width is ${wd}   height is ${hg}")
    }
}

fun main() {

    val wd = width(100L)
    val hg = Height(100L)
    val shape = Rectangle(wd, hg)
    shape.printSpec()
}
// subset of value class.
//to create wrapper to primitive type.