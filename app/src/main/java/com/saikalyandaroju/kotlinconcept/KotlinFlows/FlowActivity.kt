package com.saikalyandaroju.kotlinconcept.KotlinFlows

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.saikalyandaroju.kotlinconcept.R
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {

    private lateinit var viewModel: FlowViewModel
    private val viewModel2: FlowViewModel2 by viewModels()
    private lateinit var timer: TextView
    private lateinit var state_flow_timer: TextView
    private lateinit var shared_flow_timer: TextView
    private lateinit var live_data_timer: TextView
    private lateinit var channel_timer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)
        timer = findViewById(R.id.timer_text)
        state_flow_timer = findViewById(R.id.timer_text2)
        shared_flow_timer = findViewById(R.id.timer_text3)
        live_data_timer = findViewById(R.id.timer_text1)
        channel_timer = findViewById(R.id.timer_text4)

        viewModel =
            ViewModelProvider(this, defaultViewModelProviderFactory).get(FlowViewModel::class.java)

        setUpObservers()

        collectLifecycleAwareFlow(viewModel2.sate_flow) {
            state_flow_timer.text = it.toString()
        }

        collectLifecycleAwareSharedFlow(viewModel2.shared_flow) {
            shared_flow_timer.text = it.toString()
            println("value is : ${it.toString()}")
        }
        collectLifecycleAwareSharedFlow(viewModel2.channel_flow) {
            channel_timer.text = it.toString()
        }

    }

    override fun onRestart() {
        println("restarted.....")
        super.onRestart()
        collectLifecycleAwareFlow(viewModel2.sate_flow) {
            state_flow_timer.text = it.toString()
        }

        collectLifecycleAwareSharedFlow(viewModel2.shared_flow) {
            shared_flow_timer.text = it.toString()
            println("value is : ${it.toString()}")
        }

    }

    // not a better way.
    private fun setUpObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.countDown.collect(object : FlowCollector<Int> {
                override suspend fun emit(value: Int) {
                    timer.text = value.toString()
                }

            })
        }
        viewModel2.liveData().observe(this) {
            live_data_timer.text = it.toString()
        }
    }

    fun <T> ComponentActivity.collectLifecycleAwareFlow(
        flow: Flow<T>,
        collect: suspend (T) -> Unit
    ) {
        lifecycleScope.launch {

            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest(collect)
            }


        }
    }

    suspend fun <T> Flow<List<T>>.flattenToList() =
        flatMapConcat { it.asFlow() }.toList()

    fun <T> ComponentActivity.collectLifecycleAwareSharedFlow(
        flow: Flow<T>,
        collect: FlowCollector<T>
    ) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collect(collect)
            }
        }
    }


}