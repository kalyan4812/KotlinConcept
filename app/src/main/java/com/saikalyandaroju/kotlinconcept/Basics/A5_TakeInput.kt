package com.saikalyandaroju.kotlinconcept.Basics


fun main(){

    val input= readLine()
    println(" Your name : ${input?.toUpperCase()}") // null check


    val input2= readLine()

    println("Number entered is : ${input2?.toInt()}")

}