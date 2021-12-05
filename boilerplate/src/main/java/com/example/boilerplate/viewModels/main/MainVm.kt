package com.example.boilerplate.viewModels.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainVm(application: Application) : AndroidViewModel(application) {
      val foo = MutableLiveData<Int>(0)
}