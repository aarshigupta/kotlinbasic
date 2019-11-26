package com.example.kotlinlearning.presenters

import android.widget.Toast
import com.example.kotlinlearning.R
import com.example.kotlinlearning.base.mvp.Presenter
import com.example.kotlinlearning.base.mvp.Ui

class MainFragmentPresenter : Presenter<MainFragmentPresenter.MainFragmentUi>() {
    private var count = 0;
    private val colorArray =
        intArrayOf(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark)


    fun onSignUpClicked() {
        Toast.makeText(ui.uiContext, ui.uiContext.getString(R.string.hello_world), Toast.LENGTH_LONG).show();
        ui.onButtonClick(1);
    }

    fun onCountClicked() {
        ui.afterCountClick(colorArray[count % 3], -1)
        ++count;
        ui.afterCountClick(-1, count)
    }

    fun onRecyclerClicked() {
        ui.onButtonClick(2)
    }

    interface MainFragmentUi : Ui {
        fun onButtonClick(value: Int)
        fun afterCountClick(value1: Int, value2: Int)
    }
}
