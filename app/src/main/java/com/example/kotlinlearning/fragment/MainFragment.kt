package com.example.kotlinlearning.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinlearning.R
import com.example.kotlinlearning.base.mvp.MvpBaseFragment
import com.example.kotlinlearning.presenters.MainFragmentPresenter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : MvpBaseFragment<MainFragmentPresenter, MainFragmentPresenter.MainFragmentUi>(),
    MainFragmentPresenter.MainFragmentUi {

    /**
     * Static block to create variables or methods that can be accessed statically
     */
    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun createPresenter(): MainFragmentPresenter {
        return MainFragmentPresenter()
    }

    override fun getUi(): MainFragmentPresenter.MainFragmentUi {
        return this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun afterCountClick(value1: Int, value2: Int) {
        if (value1 != -1) {
            imageButton.setBackgroundColor(value1)
        } else {
            textView.text = "$value2"
        }
    }

    override fun onButtonClick(value: Int) {
        if (value == 1) {
            activity?.supportFragmentManager?.beginTransaction()?.add(
                R.id.root_layout,
                SignUpFragment.newInstance()
            )?.addToBackStack(null)?.commit();
        } else if (value == 2) {
            activity?.supportFragmentManager?.beginTransaction()?.add(
                R.id.root_layout,
                RecyclerFragment.newInstance()
            )?.addToBackStack(null)?.commit();
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        signup.setOnClickListener {
            presenter.onSignUpClicked()
        }
        imageButton.setBackgroundColor(Color.parseColor("#D81B60"))

        changeImage.setOnClickListener {
            presenter.onCountClicked()
        }

        recyclerView.setOnClickListener {
            presenter.onRecyclerClicked()
        }
    }
}