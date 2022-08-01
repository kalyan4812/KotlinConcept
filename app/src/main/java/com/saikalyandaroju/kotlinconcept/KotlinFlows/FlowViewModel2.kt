package com.saikalyandaroju.kotlinconcept.KotlinFlows

import android.net.NetworkInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowViewModel2 : ViewModel() {


    var mutable_data = MutableLiveData<Int>(0)


    init {

        viewModelScope.launch {
            for (i in 1..10) {
                delay(1000L)
                incrementLiveValue()
            }
        }
    }

    private fun incrementLiveValue() {

        mutable_data.postValue(mutable_data.value?.plus(1))

    }

    fun liveData(): LiveData<Int> {
        return mutable_data
    }


//--------------------------------------------------------------------------------------------------
    // Cool flow- not as livedata,it don't store the state it will restart when you rotate the device
    // or on activity recreation.

    //hot flow - executed even there are no subscribers to it.

    // state flow =live data without lifecycle awarness i.e state flow is not aware of when activity
    // is going to background or comes to foreground.
    // they store a single value and emit them and not as normal flow which emit multiple values.
    // it holds the state.

    // we can use all coolflow opeartors with state flow.

    lateinit var mutable_state_flow: MutableStateFlow<Int>
    lateinit var sate_flow: StateFlow<Int>

    init {
        mutable_state_flow = MutableStateFlow(0)
        sate_flow = mutable_state_flow.asStateFlow() // immutable.

        viewModelScope.launch {
            for (i in 1..10) {
                delay(1000L)
                incrementFlowValue()
            }
        }

    }


    fun incrementFlowValue() {
        mutable_state_flow.value += 1
    }
//--------------------------------------------------------------------------------------------------

    //shared flow =hot flow ,which is used for one time events.
    // unlike state flow it won't be trigger/persist the value after flow emission when we rotate the device.
    // like if we want any event to happen only once we can use this.
    // it can work with any number of collectors/observers.if there are no collectors flow will be executed
    // but it will be lost.

    var mutable_shared_flow = MutableSharedFlow<Int>(replay = 0)
    // here replay=5 is for caching i.e now it will store the last 5 emission values which sent to shared flow.

    val shared_flow = mutable_shared_flow.asSharedFlow()

    // now we can send any number to shared flow.

    init {

        viewModelScope.launch {
            for (i in 1..10) {
                delay(1000L)
                squareNumber(i)
            }
        }

    }

    fun squareNumber(number: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            mutable_shared_flow.emit(number * number)
        }
    }
    //---------------------------------------------------------------------------------------------

    // merge opearator.-merges two flows there may be duplicates.

    val flow1 = (1..5).asFlow()
    val flow2 = (3..8).asFlow()
    val flow3 = (10..12).asFlow()

    init {
        merge(flow1, flow2).onEach {
            println("merge $it")
        }.launchIn(viewModelScope)

    }

    //zip opearator - emits only when flow1,flow2 both are ready.
    // if incase flow1/flow2 finishes earlier then further emissions will be stopped.
    init {
        flow1.zip(flow2) { num1, num2 ->
            println("zip  $num1  $num2")
        }.launchIn(viewModelScope)
    }


    // combine operator-same as zip but it emits even if one of the flow finsihes.
    // if incase flow1 finishes earlier then for further emissions last flow1 value will be used.
    // you can use combine any number of times.

    init {
        flow1.combine(flow2) { num1, num2 ->
            println("combine1 $num1 $num2")
            if (num1 % 2 == 0) num2 else 0
        }.combine(flow3) { num2, num3 ->
            println("combine2 $num2 $num3")
        }.launchIn(viewModelScope)
    }
    /*
 combine1 1 3
 combine2 0 10
 combine2 0 11
 combine1 2 4
 combine2 4 11
 combine2 4 12
 combine1 3 5
 combine2 0 12
 combine1 4 6
 combine2 6 12
 combine1 5 7
 combine2 0 12
 combine1 5 8
 combine2 0 12

     */

    // if you use multiple zips,if last flow completes then all further emissions will be stopped.

    init {
        flow1.zip(flow2) { num1, num2 ->
            println("zipp1 $num1 $num2")
            if (num1 % 2 == 0) num2 else 0
        }.zip(flow3) { num2, num3 ->
            println("zipp2 $num2 $num3")
        }.launchIn(viewModelScope)
    }
    /*
       zipp1 1 3
       zipp2 0 10
       zipp1 2 4
       zipp2 4 11
       zipp1 3 5
       zipp2 0 12
     */
    //------------------------------------------------------------------------------------------------

    //channels -same as shared flow(but it is cool flow),but sometimes events from sharedflow will be lost

    // because on screen rotation in stop state,repeatOnLifecycle(Lifecycle.State.STARTED)
    // will cancel the couroutine inside and relaunch it.
    // so if we get any event in between onstop and ondestroy ,then it will be lost.

    // and now since channel is a cool flow,it won't emit events if there are no collectors
    // listening to it.

    // so use shared flow ,if you have multiple collectors.
    val channel = Channel<Int>()
    val channel_flow = channel.receiveAsFlow()

    init {
        viewModelScope.launch(Dispatchers.Main.immediate) {
            repeat(10) {
                channel.send(it)
                delay(1000L)
            }
        }
    }


}