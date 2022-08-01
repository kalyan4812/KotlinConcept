package com.saikalyandaroju.kotlinconcept.Basics.State

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavingViewModelState(private val savedStateHandle: SavedStateHandle) : ViewModel() {


    private var counter: Int = savedStateHandle.get("count") ?: 0

    fun incrementCount() {
        counter++
        savedStateHandle.set("count", counter)
    }


}

/*
   Android process death -some times when there is memory shortage ,android system kills the background apps
   ,some times may be foreground apps.

   so during those times we will loose the state of viewmodel.

   to restore the state we use save state handle,and make sure to put the state right after updating ,
   dont save state in onCleared(),beacuse oncleared wont be called on process death.
 */