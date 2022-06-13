package com.saikalyandaroju.kotlinconcept.Basics



fun main(){

    val a=5
    val b=5
    println(a==b) // !=,>,<


    var bool=true
    var x=9
    var y=3
    var z=9

    val res=!(x!=z) && bool || z>(x+y) && (!bool || y<z) // first and opeartor will be calculated then or.
    println(res)

}
