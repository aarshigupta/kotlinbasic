package com.example.kotlinlearning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.databinding.DataBindingUtil
import com.example.kotlinlearning.R
import com.example.kotlinlearning.databinding.FragmentSignupBinding
import com.example.kotlinlearning.viewmodel.UserModel
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment : Fragment(), View.OnClickListener {
    val userModel = UserModel()

    override fun onClick(p0: View?) {
        userModel.email=editText.text.toString()
        userModel.password=editText2.text.toString()
        userModel.address=editText4.text.toString()
        userModel.name=editText3.text.toString()

        Toast.makeText(context, userModel.email+" "+userModel.password+" "+userModel.name+" "+userModel.address, Toast.LENGTH_LONG).show()
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