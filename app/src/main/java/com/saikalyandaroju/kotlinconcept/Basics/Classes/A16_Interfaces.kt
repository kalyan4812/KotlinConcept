package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A16_Interfaces {
}

interface Climber {

    val climberOf: String

    fun climb()
}

class Tiger(override val climberOf: String) : Climber {
    override fun climb() {
        TODO("Not yet implemented")
    }

}