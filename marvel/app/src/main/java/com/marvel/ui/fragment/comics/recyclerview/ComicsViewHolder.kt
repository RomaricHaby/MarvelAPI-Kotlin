package com.marvel.ui.fragment.comics.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.comics.Comics
import com.squareup.picasso.Picasso

class ComicsViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView){

    fun updateComics(comics: Comics) {
        val comicsImage: ImageView = itemView.findViewById(R.id.viewHolderComicsIMG)
        val nameComics: TextView = itemView.findViewById(R.id.viewHolderNameComics)

        nameComics.text = comics.title

        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder.build().load(comics.thumbnail.path + "." + comics.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(comicsImage)
    }
}