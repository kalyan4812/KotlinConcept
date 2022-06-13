package com.saikalyandaroju.kotlinconcept.Basics.Classes

data class A20_DataClass(val fname: String, val sname: String) {
    var gender: String? = " " // not part of data class.
}

/*
   * data class provides funcionalities like hashcode(),toString(),componentN(),equlas(),copy().
   * Primary construtor needs to have atleast one param,and params should be val/var.
   * data classes cannot be abstract,open,sealed,inner.


 */
fun main(){
    val obj=A20_DataClass("sai","Kalyan")
    println(obj.fname+"  "+obj.sname)

    val obj2=obj.copy("pawan")
    println(obj2.fname+"  "+obj2.sname)


}