package com.example.wearosboilerplate

import android.app.Activity
import android.os.Bundle
import com.example.boilerplate.models.PostModel
import com.example.wearosboilerplate.databinding.ActivityMainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val post = PostModel("SUPER_DUPER!")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}