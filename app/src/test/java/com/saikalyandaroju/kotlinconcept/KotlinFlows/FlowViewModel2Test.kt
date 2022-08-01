package com.saikalyandaroju.kotlinconcept.KotlinFlows

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.saikalyandaroju.kotlinconcept.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FlowViewModel2Test {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule =
        MainCoroutineRule() // since we are in unit test folder not in android test +
    //below functions use couroutine scope to run and they relay on MainLoopDispatcher and since
    // don't have access to it here,we can to define our own junit rule.

    private lateinit var flowViewModel: FlowViewModel2

    @Before
    fun setUp() {
        flowViewModel = FlowViewModel2()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_fun_squareNumber() = runBlocking {
        // we are using launch scope we want job to run independently w.r.t flowviemodel.sqaurenumber.
        val job=launch {
            flowViewModel.shared_flow.test {
                val emitted_value=awaitItem()
                Truth.assertThat(emitted_value).isEqualTo(25)
                cancelAndConsumeRemainingEvents()
            }
        }
        flowViewModel.squareNumber(5) // sending value to shared flow,if there are no collectors
        // subscribed the flow will be lost.
        // either call flowviewmodel.squarenumber after subscribing(run in sequence) or use job(run parallely).

        job.join() //  wait until job finishes,if job finishes then collector will get the flow value.
        job.cancel()

    }
}