package com.example.hospitalsystem.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospitalsystem.R
import com.example.hospitalsystem.utils.MySharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MySharedPreferences.init(this)
    }

}