package com.marvel.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.series.Series
import com.marvel.ui.MainActivity
import com.squareup.picasso.Picasso

class SeriesDetailActivity : AppCompatActivity() {
    private lateinit var noDescription: TextView
    private lateinit var imageSeries: ImageView
    private lateinit var nameSeries: TextView
    private lateinit var descriptionSeries: TextView
    private lateinit var series: Series
    private lateinit var homeButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series_detail)

        unitUI()

        series = intent.getSerializableExtra("series") as Series

        setImageCharacter()

        setUpDataSeries()
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
        builder.build().load(series.thumbnail.path + "." + series.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageSeries)
    }


    private fun setUpDataSeries() {
        nameSeries.text = series.title

        if (series.description == null) {
            noDescription.visibility = View.VISIBLE
        }
        descriptionSeries.text = series.description
    }
}