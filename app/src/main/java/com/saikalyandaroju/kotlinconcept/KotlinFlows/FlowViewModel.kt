package com.saikalyandaroju.kotlinconcept.KotlinFlows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FlowViewModel : ViewModel() {


    init {
        flatMapConactOpearator()
    }

    // cool flow-it won't do anything unless some some observers are subscribed to it.
    val countDown = flow<Int> {
        val start_time = 10
        var current_time = start_time
        emit(current_time)
        while (current_time > 0) {
            delay(1000L)
            current_time--
            emit(current_time)
        }
    }.flowOn(Dispatchers.Main)


    fun collectFlow() {
        viewModelScope.launch {
            countDown.collect { time ->
                println(time)
            }
        }

        // collect vs collectLatest---> if incase emisssion of one value takes time and if another value time
        // come for emission then  previous emission will be cancelled.
    }

    fun collectFlowWithFilter() {
        viewModelScope.launch {
            countDown.filter { time ->
                time % 2 == 0
            }.collect { filtered_time ->
                println(filtered_time)
            }
        }
    }

    fun collectFlowWithMap() {
        viewModelScope.launch {
            countDown.filter { time ->
                time % 2 == 0
            }.map { filtered_time ->
                filtered_time * filtered_time

            }.collect { mapped_time ->
                println(mapped_time)
            }
        }
    }

    fun collectFlowWithOnEach() {
        val res = countDown.onEach {
            println(it)
        }.launchIn(viewModelScope)

        // onEach and collect both are similar but onEach will returan a flow ,where as collect will
        // return unit ,it finishes the flow.
    }
    //------------------------------------------------------------------------------------------------

    // Terminal flow operators- terminate the flow..


    fun countOpeartor() {
        viewModelScope.launch {
            val count = countDown.filter { time ->
                time % 2 == 0
            }.map { filtered_time ->
                filtered_time * filtered_time

            }.onEach {
                println(it)
            }.count {
                it % 2 == 0  // counts values if condition is satisfied.
            }
            println(count)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun reduceOpeartor() {
        viewModelScope.launch {
            val result = countDown.reduce { accumulator, value ->
                accumulator + value
            }
            // accumulator would be executed for very first two emissions.
            // here it is 10+9
            // accumulator stores previous (accumulator+value)=19
            // now for emission =8 ,accumulartor=8+19=27 and so on...
            println(result)  // sum of 10+9+8+7+....1=55.
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun foldOpeartor() {
        viewModelScope.launch {
            val result = countDown.fold(100) { accumulator, value ->
                accumulator + value
            }
            //same as accumulator ,here intial value of accumulator=100.
            println(result)  // sum of 100+10+9+8+7+....1=155.
        }
    }

    //----------------------------------------------------------------------------------------------

    // Flattening operators

    /*
        example: [[1,2],[1,2,3,4]] ----flat----> [1,2,1,2,3,4]
     */

    @OptIn(FlowPreview::class)
    fun flatMapConactOpearator() {
        val flow1 = (1..5).asFlow().flowOn(Dispatchers.IO) // emits 1 to 5 values as flow.
        // flowOn=subscribeOn in RXJava.

        /*  val flow2= flow<Int> {
              emit(1)
              delay(500L)
              emit(2)
          }*/
        viewModelScope.launch {
            flow1.flatMapConcat { flow1_value ->
                // usecase= getNotesById(id)
                flow {
                    emit(flow1_value + 1)
                    delay(1000L)
                    emit(flow1_value + 2)
                }
            }.collect {
                println(it)  // 2 3 3 4 4 5 5 6 6 7
            }
        }

        // so here we are using values emitted by flow1 for getting the result from flow2 and
        // we are collecting values in collect block.


        // flatMapMerge vs flatMapConcat = flatmapconcat waits until one flow1  is finished then move another
        // emission but flatmapmerge will launch all flow1 values at a time.

        //flatmaplatest same as collectlatest.
    }

    fun bufferOperator() {
        val flow1 = (1..5).asFlow()

        viewModelScope.launch {
            flow1.buffer().collect {
                println(it)
            }
        }
        // buffer makes collect block to run in different couroutine everytime,if we don't use
        // buffer for every new emission collect block should be finished.

        // conflate operator- same as buffer but if we don't finish emission1 and emission2,3 are
        // are also runnig then after finishing emission1 it drop all emissions which came before
        // emission1 and move to latest emission.
    }


}
