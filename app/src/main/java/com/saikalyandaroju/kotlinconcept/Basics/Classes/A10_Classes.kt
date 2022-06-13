package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A10_Classes {
    val a: Double = 1.0

    val b: Double = 2.0

    init {

        println("Area of rectangle is ${a * b}")
    }

    fun perimeter() {
        println("Perimeter of rectangle is ${2 * (a + b)}")
    }
}

fun main() {
    val obj = A10_Classes()
    obj.perimeter()
}

/*
class Rectangle {
    val a: Double = 1.0

    val b: Double = 2.0


}

class Rectangle {
    val a: Double

    val b: Double

    constructor(a: Double, b: Double) {
        this.a = a
        this.b = b
    }


}


class Rectangle(a: Double, b: Double) {
    var len = a
    var bd = b
}

class Rectangle(a: Double, b: Double) {
    var len: Double
    var bd: Double

    init {
        len = a
        bd = b
    }


}


 */

/*
   * execution order init block>primary constructor>secondary constructor.
   * by default ,default constructor is made avaialble by kotlin,if incase it doesn't contain any constrcutor with params.
   *

 */