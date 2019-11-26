package com.example.kotlinlearning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.databinding.DataBindingUtil
import com.example.kotlinlearning.R
import com.example.kotlinlearning.base.mvp.MvpBaseFragment
import com.example.kotlinlearning.databinding.FragmentSignupBinding
import com.example.kotlinlearning.presenters.SignUpPresenter
import com.example.kotlinlearning.viewmodel.UserModel
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment : MvpBaseFragment<SignUpPresenter, SignUpPresenter.SignUpUi>(), SignUpPresenter.SignUpUi, View.OnClickListener {
    override fun afterSubmitClicked(value: Any) {
        if (value.toString().length <= 0) {
            Toast.makeText(context, "Valid Data", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, value.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun createPresenter(): SignUpPresenter {
        return SignUpPresenter()
    }

    override fun getUi(): SignUpPresenter.SignUpUi {
        return this
    }

    val userModel = UserModel()

    override fun onClick(p0: View?) {
        userModel.email = editText.text.toString()
        userModel.password = editText2.text.toString()
        userModel.address = editText4.text.toString()
        userModel.name = editText3.text.toString()
        presenter.onSubmitClicked(userModel)
    }

    companion object {
        fun newInstance(): SignUpFragment {
            return SignUpFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        submit.setOnClickListener(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSignupBinding>(
            inflater, R.layout.fragment_signup, container, false
        )
        binding.usermodel = userModel
        val view = binding.getRoot()
        return view
    }

}