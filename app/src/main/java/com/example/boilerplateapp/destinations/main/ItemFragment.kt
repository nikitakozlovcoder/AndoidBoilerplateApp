package com.example.boilerplateapp.destinations.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.boilerplate.viewModels.main.MainVm
import com.example.boilerplateapp.R

class ItemFragment : Fragment() {
    private val vm by viewModels<MainVm>({requireParentFragment().parentFragment!!})
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
       // requireParentFragment().parentFragment!!.findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
       // val nav = activity!!.supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
       // nav.navController.navigate(R.id.action_mainFragment_to_loginFragment)
        vm.foo.value = vm.foo.value?.plus(1)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item, container, false)

    }
}