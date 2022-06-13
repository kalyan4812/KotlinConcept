package com.saikalyandaroju.kotlinconcept.Basics.Classes

open class A14_Inheritance(var name: String) { // we can make constructor params private.
    private val a = 5

    init {
        println("Parent class")
    }

    fun changeName(newname: String) {
        name = newname
    }

    open fun demo() {
        println("parent demo")
    }
}

class Child : A14_Inheritance("Child class") {

    init {
        println(name) // you can access parent variables.
    }

    fun childMethod() {
        println("Child method")
    }

    override fun demo() {
        println("child demo")
    }

}

fun main() {
    val parent = A14_Inheritance("Parent")
    parent.demo()
    parent.changeName("New parent")
    println(parent.name)

    val child = Child()
    child.demo() // child class demo will be called,since it is overrided.
    println(child.name)
    child.childMethod()
    child.changeName("New child") // you can access parent methods,variables.
    println(child.name)
    //   child.a ,can't access a ,since it is private in parent.


    val obj: A14_Inheritance = Child()
    // parent reference can be used to hold child object(polymorphism concept),but can't call child methods.
    obj.demo()

    // child reference can't be used to hold parent object.
}

/*

   * In kotlin,by default every class is sealed ,i.e is final in java.
   * SO make classes open,which you want to inherit.
   * And also to override a parent method in child class, parent method should be open.
 */

// By default classes are public.

// public -global level,can be accessed anywhere.if member of a class is public but if class is not public there is no use.
// Default-within current package.
//private-class level
// recommended modifier for variables is private,for methods is public.
//protected-within package,outside package only within child classes and only with child class reference.
// Internal modifier-visible in same module.

class Demo private constructor(){
    // we can only make demo objects ,inside demo class only.
}