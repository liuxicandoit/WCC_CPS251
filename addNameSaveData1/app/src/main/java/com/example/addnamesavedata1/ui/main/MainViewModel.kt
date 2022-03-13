package com.example.addnamesavedata1.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var editText=""
    private var displayNames = ""

    fun setName(value: String){
        this.editText = value
        displayNames = displayNames+"\n"+value
    }

    fun getName(): String {
        return displayNames

    }
}