package com.example.boilerplate.viewModels.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.boilerplate.R
import com.example.boilerplate.constants.navigation.NavigationDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class LoginVm(application: Application) : AndroidViewModel(application) {
    val navChannel = Channel<NavigationDestination>()
    fun onLogin(){
        Log.d("LOGIN", "LOGGED IN!")
        viewModelScope.launch {
            navChannel.send(NavigationDestination.LoginFragment)
        }
    }
}