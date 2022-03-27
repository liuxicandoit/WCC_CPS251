package com.example.lifecycleawareproject

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import com.example.lifecycleawareproject.ui.main.MainViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DemoObserver(viewModel: MainViewModel) : LifecycleObserver {

    private val LOG_TAG = "DemoObserver"

    val baseResult = " was fired on "
    var result = ""
    val model = viewModel
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    val timeNow = LocalDateTime.now().format(formatter)

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        result = "onResume$baseResult$timeNow\n**********"
        model.setStatus(result)
        Log.i(LOG_TAG, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        result = "onPause$baseResult$timeNow\n**********"
        model.setStatus(result)
        Log.i(LOG_TAG, "OnPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        result = "onCreate$baseResult$timeNow"
        model.setStatus(result)
        Log.i(LOG_TAG, "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        result = "onStart$baseResult$timeNow"
        model.setStatus(result)
        Log.i(LOG_TAG, "OnStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        result = "onStop$baseResult$timeNow"
        model.setStatus(result)
        Log.i(LOG_TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        result = "onDestroy$baseResult$timeNow\n**********"
        model.setStatus(result)
        Log.i(LOG_TAG,"OnDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event){
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
    }


}