package com.saikalyandaroju.kotlinconcept.Couroutines

class A1_Demo {
}

// function -sequence of instructions that takes an input,gives an output.

// thread- defines how those/in which context those instructions should be exceuted.

//------------------------ couroutines vs threads.

/*
   * they are executed within the thread.
   * they can be suspended ,i.e they can be paused in middle,which is not possible with threads.
   * they can switch their context,i.e they can move from one thread to other.
   * they are light wieght threads.
   * every couroutine has scope.(in that span only they will be live)
 */