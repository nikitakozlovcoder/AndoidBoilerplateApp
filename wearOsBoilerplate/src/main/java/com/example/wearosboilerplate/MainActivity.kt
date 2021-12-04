package com.example.wearosboilerplate

import android.app.Activity
import android.os.Bundle
import com.example.boilerplate.models.PositiontModel
import com.example.wearosboilerplate.databinding.ActivityMainBinding

class MainActivity : Activity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val post = PositiontModel("SUPER_DUPER!")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}