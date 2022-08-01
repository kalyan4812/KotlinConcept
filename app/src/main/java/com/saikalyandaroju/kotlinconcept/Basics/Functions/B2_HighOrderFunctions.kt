package com.saikalyandaroju.kotlinconcept.Basics.Functions

fun main() {

    // takes function as parameter and returns Function.


    val add = doAddition()
    println(add(2, 3)) // now add is converted to a function.

    printMsg {


    }

    // passing lambda as argument.
    //1st way
    println(lambdaArgFun("tOdo", lambda_ext))

    //2nd way
    lambdaArgFun("tOdo", { this + "some operation" })

    // 3rd way=Trailing lambda syntax.
    lambdaArgFun("todo") {
        this + "some operation"
    }


    // SAM-(SINGLE ACESS METHOD ) CONVERSION USING LAMBDA.

    // sam = interface with single abtract function.



}

fun lambdaArgFun(text: String, lambda: String.() -> String): String {
    return text.lambda()
}

val lambda_ext: String.() -> String = {

    this + "some operation" // last line is considred as return statement.
}

fun doAddition(): (Int, Int) -> Int { // returning a lambda fun.
    return ::addNum
}

fun addNum(a: Int, b: Int): Int {
    return a.plus(b)
}

fun printMsg(print: (String) -> Unit) {

}