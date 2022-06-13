package com.saikalyandaroju.kotlinconcept.Basics


fun main(){

    val arr= arrayOf("a","b","c")

    val arr2= arrayOf("a","b",3) // possible but not recommended.

    println(arr) // prints memory adresss of array.


    println(arr[0]+" "+arr[1])
}