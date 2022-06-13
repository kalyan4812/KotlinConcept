package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A11_Execution {


    var fname: String? = null
    var sname: String? = null

    constructor() {
        println("Primary constructor")
    }

    constructor(
        fname: String,
        sname: String
    ) : this() { // invoking primary from secondary constructor.

        println("Secondary constrcutor")
        this.fname = fname
        this.sname = sname
    }

    init {
        println("First init")
    }

    init {

        println("Second init")
    }

    fun randomFun() {
        println("Full name is : ${fname + sname}")
    }

}

fun main() {
    val obj = A11_Execution("Sai", " Kalyan")
    obj.randomFun()
}

// * execution order init block>primary constructor>secondary constructor.

// if in the above example if you doesn't intialize  fname,sname as null ,you will get compile time error:property must be intialized or abstract.