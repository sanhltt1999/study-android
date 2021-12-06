package com.example.adapterbinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val user =  MutableLiveData<UserInfo>()
    init {
        user.value = UserInfo("Tony Teo", "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_960_720.jpg", 18)
    }
}