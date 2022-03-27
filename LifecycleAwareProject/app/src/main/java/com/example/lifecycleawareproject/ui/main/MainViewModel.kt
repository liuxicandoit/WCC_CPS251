package com.example.lifecycleawareproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var initValue=""
    private var result: MutableLiveData<String> = MutableLiveData()

    fun setStatus(value: String) {
        this.initValue = value
        result.setValue(result.value + "\n" + value)
    }

    fun getResult(): MutableLiveData<String> {
        return result
    }
}