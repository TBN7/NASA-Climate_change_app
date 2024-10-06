package com.example.nasaproject

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible

class HomeActivity : AppCompatActivity() {
    lateinit var white: ImageView
    lateinit var redtermo: ImageView
    lateinit var yellowtermo: ImageView
    lateinit var greentermo: ImageView
    lateinit var personView: View
    lateinit var carView: View
    lateinit var factoryView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpViews()
        playBackgroundMusic()



    }

    private fun setUpViews(){
        carView = findViewById(R.id.car_view)
        factoryView = findViewById(R.id.factory_view)
        personView = findViewById(R.id.person_view)

        redtermo = findViewById(R.id.red_termo)
        yellowtermo = findViewById(R.id.yellow_termo)
        greentermo = findViewById(R.id.green_termo)
        white = findViewById(R.id.white)

        personView.setOnClickListener {
            openPersonDetails()
        }

        carView.setOnClickListener {
            openCarDetails()
        }

        factoryView.setOnClickListener {
            openFactoryDetails()
        }

    }
    private fun openPersonDetails() {
        val infoPersonFragment = InfoPersonFragment()
        infoPersonFragment.show(supportFragmentManager, "InfoPersonManager")
    }
    private fun openCarDetails() {
        val infoCarFragment = InfoCarFragment(
            onCorrectAnswer = {
                white.isVisible = true
                redtermo.isVisible = false
                greentermo.isVisible = true
                yellowtermo.isVisible = false },
            onIncorrectAnswer = {
                white.isVisible = true
                greentermo.isVisible = false
                redtermo.isVisible = true
                yellowtermo.isVisible = false
            },
            onSemiIncorrectAnswer = {
                white.isVisible = true
                greentermo.isVisible = false
                redtermo.isVisible = false
                yellowtermo.isVisible = true
            }


        )
        infoCarFragment.show(supportFragmentManager, "InfoCarManager")
    }

    private fun openFactoryDetails() {
        val infoFactoryFragment = InfoFactoryFragment(
            onCorrectAnswer = {
                white.isVisible = true
                greentermo.isVisible = true
                redtermo.isVisible = false
            },
            onIncorrectAnswer = {
                white.isVisible = true
                greentermo.isVisible = false
                redtermo.isVisible = true
            }
        )
        infoFactoryFragment.show(supportFragmentManager, "InfoFactoryManager")
    }

    private fun playBackgroundMusic() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.bg)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

}