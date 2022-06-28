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
