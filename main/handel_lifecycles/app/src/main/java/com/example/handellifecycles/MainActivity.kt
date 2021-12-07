package com.example.handellifecycles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handellifecycles.lifecycler.LifecycleOwnerActivity
import com.example.handellifecycles.normal.NormalActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNormal.setOnClickListener {
            startActivity(Intent(this, NormalActivity::class.java))
        }

        btnLifecycles.setOnClickListener {
            startActivity(Intent(this, LifecycleOwnerActivity::class.java))
        }
    }
}