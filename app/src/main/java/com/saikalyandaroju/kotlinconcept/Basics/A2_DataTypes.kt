package com.saikalyandaroju.kotlinconcept.Basics


fun main() {

    var x: Int = 5     // var keyword means variale is mutable.
    var y = 5  // no need to mention int explicitly.
    x = 20  // since it is a var we can change it.

    println("${x}" + " ${y}")

    var a = 10.0 // by default decimal is double in kotlin.
    var b = 10.0f // float.
    var d = a.toFloat()

    println("${a}" + " ${b}" + " ${d}")


    var p = "10.0"
    var q = p.toFloat()


    println("${q}")

    // q=null we can't do this,since both var ,val are not nullable by default.
    // to do that.

    var f: Int? = 10 //? means nullable.
    f = null


    var c: String? = "abcd"
    //  var len=c.length - kotlin won't allow this,since c may be null so we have to put a check.
    var len = (c?.length) ?: ("zero length")   // ?: if else type operator=elvis operator.
    println("${len}") // if incase c is null ,it will print len as null.


    var len2 = c!!.length

    println("${len2}") // use this assertion only if you are sure that variable is not null ,otherwise null pointer exception/compile time error.

//--------------------------------------------------------------------------------------------------


    val i = 10 // val keyword means variable is immutable.
    //i=20  you can't do this.
    println(i)
    println("The value of i is : $i")


    var g = null
    // var h=g as Int - null pointer exception.
    var h = g as? Int  // safe cast operator.
    println(h)

    var m = true
    m = false


    var r=20f
    var s=8  // float-4bytes,double-8 bytes and accurate.

    println("The value of r/s is : ${r/s}")


    var v="sai kalyan"
    println(v.toUpperCase())

    //-------------------------------------------------------------------------------------------------
}