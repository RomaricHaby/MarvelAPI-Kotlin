package com.marvel.ui.event.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.event.Event
import com.squareup.picasso.Picasso

class EventViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var eventImage: ImageView
    private lateinit var nameEvent: TextView

    fun updateEvent(event: Event) {
        initUI()

        setUpDataEvent(event)

        setUpEventImage(event)
    }

    private fun initUI() {
        eventImage = itemView.findViewById(R.id.viewHolderImageEvent)
        nameEvent = itemView.findViewById(R.id.viewHolderNameEvent)
    }

    private fun setUpDataEvent(event: Event) {
        nameEvent.text = event.title
    }

    private fun setUpEventImage(event: Event) {
        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder.build().load(event.thumbnail.path + "." + event.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(eventImage)
    }
}