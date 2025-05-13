package com.example.gameapp.allFragments.registrationFragment

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewmodel(): ViewModel() {

    var  handler = Handler(Looper.getMainLooper())
    var isBlinking:Boolean = true

    private val mutableLiveDataforBlinking = MutableLiveData<Boolean>()
    val liveDataBinking: LiveData<Boolean>
        get() = mutableLiveDataforBlinking

    init {

        blinkingText()
    }

    fun blinkingText(){
        handler.post(object : Runnable{
            override fun run() {

                if(isBlinking){
                    mutableLiveDataforBlinking.value = true
                    handler.postDelayed(this,500)
                }
            }
        })
    }
}