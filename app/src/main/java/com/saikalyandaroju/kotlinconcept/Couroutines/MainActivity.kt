package com.saikalyandaroju.kotlinconcept.Couroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.saikalyandaroju.kotlinconcept.R
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // global scope=application scope.
        GlobalScope.launch {
            delay(1000L) // same as sleep in thread.
            // note delay only pause couroutine ,not the thread in which it is executing.
            Log.d(TAG, "Couroutine is running in a thread ${Thread.currentThread().name}")

            Log.d(TAG, networkCall())
        }

        Log.d(TAG, "Current thread  is ${Thread.currentThread().name}")


        // dispacthers - main,io,default,unconfined.

        /*
           * ui-main
           * network,database,file-io
           * complex opeartions-default.
         */

        GlobalScope.launch(Dispatchers.Main) {
            delay(1000L) // it won't block ui ,if you want to block ui use runblocking.
        }

        GlobalScope.launch(newSingleThreadContext("MyThread")) { } // own thread.


        GlobalScope.launch(Dispatchers.IO) {
            val ans = networkCall()
            // now switching thread to main thread.
            withContext(Dispatchers.Main) {
                // you can upadte the UI.
            }
        }

        runBlocking {
            delay(1000L)
            networkCall()// you can call suspend functions.
            launch { } // you can launch a courotine.
        }
        // runblocking will only effect the main thread,other couroutines will run aschronously.


        val job = GlobalScope.launch(Dispatchers.IO) {
            repeat(5) {
                if (isActive) {
                    Log.d(TAG, "couroutine is running")
                }
                delay(1000L)
            }
        }

        runBlocking {
            job.join() // it will block main thread until job finishes.

            // job.cancel()-- cancelling a job.
            Log.d(TAG, "Main thread is continuing")
        }
        // some times courotines won't get canclled ,since they are busy in working,so it is better to have a check if isActive().
        // if network call takes too much time,you can cancel it.--use case.


        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                networkCall()
                networkCall2()
            }
            Log.d(TAG, "Time taken is $time")
        }

        // in the above way ,suspend functions are executed one after other.

        GlobalScope.launch(Dispatchers.IO) {
            val ans1 = async { networkCall() } // return Deffered<String>

            val ans2 = async { networkCall2() }

            Log.d(
                TAG,
                ans1.await()
            ) // await means it waits until networkcall() finishes and we get the answer ,otherwise ans1 will be null.
            Log.d(TAG, ans2.await())
        }


        // it is not good to use GlobalScope,may lead to memory leak.
        // use  lifecyclescope- scope of activity.
        // viewmodelscope-scope of viewmodel
        lifecycleScope.launch {

        }

    }


    // writing our own suspend function.

    suspend fun networkCall(): String { // can only called from a couroutine.
        delay(2000L)
        return "Response"
    }


    suspend fun networkCall2(): String {
        return "new response."
    }
}

// if main thread finishes ,then all couroutines will be killed.
// to know about any function use ctrl+q.

// delay can only be called from another suspend function or in a couroutine.


// in couroutine ,if they are two suspend functions,they will get executed one after another by default.
// one way of solving is to launch two more separete coroutines to get the answers.(not good way if they are many suspend function)
