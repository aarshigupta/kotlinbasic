package com.example.kotlinlearning.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinlearning.fragment.MainFragment
import com.example.kotlinlearning.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Add Fragment Main to the main activity in root layout
         */
        supportFragmentManager.beginTransaction().add(
            R.id.root_layout,
            MainFragment.newInstance()
        ).commit();
    }
}
