package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A15_AbstractClasses {
}

abstract class Shape(var name: String) { // by default params are val.

    init {
        println("Parent class")
    }

    abstract val id: Int
    abstract fun area(): Double

    abstract fun perimeter(): Double

    fun changeName(newname: String) {
        name = newname
    }
}

class Square(val a: Double, val b: Double) : Shape("Square") {

    override val id: Int
        get() = a.toInt()


    // constructor overloading
    constructor(a: Double) : this(a, a)

    constructor(a: Int) : this(a.toDouble(), a.toDouble())

    constructor(a: Int, b: Int) : this(a.toDouble(), b.toDouble())

    // you can overload functions also.

    override fun area(): Double {
        return a * a
    }

    override fun perimeter(): Double {
        return 4 * a
    }

}

abstract class Triangle(override val id: Int) : Shape("Triangle") {

}

abstract class Cyclinder : Triangle(123) {

}

fun main() {
    val obj = Square(4.0, 4.0)
    println(obj.area())
}
/*
  * abstract classes can't be instantiated.
  *
 */


//abstract(not complete)-applicable for methods,classes.
//abstract method-only declaration no implementation.
//if a class contains at least one abstract method ,class should be abstract because if its not abstract if anyone tries to call
//abstract method there is no implementation.
// abstract class have both abstract and non abstract methods.
// child class has to provide implementation for abstract methods of parent abstract class.other wise you have to make child class
// also abstract.