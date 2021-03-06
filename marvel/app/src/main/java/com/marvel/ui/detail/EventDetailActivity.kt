package com.marvel.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.event.Event
import com.marvel.ui.MainActivity
import com.squareup.picasso.Picasso

class EventDetailActivity : AppCompatActivity() {
    private lateinit var imageEvent: ImageView
    private lateinit var nameEvent: TextView
    private lateinit var descriptionEvent: TextView
    private lateinit var event: Event
    private lateinit var homeButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)

        unitUI()

        event = intent.getSerializableExtra("events") as Event

        setImageEvent()

        setUpDataEvent()
    }

    private fun unitUI() {
        descriptionEvent = findViewById(R.id.EventDetailDescription)
        imageEvent = findViewById(R.id.EventDetailImage)
        nameEvent = findViewById(R.id.EventDetailName)
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

    private fun setImageEvent() {
        val builder = Picasso.Builder(this)
        builder.downloader(OkHttp3Downloader(this))
        builder.build().load(event.thumbnail.path + "." + event.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageEvent)
    }

    private fun setUpDataEvent() {
        nameEvent.text = event.title
        descriptionEvent.text = event.description
    }
}