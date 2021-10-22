package com.marvel.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.squareup.picasso.Picasso

class CharacterDetailActivity() : AppCompatActivity() {
    private lateinit var imageCharacter: ImageView
    private lateinit var nameCharacter: TextView

    private lateinit var character: Hero


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        unitUI()

        character = intent.getSerializableExtra("character") as Hero

        setImageCharacter()

        nameCharacter.text = character.name

    }


    private fun unitUI() {
        imageCharacter = findViewById(R.id.CharacterDetailImage)
        nameCharacter = findViewById(R.id.CharacterDetailName)
    }

    private fun setImageCharacter(){
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(character.thumbnail.path + "." + character.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageCharacter)
    }
}