package com.saikalyandaroju.kotlinconcept.KotlinFlows

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.saikalyandaroju.kotlinconcept.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FlowViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var mainCoroutineRule =
        MainCoroutineRule() // since we are in unit test folder not in android test +
    //below functions use couroutine scope to run and they relay on MainLoopDispatcher and since
    // don't have access to it here,we can to define our own junit rule.

    private lateinit var flowViewModel: FlowViewModel

    @Before
    fun setUp() {
        flowViewModel = FlowViewModel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun test_fun_countDownValue() = runBlocking {
        flowViewModel.countDown.test {
            for (i in 10 downTo 0) {

                mainCoroutineRule.testScheduler.advanceTimeBy(1000L)
                val emitted_value = awaitItem()
                Truth.assertThat(emitted_value).isEqualTo(i)
            }
            cancelAndConsumeRemainingEvents() // avoid exception if there are some more flow emission.
        }
    }
    /*
     Note for above test : since we are doing unit tests we need to skip delays to do that
     we need access to couroutine dispacthers in unit test ,so we need to add maincouroutine rule
     and make sure to run flows on Dispatchers.Main in our Viewmodel and advancetimeBy in tests by respective
     delay used in our flows in viewmodel.
     */
}