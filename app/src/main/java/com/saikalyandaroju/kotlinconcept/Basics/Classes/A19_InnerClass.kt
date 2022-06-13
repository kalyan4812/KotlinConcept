package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A19_InnerClass {
}

class Person(val name: String, val address: Address?) {


    inner class Address(val locality: String, val city: String) {
        fun displayAddresss() {
            println("Name is $name Locality is $locality   ,   city is $city")
        }
    }
    // to access outer class variables inside a nest class,nest class should be inner.

}

fun main() {

    val person = Person("Kalyan", null)
    val ad = person.Address("DVK", "Nalgonda")
    person.address?.displayAddresss()
}

// nest class extend an interface.
// we can nest class in a interface,interface in a class.