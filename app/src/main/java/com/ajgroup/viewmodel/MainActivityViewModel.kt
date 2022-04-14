package com.ajgroup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var number: MutableLiveData<Int> = MutableLiveData(0)

    fun increaseNumber(){
        number.value?.let {
            number.postValue(it+1)
        }
    }

}