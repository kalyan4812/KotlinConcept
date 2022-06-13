package com.saikalyandaroju.kotlinconcept.Basics.Functions


fun main() {


    var list = (1..20).toList()
    println(list)
    list = list.filter {
        it % 2 == 0  // filtering even numbers.

    }

    println(list)


    fun add( a:Int, b:Int):Int=a+b

    val lambdaAdd:(a:Int,b:Int)->Int={ a,b->a+b} // u can use var.
    //or val lambdaAdd:(Int,Int)->Int={ a,b->a+b}
    // or val add={a:Int,b:Int -> a+b}


    println(lambdaAdd(2,4))
    println(lambdaAdd.invoke(2,3))
}
// SHIFT+F6 TO RENAME.
