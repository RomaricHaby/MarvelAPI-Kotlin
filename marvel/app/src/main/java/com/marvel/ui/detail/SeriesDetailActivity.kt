package com.marvel.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.series.Serie
import com.marvel.ui.MainActivity
import com.squareup.picasso.Picasso

class SeriesDetailActivity : AppCompatActivity() {
private lateinit var noDescription : TextView
    private lateinit var imageSeries: ImageView
    private lateinit var nameSeries: TextView
    private lateinit var descriptionSeries: TextView
    private lateinit var serie: Serie
    private lateinit var homeButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series_detail)


        unitUI()

        serie = intent.getSerializableExtra("series") as Serie

        setImageCharacter()
        nameSeries.text = serie.title

        if (serie.description == null) {
            noDescription.visibility = View.VISIBLE
        }
            descriptionSeries.text = serie.description


    }


    private fun unitUI() {
        descriptionSeries = findViewById(R.id.SeriesDetailDescription)
        imageSeries = findViewById(R.id.SeriesDetailImage)
        nameSeries = findViewById(R.id.SeriesDetailName)
        noDescription = findViewById(R.id.ViewDescriptionSeries_tv)
        homeButton = findViewById(R.id.floatingButtonHome)

        setHomeButton()

    }

    private fun setHomeButton() {
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }


    private fun setImageCharacter() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(serie.thumbnail.path + "." + serie.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageSeries)
    }
}