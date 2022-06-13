package com.saikalyandaroju.kotlinconcept.Basics


fun main() {


    val x = 2
    val y = 3

    println(printPower(x, y)) //8


    defaultArgument("hello", "hiiiii")
    defaultArgument(y = "hiiiiii")

    println(
        varArgFun(
            1,
            2,
            4,
            8,
            z = 9
        )
    ) // to differniate b/w vararg and normal paramter we have to mention z.
    // you can also pass array as parameterin vararg parameter.


    val arr = intArrayOf(1, 2, 3, 6, 8, 10)
    println(
        varArgFun(
            *arr,
            z = 9
        )
    )


    println(isMinor(17)) // true.
    println(isMinorOther(19)) // false.

    val d = 7
    println(d.isPrime())  // extension functions. //true

    val e = 4
    println(e.isPrime()) //false
}


fun printPower(
    base: Int,
    expo: Int
): Long { // parameters are treated as val,so they can't be reassigned.

    return Math.pow(base.toDouble(), expo.toDouble()).toLong()
}

// for reassigning

fun demo(x: Int): Int {
    var z = x
    z += 5
    return z
}

fun defaultArgument(x: String = "default value", y: String) {
    println("$x   $y")
}

fun demoList(list: List<Int>) {
    println(list[0])
}


fun varArgFun(vararg i: Int, z: Int): Int {

    var max = i[0]

    for (y in i) {
        max = Math.max(y, max)
    }

    return Math.max(max, z)

}


fun isMinor(age: Int): Boolean {
    if (age?.compareTo(18)!! < 0) {
        return true
    }
    return false
}


fun isMinorOther(age: Int): Boolean = age?.compareTo(18)!! < 0  // expressive functions.


// function overloading.
fun demoFun(): Int {
    return 1
}

fun demoFun(x: String): String {
    return "a"
}

//---------------------------------------- extension functions

fun Int.isPrime(): Boolean {

    for (i in 2 until this - 1) {
        if (this % i == 0) {
            return false
        }
    }
    return true
}

//extension functions are useful,when u use third party libraries,and you want to add more functionality to it.

class C {
    fun demo() {
        println("C")
    }
}

fun C.demo() {
    println("C extension ")
}

// val c=C(), c.demo() ----> gives output as C. so always member functions>extension function.


class Radio(val freq: String) { // extension reciever.
    fun play() {
        println("Playing audio with frequency : $freq")
    }
}

class Car(val name: String, val radio: Radio) { // extension dipatcher.
    fun printName() {
        println(name)
    }

    fun Radio.audioDetails() { // extension function.
        printName()
        print(":")
        radio.play()
    }

    fun showCarDetails() {
        radio.audioDetails()
    }
}

// val c=Car(),c.showCarDetails().




