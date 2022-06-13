package com.saikalyandaroju.kotlinconcept.Basics.Classes

sealed class A21_SealedClass { // sealed class to restrict inheritance.

    private constructor() { // by default protected.

    }

}

// sealed classes can only extended in same file.
class B : A21_SealedClass() {

}
