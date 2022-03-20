package com.example.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var editText=""
    var displayNames: MutableLiveData<String> = MutableLiveData()

    fun setName(value: String){
        this.editText = value
        displayNames.setValue(displayNames.value+"\n"+value)
    }

    fun getName(): MutableLiveData<String> {
        return displayNames

    }


    fun addName(){
           if(editText != ""){
               //resetName()
                   if(displayNames.value.equals("No Name Displayed")){
                       displayNames.setValue("")
                       setName(editText)
                       //getName()
                   }else{
                       setName(editText)
                   }
           }else{
               displayNames.setValue("No Name Displayed")

            }
    }
}