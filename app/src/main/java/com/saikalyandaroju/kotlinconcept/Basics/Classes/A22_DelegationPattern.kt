package com.saikalyandaroju.kotlinconcept.Basics.Classes

class A22_DelegationPattern {
}

interface Engine{
    fun runsOn()
}

class ElectricEngine:Engine{
    override fun runsOn() {
    println("Runs on electricity")
    }

}

/*class TeslaEngine(val eng:Engine){
  fun runsOn(){
      eng.runsOn()
  }
}*/

class TeslaEngine(val eng:Engine):Engine by eng  // delegate pattern.

fun main(){
    val obj=TeslaEngine(ElectricEngine())
    obj.runsOn()



}