package com.saikalyandaroju.kotlinconcept.Basics.Classes


class A23_ValueClass private constructor(val timeperiod: Long) {
    companion object {

        fun millis(millis: Long) = A23_ValueClass(millis)
        fun seconds(sec: Long) = A23_ValueClass(sec * 1000)
    }


}

fun main() {

    val obj = A23_ValueClass.millis(2000)
    println(obj.hashCode())
    println(obj.timeperiod)

    val obj2 = A23_ValueClass.seconds(2)
    println(obj2.hashCode())
    println(obj2.timeperiod)

}

// by using value class,object creation is only done once.
// Jvminline treats objects as primitives.