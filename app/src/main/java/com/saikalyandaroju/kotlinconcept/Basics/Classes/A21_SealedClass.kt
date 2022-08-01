package com.saikalyandaroju.kotlinconcept.Basics.Classes

sealed class A21_SealedClass { // same as abstract class but sealed class will restrict inheritance.

    private constructor() { // by default protected.

    }
    //you can use it in when blocks.
}

// usecase :NetworkResponseHandler util class in kotlinNews project.

// sealed classes can only extended in same file.
class B : A21_SealedClass() {

}

sealed class SealedDemo(val code: Int) {
    data class first(val reason: String) : SealedDemo(1)
    object second : SealedDemo(2)

    fun doToDo() {

    }
}

enum class EnumDemo(val code: Int) {

    FIRST(1), SECOND(2);

    fun doEnum() {

    }
}
// both enum and sealed class allows to know their child's at compile time.
// enum stores constants,functions.
// sealed class is like more customized version of enum,like it can have objects,data class,functions,
// abstarct functions.

// sealed class deal with instances,enum deals with constants.
sealed interface SealedInterafaceDemo {
    data class first(val reason: String) : SealedInterafaceDemo

}
// sealed interface is same as sealed class,use interface if you dont have constructor for sealed classs.
