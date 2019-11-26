package com.example.kotlinlearning.presenters

import android.util.Patterns
import android.widget.Toast
import com.example.kotlinlearning.base.mvp.Presenter
import com.example.kotlinlearning.base.mvp.Ui
import com.example.kotlinlearning.viewmodel.UserModel
import android.text.TextUtils
import com.example.kotlinlearning.R


class SignUpPresenter : Presenter<SignUpPresenter.SignUpUi>() {

    var invalidInputName: String = ""
    fun onSubmitClicked(userModel: UserModel) {
        invalidInputName = ""
        Toast.makeText(ui.uiContext, userModel.email + " " + userModel.password + " " + userModel.name + " " + userModel.address, Toast.LENGTH_LONG).show()
        if (isValidEmail(userModel.email) && isValidPassword(userModel.password) && isValidOther(userModel.address)) {
            ui.afterSubmitClicked(invalidInputName)
        } else {
            ui.afterSubmitClicked(invalidInputName)
        }
    }

    interface SignUpUi : Ui {
        fun afterSubmitClicked(value: Any)
    }

    fun isValidEmail(target: CharSequence): Boolean {
        var local = !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        if (!local) {
            invalidInputName = ui.uiContext.getString(R.string.Invalid_Email_Length_or_Format)
        }
        return local
    }

    fun isValidPassword(target: CharSequence): Boolean {
        var local = !TextUtils.isEmpty(target) && target.length > 6
        if (!local) {
            invalidInputName = ui.uiContext.getString(R.string.Invalid_Password_Length)
        }
        return local
    }

    fun isValidOther(target: CharSequence): Boolean {
        var local = !TextUtils.isEmpty(target) && target.length > 5
        if (!local) {
            invalidInputName = ui.uiContext.getString(R.string.Invalid_Name_Address)
        }
        return local
    }
}
