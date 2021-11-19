package com.marvel.ui

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.marvel.R
import com.marvel.manager.ResourcesManager
import com.marvel.manager.SharedPreferencesManager

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var marvelAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        /* val rocketImage = findViewById<ImageView>(R.id.image_view_animation).apply {
             setBackgroundResource(R.drawable.animation_list)
             marvelAnimation = background as AnimationDrawable
         }
         marvelAnimation.start()*/



        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 0) // todo remettre à 8500


        //Load fav character
        SharedPreferencesManager.loadAllCharacter(this)
        ResourcesManager.loadKeyAPI()
    }
}