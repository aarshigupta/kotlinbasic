package com.example.kotlinlearning.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinlearning.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment()
{
    private var count=0;
    private val colorArray= arrayOf(R.color.colorPrimary,R.color.colorAccent,R.color.colorPrimaryDark)

    /**
     * Static block to create variables or methods that can be accessed statically
     */
    companion object {

        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        signup.setOnClickListener {
            Toast.makeText(context,"Hello World",Toast.LENGTH_LONG).show();
            activity?.supportFragmentManager?.beginTransaction()?.add(
                R.id.root_layout,
                SignUpFragment.newInstance()
            )?.addToBackStack(null)?.commit();
        }
        changeImage.setOnClickListener {
            imageButton.setBackgroundColor(colorArray[count%3])
            ++count;
            textView.text="$count"
        }

        recyclerView.setOnClickListener {
           activity?.supportFragmentManager?.beginTransaction()?.add(
               R.id.root_layout,
               RecyclerFragment.newInstance()
           )?.addToBackStack(null)?.commit();
        }
    }
}