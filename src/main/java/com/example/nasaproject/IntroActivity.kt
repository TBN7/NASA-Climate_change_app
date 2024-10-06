package com.example.nasaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class IntroActivity : AppCompatActivity() {
    lateinit var text: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        setupView()
    }

    fun setupView() {
        text = findViewById(R.id.text2)

    }
}