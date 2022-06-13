package com.saikalyandaroju.kotlinconcept.Basics


fun main() {

    var x: Int?

    var a = 10
    var b = 20

    if (a > b) {
        x = a
    } else {
        x = b
    }
    println("max value is $x")

    //----------------------------------------------------------------------------------------------

    // when=switch in java
    var p = 1
    var value: String
    value = when (p) {
        0 -> "zero"
        1 -> "one"
        else -> "default"
    }

    println(value)


    value = when (p) {
        0, 1, 2 -> "range is 0 to 2"
        3 -> "three"
        else -> "default"
    }

    println(value)

    value = when (p) {
        in 0..5 -> "range is 0 to 5"
        6 -> "three"
        else -> "default"
    }

    println(value)

    val d = 5
    value = when (p) {
        p -> "$p"
        3 -> if (d == 5) {
            "three"
        } else {
            "no"
        }
        else -> "default"
    }

    println(value)


    val age =18

    when(age){

        in 0..17->{
            println("hey")
            println("you are not an adult")
        }

        else ->
            println("you are an adult.")

    }


}