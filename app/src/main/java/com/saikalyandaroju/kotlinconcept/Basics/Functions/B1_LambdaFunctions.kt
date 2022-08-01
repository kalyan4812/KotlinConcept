package com.saikalyandaroju.kotlinconcept.Basics.Functions


fun main() {


    var list = (1..20).toList()
    println(list)
    list = list.filter {
        it % 2 == 0  // filtering even numbers.

    }

    println(list)

    fun add(a: Int, b: Int): Int = a + b

    val lambdaAdd: (a: Int, b: Int) -> Int = { a, b -> a + b } // u can use var.
    //or val lambdaAdd:(Int,Int)->Int={ a,b->a+b}
    // or val add={a:Int,b:Int -> a+b}

    // a,b -input,Int-return type above.


    println(lambdaAdd(2, 4))
    println(lambdaAdd.invoke(2, 3))


    val square: (Int) -> Int = { num: Int -> num * num }

    val shortHandSqaure: (Int) -> Int = { it * it } // only for one param.


    // lambdas for extensions.

    val lambda_ext: String.() -> String = {

        this + "some operation" // last line is considred as return statement.
    }
    println("hi".lambda_ext())


    // lambda for multiple return statements.

    val ageLambda: (Int) -> String = description@{ it ->

        if (it >= 18) {
            return@description "Adult"
        } else {
            return@description "Child"
        }
    }

    println(ageLambda.invoke(5))

    // lambda with pairs.

    val pairLambda: (Pair<String, String>) -> Unit = {
        println("${it.first}    ${it.second}")
    }
    println(pairLambda(Pair("hi", "hello")))
}
// SHIFT+F6 TO RENAME.
