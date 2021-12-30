package com.example.testproject.presentation.view.json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testproject.MyApp
import com.example.testproject.R

class MainActivity : AppCompatActivity() {

    private val component by lazy {
        (application as MyApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}