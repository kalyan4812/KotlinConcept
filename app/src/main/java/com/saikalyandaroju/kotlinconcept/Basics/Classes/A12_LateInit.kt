package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A12_LateInit {
    lateinit var fname: String // lateinit can't be nullable.
    lateinit var sname: String

    // if it is a val variable,it should be not reassigned+must be intialized.
    // you can intialize in primary constructor.
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

    fun randomFun2() {
        if (this::fname.isInitialized && this::sname.isInitialized) { // double reference operator.
            println("Full name is : ${fname + sname}")
        } else {
            println("Properties are not intialized ")
        }
    }

}

fun main() {
    val obj = A12_LateInit("Sai", " Kalyan")
    obj.randomFun()

    val obj2 = A12_LateInit()
    // obj2.randomFun()   ----> unintialized property exception.
    obj2.randomFun2()

    obj.fname = "Pawan"
    obj.randomFun2()

    /*
      ****note****

      * you can't do obj/obj2=A12_LateInit(),since it is a val.
      *but you can do obj.fname="ram",instance variables can be reassigned.
     */

    val obj3 = lazy { A12_LateInit("sai", "ram") }
    // obj3 will be allocated memory only when we use it.

    println(obj3.value.randomFun())

}