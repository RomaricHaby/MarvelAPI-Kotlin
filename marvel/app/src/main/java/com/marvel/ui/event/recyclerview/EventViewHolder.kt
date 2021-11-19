package com.marvel.ui.event.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.events.Event
import com.squareup.picasso.Picasso

class EventViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    fun updateEvent(event: Event) {
        val eventImage: ImageView = itemView.findViewById(R.id.viewHolderImageEvent)
        val nameEvent: TextView = itemView.findViewById(R.id.viewHolderNameEvent)

        nameEvent.text = event.title

        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder.build().load(event.thumbnail.path + "." + event.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(eventImage)
    }
}