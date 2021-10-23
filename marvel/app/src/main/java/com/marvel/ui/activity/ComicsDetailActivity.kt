package com.marvel.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.widget.ImageView
import android.widget.TextView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.modele.characters.Hero
import com.marvel.modele.comics.Comics
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class ComicsDetailActivity: AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var imageComics: ImageView
    private lateinit var nameComics: TextView
    private lateinit var descriptionComics: TextView

    private lateinit var comics: Comics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_detail)

        comics = intent.getSerializableExtra("comics") as Comics

        unitUI()

        setImageCharacter()
        nameComics.text = comics.title
        descriptionComics.text = comics.description
    }

    private fun unitUI() {
        imageComics = findViewById(R.id.ComicsImage)
        nameComics = findViewById(R.id.ComicsDetailName)
        descriptionComics = findViewById(R.id.ComicsDetailDescrip)
    }

    private fun setImageCharacter() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(comics.thumbnail.path + "." + comics.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageComics)
    }

}