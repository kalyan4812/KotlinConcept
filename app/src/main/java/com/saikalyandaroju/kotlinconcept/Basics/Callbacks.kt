package com.saikalyandaroju.kotlinconcept.Basics

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main() {

    val editText: EditText? = null

    editText?.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(p0: Editable?) {
            TODO("Not yet implemented")
        }

    })
    GlobalScope.launch {
        val d = editTextListener(editText!!)

    }
    // converting callbacks to suspend functions.

}

suspend fun editTextListener(editText: EditText): String {

    return suspendCoroutine {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable) {
                it.resume(p0.toString())
            }

        })
    }
}