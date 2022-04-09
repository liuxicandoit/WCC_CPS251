package com.example.recycleview

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){

    //some static property arraylist of arraylist<int>

    //some method that will creates the sub arrays that will have 3 random number each
    // method outside the companion object
    //call that method from mainactivity

    companion object{

        //var innerArr: IntArray = intArrayOf(0,1,2)
        var arr : Array<IntArray> = Array(8){ IntArray(3 ){0} }
        var isFirstArr = true

    }
    fun set2DArr() {

        for (i in 0 until arr.size) {
            var colArray=IntArray(3)
            for (j in 0 until 3) {
                val ranNum = (0 until arr.size).random()
                colArray[j] = ranNum
            }
            arr[i] = colArray
        }
    }

    fun get2DArr():Array<IntArray>{
        return arr
    }

}