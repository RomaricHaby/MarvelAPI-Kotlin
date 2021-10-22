package com.marvel.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.marvel.modele.comics.Comics
import com.squareup.picasso.Picasso

class ComicsDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_detail)


    }


}