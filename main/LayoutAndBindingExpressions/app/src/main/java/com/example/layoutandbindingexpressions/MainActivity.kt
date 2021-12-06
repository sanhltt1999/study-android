package com.example.layoutandbindingexpressions

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.layoutandbindingexpressions.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var user = User("Test", "User", 15)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.user = user
        binding.activity = this

    }

    fun onPlusAge(view: View) {
        user.age = user.age + 1
        Log.d("MainActivity", user.age.toString())
    }

}