package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A13_SettersAndGetters {

    var name: String? = null
        // we can customize setter and getter.
        set(value) {
            field = value + "kalyan"
        }
        get() {
            return field
        }

    init {
        name = "Sai "
    }

}

fun main() {

    val obj = A13_SettersAndGetters()
    println(obj.name) // output will  be sai kalyan.

}
/*
   * In kotlin,for every instance variable ,we get setters and getters by default.
   * Internally
       set(value){field =value}
       get(){return field}
   * where field is a inbuilt keyword/backing field/instance variable which have to used in set and get functions.
   * same as this.name ,but you can't use this here.

   * EVery setter and getter has to written below its corresponding instance variable.
 */