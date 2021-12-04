package com.example.boilerplateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.coroutineScope
import com.example.boilerplate.repos.implementation.PositionRepo
import com.example.boilerplateapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

//TODO nav component, nav graph scope vm, retrofit, room, bottomNavigation, setup as nav component, navigation drawer, generic recyclerview
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        val positionRepo =  PositionRepo()

        lifecycle.coroutineScope.launch {
            val positionRes = positionRepo.get()
            Log.d("positionRes", positionRes.toString())
        }
    }
}