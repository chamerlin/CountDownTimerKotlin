package com.example.kotlinflow.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class HomeViewModel : ViewModel() {
//    val numberSeq = sequenceOf(1,2,3,4,5)
//    val numberSeq2 = numberSeq.map { it+2 }
    
//    val firstFlow = flow {
//        for(i in 1..10){
////            Log.d("hello", "Im from flow builder")
//            delay(1000)
//            emit(i)
//        }
//    }.flowOn(Dispatchers.Default)

    var minutes = MutableLiveData<Int>()
    var seconds = MutableLiveData<Int>()

    fun getTime(minute: Int, second: Int){
        minutes.value = minute
        seconds.value = second
    }

    fun createCountDownTimer(minute: Int, second: Int) = flow {
        val initialCount = minute*60 + second
        var currentCount = initialCount
        emit(currentCount)
        while(currentCount > 0){
            delay(1000)
            currentCount--
            emit(currentCount)
//            if(currentCount < 5){
//                throw Exception("the number should be lower than 7")
//            }
        }
    }

    val secondFlow = listOf(1,2,3,4,5).asFlow()

    fun getCountDownTimer(minute: Int, second: Int) = flow {
        createCountDownTimer(minute, second)
            .catch{
                emit(0)
            }
            .collect{
                emit(String.format("%02d:%02d", it/60, it%60))
            }
    }
}