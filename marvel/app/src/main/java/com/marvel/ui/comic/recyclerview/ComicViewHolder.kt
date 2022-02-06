package com.marvel.ui.comic.recyclerview

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.picasso.OkHttp3Downloader
import com.marvel.R
import com.marvel.model.comic.Comic
import com.squareup.picasso.Picasso

class ComicViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var comicsImage: ImageView
    private lateinit var nameComics: TextView

    fun updateComics(comic: Comic) {
        initUI()

        setUpDataComic(comic)

        setUpCharacterImage(comic)
    }

    private fun setUpDataComic(comic: Comic) {
        nameComics.text = comic.title
    }

    private fun setUpCharacterImage(comic: Comic) {
        val builder = Picasso.Builder(context)
        builder.downloader(OkHttp3Downloader(context))
        builder.build().load(comic.thumbnail.path + "." + comic.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(comicsImage)
    }

    private fun initUI() {
        comicsImage = itemView.findViewById(R.id.viewHolderComicsIMG)
        nameComics = itemView.findViewById(R.id.viewHolderNameComics)
    }
}