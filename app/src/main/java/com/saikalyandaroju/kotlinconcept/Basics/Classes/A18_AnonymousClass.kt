package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A18_AnonymousClass {
}

abstract class Shapes(var name: String) { // by default params are val.

    init {
        println("Parent class")
    }

    constructor(a: Int, b: Int, name: String) : this(name)

    abstract val id: Int
    abstract fun area(): Double

    abstract fun perimeter(): Double

    fun changeName(newname: String) {
        name = newname
    }
}

fun main() {

    val a = 4.0
    val b = 5.0
    val name = "Square"

    val obj = object : Shape(name) { // object expressions.
        init {

            println("anonymous class created")
            changeName("New "+name)

        }

        override val id: Int
            get() = (a + b).toInt()

        override fun area(): Double {
            return a * a
        }

        override fun perimeter(): Double {
            return 4 * a
        }

    }
    println(obj.name)
}