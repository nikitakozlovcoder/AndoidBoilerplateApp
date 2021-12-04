package com.example.boilerplateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boilerplate.models.PostModel
import com.example.boilerplateapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        val post = PostModel("SUPER_DUPER!")
    }
}