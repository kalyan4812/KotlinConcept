package com.saikalyandaroju.kotlinconcept.Basics.ExceptionHandling

import java.lang.Exception

fun main() {
    val input = try {
        readLine()?.toInt()
    } catch (e: Exception) {
        println(e.printStackTrace())
        0
    } finally {
        println("Try catch executed")

    }
    println("Number entered is : ${input}")
}

class DivisonException : Exception("Division by zero exception") {

}

fun divide(a: Double, b: Double): Double {
    if (b == 0.0) {
        throw DivisonException()
    }
    return a / b
}