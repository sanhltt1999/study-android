package com.example.handellifecycles.normal

import android.content.Context
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.handellifecycles.R

class NormalActivity : AppCompatActivity() {

    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)

        myLocationListener = MyLocationListener(this) { location ->
            // update UI
        }
    }

    public override fun onStart() {
        super.onStart()
        myLocationListener.start()
        // manage other components that need to respond
        // to the activity lifecycle
    }

    public override fun onStop() {
        super.onStop()
        myLocationListener.stop()
        // manage other components that need to respond
        // to the activity lifecycle
    }
}

internal class MyLocationListener(
    private val context: Context,
    private val callback: (Location) -> Unit
) {

    fun start() {
        // connect to system location service
        Log.d("NormalActivity", "start")
    }

    fun stop() {
        // disconnect from system location service
        Log.d("NormalActivity", "stop")
    }
}