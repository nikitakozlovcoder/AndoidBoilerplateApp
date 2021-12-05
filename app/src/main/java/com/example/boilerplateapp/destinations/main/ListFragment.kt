package com.example.boilerplateapp.destinations.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.example.boilerplate.viewModels.main.MainVm
import com.example.boilerplateapp.R

class ListFragment : Fragment() {
    private val vm by viewModels<MainVm>({ requireParentFragment().parentFragment!! })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm.foo.observe(viewLifecycleOwner){
            Log.d("MainVm", it.toString())
        }
        vm.foo.value = vm.foo.value?.plus(1)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }
}