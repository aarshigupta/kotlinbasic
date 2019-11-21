package com.example.kotlinlearning.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData



class UserModel : ViewModel() {
    private val mAction = MutableLiveData<Action>()

    fun getAction(): LiveData<Action> {
        return mAction
    }

    var email: String = ""

    var password: String = ""

    var name: String = ""
    var address: String = ""

    fun validateAndSubmit(): Boolean {
        mAction.setValue(Action(Action.SHOW_INVALID_PASSWARD_OR_LOGIN))
        return true
    }


}