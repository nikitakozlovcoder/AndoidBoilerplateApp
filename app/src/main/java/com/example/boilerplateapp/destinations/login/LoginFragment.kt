package com.example.boilerplateapp.destinations.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.boilerplate.constants.navigation.NavigationDestination
import com.example.boilerplate.viewModels.login.LoginVm
import com.example.boilerplateapp.R
import com.example.boilerplateapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private val vm by viewModels<LoginVm>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            for (item in vm.navChannel){
                when(item) {
                    NavigationDestination.LoginFragment -> {
                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                    }
                }
            }
        }
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm
        return binding.root
    }
}