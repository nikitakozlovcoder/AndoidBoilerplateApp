package com.example.boilerplateapp.destinations.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.navigation.ui.setupWithNavController
import com.example.boilerplate.viewModels.main.MainVm
import com.example.boilerplateapp.R
import com.example.boilerplateapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private val vm by viewModels<MainVm>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vm.foo.observe(viewLifecycleOwner){
                Log.d("MainVm", it.toString())
        }
        vm.foo.value = vm.foo.value?.plus(1)
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val nav = childFragmentManager.findFragmentById(binding.mainFragmentContainerView.id) as NavHostFragment
        binding.bottomNav.setupWithNavController(nav.navController)
        return binding.root
    }
}