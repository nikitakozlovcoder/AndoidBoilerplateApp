package com.example.boilerplateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boilerplateapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BoilerplateApp)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}