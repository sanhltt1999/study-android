package com.example.handellifecycles.lifecycler

import android.app.Activity
import android.content.Context
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class LifecycleOwnerActivity : AppCompatActivity() {

    private lateinit var lifecycleRegistry: LifecycleRegistry
    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        lifecycleRegistry = LifecycleRegistry(this)
//        lifecycleRegistry.markState(Lifecycle.State.CREATED)

        myLocationListener = MyLocationListener(this, lifecycle) { location ->
            // update UI
        }
        lifecycle.addObserver(myLocationListener)
    }

    override fun onStart() {
        super.onStart()
    }

}

internal class MyLocationListener(
    private val context: Context,
    private val lifecycle: Lifecycle,
    private val callback: (Location) -> Unit
): DefaultLifecycleObserver {

    private var enabled = false

    override fun onStart(owner: LifecycleOwner) {
        Log.d("LifecycleOwnerActivity", "start")
    }

    fun enable() {
        enabled = true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("LifecycleOwnerActivity", "stop")
    }
}