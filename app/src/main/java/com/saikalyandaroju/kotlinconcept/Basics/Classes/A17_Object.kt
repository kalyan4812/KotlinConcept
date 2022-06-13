package com.saikalyandaroju.kotlinconcept.Basics.Classes

import kotlin.random.Random

object A17_Object {

    val PI = 3.14

    fun demo() {

    }

}


// objects are same as singleton classes,where there will be unquie instance.
// you can't again create instance for above A17_Object.
// to access pi,use A17_Object.pi
// it is the better place to store constants.


// if you want to make some part of class as singleton,use Companion Object.


class Circle {

    companion object { // same as static fun and variables.

        fun randomCricle(): Double {

            val radius = Random.nextDouble(1.0, 10.0) // random number b/w 1 and 10
            println("Radius of circle is ${radius}")
            return A17_Object.PI * radius * radius
        }
    }

}

fun main() {
    println("Area of circle is : ${Circle.randomCricle()}")

    val obj=Circle()
   // obj.randomCircle() ,can't do this.
}